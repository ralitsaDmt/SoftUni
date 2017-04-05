package FamilyTree;

import java.util.*;

public class Person {
    private String name;
    private Date birthDate;
    private HashSet<Person> parents;
    private HashSet<Person> children;

    public Person(String name, Date birthDate){
        this.setName(name);
        this.setBirthDate(birthDate);
        this.parents = new HashSet<>();
        this.children = new HashSet<>();
    }

    public Person(String name) {
        this (name, null);
    }

    public Person(Date birthDate){
        this (null, birthDate);
    }

    public String getName(){
        return this.name;
    }

    public void setName(String value){
        this.name = value;
    }

    public Date getBirthDate(){
        return this.birthDate;
    }

    public void setBirthDate(Date value){
        this.birthDate = value;
    }

    public void addChild(Person child) {
        this.children.add(child);
    }

    public void addParent(Person parent) {
        this.parents.add(parent);
    }

    public HashSet<Person> getParents() {
        return this.parents;
    }

    public HashSet<Person> getChildren() {
        return this.children;
    }

    @Override
    public String toString() {
        if (this.name == null) {
            return String.format("%1$td/%1$tm/%1$tY", this.birthDate);
        } else if (this.birthDate == null) {
            return this.name;
        } else {
            return this.name
                    + " " + String.format("%1$td/%1$tm/%1$tY", this.birthDate);
        }
    }
}
