package Documents;

public class WordDocument implements document{

    @Override
    public void open() {
        System.out.println("Opening word document");
    }
}
