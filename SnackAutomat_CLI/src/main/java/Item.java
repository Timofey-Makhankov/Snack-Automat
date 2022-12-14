public class Item {
    private String name;
    private int id;
    private float price;
    private int amount;

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public float getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }

    public Item(String name, int id, float price, int amount) {
        this.name = name;
        this.id = id;
        this.price = price;
        this.amount = amount;
    }
}
