package pr_9;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Application extends JFrame {
    DataBase db = new DataBase("DataBase.txt");

    String filter_name = null;
    String filter_surname = null;
    int filter_age = -1;
    int filter_found = 0;

    JPanel panel = new JPanel();
    JPanel panel2 = new JPanel();

    JTextArea txtaFound = new JTextArea(4, 20);
    JLabel lblFound = new JLabel("Список совпадений: ", SwingConstants.CENTER);

    JTextArea txtaList = new JTextArea(4, 20);
    JLabel lblList = new JLabel("Список студентов: ", SwingConstants.CENTER);

    JButton btnAdd = new JButton("Добавить");
    JButton btnFind = new JButton("Поиск по Фамилии");
    JButton btnDelete = new JButton("Удалить найденные");
    JButton btnSort = new JButton("Сортировка списка");

    JScrollPane scrollBar = new JScrollPane(txtaList);
    JScrollPane scrollBar2 = new JScrollPane(txtaFound);

    Application() {
        super("Список студентов");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setLayout(new GridLayout(2, 0, 5, 15));
        panel2.setLayout(new GridLayout(2, 1));

        txtaList.setEditable(false);
        txtaFound.setEditable(false);
        updateStudentsList();

        panel.add(lblFound, BorderLayout.EAST);
        panel.add(scrollBar2);
        btnDelete.setEnabled(false);

        btnFind.addActionListener(e -> {
            filter_name = null;
            if (getBoolInput("Фильтровать по имени?",
                    "Настройка фильтра"))
                filter_name = getTextInput("имя студента");
            filter_surname = null;
            if (getBoolInput("Фильтровать по фамилии?",
                    "Настройка фильтра"))
                filter_surname = getTextInput("фамилия студента");
            filter_age = -1;
            if (getBoolInput("Фильтровать по возрасту?",
                    "Настройка фильтра"))
                filter_age = getIntInput("возраст студента", 0, 120);
            ArrayList<String> result = new ArrayList<>();
            btnDelete.setEnabled(false);
            filter_found = 0;
            for (int i = 0; i < db.size(); i++) {
                try {
                    Student s = (Student) db.get(i);
                    if (filter_name != null && s.getName().equals(filter_name) ||
                            filter_surname != null && s.getSurname().equals(filter_surname) ||
                            filter_age != -1 && s.getAge() == filter_age)
                        result.add(s.toString());
                } catch (Throwable ignore) {}
            }

            JOptionPane.showMessageDialog(this,
                    result.size() != 0 ? "Найдено: " + result.size() + '.' : "Ничего не найдено!",
                    "Результаты поиска",
                    result.size() != 0 ? JOptionPane.INFORMATION_MESSAGE : JOptionPane.WARNING_MESSAGE
            );
            filter_found = result.size();
            if (result.size() != 0)
                btnDelete.setEnabled(true);
            txtaFound.setText("");
            for (String str: result)
                txtaFound.append(str+"\n");
        });
        btnDelete.addActionListener(e -> {
            if (filter_found <= 0)
                return;
            if (!getBoolInput(
                    "Будет удалено записей: "+filter_found,
                    "Подтверждение удаления"))
                return;
            btnDelete.setEnabled(false);
            for (int i = 0; i < db.size(); i++) {
                try {
                    Student s = (Student) db.get(i);
                    if (filter_name != null && s.getName().equals(filter_name) ||
                            filter_surname != null && s.getSurname().equals(filter_surname) ||
                            filter_age != -1 && s.getAge() == filter_age)
                        db.remove(i--);
                } catch (Throwable ignore) {}
            }
            filter_name = null;
            filter_surname = null;
            filter_age = -1;
            filter_found = 0;
            txtaFound.setText("");
            updateStudentsList();
        });
        panel2.add(btnFind);
        panel2.add(btnDelete);
        panel.add(panel2);

        panel.add(lblList);
        panel.add(scrollBar, BorderLayout.CENTER);

        btnAdd.addActionListener(e -> {
            String name = getTextInput("имя студента", "Иван");
            String surname = getTextInput("фамилия студента", "Иванов");
            int age = getIntInput("возраст студента", 0, 120);
            Student s = new Student(name, surname, age);
            db.add(s);
            btnFind.setEnabled(true);
            if (db.size() > 1)
                btnSort.setEnabled(true);
            txtaList.append(s.toString()+"\n");
        });
        panel.add(btnAdd);
        btnSort.addActionListener(e -> {
            final int k = getBoolInput("Сортировать по возростанию?",
                    "Настройка сортировки") ? 1 : -1;
            if (getBoolInput("Сортировать по имени?",
                    "Настройка сортировки")) {
                db.sort((o1, o2) -> {
                    try {
                        return k *((Student)(o1)).getName().compareTo(((Student)(o2)).getName());
                    } catch (Throwable ex) {
                        return 0;
                    }
                });
            }
            else if (getBoolInput("Сортировать по фамилии?",
                    "Настройка сортировки"))
                db.sort((o1, o2) -> {
                    try {
                        return k*((Student)(o1)).getSurname().compareTo(((Student)(o2)).getSurname());
                    } catch (Throwable ex) {
                        return 0;
                    }
                });
            else if (getBoolInput("Сортировать по возрасту?",
                    "Настройка сортировки"))
                db.sort((o1, o2) -> {
                    try {
                        return k*Integer.compare(((Student)(o1)).getAge(),((Student)(o2)).getAge());
                    } catch (Throwable ex) {
                        return 0;
                    }
                });
            else {
                JOptionPane.showMessageDialog(this,
                        "Ничего не изменилось.",
                        "Результаты сортировки",
                        JOptionPane.INFORMATION_MESSAGE
                );
                return;
            }
            updateStudentsList();
            JOptionPane.showMessageDialog(this,
                    "Данные отсортированы.",
                    "Результаты сортировки",
                    JOptionPane.INFORMATION_MESSAGE
                );
        });
        add(btnSort, BorderLayout.SOUTH);

        add(panel);
        pack();
        setLocationRelativeTo(null);
    }

    public String getTextInput(String name) {
        return getTextInput(name, "");
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

    public int getIntInput(String name, int min, int max) {
        int value;
        while (true) {
            String t = getTextInput(name);
            try {
                value = Integer.parseInt(t);
            } catch (Throwable ex) {
                JOptionPane.showMessageDialog(this,
                            "Поле '"+name+"' должно содержать число!",
                            "Ошибка!",
                            JOptionPane.ERROR_MESSAGE
                );
                continue;
            }
            if (value < min) {
                JOptionPane.showMessageDialog(this,
                        "Поле '"+name+"' не может быть меньше "+min+"!",
                        "Ошибка!",
                        JOptionPane.ERROR_MESSAGE
                );
                continue;
            }
            if (value > max) {
                JOptionPane.showMessageDialog(this,
                        "Поле '"+name+"' не может превышать "+max+"!",
                        "Ошибка!",
                        JOptionPane.ERROR_MESSAGE
                );
                continue;
            }
            return value;
        }
    }

    public boolean getBoolInput(String message, String title) {
        return JOptionPane.showConfirmDialog(this,
                message,
                title,
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
    }

    void updateStudentsList() {
        txtaList.setText("");
        if (db.size() == 0) {
            btnDelete.setEnabled(false);
            btnSort.setEnabled(false);
            btnFind.setEnabled(false);
        } else {
            btnFind.setEnabled(true);
            if (db.size() > 1)
                btnSort.setEnabled(true);
            else
                btnSort.setEnabled(false);
        }
        for (int i = 0; i < db.size(); i++)
            txtaList.append(db.get(i).toString()+"\n");
    }

    public static void main(String[]args) {
        (new Application()).setVisible(true);
    }
}