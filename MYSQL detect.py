import pymysql  # 导入连接数据库的模块
import sys

class PoJieTwo:
    def __init__(self, accountPath, wordPath):
        self.accountFile = open(accountPath, "r", errors="ignore")  # 打开账户字典
        self.wordFile = open(wordPath, "r", errors="ignore")  # 打开密码字典

    def LianJieMySql(self, account, word):  # 连接数据库的方法
        try:
            db = pymysql.connect(
                host="localhost", user=account, password=word)  # 连接数据库
            # pymysql.connect()方法的第一个参数是ip地址，本机可以用localhost代替
            # 第二个参数是账户名，
            # 第三个是密码
            db.close()  # 关闭数据库
            return True  # 连接成功返回True
        except:
            return False

    def PoJieChangShi(self):  # 读取字典文件的方法
        while True:  # 循环读取账户字典
            myAccount = self.accountFile.readline().rstrip('\n')  # 读取一行
            restart = True
            if not myAccount:  # 如果读到账户文件最后没有数据了，就跳出循环
                break

            while restart:  # 循环读取密码字典
                myWord = self.wordFile.readline().rstrip('\n')  # 读取密码字典的一行
                if not myWord:  # 如果读到密码文件最后没有数据了，就跳出循环
                    self.wordFile.close()
                    self.wordFile = open(
                        wordPath, "r", errors="ignore")  # 重启密码字典
                    break
                if self.LianJieMySql(myAccount, myWord):  # 把读到账户和密码传到连接数据库方法里面
                    # 如果返回了True说明破解成功
                    print("这是一个弱口令")  # 打印正确密码
                    sys.exit()
                elif self.LianJieMySql(myAccount, myWord) == False:
                    print("未找到弱口令")
                    restart = True

    def __del__(self):  # 无论如何最终要执行的方法
        self.accountFile.close()  # 关闭账户字典
        self.wordFile.close()  # 关闭密码字典文件
        pass

accountPath = r"./username.txt"  # 传入账户字典绝对文件路径
wordPath = r"./passwords.txt"  # 传入密码字典绝对文件路径
start = PoJieTwo(accountPath, wordPath)  # 实例化对象
start.PoJieChangShi()  # 对象执行方法

    
