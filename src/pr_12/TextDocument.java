package pr_12;

import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;

public class TextDocument implements IDocument{
    private String content;

    TextDocument(String content) {
        this.content = content;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = (String)content;
    }

    public void saveInformation(String path) {
        try(FileWriter fileWriter = new FileWriter(path)) {
            fileWriter.write(content);
            fileWriter.flush();
        }
        catch (Throwable e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null,
                    "Не удалось сохранить файл!",
                    "Ошибка сохранения файла",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
}
/*
Потребуется создать конкретный унаследованный класс TextDocument и фабрику для него — CreateTextDocument.
*/