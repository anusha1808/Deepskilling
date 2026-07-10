package Factory;

import Documents.PdfDocument;
import Documents.document;

import javax.print.Doc;

public class PdfFactory extends DocumentFactory {

    @Override
    public document createDocument() {
        return new PdfDocument();
    }
}
