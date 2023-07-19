# Weak_pwd_crack_master
A universal web weak password cracking script aimed at batch detecting management backends without verification codes.
With the increase of attack and defense drills and some vulnerability mining tasks, it is sometimes necessary to quickly detect the security of some website backend in large quantities, especially to test some weak management passwords. Therefore, this tool is available - a universal web weak password cracking script
# Change log
[2023-01-05] We have dealt with the abnormal situations that occurred during the detection, but there are still many problems  

[2023-01-03] We have used multiple threads and conducted a comprehensive summary of login situations for different websites
# Function principle
1.Identify blasting parameters  
  We determine the location of username and password parameters based on extracting keywords such as user pass from the form  
```if parameter:
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
However, as a universal blasting script, there are various websites in the world, and it is impossible to find features one by one or to perform regular matching one by one.
  Finally, we adopt the following matching method
3.Determine whether to dynamically return a value and obtain Error Length
  First, let's send two passwords that are definitely incorrect, such as length_ Test.Then,we obtain two return values and compare them.If the values are different twice, it indicates that the management system returns different lengths for the same data packet. At this point, the script cannot determine and exits the explosion.If it is the same, record this value as the basis for judgment.However, in practice, a request will be made first, as it has been found that some management systems add tags to the response header during the first login. Removing this item may result in misjudgment.
