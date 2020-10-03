package lab_8;

import java.io.*;
import java.util.Scanner;

public class RewriteFile {
    public static void main(String[] args) {
        try(FileWriter writer = new
                FileWriter(".\\note.txt")) {
            var sc = new Scanner(System.in);
            System.out.println("Введите текст для записи в файл:");
            String text = sc.nextLine();
            writer.write(text);
            writer.flush();
        } catch(IOException ex){
            System.out.println("Что-то пошло не так...");
            System.out.println(ex.getMessage());
        }
    }
}