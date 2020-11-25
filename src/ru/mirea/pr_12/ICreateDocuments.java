package ru.mirea.pr_12;

public interface ICreateDocuments {
    IDocument CreateNew();
    IDocument CreateOpen(String path);
}