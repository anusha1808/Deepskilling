package Documents;

public class PdfDocument implements document{
    @Override
    public void open() {
        System.out.println("Opening pdf document");
    }
}
