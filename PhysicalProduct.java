public class PhysicalProduct extends Product {
    private final String name;
    private final Float price;
    private final Float weight;
    public PhysicalProduct(String name, Float price, Float weight) {
        this.name = name;
        this.price = price;
        this.weight = weight;
    }

    public Float getShippingWeight() {
        return weight;
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
