package Problem_01_ListyIterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListyIterator implements Iterator<String> {

    private List<String> items;
    private int index;

    public ListyIterator(String... items){
        this.index = 0;
        this.setItems(items);
    }

    private void setItems(String... items) {
        if (items.length == 0) {
            this.items = new ArrayList<>();
        } else {
            this.items = Arrays.asList(items);
        }
    }

    public boolean move(){

        if (this.index >= this.items.size() - 1) {
            return false;
        } else {
            this.index++;
            return true;
        }
    }

    public void print(){
        if (this.index < this.items.size()) {
            System.out.println(this.next());
        } else {
            System.out.println("Invalid Operation!");
        }
    }

    @Override
    public boolean hasNext() {
        return this.index < this.items.size() - 1;
    }

    @Override
    public String next() {
        return this.items.get(this.index);
    }
}
