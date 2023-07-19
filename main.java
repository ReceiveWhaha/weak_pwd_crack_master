import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class MainWindow extends QMainWindow {
    // 声明界面组件属性
 
    public MainWindow() {
      self.pushButton.clicked.connect(lambda: self.stackedWidget.setCurrentIndex(0))
        # 生成
        self.pushButton_6.clicked.connect(self.generate)
        setupUi();
    }
 
    private void setupUi() {
      def __init__(self):
        # 继承(QMainWindow,Ui_MainWindow)父类的属性
        super(MainWindow, self).__init__()
        # 初始化界面组件
        self.setupUi(self)
        self.stackedWidget.setCurrentIndex(0)
        # 功能一
        self.pushButton.clicked.connect(lambda: self.stackedWidget.setCurrentIndex(0))
        # 生成
        self.pushButton_6.clicked.connect(self.generate)

        # 功能二
        self.pushButton_2.clicked.connect(lambda: self.stackedWidget.setCurrentIndex(1))
        # 开始检测
        self.pushButton_7.clicked.connect(self.jiance1)

        # 功能三
        self.pushButton_3.clicked.connect(lambda: self.stackedWidget.setCurrentIndex(2))
        # 导入
        self.pushButton_8.clicked.connect(self.load)
        # 运行
        self.pushButton_9.clicked.connect(self.runFunc)

        # 功能四
        self.pushButton_4.clicked.connect(lambda: self.stackedWidget.setCurrentIndex(3))
        # 检测
        self.pushButton_10.clicked.connect(self.jiance)

        # 功能五
        self.pushButton_5.clicked.connect(lambda: self.stackedWidget.setCurrentIndex(4))
        # 完成
        self.pushButton_11.clicked.connect(self.finished)

 
    }
 
    private void load() {
       fileName, filetype = QFileDialog.getOpenFileName(self,
                                                         "选取文件",
                                                         "./",
                                                         "Text Files (*.txt)")  # 设置文件扩展名过滤,注意用双分号间隔
        if fileName:
            with open(fileName, "r") as f:
                self.textEdit_4.append(f.read())

 
    }
 
    private void runFunc() {
        self.textEdit_5.clear()

        def single_process_crack(url_list):
            all_num = len(url_list)
            cur_num = 1
            print("总任务数: " + str(all_num))
            for url in url_list:
                CrackTask().run(cur_num, url)
                cur_num += 1

        try:
            import conf.config
        except:
            QMessageBox.warning(self, "警告", "加载配置文件失败！", QMessageBox.Yes)
            return

        urls = self.textEdit_4.toPlainText().strip().split("\n")
        for url_file_name in urls:
            # url_file_name = input('File or Url:\n')

            if '://' in url_file_name:
                CrackTask().run(1, url_file_name)
            else:
                url_list = []
                if os.path.exists(url_file_name):
                    self.textEdit_5.append(url_file_name + "exists!")
                    print(url_file_name, "exists!\n")
                    with open(url_file_name, 'r', encoding="UTF-8") as url_file:
                        for url in url_file.readlines():
                            url = url.strip()
                            if url.startswith('#') or url == '' or ('.edu.cn' in url) or ('.gov.cn' in url):
                                continue
                            url_list.append(url)
                    start = datetime.datetime.now()
                    single_process_crack(url_list)
                    end = datetime.datetime.now()
                    self.textEdit_5.append(f'All processes done! Cost time: {str(end - start)}')
                    print(f'All processes done! Cost time: {str(end - start)}')
                else:
                    self.textEdit_5.append(url_file_name + " not exist!")
                    print(url_file_name + " not exist!")
 
    }
 
    private void jiance1() {
      self.textEdit_2.clear()
        ip = self.lineEdit_12.text()
        from asyncio import wait_for, TimeoutError, open_connection, run

        async def check_ssh_open(ip: str):
            try:
                reader, writer = await wait_for(open_connection(ip, 22), 2)
            except (TimeoutError, OSError) as e:
                return "SSH service is not open."

            try:
                s = await wait_for(reader.readuntil(b"\n"), 3)
                # print(s)
                s = s.decode()
                if s.startswith("SSH"):
                    return f"{ip} -> {s.strip()}"
                    # return ip, s.strip()
            except TimeoutError as e:
                pass
            finally:
                writer.close()
            return False

        async def main():
            info = await check_ssh_open("8.129.1.143")
            self.textEdit_2.append(info)

        run(main())

        username_list = []
        password_list = []

        def get_username_list():
            #global username_list
            if not username_list:
                f = open('username.txt', 'r', encoding='utf-8')
                for item in f.readlines():
                    item = item.strip()
                    if item and not item.startswith('#'):
                        username_list.append(item)
                f.close()
            return username_list
 
        class PoJieTwo {
            public PoJieTwo(String accountPath, String wordPath) {
                // 对象初始化，传入账户字典文件路径和密码字典文件路径
            }
         
           
         
            public ArrayList<String> PoJieChangShi() {
                ArrayList<String> data = new ArrayList<>();
                while (true) {  // 循环读取账户字典
                    String myAccount = accountFile.readLine().trim();  // 读取一行
                    boolean restart = true;
                    if (myAccount == null || myAccount.equals("")) {  // 如果读到账户文件最后没有数据了，就跳出循环
                        break;
                    }
                    while (restart) {  // 循环读取密码字典
                        String myWord = wordFile.readLine().trim();  // 读取密码字典的一行
                        if (myWord == null || myWord.equals("")) {  // 如果读到密码文件最后没有数据了，就跳出循环
                            wordFile.close();
                            wordFile = new BufferedReader(new FileReader(wordPath));  // 重启密码字典
                            break;
                        }
                        if (LianJieMySql(myAccount, myWord)) { // 把读到的账户和密码传给连接数据库方法进行检测
                            data.add("账号:" + myAccount + " 密码:" + myWord + " 具有弱口令");
                            System.out.println("这是一个弱口令");  // 打印正确的密码
                            restart = false;
                        } else {
                            data.add("账号:" + myAccount + " 密码:" + myWord + " 没有找到弱口令");
                        }
                    }
                }
                return data;
            }
         
            public void close() throws IOException {
                accountFile.close();  // 关闭账户字典文件流
                wordFile.close();   // 关闭密码字典文件流
            }
        }
         
        String accountPath = "./username.txt";   // 账户字典路径
        String wordPath = "./passwords.txt";   // 密码字典路径
        PoJieTwo start = new PoJieTwo(accountPath, wordPath);   // 实例化对象
        ArrayList<String> data = start.PoJieChangShi();   // 对象执行方法
        for (String s : data) {
            textEdit.append(s + "\n");   // 将数据输出到界面上
        }
    }
 
    private void generate() {
        account = self.lineEdit.text()
        name = self.lineEdit_2.text()
        namesuo = self.lineEdit_3.text()
        company = self.lineEdit_4.text()
        qinmi = self.lineEdit_5.text()
        qita = self.lineEdit_6.text()
        birth = self.lineEdit_7.text()
        if len(birth) != 6:
            QMessageBox.warning(self, "警告", "非6位", QMessageBox.Yes)
            return
        qinmibirth = self.lineEdit_9.text()
        if len(qinmibirth) != 6:
            QMessageBox.warning(self, "警告", "非6位", QMessageBox.Yes)
            return
        phone = self.lineEdit_8.text()
        qinmiphone = self.lineEdit_10.text()
 
    }
 
    public static void main(String[] args) {
        QApplication app = new QApplication(args);
        MainWindow window = new MainWindow();
        window.show();
        app.exec();
    }
}