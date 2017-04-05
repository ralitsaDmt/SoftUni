package CompanyHierarchy.Models;

import CompanyHierarchy.Interfaces.ICustomer;

public class Customer extends Person implements ICustomer {

    private double netPurchaseAmount;

    public Customer (int id, String firstName, String lastName, double netPurchaseAmount) {
        super (id, firstName, lastName);
        this.setNetPurchaseAmount(netPurchaseAmount);
    }

    private void setNetPurchaseAmount(double netPurchaseAmount) {
        if (netPurchaseAmount < 0) {
            throw new IllegalArgumentException("Invalid input!");
        }

        this.netPurchaseAmount = netPurchaseAmount;
    }

    @Override
    public double getTotalAmountSpent() {
        return this.netPurchaseAmount;
    }
}
