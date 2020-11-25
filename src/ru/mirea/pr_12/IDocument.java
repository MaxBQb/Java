package ru.mirea.pr_12;

public interface IDocument {
    void saveInformation(String path);
    Object getContent();
    void setContent(Object content);
}
