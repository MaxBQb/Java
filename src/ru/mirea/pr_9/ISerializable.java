package ru.mirea.pr_9;

public interface ISerializable {
    String serialize();
    boolean deserialize(String serial);
}
