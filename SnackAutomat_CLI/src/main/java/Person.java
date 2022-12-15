import java.util.ArrayList;

public class Person {
    private String personName;
    private float budget;
    private ArrayList<Item> bag;

    public Person(String personName, float budget){
        this.personName = personName;
        this.budget = budget;
    }

    public String toString(){
        return String.format("Name: %s\nBudget: %.2f", personName, budget);
        for(int i = 0; i < bag.size(); i++) System.out.println((bag.get(i)).toString());
    }

    public String getPersonName() {return personName;}
    public float getBudget() {return budget;}

    public void setPersonName(String personName) {this.personName = personName;}
    public void setBudget(float budget) {this.budget = budget;}
}
