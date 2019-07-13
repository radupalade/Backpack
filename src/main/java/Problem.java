import java.util.*;

public class Problem {

    private Backpack backpack;
    private List<Item> availableItems;
    private Map<String, Integer> countAvailableItems;
    private Map<String, Double> sumOfItemValues;
    private Map<String, Double> averageValue;

    public Map<String, Integer> getCountAvailableItems() {
        return countAvailableItems;
    }

    public void setCountAvailableItems(Map<String, Integer> countAvailableItems) {
        this.countAvailableItems = countAvailableItems;
    }

    public Map<String, Double> getSumOfItemValues() {
        return sumOfItemValues;
    }

    public void setSumOfItemValues(Map<String, Double> sumOfItemValues) {
        this.sumOfItemValues = sumOfItemValues;
    }

    public Map<String, Double> getAverageValue() {
        return averageValue;
    }

    public void setAverageValue(Map<String, Double> averageValue) {
        this.averageValue = averageValue;
    }

    public Problem() {
        availableItems = new ArrayList<Item>();
        countAvailableItems = new HashMap<>();
        sumOfItemValues = new HashMap<>();
        averageValue = new HashMap<>();
    }


    public Backpack getBackpack() {
        return backpack;
    }

    public void setBackpack(Backpack backpack) {
        this.backpack = backpack;
    }

    public List<Item> getAvailableItems() {
        return availableItems;
    }

    public void setAvailableItems(List<Item> availableItems) {
        this.availableItems = availableItems;
    }

    public void addAvailableItems(Item item) {


        this.availableItems.add(item);

    }

    public double getTotalWeightOfItemsInBackpack() {

        return backpack.getTotalWeightOfItems();

    }

    public void moveItemToBackpack() {

        for (int i = 0; i < availableItems.size(); i++) {
            Item currentitem = availableItems.get(i);
            backpack.add(currentitem);

        }

    }

    public double getAvailableCapacity() {
        return backpack.getAvailableCapacity();
    }

    public double getTotalValueOfTheItemsInBackpack() {
        return backpack.getTotalValueOfItems();
    }

    public double getBackpackCapacity() {
        return backpack.getCapacity();
    }

    public void moveFractionItemsToBackpack() {
        Set<Item> itemSet = new TreeSet<>(availableItems);
        // System.out.println(itemSet);
        Iterator<Item> iterator = itemSet.iterator();
        while (iterator.hasNext()) {
            backpack.addFraction(iterator.next());
        }
    }


    public void moveProfitableItemsToBackpack() {
        Set<Item> itemSet = new TreeSet<>(availableItems);
        // System.out.println(itemSet);
        Iterator<Item> iterator = itemSet.iterator();
        while (iterator.hasNext()) {
            backpack.add(iterator.next());
        }
        /*for (int i = 0; i < itemSet.size(); i++) {
            System.out.println(itemSet);

        }*/

    }

    public void moveLightItemsToBackpack() {
        ItemComparatorByWeight comparator = new ItemComparatorByWeight();
        Set<Item> itemSet = new TreeSet<>(comparator);
        itemSet.addAll(availableItems);
        //  System.out.println(itemSet);
        Iterator<Item> iterator = itemSet.iterator();
        while (iterator.hasNext()) {
            backpack.add(iterator.next());
        }
    }

    public int getNumberOfItemsInBP() {
        return backpack.getNumberOfItems();
    }

   /* public List<Item> showGeneratedItems(){
        return Util.generateItems(100);

    }
*/

    public void removeItemsAfterPlacingThemInTheBP() {
        availableItems.removeAll(backpack.getItemList());
    }

    public void countAndCopyAvailableItems() {
        for (Item item : availableItems) {
            String key = item.getName();

            if (!countAvailableItems.containsKey(key)) {
                countAvailableItems.put(key, 1);
            } else {
                int value = countAvailableItems.get(key);
                value++;
                countAvailableItems.put(key, value);
            }
        }
    }

    public void calculateSumOfAvailableItems() {
        for (Item item : availableItems) {
            String key = item.getName();
            double value = item.getValue();
            double sum = 0;
            if (!sumOfItemValues.containsKey(key)) {
                sumOfItemValues.put(key, value);
            } else {
                double values = sumOfItemValues.get(key);
                sum = sum + values + value;
                sumOfItemValues.put(key, sum);
            }


        }

    }

    public void calculateAverageValueOfAvailableItems() {
        for (String key : sumOfItemValues.keySet()) {
            for (String keyAvailable : countAvailableItems.keySet()) {
                if (key.equals(keyAvailable)) {
                    averageValue.put(key, sumOfItemValues.get(key) / countAvailableItems.get(keyAvailable));
                }
            }
        }
    }

    public int getAvailableItemsSize() {
        return availableItems.size();
    }

    public void showItemListInBP() {
        backpack.showItemList();
    }
}

