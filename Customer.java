import java.util.HashMap;
import java.util.Map;

public class Customer {

    private final Map<Product, Integer> purchasedProducts;
    private ShoppingCart shoppingCart;
    private Float money;
    public Customer(Float money) {
        this.money = money;
        purchasedProducts = new HashMap<>();
    }
    public void getShoppingCart(Shop shop) {
        shoppingCart =  new ShoppingCart(shop);
    }
    public Float getMoney() {
        return money;
    }
    public void addMoney(Float money) {
        this.money += money;
    }

    public void purchase() {
        cartIsValid();
        if (shoppingCart.getTotalPrice() > money) {
            System.out.println("Not enough money to buy all products in the shopping cart");
            return;
        }
        Product key;
        Integer value;
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

    public void addProductToCart(Product product, Integer quantity) {
        cartIsValid();
        shoppingCart.addProduct(product, quantity);
        System.out.println(quantity + " " + product.getName() + "s are added to the shopping cart");
    }
    public void removeProductFromCart(Product product, Integer quantity) {
        cartIsValid();
        shoppingCart.removeProduct(product, quantity);
        System.out.println(quantity + " " + product.getName() + "s are removed from the shopping cart");

    }

    public Float getTotalPrice() {
        cartIsValid();
        Float additionalPrice = 0f;
        if (getTotalShippingWeight() >= 10) {
            additionalPrice += 1500;
        }
        if (getTotalDownloadSize() > 30f) {
            additionalPrice += 500;
        }
        return shoppingCart.getTotalPrice() + additionalPrice ;
    }

    public Integer getProductQuantityInCart(Product product) {
        return shoppingCart.getProductQuantityInCart(product);
    }


    public Float getTotalShippingWeight() {
        cartIsValid();
        return shoppingCart.getTotalShippingWeight();
    }

    public Float getTotalDownloadSize() {
        cartIsValid();
        return shoppingCart.getTotalDownloadSize();
    }

    private void cartIsValid() {
        if (shoppingCart == null) {
            throw new NullPointerException("Shop is not choosen");
        }
    }


}
