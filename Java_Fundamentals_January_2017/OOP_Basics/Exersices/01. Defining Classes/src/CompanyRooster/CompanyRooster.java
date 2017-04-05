package CompanyRooster;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class CompanyRooster {
    public static void main(String[] args) throws IOException {
        BufferedReader in =
                new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(in.readLine());

        List<Employee> employees = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            String[] inf = in.readLine().split("\\s+");

            String name = inf[0];
            Double salary = Double.parseDouble(inf[1]);
            String position = inf[2];
            String department = inf[3];

            String email = "n/a";
            Integer age = -1;

            Employee emp = null;
            if (inf.length == 5){
                email = inf[4];
            }
            else if (inf.length == 6){
                email = inf[4];
                age = Integer.parseInt(inf[5]);
            }

            emp = new Employee(name, salary, position, department, email, age);

            employees.add(emp);
        }

        Map<String, Double> avgSalaryByDepartment = employees.stream()
                .collect(
                        Collectors.groupingBy(Employee::getDepartment,
                                Collectors.averagingDouble(Employee::getSalary)
                ));

        String department = Collections.max(avgSalaryByDepartment.entrySet(), Map.Entry.comparingByValue()).getKey();

        List<Employee> filtered = employees.stream()
                .filter(e -> e.department.equals(department))
                .collect(Collectors.toList());

        filtered = filtered.stream().sorted((e1, e2) -> e2.salary.compareTo(e1.salary))
                .collect(Collectors.toList());

        System.out.println("Highest Average Salary: " + department);

        StringBuilder sb = new StringBuilder();

        for (Employee f :
                filtered) {
            sb.append(String.format("%s %.2f %s %s\n",
                    f.name, f.salary, f.email, f.age));
        }

        sb.delete(sb.length() - 1, sb.length() - 1);

        System.out.println(sb);
    }
}
