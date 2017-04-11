package Problem_09_CollectionHierarchy.models;

import Problem_09_CollectionHierarchy.contracts.Usable;

public class MyList extends AddRemoveCollection implements Usable{

    @Override
    public String remove() {
        String itemToRemove = this.getCollection().get(0);
        this.getCollection().remove(0);
        return itemToRemove;
    }

    @Override
    public int getUsedElements() {
        int size = super.getCollection().size();
        return size;
    }
}
