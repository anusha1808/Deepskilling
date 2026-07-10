package Factory;

import Documents.ExcelDocument;
import Documents.document;

public class ExcelFactory extends DocumentFactory{
    @Override
    public document createDocument() {
        return new ExcelDocument();
    }
}
