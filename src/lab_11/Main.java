package lab_11;

import java.io.File;
import java.util.ArrayList;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        try {
            ArrayList<String> content = getDirectoryList(".");
            for (int i = 0; i < 5 && i < content.size(); i++)
                System.out.println(content.get(i));
        } catch (SecurityException e) {
            System.out.println("Защищёный каталог не хочет читаться.. :(");
        } catch (Throwable t) {
            System.out.println("Что-то пошло совсем не так...");
        }
    }

    public static ArrayList<String> getDirectoryList(String path) throws SecurityException {
        ArrayList<String> list = new ArrayList<>();
        File actual = new File(path);
        if (actual.listFiles() != null)
            for(File f: Objects.requireNonNull(actual.listFiles()))
                list.add(f.getName());
        return list;
    }
}