package Problem_09_CollectionHierarchy.models;

import Problem_09_CollectionHierarchy.contracts.Removable;

public class AddRemoveCollection extends AddCollection implements Removable {

    @Override
    public int add(String item) {

        if (super.getCollection().size() > 0){
            super.getCollection().add(0, item);
            return 0;
        } else {
            return super.add(item);
        }
    }

    @Override
    public String remove() {
        int lastIndex = super.getCollection().size() - 1;
        String itemToRemove = this.getCollection().get(lastIndex);
        this.getCollection().remove(lastIndex);
        return itemToRemove;
    }
}
