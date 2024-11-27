package com.example.demo;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

import java.io.*;
import java.net.SocketException;
import java.util.Scanner;

public class FTP_connect  {

    public static String ip = "185.180.223.189";
    public static String user = "ftpuser";
    public static String psw = "1111";
    public static File share = new File("C:/Users/user/Desktop/demo/share/");

    public static String getIp() {
        return ip;
    }

    public static void setIp(String ip) {
        FTP_connect.ip = ip;
    }

    public static String getUser() {
        return user;
    }

    public static void setUser(String user) {
        FTP_connect.user = user;
    }

    public static String getPsw() {
        return psw;
    }

    public static void setPsw(String psw) {
        FTP_connect.psw = psw;
    }

    public static void push_file() {
        FTPClient con = null;
        Scanner scanner = new Scanner(System.in);
        try {
            con = new FTPClient();
            con.connect(ip);
            if (con.login(user, psw)) {
                con.enterLocalPassiveMode();
                con.setFileType(FTP.BINARY_FILE_TYPE);
                try {
                    System.out.println("Введите название файла из папки share который нужно скопировать");
                    String file_name = scanner.nextLine();
                    String data = share + file_name;
                    FileInputStream in = new FileInputStream(new File(data));
                    boolean result = con.storeFile("C:/Users/user/Desktop/demo/share/" + file_name, in);
                    in.close();
                } catch (FileNotFoundException e) {
                    System.out.println("Файл не найден");
                }
            }
            con.logout();
            con.disconnect();
            System.out.println("Файл скопирован на FTP сервер");
        } catch (Exception e) {
            System.out.println("Подключение не удалось");
        }
    }
}

