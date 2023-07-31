import java.util.HashMap;
import java.util.Map;

public class Customer {

    private final Map<Product, Integer> purchasedProducts;
    private ShoppingCart shoppingCart;
    private float money;
    public Customer(float money) {
        this.money = money;
        purchasedProducts = new HashMap<>();
    }
    public void getShoppingCart(Shop shop) {
        shoppingCart =  new ShoppingCart(shop);
    }
    public float getMoney() {
        return money;
    }
    public void addMoney(float money) {
        this.money += money;
    }

    public void purchase() {
        cartIsValid();
        if (getTotalPrice() > money) {
            System.out.println("Not enough money to buy all products in the shopping cart");
            return;
        }
        Product key;
        int value;
        for (Map.Entry<Product, Integer> productInCart : shoppingCart.getProductsInCart().entrySet()) {
            key = productInCart.getKey();
            value = productInCart.getValue();
            if(purchasedProducts.containsKey(key)) {
                purchasedProducts.replace(key, value + purchasedProducts.get(key));
            } else {
                purchasedProducts.put(key, value);
            }
        }
        System.out.println("All products in the shopping cart are purchased");
        money -= getTotalPrice();
        shoppingCart.removeAllProducts();

    }

    public void getPurchasedProducts() {
        for (Map.Entry<Product, Integer> pr : purchasedProducts.entrySet()) {
            System.out.println(pr.getKey().getName() + ": " + pr.getValue() + " samples each " + pr.getKey().getPrice() + "AMD");
        }
    }

    public void addProductToCart(Product product, int quantity) {
        cartIsValid();
        shoppingCart.addProduct(product, quantity);
        System.out.println(quantity + " " + product.getName() + "s are added to the shopping cart");
    }
    public void removeProductFromCart(Product product, int quantity) {
        cartIsValid();
        shoppingCart.removeProduct(product, quantity);
        System.out.println(quantity + " " + product.getName() + "s are removed from the shopping cart");

    }

    public float getTotalPrice() {
        cartIsValid();
        float additionalPrice = 0;
        if (getTotalShippingWeight() >= 10) {
            additionalPrice += 1500;
        }
        if (getTotalDownloadSize() > 30) {
            additionalPrice += 500;
        }
        return shoppingCart.getTotalPrice() + additionalPrice ;
    }

    public int getProductQuantityInCart(Product product) {
        return shoppingCart.getProductQuantityInCart(product);
    }


    public float getTotalShippingWeight() {
        cartIsValid();
        return shoppingCart.getTotalShippingWeight();
    }

    public float getTotalDownloadSize() {
        cartIsValid();
        return shoppingCart.getTotalDownloadSize();
    }

    private void cartIsValid() {
        if (shoppingCart == null) {
            throw new NullPointerException("Shop is not choosen");
        }
    }


}
