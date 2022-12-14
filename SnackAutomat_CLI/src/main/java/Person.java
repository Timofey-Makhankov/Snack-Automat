import java.util.ArrayList;

public class Person {
    private String personName;
    private float budget;
    private ArrayList<Item> bag;

    public Person(String personName, float budget){
        this.personName = personName;
        this.budget = budget;
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
