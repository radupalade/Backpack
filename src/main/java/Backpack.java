import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Backpack {

    private double capacity;
    private List<Item> itemList;

    public Backpack(double capacity) {
        itemList = new ArrayList<Item>();
        this.capacity = capacity;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public double getAvailableCapacity() {

        return capacity - getTotalWeightOfItems();
    }

    public double getTotalWeightOfItems() {

        double sum = 0;
        // double totalWeight = 0;
        for (Item item : itemList) {
            sum = sum + item.getWeight();
        }

        return sum;
    }

    public double getTotalValueOfItems() {

        double sum = 0;
        // double totalWeight = 0;
        for (Item item : itemList) {
            sum = sum + item.getValue();
        }

        return sum;
    }

    public void add(Item item) {
        if (getAvailableCapacity() >= item.getWeight()) {
            itemList.add(item);
        } else {
            System.out.println("backpack is full");
        }
    }

    public void addFraction(Item item) {
        double availableCapacity = getAvailableCapacity();
        if (availableCapacity == 0) {
            return;
        }
        if (getAvailableCapacity() >= item.getWeight()) {
            itemList.add(item);
        } else {
            Item fractionItem = new Item(item.getName(), availableCapacity, availableCapacity * item.getValue() / item.getWeight());
            itemList.add(fractionItem);
        }
    }

    public int getNumberOfItems() {
        return this.itemList.size();
    }


    public void showItemList() {
        for (Item item : itemList) {
            System.out.println(item);
        }
    }
}
