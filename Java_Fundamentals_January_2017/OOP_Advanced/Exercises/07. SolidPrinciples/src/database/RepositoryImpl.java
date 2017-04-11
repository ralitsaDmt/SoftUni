package database;

import Utility.Constants;
import contracts.Modelable;
import contracts.Repository;
import exeptions.DuplicateModelException;
import exeptions.NonExistantModelException;

import java.util.HashMap;
import java.util.Map;

public class RepositoryImpl<T extends Modelable> implements Repository {

    private Map<String, Modelable> itemsByModel;

    public RepositoryImpl()
    {
        this.itemsByModel = new HashMap<>();
    }

    @Override
    public void add(Modelable item) throws DuplicateModelException {
        String model = item.getModel();
        if (this.itemsByModel.containsKey(model))
        {
            throw new DuplicateModelException(Constants.DUPLICATE_MODEL_MESSAGE);
        }

        this.itemsByModel.put(model, item);
    }


    @Override
    public Modelable getItem(String model) throws NonExistantModelException {
        if (!this.itemsByModel.containsKey(model))
        {
            throw new NonExistantModelException(Constants.NON_EXISTANT_MODEL_MESSAGE);
        }

        return this.itemsByModel.get(model);
    }

}
