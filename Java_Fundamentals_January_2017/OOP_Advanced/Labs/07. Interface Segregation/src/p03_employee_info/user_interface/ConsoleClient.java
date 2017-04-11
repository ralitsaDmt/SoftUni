package p03_employee_info.user_interface;

import p03_employee_info.models.Employee;

import java.util.Comparator;

public class ConsoleClient {

    private Formatter formatter;
    private InfoProvider infoProvider;

    public ConsoleClient(Formatter formatter, InfoProvider provider){
        this.formatter = formatter;
        this.infoProvider = provider;
    }

    public String getResultByName(){

        Comparator<Employee> comparator = (e1, e2) -> e1.getName().compareTo(e2.getName());

        return this.formatter.format(
                this.infoProvider.getEmployeesBy(comparator));
    }

    public String getResultBySalary(){
        Comparator<Employee> comparator = (e1, e2) -> e1.getSalary() - e2.getSalary();

        return this.formatter.format(
                this.infoProvider.getEmployeesBy(comparator));
    }
}
