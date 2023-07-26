import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
 private static final String PASSWORD_FILE_PATH = "passwords.txt";

 public static void main(String[] args) {
 Scanner scanner = new Scanner(System.in);
 System.out.print("请输入口令：");
 String password = scanner.nextLine();
 scanner.close();

 if (checkPassword(password)) {
 System.out.println("这是一个弱口令");
 } else {
 System.out.println("根据社会工程学检测，这个口令安全性较高");
 }
 }

 private static boolean checkPassword(String password) {
 try (BufferedReader reader = new BufferedReader(new FileReader(PASSWORD_FILE_PATH))) {
 String line;
 while ((line = reader.readLine()) != null) {
 line = line.trim();
 if (line.equals(password)) {
 return true; // 字典中包含该密码，认为是弱口令
 }
 }
 } catch (IOException e) {
 e.printStackTrace();
 }
 return false; // 字典中不包含该密码，认为是较高安全性的口令
 }
}