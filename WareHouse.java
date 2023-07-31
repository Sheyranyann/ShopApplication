import java.util.HashMap;
import java.util.Map;
public class WareHouse {

    private final Map<Product, Integer> productCount;
    public WareHouse() {
        productCount = new HashMap<>();
    }
    public void addProductToWareHouse(Product product, int quantity) {
        if (productCount.containsKey(product)) {
            productCount.replace(product, productCount.get(product) + quantity);
        } else {
            productCount.put(product, quantity);
        }
    }

    public void removeProductFromWareHouse(Product product, int quantity) {
        if (!productCount.containsKey(product)) {
            throw new ProductIsNotFoundException("Following product is not found in the Warehouse: ");
        }
        if (quantity > productCount.get(product)) {
            throw new NotEnoughProductsException("There are not enough products in the Warehouse");
        }
        productCount.replace(product, productCount.get(product) - quantity);
    }

    public Integer getProductQuantityInWareHouse(Product product) {
        if (!productCount.containsKey(product)) {
            System.out.println(("Following product is not found in the Warehouse"));
            return null;
        }
        if (productCount.get(product) == 0) {
            System.out.print("Product is out of stock: ");
            return 0;
        }
        return productCount.get(product);
    }


}
