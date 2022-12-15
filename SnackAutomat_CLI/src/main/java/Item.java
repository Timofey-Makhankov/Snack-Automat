public class Item {
    private String name;
    private int id;
    private float price;
    private int amount;

    private String image = " ";

    public Item(String name, int id, float price, int amount) {
        this.name = name;
        this.id = id;
        this.price = price;
        this.amount = amount;
    }

    public String toString() {
        return String.format("%d - %s %s - %d - %.2fCHF\n", getId(), getImage(), getName(), getAmount(), getPrice());
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

    public String getImage() {
        return image;
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

    public void setImage(String image) {
        this.image = image;
    }
}
