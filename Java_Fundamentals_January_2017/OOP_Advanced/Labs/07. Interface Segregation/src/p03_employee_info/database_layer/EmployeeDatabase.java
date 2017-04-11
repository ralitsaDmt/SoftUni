package p03_employee_info.database_layer;

import p03_employee_info.models.EmployeeImpl;
import p03_employee_info.bussiness_layer.Database;
import p03_employee_info.models.Employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeDatabase implements Database {

    @Override
    public List<Employee> readEmployees() {
        List<Employee> employees = new ArrayList<>();
        Collections.addAll(employees,
                new EmployeeImpl("Pesho", 20),
                new EmployeeImpl("Gosho", 40));

        return employees;
    }
}
