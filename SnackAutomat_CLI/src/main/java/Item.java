public class Item {
    private String name;
    private int id;
    private float price;
    private int amount;

    public Item(String name, int id, float price, int amount) {
        this.name = name;
        this.id = id;
        this.price = price;
        this.amount = amount;
    }

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

    public void setName(String name) {
        this.name = name;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setPrice(float price) {
        this.price = price;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
}
