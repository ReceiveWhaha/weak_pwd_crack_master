import java.util.*;
import java.util.regex.*;
public class DictGenerator {
 public static List<String> gen_dict(String url) {
 List<String> username_list = gen_base_dict().get(0);
 List<String> password_list = gen_base_dict().get(1);
 if (generatorConfig.get("dict_config").get("domain_dict").get("enable")) {
 Map<String, List<String>> domain_dict = gen_domain_dict(url);
 if (!domain_dict.isEmpty()) {
 username_list.addAll(domain_dict.get("domain_user_dict"));
 password_list.addAll(domain_dict.get("domain_pass_dict"));
 }
 }
 if (!username_list.isEmpty() && !password_list.isEmpty()) {
 return Arrays.asList(username_list, password_list);
 } else {
 throw new Exception("[-] 字典生成失败！");
 }
 }
 public static Map<String, List<String>> gen_sqlin_dict() {
 List<String> sqlin_user_dict = generatorConfig.get("dict_config").get("sqlin_dict").get("payload_list");
 List<String> sqlin_pass_dict = new ArrayList<>(sqlin_user_dict);
 return Map.of("sqlin_user_dict", sqlin_user_dict, "sqlin_pass_dict", sqlin_pass_dict);
 }
 public static Map<List<String>, List<String>> gen_base_dict() {
 List<String> base_username_list = new ArrayList<>(generatorConfig.get("dict_config").get("base_dict").get("username_list"));
 List<String> base_password_list = new ArrayList<>(generatorConfig.get("dict_config").get("base_dict").get("password_list"));
 return Map.of(base_username_list, base_password_list);
 }
 public static Map<String, List<String>> gen_domain_dict(String url) throws Exception {
 List<String> domain_user_dicts = new ArrayList<>();
 List<String> domain_pass_dicts = new ArrayList<>();
 List<String> tmp_dicts = new ArrayList<>();
 List<String> suffix_list = generatorConfig.get("dict_config").get("domain_dict").get("suffix_list");
 String[] list1 = url.split("/");
 String host = list1[2].split(":")[0];
 Pattern compile_ip = Pattern.compile("^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$");
 Matcher matcher = compile_ip.matcher(host);
 int check_ip = matcher.matches() ? 1 : 0;
 if (check_ip != 0) {
 String[] list2 = host.split("\\.");
 int i = list2.length;
 for (int u = 0; u < i; u++) { // 生成url字典1
 String[] list3 = Arrays.copyOfRange(list2, u, i);
 String part = String.join(".", list3);
 if (part.length() < 5) {
 continue;
 }
 domain_pass_dicts.add(part);
 }
 for (int u = 0; u < i; u++) { // 生成url字典2
 String[] list3 = {list2[u]};
 if (list3.length < 5) {
 continue;
 }
 tmp_dicts.add(list3[u]);
 }
 for (String i : tmp_dicts) {
 for (String suffix : suffix_list) {
 String u = i + suffix;
 domain_pass_dicts.add(u);
 }
 }
 return Map.of("domain_user_dicts", domain_user_dicts, "domain_pass_dicts", domain_pass_dicts);
 } else {
 return Map.of("domain_user_dicts", new ArrayList<>(), "domain_pass_dicts", new ArrayList<>());
 }
 }
}