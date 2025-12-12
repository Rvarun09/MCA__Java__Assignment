/*1. Smart Warehouse Management System
Concepts: Generic Classes, Bounded Type Parameters, Wildcards
Problem Statement:
You are developing a Smart Warehouse System that manages different types of items like Electronics, Groceries, and Furniture. The system should be able to store and retrieve items dynamically while maintaining type safety.
Hints:
Create an abstract class WarehouseItem that all items extend (Electronics, Groceries, Furniture).
Implement a generic class Storage<T extends WarehouseItem> to store items safely.
Implement a wildcard method to display all items in storage regardless of their type (List<? extends WarehouseItem>).*/

import java.util.ArrayList;
import java.util.List;

abstract class WarehouseItem {
    String name;
    WarehouseItem(String name) { this.name = name; }
    public String toString() { return name; }
}
class Electronics extends WarehouseItem {
    Electronics(String name) { super(name); }
}

class Groceries extends WarehouseItem {
    Groceries(String name) { super(name); }
}

class Furniture extends WarehouseItem {
    Furniture(String name) { super(name); }
}
class Storage<T extends WarehouseItem> {
    List<T> items = new ArrayList<>();
    void add(T item) { items.add(item); }
    List<T> get() { return items; }
}
class Util {
    static void show(List<? extends WarehouseItem> list) {
        for (WarehouseItem item : list) {
            System.out.println(item);
        }
    }
}
public class SmartWarehouseManagementSystem {
    public static void main(String[] args) {

        Storage<Electronics> e = new Storage<>();
        e.add(new Electronics("Laptop"));
        e.add(new Electronics("Phone"));

        Storage<Groceries> g = new Storage<>();
        g.add(new Groceries("Rice"));
        g.add(new Groceries("Milk"));

        Storage<Furniture> f = new Storage<>();
        f.add(new Furniture("Chair"));
        f.add(new Furniture("Table"));

        Util.show(e.get());
        Util.show(g.get());
        Util.show(f.get());
    }
}
