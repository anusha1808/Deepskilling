public class Main {
    public static void main(String[] args) {
        Computer computer = new Computer.Builder()
                .setCPU("Intel Core i9")
                .setRAM("32 GB")
                .setStorage("1 TB SSD")
                .build();

        computer.display();
    }
}
