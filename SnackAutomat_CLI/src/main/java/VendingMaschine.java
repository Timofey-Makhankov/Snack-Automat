import java.io.*;
import java.util.ArrayList;

public class VendingMaschine {
    private ArrayList<Item> items;
    private int width;
    private int height;

    /**
     * Constructor: Sets the Maximum Amount in one Item and initialize the Item Array
     */
    public VendingMaschine(int row, int column) {
        this.width = column;
        this.height = row;
        int initialCapacity = column * row;
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
     * @param item give an item to be added
     */
    public void addItem(Item item) {
        if (getHeight() * getWidth() > this.getItemAmount()) {
            this.items.add(item);
        }
    }

    public void replaceItem(int index, Item item) {
        this.items.set(index, item);
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
     */
    public void fillUp(int index, int amount) {
        int itemAmount = this.items.get(index).getAmount();
        itemAmount += amount;

        this.items.get(index).setAmount(itemAmount);
    }

    /**
     * prints out the Item Grid with their respective id, name and price
     */
    public void ItemGrid() {
        for (int i = 0; i <= 3; i++){
            for (int j = 0; j <= 3; j++){
                Item item =  this.items.get(j + i * 3);
                System.out.print("             |");
                System.out.print("   ______    |");
                System.out.print("  |      |   |");
                System.out.printf("  |  %s  |   |" + item.getImage());
                System.out.print("  |______|   |");
                System.out.printf("   id: %3d    |" + this.items.get(j + i * 3).getId());
                System.out.print("_____________|");
                System.out.println("\t");
            }
        }
        System.out.println("Id      product     price\n");
        for (Item item :
                this.items) {
            System.out.printf("%d    %s   %.2fCHF", item.getId(), item.getName(), item.getPrice());
        }

    }

    /**
     * prints out the Whole Item Array from a Vending Maschine
     */
    public void printItemList() {
        System.out.print("Item: Name, Amount, Price\n");
        int index = 0;
        for (Item item : this.items) {
            System.out.printf("%d: " + item, index);
            index++;
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

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    // Setters
    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
