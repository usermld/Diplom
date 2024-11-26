package com.example.demo;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.SocketException;
import java.util.Scanner;

public class FTP_connect {

    public static String ip = "185.180.223.189";
    public static String user = "ftpuser";
    public static String psw = "1111";
    public static File share = new File("C:/Users/user/Desktop/demo/share/");

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

    public static void push_file() {
        FTPClient con = null;
        Scanner scanner = new Scanner(System.in);
        try {
            con = new FTPClient();
            con.connect(ip);
            //System.out.println("connect");
            if (con.login(user, psw)) {
                //System.out.println("succes");
                con.enterLocalPassiveMode(); // important!
                con.setFileType(FTP.BINARY_FILE_TYPE);
                try {
                    System.out.println("Введите название файла из папки share который нужно скопировать");
                    String file_name = scanner.nextLine();
                    String data = "C:/Users/user/Desktop/demo/share/" + file_name;
                    FileInputStream in = new FileInputStream(new File(data));
                    boolean result = con.storeFile("/" + file_name, in);
                    in.close();
                } catch (FileNotFoundException e) {
                    System.out.println("Файл не найден");
                }
            }
            con.logout();
            con.disconnect();
           // System.out.println("disconect");
            System.out.println("Файл скопирован на FTP сервер");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void add_file() {
        System.out.println("Введите путь к файлу: ");
        Scanner scanner = new Scanner(System.in);
        String f_path = scanner.nextLine();
        File add_f = new File(f_path);

        if (add_f.exists())
            System.out.println("Файл найден и скопирован в папку share");
        else
            System.out.println("Файл не найден");

        add_f.renameTo(new File("C:/Users/user/Desktop/demo/share/" + add_f.getName()));
    }

    public static void create_file() { // сделать так, что бы сразу можно было писать в этот файл
        System.out.println("Введите имя файла: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        File f_name = new File("C:/Users/user/Desktop/demo/share/" + name);

        try {
            boolean created = f_name.createNewFile();
            if (created)
                System.out.println("Файл создан");
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }
}

