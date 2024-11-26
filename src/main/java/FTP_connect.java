import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.SocketException;

public class FTP_connect {

    public static String ip = "185.180.223.189";
    public static String user = "ftpuser";
    public static String psw = "1111";

    public FTP_connect(String ip, String user, String psw) throws SocketException, FileNotFoundException, IOException {
        this.ip = ip;
        this.user = user;
        this.psw = psw;
    }

    FTPClient con = null;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    @Override
    public String toString() {
        return "FTP_connect{" +
                "ip='" + ip + '\'' +
                ", user='" + user + '\'' +
                ", psw='" + psw + '\'' +
                +
                        '}';
    }

    public static void push_file() {
        FTPClient con = null;
        try {
            con = new FTPClient();
            con.connect(ip);
            System.out.println("connect");
            if (con.login(user, psw)) {
                System.out.println("succes");
                con.enterLocalPassiveMode(); // important!
                con.setFileType(FTP.BINARY_FILE_TYPE);
                String data = "C:/Users/user/Desktop/demo/files";
                FileInputStream in = new FileInputStream(new File(data));
                boolean result = con.storeFile("/files", in);
                in.close();
//							if (result) Log.v("upload result", "succeeded");
            }
            con.logout();
            con.disconnect();
            System.out.println("disconect");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

