import java.util.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.text.SimpleDateFormat;
public class Log {
 private static String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
 private static String log_dir = Paths.get(".", date).toString();
 private static Path success_filename = Paths.get(log_dir, logConfig.get("success_filename"));
 private static Path log_filename = Paths.get(log_dir, logConfig.get("log_filename"));
 private static Map<String, Object> lock = new HashMap<>();
 private static String id = "";
 public static void init_lock(Map<String, Object> l) {
 lock = l;
 }
 public static void init_log_id(String i) {
 id = i;
 }
 public static String get_time() {
 return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
 }
 public static void write_log(Path filename, String msg) throws IOException {
 synchronized (lock) {
 Files.write(filename, (msg + "\n").getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND, StandardOpenOption.CREATE);
 }
 }
 public static void Info(Object msg) throws IOException {
 String current_time = get_time();
 if (!id.isEmpty()) {
 msg = current_time + " id: " + id + " " + msg.toString();
 } else {
 msg = current_time + " " + msg.toString();
 }
 System.out.println(msg);
 write_log(log_filename, msg.toString());
 }
 public static void Error(Object msg) throws IOException {
 String current_time = get_time();
 if (!id.isEmpty()) {
 msg = current_time + " id: " + id + " " + msg.toString();
 } else {
 msg = current_time + " " + msg.toString();
 }
 System.err.println(msg);
 write_log(log_filename, msg.toString());
 }
 public static void Success(Object msg) throws IOException {
 String current_time = get_time();
 if (!id.isEmpty()) {
 msg = current_time + " id: " + id + " " + msg.toString();
 } else {
 msg = current_time + " " + msg.toString();
 }
 System.out.println(msg);
 write_log(success_filename, msg.toString());
 }
}