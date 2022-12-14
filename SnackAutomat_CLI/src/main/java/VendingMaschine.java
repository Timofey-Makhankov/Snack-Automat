import java.util.ArrayList;

public class VendingMaschine {
    private ArrayList<Item> items;
    private int maxItems = 10;

    public VendingMaschine(){
        int initialCapacity = 36;
        this.items = new ArrayList<>(initialCapacity);
    }

    public int getItemAmount(){
        return this.items.size();
    }

    public void addItem(int id, String name, int amount, float price){
        this.items.add(new Item(name, id, price, amount));
    }

    public void changePrice(int index, float newPrice){
        this.items.get(index).setPrice(newPrice);
    }

    public Boolean fillUp(int index, int amount){
        int itemAmount = this.items.get(index).getAmount();
        itemAmount += amount;
        if (itemAmount > this.maxItems + 1){
        this.items.get(index).setAmount(itemAmount);
            return true;
        } else {
            return false;
        }
    }

    public void printItemList(){
        System.out.printf("Item: Name, Amount, Price\n");
        for (Item item: this.items){
            System.out.printf("%d: %s - %d - %.2fCHF\n",
                    item.getId(),
                    item.getName(),
                    item.getAmount(),
                    item.getPrice()
            );
        }
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public int getMaxItems() {
        return maxItems;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }
}
