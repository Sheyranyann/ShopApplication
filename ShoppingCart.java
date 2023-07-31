import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {

    private final Map<Product, Integer> products;
    private final Shop shop;
    public ShoppingCart(Shop shop) {
        products = new HashMap<>();
        this.shop = shop;
    }
    public  Map<Product, Integer> getProductsInCart() {
        return products;
    }
    public void addProduct(Product product, int quantity) {
        shop.removeProductFromShop(product, quantity);
        if(products.containsKey(product)) {
            products.replace(product, products.get(product) + quantity);
        } else {
            products.put(product, quantity);
        }
    }
    public void removeProduct(Product product, int quantity) {
        shop.getProductsInShop().replace(product, shop.getProductsInShop().get(product) + quantity);
        products.replace(product, products.get(product) - quantity);
    }
    public void removeAllProducts() {
        for (Map.Entry<Product, Integer> pr : products.entrySet()) {
            shop.getProductsInShop().replace(pr.getKey(), shop.getProductsInShop().get(pr.getKey()) + pr.getValue());
            pr.setValue(0);
        }
        products.clear();
    }

    public float getTotalShippingWeight() {
        float weight = 0;
        for (Map.Entry<Product, Integer> pr : products.entrySet()) {
            if(pr.getKey() instanceof PhysicalProduct) {
                weight += pr.getValue() * ((PhysicalProduct) pr.getKey()).getShippingWeight();
            }
        }
        return weight;
    }

    public float getTotalDownloadSize() {
        float MegaBytes = 0;
        for (Map.Entry<Product, Integer> pr : products.entrySet()) {
            if(pr.getKey() instanceof DigitalProduct) {
                MegaBytes += pr.getValue() * ((DigitalProduct) pr.getKey()).getDownloadSize();
            }
        }
        return MegaBytes;
    }

    public float getTotalPrice() {
        float totalPrice = 0;
        for (Map.Entry<Product, Integer> pr : products.entrySet()) {
            totalPrice += pr.getKey().getPrice() * pr.getValue();
        }
        return totalPrice;
    }

    public int getProductQuantityInCart(Product product) {
        return products.get(product);
    }

}
