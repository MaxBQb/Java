package pr_9;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class DataBase {
    private ArrayList<ISerializable> data;
    private String path;

    public DataBase(String path) {
        this.path = path;
        data = new ArrayList<>();
        try {
            load();
        } catch (Throwable ignored) {}
    }

    public void load() throws IOException {
        try (FileReader fileReader = new FileReader(path)) {
            Scanner scan = new Scanner(fileReader);
            while (scan.hasNextLine()) {
                Student s = new Student();
                if (s.deserialize(scan.nextLine()))
                    data.add(s);
            }
        } catch (IOException ex) {
            throw ex;
        } catch (Throwable ignored) {}
    }

    public int size() {
        return data.size();
    }

    public void save() {
        try (FileWriter fileWriter = new FileWriter(path)) {
            for (ISerializable ser: data)
                fileWriter.write(ser.serialize()+'\n');
        } catch (IOException ex) {
            System.out.println("DataBase saving performs with errors: "+ex.getMessage());
        }
    }

    public void add(ISerializable o) {
        data.add(o);
        save();
    }

    public ISerializable remove(int index) {
        ISerializable t = data.remove(index);
        save();
        return t;
    }

    public void set(int index, ISerializable o) {
        data.set(index, o);
        save();
    }

    public ISerializable get(int index) {
        return data.get(index);
    }

    public void sort(Comparator<? super ISerializable> c) {
        data.sort(c);
        save();
    }
}
