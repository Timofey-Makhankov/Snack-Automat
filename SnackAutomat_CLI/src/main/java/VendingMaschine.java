import java.io.*;
import java.util.ArrayList;

public class VendingMaschine {
    private ArrayList<Item> items;
    private final int maxItems = 10;

    /**
     * Constructor: Sets the Maximum Amount in one Item and initialize the Item Array
     */
    public VendingMaschine() {
        int initialCapacity = 36;
        this.items = new ArrayList<>(initialCapacity);
    }

    /**
     * Get The Amount of Items in the ArrayList
     *
     * @return the Amount of Items in the Vending Maschine
     */
    public int getItemAmount() {
        return this.items.size();
    }

    /**
     * Adds an Item to the Vending Maschine Array
     *
     * @param id     specifier for the Item
     * @param name   given name for the Item
     * @param amount How many Items are in the Vending Maschine
     * @param price  the cost of the Item
     */
    public void addItem(int id, String name, int amount, float price, String emoji) {
        Item newItem = new Item(name, id, price, amount);
        newItem.setImage(emoji);
        this.items.add(newItem);
    }

    /**
     * to be able to change the Price of an Item
     *
     * @param index    What Item to change the Price
     * @param newPrice Given Price to be changed to
     */
    public void changePrice(int index, float newPrice) {
        this.items.get(index).setPrice(newPrice);
    }

    /**
     * Fill up an Item to a desired amount
     *
     * @param index  What Item to fill up
     * @param amount by how much to fill up
     * @return true if it was able to fill up, otherwise returns false if not
     */
    public Boolean fillUp(int index, int amount) {
        int itemAmount = this.items.get(index).getAmount();
        itemAmount += amount;
        if (itemAmount > this.maxItems + 1) {
            this.items.get(index).setAmount(itemAmount);
            return true;
        } else {
            return false;
        }
    }

    /**
     * prints out the Whole Item Array from a Vending Maschine
     */
    public void printItemList() {
        System.out.print("Item: Name, Amount, Price\n");
        for (Item item : this.items) {
            System.out.printf("%d: %s %s - %d - %.2fCHF\n",
                    item.getId(),
                    item.getImage(),
                    item.getName(),
                    item.getAmount(),
                    item.getPrice()
            );
        }
    }

    public void printTitle() throws IOException {
        File file = new File("src/VendingMaschineASCII.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
    }

    // Getters
    public ArrayList<Item> getItems() {
        return items;
    }

    public int getMaxItems() {
        return maxItems;
    }

    // Setters
    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }
}
