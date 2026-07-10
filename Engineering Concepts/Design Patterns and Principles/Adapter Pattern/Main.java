//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        PaymentProcessor paypal =
                new PayPalAdapter(new PayPalGateway());

        paypal.processPayment(2500);
        
        PaymentProcessor stripe =
                new StripeAdapter(new StripeGateway());

        stripe.processPayment(5000);
    }
}
