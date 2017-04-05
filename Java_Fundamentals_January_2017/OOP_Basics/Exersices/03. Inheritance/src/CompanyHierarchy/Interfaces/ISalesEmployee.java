package CompanyHierarchy.Interfaces;

import CompanyHierarchy.Models.Sale;

import java.util.List;

public interface ISalesEmployee extends IRegularEmployee {
    List<Sale> getSales();
}
