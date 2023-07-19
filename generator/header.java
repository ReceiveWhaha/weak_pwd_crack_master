import java.util.*;
public class HeaderGenerator {
 private static List<String> useragent_list = generatorConfig.get("headers_config").get("useragent_list");
 private static boolean enable = generatorConfig.get("headers_config").get("enable");
 public static Map<String, String> get_random_headers() {
 if (enable) {
 String UA = useragent_list.get(new Random().nextInt(useragent_list.size()));
 String a = String.valueOf(new Random().nextInt(255) + 1);
 String b = String.valueOf(new Random().nextInt(255) + 1);
 String c = String.valueOf(new Random().nextInt(255) + 1);
 String random_XFF = "127." + a + "." + b + "." + c;
 String random_CI = "127." + c + "." + a + "." + b;
 Map<String, String> headersMap = new HashMap<>();
 headersMap.put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
 headersMap.put("User-Agent", UA);
 headersMap.put("X-Forwarded-For", random_XFF);
 headersMap.put("Client-IP", random_CI);
 headersMap.put("Accept-Encoding", "gzip, deflate");
 headersMap.put("Accept-Language", "zh-CN,zh;q=0.8");
 headersMap.put("Referer", "http://www.baidu.com/");
 headersMap.put("Content-Type", "application/x-www-form-urlencoded");
 return headersMap;
 } else {
 return generatorConfig.get("rand_headers_config").get("default_headers");
 }
 }
}