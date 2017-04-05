package CompanyRooster;

public class Employee {
    public String name;
    public Double salary;
    public String position;
    public String department;

    public Double getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }

    public String email;
    public Integer age;

    public Employee (String name, Double salary, String position, String department, String email, Integer age){
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.email = email;
        this.age = age;
    }

    public Employee(String name, Double salary, String position, String department, String email) {
        this (name, salary, position, department, email, -1);
    }

    public Employee(String name, Double salary, String position, String department) {
        this (name, salary, position, department, "n/a", -1);
    }


}
