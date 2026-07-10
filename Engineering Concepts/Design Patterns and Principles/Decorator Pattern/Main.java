//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Notifier emailNotifier = new EmailNotifier();
        emailNotifier.send("Welcome!");

        System.out.println();

        Notifier emailSMSNotifier =
                new SMSNotifierDecorator(new EmailNotifier());

        emailSMSNotifier.send("Your OTP is 123456");

        System.out.println();

        Notifier allNotifier =
                new SlackNotifierDecorator(
                        new SMSNotifierDecorator(
                                new EmailNotifier()));

        allNotifier.send("Server is down!");
    }
}
