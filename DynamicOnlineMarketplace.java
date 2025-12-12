/*2. Dynamic Online Marketplace
Concepts: Type Parameters, Generic Methods, Bounded Type Parameters
Problem Statement:
Build a generic product catalog for an online marketplace that supports various product types like Books, Clothing, and Gadgets. Each product type has a specific price range and category.
Hints:
Define a generic class Product<T> where T is restricted to a category (BookCategory, ClothingCategory, etc.).
Implement a generic method to apply discounts dynamically (<T extends Product> void applyDiscount(T product, double percentage)).
Ensure type safety while allowing multiple product categories to exist in the same catalog. */
import java.util.*;

public class DynamicOnlineMarketplace {
    static class Book {}
    static class Clothing {}
    static class Gadget {}
    static class Product<T> {
        String name;
        double price;
        T type;

        Product(String name, double price, T type) {
            this.name = name;
            this.price = price;
            this.type = type;
        }

        public String toString() {
            return name + " - Rs" + price;
        }
    }

    static class Discount {
        static <T> void apply(Product<T> p, double percent) {
            p.price -= p.price * percent / 100;
        }
    }


    static class Catalog {
        List<Product<?>> list = new ArrayList<>();
        void add(Product<?> p) { list.add(p); }
        void show() { list.forEach(System.out::println); }
    }

    public static void main(String[] args) {
        Catalog catalog = new Catalog();
        Product<Book> b = new Product<>("Java Book", 500, new Book());
        Product<Clothing> c = new Product<>("Shirt", 300, new Clothing());
        Product<Gadget> g = new Product<>("Headphone", 800, new Gadget());
        catalog.add(b);
        catalog.add(c);
        catalog.add(g);
        Discount.apply(g, 10);
        catalog.show();
    }
}

