import java.util.*;
import java.io.*;
import java.net.*;
import javax.net.ssl.*;
import javax.swing.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.util.regex.Pattern;
public class Parser {
 private int id;
 private String url;
 private String post_path;
 private String resp_content;
 private Element form_content;
 private String username_keyword;
 private String password_keyword;
 private Map<String, String> data;
 private String cms;
 private Map<String, Map<String, Object>> cmsConfig;

 public Parser(String url) {
 this.url = url;

 }

 public boolean run() {
 try {
 this.get_resp_content();
 this.cms_parser();
 this.form_parser();
 this.check_login_page();
 this.captcha_parser();
 this.post_path_parser();
 this.param_parser();
 } catch (Exception e) {
 System.err.println("[-] " + e.toString());
 return false;
 }
 return true;

 }

 public void get_resp_content() throws IOException {
 Connection conn = Jsoup.connect(url).ignoreContentType(true).ignoreHttpErrors(true)
 .userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.3")
 .timeout(30000);
 Document doc = conn.get();

 this.resp_content = doc.html();

 }

 public void cms_parser() throws IOException {

 for (Map.Entry<String, Map<String, Object>> cmsEntry : cmsConfig.entrySet()) {
 Map<String, Object> cmsData = cmsEntry.getValue();
 String keyword = (String) cmsData.get("keywords");
 if (keyword != null && keyword.length() > 0 && resp_content.contains(keyword)) {

 System.out.println("[*] " + url + " 识别到cms: " + cmsData.get("name"));
 if (Boolean.TRUE.equals(cmsData.get("alert"))) {
 System.out.println("[*] " + url + " " + cmsData.get("note"));
 }
 this.cms = (String) cmsData.get("name");
 break;
 }
 }
 }

 public void form_parser() throws Exception {
 String html = resp_content;
 Pattern pattern = Pattern.compile("(?i).*<form (.*)</form>.*");
 java.util.regex.Matcher matcher = pattern.matcher(html);
 if (matcher.find()) {
 String form_data = "<form " + matcher.group(1) + "</form>";
 Document doc = Jsoup.parse(form_data);
 this.form_content = doc.selectFirst("form");

 } else {
 throw new Exception("Can not get form");
 }
 }

 public void check_login_page() throws Exception {
 List<String> login_keyword_list = parserConfig.getStringList("login_keyword_list");
 for (String login_keyword : login_keyword_list) {
 if (form_content.toString().toLowerCase().contains(login_keyword.toLowerCase())) {
 return;
 }
 }
 throw new Exception("Maybe not login pages");
 }

 public void captcha_parser() throws Exception {
 List<String> captcha_keyword_list = parserConfig.getStringList("captcha_keyword_list");
 for (String captcha : captcha_keyword_list) {
 if (resp_content.toLowerCase().contains(captcha.toLowerCase())) {
 throw new Exception(captcha + " in login page");
 }
 }
 }

 public void post_path_parser() throws Exception {
 URL current_url = new URL(url);

 Element form_action_element = form_content;
 String action_path;
 String path;

 try {

 action_path = form_action_element.attr("action");

 } catch (Exception e) {

 post_path = url; // 当form中没有action字段时，默认地址为url
 return;

 }

 if (!action_path.isEmpty()) {

 if (action_path.startsWith("http")) { // action为绝对路径

 path = action_path;

 } else if (action_path.startsWith("/")) { // action为根路径

 path = current_url.getProtocol() + "://" + current_url.getHost() + action_path;

 } else if (action_path.isEmpty()) { // action为空

 path = url;

 } else { // action为同目录下相对路径

 String relative_path = url.replace(current_url.getPath(), "");
 path = relative_path + action_path;

 }

 if (path.isEmpty()) {
 throw new Exception("Can not get post path");
 }

 post_path = path;
 }

 public void param_parser() throws Exception {

 Map<String, List<String>> headers = new HashMap<>();
 headers.put("User-Agent", Collections.singletonList(
 "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.3"
 ));

 Connection conn = Jsoup.connect(url).headers(headers).ignoreContentType(true).ignoreHttpErrors(true)
 .method(Connection.Method.GET)
 .timeout(30000);

 Document doc = conn.get();

 Element form_element = doc.selectFirst("form");

 if (form_element != null) {

 Map<String, String> dataMap = new HashMap<>();

 for (Element input_element : form_element.select("input")) {

 String parameter;
 String value;

 if (!input_element.hasAttr("name")) {
 parameter = "";
 } else {
 parameter = input_element.attr("name");
 }

 if (!input_element.hasAttr("value")) {
 value = parserConfig.getString("default_value");
 } else {
 value = input_element.attr("value");
 }

 dataMap.put(parameter, value);

 }

 this.data = dataMap;

 String username_keyword;
 String password_keyword;
 List<String> username_keyword_list = parserConfig.getStringList("username_keyword_list");
 List<String> password_keyword_list = parserConfig.getStringList("password_keyword_list");

 for (Map.Entry<String, String> entry : data.entrySet()) {

 String parameter = entry.getKey();
 String value = entry.getValue();

 if (username_keyword_list.stream().anyMatch(keyword -> keyword.toLowerCase().contains(parameter.toLowerCase()))) {
 username_keyword = parameter;
 } else if (password_keyword_list.stream().anyMatch(keyword -> keyword.toLowerCase().contains(parameter.toLowerCase()))) {
 password_keyword = parameter;
 }

 }

 if (username_keyword != null && password_keyword != null) {

 this.username_keyword = username_keyword;
 this.password_keyword = password_keyword;

 } else {

 throw new Exception("Can not get login parameter");

 }

 } else {

 throw new Exception("Can not get form");

 }

 }
}  