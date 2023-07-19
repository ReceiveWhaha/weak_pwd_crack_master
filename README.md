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

