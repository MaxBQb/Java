package ru.mirea.pr_9;

public class Student implements ISerializable {
    private String name;
    private String surname;
    private int age;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    Student() {
        this("", "");
    }

    Student(String name, String surname) {
        this(name, surname, 0);
    }

    Student(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    @Override
    public String serialize() {
        return name+';'+surname+';'+age;
    }

    @Override
    public boolean deserialize(String serial) {
        try {
            String[] params = serial.split(";");
            if (params.length < 3)
                throw new WrongFieldsCountException("Not enough fields");
            if (params.length > 3)
                throw new WrongFieldsCountException("Too many fields");
            name = params[0];
            surname = params[1];
            age = Integer.parseInt(params[2]);
        } catch (Throwable ex) {
            System.out.println("Can't deserialize object: "+ex.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Студент: "
                + name + ' '
                + surname + ", возраст: "
                + age;
    }
}
