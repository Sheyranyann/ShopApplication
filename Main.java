
public class Main {
    public static void main(String[] args) {
        //TESTS
        System.out.println();

        //Creating WareHouse
        WareHouse wareHouse = new WareHouse();
        Product pr1 = new PhysicalProduct("Water", 300f, 2f);
        Product pr2 = new PhysicalProduct("Bread", 350f, 1f);
        Product pr3 = new PhysicalProduct("Ice cream", 350f, 0.6f);
        Product pr4 = new PhysicalProduct("Pencil", 200f, 0.3f);

        wareHouse.addProductToWareHouse(pr1, 25);
        wareHouse.addProductToWareHouse(pr2, 15);
        wareHouse.addProductToWareHouse(pr3, 20);

        wareHouse.addProductToWareHouse(pr2, 3);
        wareHouse.removeProductFromWareHouse(pr1,4);
        wareHouse.removeProductFromWareHouse(pr3, 20);

////        ProductIsNotFoundException
//        wareHouse.removeProductFromWareHouse(pr4, 20);
////        NotEnoughProductsException
//        wareHouse.removeProductFromWareHouse(pr2, 75);

        System.out.println("There are " + wareHouse.getProductQuantityInWareHouse(pr1) + " " + pr1.getName() + "2 in WareHouse");
        System.out.println("There are " + wareHouse.getProductQuantityInWareHouse(pr2) + " " + pr2.getName() + "s in WareHouse");
        System.out.println("There are " + wareHouse.getProductQuantityInWareHouse(pr3) + " " + pr3.getName() + "s in WareHouse");
        wareHouse.getProductQuantityInWareHouse(pr4);

        System.out.println();


        //Creating Shop
        Shop shop1 = new Shop(wareHouse);
        System.out.println("There are " + wareHouse.getProductQuantityInWareHouse(pr1) + " " + pr1.getName() + " in WareHouse");

        shop1.addProductToShop(pr1, 10);
        System.out.println("There are " + wareHouse.getProductQuantityInWareHouse(pr1) + " " + pr1.getName() + " in WareHouse");
        System.out.println("There are " + shop1.getProductQuantityInShop(pr1) + " " + pr1.getName() + " in shop");
        System.out.println("There are " + shop1.getProductQuantityInShop(pr3) + " " + pr3.getName() + "s in shop");

        shop1.removeProductFromShop(pr1, 6);
        System.out.println("There are " + shop1.getProductQuantityInShop(pr1) + " " + pr1.getName() + "s in shop");

        shop1.addProductToShop(pr2, 10);
        shop1.removeProductFromShop(pr2, 14);
        System.out.println(shop1.getProductQuantityInShop(pr2));

////        NotEnoughProductsException
//        shop1.removeProductFromShop(pr2, 5);

//        shop1.addProductToShop(pr1, 32);

////        ProductIsNotFoundException
//        Product product = shop1.getProduct("Soda");

//        Product product2 = new Product("Soda", 450f);
//        shop1.addProductToShop(product2, 3);


        Product pr5 = shop1.getProduct("Water");
        System.out.println("Price of " + pr5.getName() + " is " + pr5.getPrice() + " and there are " + shop1.getProductQuantityInShop(pr5) + " " + pr5.getName() + "s in the shop");
////        ProductIsNotFoundException
//        pr5 = shop1.getProduct("Coca Cola");


        //Creating customer

        Product product1 = new PhysicalProduct("Pen", 220f, 0.5f);
        Product product2 = new PhysicalProduct("Candy", 450f, 1f);
        Product product3 = new PhysicalProduct("Ball", 600f, 0.8f);
        Product product4 = new PhysicalProduct("Plate", 1000f, 1f);
        Product digProduct = new DigitalProduct("Book", 2000f, 35f);

        WareHouse wareHouse2 = new WareHouse();
        wareHouse2.addProductToWareHouse(product1, 50);
        wareHouse2.addProductToWareHouse(product2, 50);
        wareHouse2.addProductToWareHouse(product3, 50);
        wareHouse2.addProductToWareHouse(digProduct, 5);

        Shop shop2 = new Shop(wareHouse2);
        Shop shop3 = new Shop(wareHouse2);

        shop2.addProductToShop(product1, 5);
        shop2.addProductToShop(product2,10);
        shop3.addProductToShop(product3,2);

        Customer customer = new Customer(1500f);

////        Shop is not choosen
//        System.out.println("Total price is " + customer.getTotalPrice());

        customer.getShoppingCart(shop2);

        ////        ProductIsNotFoundException
//        customer.addProductToCart(product4, 5);


        System.out.println("Total price is " + customer.getTotalPrice());
        customer.addProductToCart(product2, 5);
        System.out.println("Total price is " + customer.getTotalPrice());
        customer.purchase();

        System.out.println("Quantity in shop: " + shop2.getProductQuantityInShop(product2));
        System.out.println("Quantity in cart: " + customer.getProductQuantityInCart(product2));

        customer.removeProductFromCart(product2,2);

        System.out.println("Quantity in shop: " + shop2.getProductQuantityInShop(product2));
        System.out.println("Quantity in cart: " + customer.getProductQuantityInCart(product2));


        System.out.println("Total price is " + customer.getTotalPrice());
        System.out.println("Customer's money: " + customer.getMoney());
        customer.purchase();
        customer.getPurchasedProducts();

        System.out.println();

        //In Warehouse but not in the shop
        System.out.println("Total weight of physical products is " + customer.getTotalShippingWeight());
        System.out.println("Total download size is " + customer.getTotalDownloadSize());
        System.out.println("Total price is " + customer.getTotalPrice());
        customer.addProductToCart(product3, 15);
        customer.addProductToCart(digProduct, 5);
        System.out.println("Total weight of physical products is " + customer.getTotalShippingWeight());
        System.out.println("Total download size is " + customer.getTotalDownloadSize());
        System.out.println("Total price is " + customer.getTotalPrice());
        System.out.println("Customer's money: " + customer.getMoney());
        customer.purchase();
        customer.addMoney(customer.getTotalPrice() - customer.getMoney());

        System.out.println("Customer's money: " + customer.getMoney());
        customer.purchase();
        System.out.println("Customer's money: " + customer.getMoney());

        customer.getPurchasedProducts();
        System.out.println("Total weight of physical products is " + customer.getTotalShippingWeight());
        System.out.println("Total download size is " + customer.getTotalDownloadSize());
        System.out.println("Total price is " + customer.getTotalPrice());

        customer.getShoppingCart(shop3);
        customer.addProductToCart(product3,2);
        customer.addMoney(customer.getTotalPrice() - customer.getMoney());
        customer.purchase();

        customer.getPurchasedProducts();

    }

}