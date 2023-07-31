import java.util.HashMap;
import java.util.Map;

public class Shop {
    private final Map<Product, Integer> products;
    private final WareHouse wareHouse;
    public Shop(WareHouse wareHouse) {
        products = new HashMap<>();
        this.wareHouse = wareHouse;
    }

    public  Map<Product, Integer> getProductsInShop() {
        return products;
    }

    public void addProductToShop(Product product, int quantity) {
        wareHouse.removeProductFromWareHouse(product, quantity);
        if (products.containsKey(product)) {
            products.replace(product, products.get(product) + quantity);
        } else {
            products.put(product, quantity);
        }
    }

    public void removeProductFromShop(Product product, int quantity) {
        if(!products.containsKey(product) || quantity > getProductQuantityInShop(product)) {
            addProductToShop(product, quantity - getProductQuantityInShop(product));
        }
        products.replace(product, products.get(product) - quantity);
    }

    public Product getProduct(String name) {
        for (Product key : products.keySet() ) {
            if(key.getName().equals(name)) {
                return key;
            }
        }
        throw new ProductIsNotFoundException("Following product is not found in the Shop: ");
    }

    public int getProductQuantityInShop(Product product) {
        if(!products.containsKey(product)) {
            return 0;
        }
        return products.get(product);
    }

}
