import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class MainWindow extends QMainWindow {
    // 声明界面组件属性
 
    public MainWindow() {
        // 初始化界面组件
        setupUi();
 
        // 实现按钮点击事件的响应
 
    }
 
    private void setupUi() {
        // 设置界面布局和属性
 
        // 添加其他组件的初始化和布局代码
 
    }
 
    private void load() {
        // 实现导入功能的响应事件
 
    }
 
    private void runFunc() {
        // 实现运行功能的响应事件
 
    }
 
    private void jiance1() {
        // 实现开始检测功能的响应事件
 
        class PoJieTwo {
            public PoJieTwo(String accountPath, String wordPath) {
                // 对象初始化，传入账户字典文件路径和密码字典文件路径
            }
         
            public boolean LianJieMySql(String account, String word) {
                // 连接数据库方法，实现连接数据库功能
                try {
                    Connection conn = DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/dbname?useUnicode=true&characterEncoding=utf-8", account, word);
                    conn.close();
                    return true;
                } catch(Exception e) {
                    return false;
                }
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
        // 实现生成功能的响应事件
 
    }
 
    public static void main(String[] args) {
        QApplication app = new QApplication(args);
        MainWindow window = new MainWindow();
        window.show();
        app.exec();
    }
}