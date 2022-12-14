import java.util.ArrayList;

public class VendingMaschine {
    private ArrayList<Item> items;

    public VendingMaschine(){
        int initialCapacity = 36;
        this.items = new ArrayList<>(initialCapacity);
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }
}
