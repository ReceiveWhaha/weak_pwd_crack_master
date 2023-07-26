# Weak_pwd_crack_master
  A universal web weak password cracking script aimed at batch detecting management backends without verification codes.
  With the increase of attack and defense drills and some vulnerability mining tasks, it is sometimes necessary to quickly detect the security of some website 
  backend in large quantities, especially to test some weak management passwords. Therefore, this tool is available - a universal web weak password cracking script
# Change log
[2023-01-05] We have dealt with the abnormal situations that occurred during the detection, but there are still many problems  

[2023-01-03] We have usedmultiple threads and conducted a comprehensive summary of login situations for different websites
# Function principle

1.Identify blasting parameters  

  We determine the location of username and password parameters based on extracting keywords such as user pass from the form  
```
if parameter:
  if not user_key:
    for z in [ 'user', 'name','zhanghao', 'yonghu', 'email', 'account']:
      if z in parameter.lower():
        value = '{user_name}'
        user_key = parameter
        ok_flag = 1
        break
      if not ok_flag:
        for y in ['pass', 'pw', 'mima']:
          if y in parameter.lower():
            value = '{pass_word}'
            pass_key = parameter
            ok_flag = 1
            break
```

2.The way to determine successful login  

  This can be said to be the most troublesome issue 
  
  If it's okay for a management system, just find the pattern and determine if there are any features of successful login
  However, as a universal blasting script, there are various websites in the world, and it is impossible to find features one by one or to perform   
  regular matching one by one.  
  
  Finally, we adopt the following matching method
  
3.Determine whether to dynamically return a value and obtain Error Length  

  First, let's send two passwords that are definitely incorrect, such as length_ Test.Then,we obtain two return values and compare them.  
  If the values are different twice, it indicates that the management system returns different lengths for the same data packet. 
  
  At this point, the script cannot determine and exits the explosion.If it is the same, record this value as the basis for judgment.  
  
  However, in practice, a request will be made first, as it has been found that some management systems add tags to the response header during the first login. 
  Removing this item may result in misjudgment.  
  
4.Determine if the key names of the username and password exist on the redirected pag  

  There is no need to explain this too much. If it exists, it indicates that the login was unsuccessful and the user has returned to the login page.
  
  Because during the testing, it was found that some CMS would pop up a login failure box on the login page, directly determining whether it is equal is not accurate.
  
  There is another way to calculate page hashes and determine the similarity between the two.
  
  But we don't think it's necessary because there are different systems that are difficult to use a unified threshold for judgment, so we finally gave it up.
  
5.Recheck

  In order to improve accuracy and prevent false positives, we have added a recheck link.
  
  That is, send the password of the cracked account to the client again, and compare it with the error sent again_ Length comparison
  If different, it is the correct password.
  
  The previous error was not used here_ Length is because in actual testing, it was found that the length value of the returned packet may change due to WAF or 
  other factors.  
  
# Expansion module  

1.Dynamic Dictionary

  The code is as follows：
  ```
public class DictionaryGenerator {
 public List<String> genDynamDic(String url) {
 List<String> dynamPassDic = new ArrayList<>();
 List<String> tmpDic = new ArrayList<>();
 List<String> suffixDic = Arrays.asList("", "123", "888", "666", "123456");
 String[] list1 = url.split("/");
 String host = list1[2].split(":")[0];
 Pattern compileIp = Pattern.compile("^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$");
 boolean checkIp = compileIp.matcher(host).matches();
 if (!checkIp) {
 String[] list2 = host.split("\\.");
 int i = list2.length;
 for (int u = 0; u < i; u++) {
 String[] list3 = Arrays.copyOfRange(list2, u, i);
 String part = String.join(".", list3);
 if (part.length() < 5) {
 continue;
 }
 dynamPassDic.add(part);
 }
 for (int u = 0; u < i; u++) {
 String list3 = list2[u];
 if (list3.length() < 5) {
 continue;
 }
 tmpDic.add(list3);
 }
 for (String i : tmpDic) {
 for (String suffix : suffixDic) {
 String u = i + suffix;
 dynamPassDic.add(u);
 }
 }
 return dynamPassDic;
 } else {
 return new ArrayList<>();
 }
 }
}
```

If the domain name is  
  ```webcrack.yzddmr6.com```  
Then the following dynamic dictionary list will be generated.

2.Universal password detection

In addition to weak passwords, a large part of the vulnerabilities in the backend are due to universal passwords  
Some commonly used payloads have also been added to weak_pwd_crack_master
```
admin' or 'a'='a
'or'='or'
admin' or '1'='1' or 1=1
')or('a'='a
'or 1=1--
```

# Update

We have optimized it as follows:

·Firstly, we have added the following three parts to the original detection of weak passwords in the web front-end:

Weak password detection for SSH services, weak password detection for databases, and weak password detection for local hosts. Make this weak password detection tool more comprehensive and powerful.

·Secondly, we have optimized the original code to a certain extent, making it more efficient and adding logging functionality.

·Finally, we optimized the existing GUI to make it smoother.
