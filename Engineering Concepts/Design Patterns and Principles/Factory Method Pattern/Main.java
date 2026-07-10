import Documents.document;
import Factory.DocumentFactory;
import Factory.ExcelFactory;
import Factory.PdfFactory;
import Factory.WordFactory;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        DocumentFactory wordFactory = new WordFactory();
        document word = wordFactory.createDocument();
        word.open();

        DocumentFactory pdfFactory = new PdfFactory();
        document pdf = pdfFactory.createDocument();
        pdf.open();

        DocumentFactory excelFactory = new ExcelFactory();
        document excel = excelFactory.createDocument();
        excel.open();
    }
}
