package P04_DetailPrinter;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Employee employee = new Employee("Pesho");

        List<String> documents = new ArrayList<>();
        documents.add("doc1");
        documents.add("doc2");
        documents.add("doc3");
        Manager manager = new Manager("Gosho", documents);

        Worker worker = new Worker("Tanas", 11);

        List<Employee> employees = new ArrayList<>();
        employees.add(employee);
        employees.add(manager);
        employees.add(worker);

        DetailsPrinter printer = new DetailsPrinter(employees);
        printer.printDetails();
    }
}
