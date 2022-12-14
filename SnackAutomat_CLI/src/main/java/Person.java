import java.util.ArrayList;
import java.util.Scanner;

public class Person {
    private String personName;
    private float budget;
    private ArrayList<Item> bag;

    public personInfo(String personName, float budget){
        this.personName = personName;
        this.budget = budget;
    }

    public String getPersonName() {
        return personName;
    }
    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public float getBudget() {
        return budget;
    }
    public void setBudget(float budget) {
        this.budget = budget;
    }
}
