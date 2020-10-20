package pr_12;

import javax.swing.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;

public class CreateTextDocument extends CreateAbstractDocument{
    public IDocument CreateNew() {
        return new TextDocument("");
    }

    public IDocument CreateOpen(String path) {
        try {
            String str = Files.readString(Paths.get(path));
            return new TextDocument(str);
        } catch (InvalidPathException e) {
            System.out.println("Ошибка пути: "+e.getMessage());
        } catch (IOException e) {
            System.out.println("Всё упало :(");
        }
        JOptionPane.showMessageDialog(null,
                "Не удалось открыть файл!",
                "Ошибка открытия файла",
                JOptionPane.ERROR_MESSAGE
        );
        return new TextDocument("");
    }
}
