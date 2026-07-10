//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();

        Observer mobile = new MobileApp();
        Observer web = new WebApp();

        // Register observers
        stockMarket.registerObserver(mobile);
        stockMarket.registerObserver(web);

        // Stock price changes
        stockMarket.setStock("TCS", 3850.50);

        stockMarket.setStock("Infosys", 1620.75);

        // Remove one observer
        stockMarket.deregisterObserver(web);

        stockMarket.setStock("Reliance", 2950.00);
    }
}
