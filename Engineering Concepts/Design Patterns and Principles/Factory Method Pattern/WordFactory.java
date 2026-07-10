package Factory;

import Documents.WordDocument;
import Documents.document;

public class WordFactory extends DocumentFactory{

    @Override
    public document createDocument() {
        return new WordDocument();
    }
}
