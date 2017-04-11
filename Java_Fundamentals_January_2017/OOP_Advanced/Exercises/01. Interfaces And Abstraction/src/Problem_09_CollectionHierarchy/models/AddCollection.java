package Problem_09_CollectionHierarchy.models;

import Problem_09_CollectionHierarchy.contracts.Addable;

import java.util.ArrayList;
import java.util.List;

public class AddCollection implements Addable {

    private List<String> collection;

    protected List<String> getCollection(){
        return this.collection;
    }

    public AddCollection(){
        this.collection = new ArrayList<>();
    }

    @Override
    public int add(String item) {
        this.collection.add(item);
        int lastIndex = this.collection.size() - 1;
        return lastIndex;
    }
}
