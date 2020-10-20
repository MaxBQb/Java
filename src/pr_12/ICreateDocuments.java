package pr_12;

public interface ICreateDocuments {
    IDocument CreateNew();
    IDocument CreateOpen(String path);
}