public class Main {

    public static void main(String[] args) {

        Product[] products = {
                new Product(101, "Laptop", "Electronics"),
                new Product(102, "Mobile", "Electronics"),
                new Product(103, "Shoes", "Fashion"),
                new Product(104, "Watch", "Accessories"),
                new Product(105, "Book", "Education")
        };

        System.out.println("Linear Search:");

        Product p1 = SearchOperation.linearSearch(products, 104);

        if (p1 != null)
            System.out.println(p1);
        else
            System.out.println("Product Not Found");

        System.out.println();

        System.out.println("Binary Search:");

        Product p2 = SearchOperation.binarySearch(products, 104);

        if (p2 != null)
            System.out.println(p2);
        else
            System.out.println("Product Not Found");
    }
}
