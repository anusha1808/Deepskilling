package Documents;

public class ExcelDocument implements document{
    @Override
    public void open() {
        System.out.println("Opening excel document");
    }
}
