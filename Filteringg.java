import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

class Product {
    String name;
    double price;
    boolean inStock;

    public Product(String name, double price, boolean inStock) {
        this.name = name;
        this.price = price;
        this.inStock = inStock;
    }

    @Override
    public String toString() {
        return "Product{name='" + name + "', price=" + price + ", inStock=" + inStock + "}";
    }
}

public class Filteringg {
    public static void main(String[] args) {
        List<Product> list = new ArrayList<>();
        
        // Custom items for the list
        list.add(new Product("Matcha", 9.0, true));
        list.add(new Product("Latte", 7.0, true));
        list.add(new Product("Americano", 6.0, false));
        list.add(new Product("Chay", 2.0, true));

        Predicate<Product> isAffordable = p -> p.price < 8 && p.inStock;

        list.removeIf(p -> !isAffordable.test(p));
        
        System.out.println("Available affordable items:");
        list.forEach(p -> System.out.println(p));
    }
}