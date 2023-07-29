public class DigitalProduct extends Product {
    private final String name;
    private final Float price;
    private final Float size;

    public DigitalProduct(String name, Float price, Float size) {
        this.name = name;
        this.price = price;
        this.size = size;
    }

    public Float getDownloadSize() {
         return size;
     }
    @Override
    public String getName() {
        return name;
    }
    @Override
    public Float getPrice() {
        return price;
    }

}
