package Problem_09_CollectionHierarchy;

import Problem_09_CollectionHierarchy.contracts.Addable;
import Problem_09_CollectionHierarchy.contracts.Removable;
import Problem_09_CollectionHierarchy.models.AddCollection;
import Problem_09_CollectionHierarchy.models.AddRemoveCollection;
import Problem_09_CollectionHierarchy.models.MyList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        String firstLine = reader.readLine();

        String[] elementsToAdd = firstLine.split("\\s+");
        int removesCount = Integer.parseInt(reader.readLine());

        AddCollection addCollection = new AddCollection();
        AddRemoveCollection addRemoveCollection = new AddRemoveCollection();
        MyList list = new MyList();

        String addIndexesAddCollection = fillCollection(addCollection, elementsToAdd);
        
        String addIndexesAddRemoveCollection = fillCollection(addRemoveCollection, elementsToAdd);
        
        String addIndexesMyList = fillCollection(list, elementsToAdd);
        
        String removedItemsAddRemoveCollection = removeItems(addRemoveCollection, removesCount);

        String removedItemsMyList = removeItems(list, removesCount);
        
        System.out.println(addIndexesAddCollection);
        System.out.println(addIndexesAddRemoveCollection);
        System.out.println(addIndexesMyList);
        System.out.println(removedItemsAddRemoveCollection);
        System.out.println(removedItemsMyList);
    }

    private static String fillCollection(Addable collection, String[] elementsToAdd) {

        StringBuilder indexesBuilder = new StringBuilder();

        for (String item : elementsToAdd) {
            String index = String.valueOf(collection.add(item));
            indexesBuilder.append(index)
                    .append(" ");
        }

        String trimmedOuput = indexesBuilder.substring(0, indexesBuilder.length());
        return trimmedOuput;
    }

    private static String removeItems(Removable collection, int countOfItemsToRemove) {
        StringBuilder removedItems = new StringBuilder();

        for (int i = 0; i < countOfItemsToRemove; i++) {
            String removedItem = collection.remove();
            removedItems.append(removedItem)
                    .append(" ");
        }

        String trimmedRemovedItems = removedItems.substring(0, removedItems.length());
        return trimmedRemovedItems;
    }
}
