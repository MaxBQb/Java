package pr_12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Application extends JFrame{
    JMenuBar mbar = new JMenuBar();
    JMenu menu = new JMenu("File");
    JMenuItem optionNew = new JMenuItem("New"),
            optionOpen = new JMenuItem("Open"),
            optionSave = new JMenuItem("Save"),
            optionExit = new JMenuItem("Exit");
    ICreateDocuments documentsFabric;
    IDocument document;
    JTextArea txtaNotepad = new JTextArea();
    JScrollPane scrollBar = new JScrollPane(txtaNotepad);
    Application(ICreateDocuments documentsFabric) {
        super("Work with File");
        this.documentsFabric = documentsFabric;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,400);
        setLocation(700, 400);

        txtaNotepad.setVisible(false);
        txtaNotepad.setFont(new Font("Tahoma", Font.PLAIN, 18));

        optionNew.addActionListener(e -> {
            document = documentsFabric.CreateNew();
            txtaNotepad.setText("");
            txtaNotepad.setEnabled(true);
            optionSave.setEnabled(true);
            txtaNotepad.setVisible(true);
        });

        optionOpen.addActionListener(e -> {
            document = documentsFabric.CreateOpen("./"+
                    getTextInput("имя файла", "untitled")+".txt");
            txtaNotepad.setText((String)document.getContent());
            txtaNotepad.setEnabled(true);
            optionSave.setEnabled(true);
            txtaNotepad.setVisible(true);
        });

        optionSave.addActionListener(e -> {
            if (document == null)
                return;
            document.setContent(txtaNotepad.getText());
            document.saveInformation("./"+getTextInput("имя файла", "untitled")+".txt");
        });

        optionExit.addActionListener(e -> {
            System.exit(0);
        });

        optionSave.setEnabled(false);
        menu.add(optionNew);
        menu.add(optionOpen);
        menu.add(optionSave);
        menu.add(optionExit);
        mbar.add(menu);

        scrollBar.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        txtaNotepad.setLineWrap(true);
        txtaNotepad.setEnabled(false);
        add(scrollBar);
        setJMenuBar(mbar);

        setLocationRelativeTo(null);
    }


    public String getTextInput(String name, String _default) {
        String value = "";
        while (value == null || value.isBlank()) {
            value = JOptionPane.showInputDialog(this,
                    "Введите "+name+": ",
                    _default);
            if (value != null && value.isBlank())
                JOptionPane.showMessageDialog(this,
                        "Поле '"+name+"' не может пустовать!",
                        "Ошибка!",
                        JOptionPane.ERROR_MESSAGE
                );
        }
        return value;
    }


    public static void main(String[] args) {
        (new Application(new CreateTextDocument())).setVisible(true);
    }
}
