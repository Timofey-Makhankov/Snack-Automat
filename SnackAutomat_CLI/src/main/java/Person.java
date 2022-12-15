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

    public String getPersonName() {
        return personName;
    }

    public float getBudget() {
        return budget;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public void setBudget(float budget) {
        this.budget = budget;
    }
}
