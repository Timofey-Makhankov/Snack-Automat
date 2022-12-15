import java.io.*;
import java.util.ArrayList;

public class VendingMachine {
    private ArrayList<Item> items;
    private int width;
    private int height;

    /**
     * Constructor: Sets the Maximum Amount in one Item and initialize the Item Array
     */
    public VendingMachine(int row, int column) {
        this.width = column;
        this.height = row;
        int initialCapacity = column * row;
        this.items = new ArrayList<>(initialCapacity);
    }

    /**
     * Get The Amount of Items in the ArrayList
     *
     * @return the Amount of Items in the Vending Machine
     */
    public int getItemAmount() {
        return this.items.size();
    }

    /**
     * Adds an Item to the Vending Machine Array
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
        for (int i = 0; i <= this.height; i++) {
            for (int l = 0; l < this.width; l++) {
                System.out.print("               |");
            }
            System.out.println();
            for (int l = 0; l < this.width; l++) {
                System.out.print("               |");
            }
            System.out.println();
            for (int l = 0; l < this.width; l++) {
                System.out.printf("       %2s      |", getItem(i, l).getImage());
            }
            System.out.println();
            for (int l = 0; l < this.width; l++) {
                System.out.print("               |");
            }
            System.out.println();
            for (int l = 0; l < this.width; l++) {
                System.out.printf("  amount: %2d   |", getItem(i, l).getAmount());
            }
            System.out.println();
            for (int l = 0; l < this.width; l++) {
                System.out.printf("    id: %3d    |", getItem(i, l).getId());
            }
            System.out.println();
            for (int l = 0; l < this.width; l++) {
                System.out.print("_______________|");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("Id      product(price)\n");
        for (Item item :
                this.items) {
            System.out.printf("%d       %s(%.2fCHF)\n", item.getId(), item.getName(), item.getPrice());
        } System.out.println();
    }

    /**
     * prints out the Whole Item Array from a Vending Machine
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
        File file = new File("src/VendingMachineASCII.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
    }

    public Item getItem(int i, int j) {
        try {
            return this.items.get(j + i * 3);
        } catch (Exception e) {
            return new Item("None", 0, 0, 0);
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
