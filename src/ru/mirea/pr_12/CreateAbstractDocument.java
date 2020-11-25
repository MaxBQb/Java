package ru.mirea.pr_12;

public abstract class CreateAbstractDocument implements ICreateDocuments{

    @Override
    public IDocument CreateNew() {
        return null;
    }

    @Override
    public IDocument CreateOpen(String path) {
        return null;
    }
}
