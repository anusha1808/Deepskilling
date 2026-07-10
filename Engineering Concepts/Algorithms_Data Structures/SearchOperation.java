public class SearchOperation {

    // Linear Search
    public static Product linearSearch(Product[] products, int targetId) {

        for (Product product : products) {
            if (product.getProductId() == targetId) {
                return product;
            }
        }

        return null;
    }

    // Binary Search
    public static Product binarySearch(Product[] products, int targetId) {

        int low = 0;
        int high = products.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            if (products[mid].getProductId() == targetId) {
                return products[mid];
            }

            else if (products[mid].getProductId() < targetId) {
                low = mid + 1;
            }

            else {
                high = mid - 1;
            }
        }

        return null;
    }
}
