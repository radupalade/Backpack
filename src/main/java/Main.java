import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {


       /* Item item1 = new Sunglasses("ochelari", 2, 10);
        Item item2 = new Sunglasses("aaa", 2, 10);
        Item item3 = new Sunglasses("vvv", 3, 12);
*/
        Problem problem = new Problem();
        problem.setBackpack(new Backpack(12));


  /*      problem.addAvailableItems(item1);
        problem.addAvailableItems(item2);
        problem.addAvailableItems(item3);*/
        problem.moveItemToBackpack();

        problem.getTotalWeightOfItemsInBackpack();

        System.out.println("total value in the backpack is: " + problem.getTotalValueOfTheItemsInBackpack());
        System.out.println("total weight of items in BP is: " + problem.getTotalWeightOfItemsInBackpack());

        System.out.println("the weight that is still available: " + problem.getAvailableCapacity());

        List<Item> generateItems = Util.generateItems(100);
        System.out.println(generateItems);
        problem.setAvailableItems(generateItems);
        Util.saveProblem(problem);

        problem.moveProfitableItemsToBackpack();
        double totalWeightOfItemsInBkacpack = problem.getTotalWeightOfItemsInBackpack();
        double backpackCapacity = problem.getBackpackCapacity();

        System.out.println("capacity: " + backpackCapacity + ", total weight in backpack: " + totalWeightOfItemsInBkacpack);

        double totalValue = problem.getTotalValueOfTheItemsInBackpack();
        System.out.println("total value is: " + totalValue);

        /////////////////////////////////////////////////////////////////
        System.out.println("\n\n");
        //cazul nesortat
        problem.setBackpack(new Backpack(12)); // resetam rucascul
        problem.moveItemToBackpack();
        totalWeightOfItemsInBkacpack = problem.getTotalWeightOfItemsInBackpack();
        backpackCapacity = problem.getBackpackCapacity();

        System.out.println("capacity: " + backpackCapacity + ", total weight in backpack: " + totalWeightOfItemsInBkacpack);

        totalValue = problem.getTotalValueOfTheItemsInBackpack();
        System.out.println("total value is: " + totalValue);

        //cazul obiecte usoare
        problem.setBackpack(new Backpack(12)); // resetam rucascul
        problem.moveLightItemsToBackpack();
        totalWeightOfItemsInBkacpack = problem.getTotalWeightOfItemsInBackpack();
        backpackCapacity = problem.getBackpackCapacity();

        System.out.println("capacity: " + backpackCapacity + ", total weight in backpack: " + totalWeightOfItemsInBkacpack + " "
                + "number of items in bp: " + problem.getNumberOfItemsInBP());

        totalValue = problem.getTotalValueOfTheItemsInBackpack();
        System.out.println("total value is: " + totalValue);


        //cazul obiecte factionare
        problem.setBackpack(new Backpack(12)); // resetam rucascul
        problem.moveFractionItemsToBackpack();
        totalWeightOfItemsInBkacpack = problem.getTotalWeightOfItemsInBackpack();
        backpackCapacity = problem.getBackpackCapacity();

        System.out.println("capacity: " + backpackCapacity + ", total weight in backpack: " + totalWeightOfItemsInBkacpack + " "
                + "number of items in bp: " + problem.getNumberOfItemsInBP());

        totalValue = problem.getTotalValueOfTheItemsInBackpack();
        System.out.println("total value is: " + totalValue);


        problem.countAndCopyAvailableItems();
        System.out.println(problem.getCountAvailableItems());
        problem.calculateSumOfAvailableItems();
        System.out.println(problem.getSumOfItemValues());
        problem.calculateAverageValueOfAvailableItems();
        System.out.println(problem.getAverageValue());
        System.out.println();


    }

    public static void display(Problem problem) {
        double totalWeight;
        double bpCapacity;
        double totalValue;

        totalWeight = problem.getTotalWeightOfItemsInBackpack();
        bpCapacity = problem.getBackpackCapacity();
        totalValue = problem.getTotalValueOfTheItemsInBackpack();
        System.out.println(" " + bpCapacity + " " + totalWeight + " " + problem.getNumberOfItemsInBP());
        System.out.println("total value: " + totalValue);
        System.out.println("size: " + problem.getAvailableItemsSize() + "\n");
    }
}
