import java.util.ArrayList;

public class Person {
    private String personName;
    private float budget;
    private ArrayList<Item> bag;

    public Person(String personName, float budget) {
        this.bag = new ArrayList<>();
        this.personName = personName;
        this.budget = budget;
    }

    public String toString() {
        String temp = "";
        if (this.bag.isEmpty()) {
            temp = "Empty";
        } else {
            for (Item item : bag) {
                temp = String.format(temp + item + "\n");
            }
        }
        return String.format("Name: %s\nBudget: %.2f\nBag:\n" + temp, personName, budget);
    }

    public void addToBag(Item item){
        this.bag.add(item);
    }

    public String getPersonName() {
        return personName;
    }

    public float getBudget() {
        return budget;
    }

    public ArrayList<Item> getBag() {
        return bag;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public void setBudget(float budget) {
        this.budget = budget;
    }

    public void setBag(ArrayList<Item> bag) {
        this.bag = bag;
    }
}
