package CompanyHierarchy.Models;

import CompanyHierarchy.Enums.Department;
import CompanyHierarchy.Interfaces.ISalesEmployee;

import java.util.LinkedList;
import java.util.List;

public class SalesEmployee extends RegularEmployee implements ISalesEmployee {
    private List<Sale> sales;

    public SalesEmployee (int id, String firstName, String lastName, Department department) {
        super (id, firstName, lastName, department);

        this.sales = new LinkedList<>();
    }

    @Override
    public List<Sale> getSales() {
        return this.sales;
    }

    @Override
    public String toString() {
        return "SalesEmployee{" +
                "sales=" + sales +
                '}';
    }
}
