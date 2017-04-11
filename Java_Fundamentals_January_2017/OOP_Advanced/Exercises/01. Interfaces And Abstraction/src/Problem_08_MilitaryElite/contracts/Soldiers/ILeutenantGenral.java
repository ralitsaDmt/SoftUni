package Problem_08_MilitaryElite.contracts.Soldiers;

import Problem_08_MilitaryElite.models.Soldiers.Private;

import java.util.List;

public interface ILeutenantGenral {
    List<Private> getPrivates();

    void addPrivate(Private aPrivate);
}
