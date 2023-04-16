package com.example.homework29.services;

import org.springframework.stereotype.Service;
import com.example.homework29.model.Employee;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentService {
    private List<Employee> staff = new ArrayList<>(List.of(
            new Employee("Ivan", "Ivanov", 3, 11.0),
            new Employee("Petr", "Petrov", 3, 55.5),
            new Employee("Sidor", "Sidorov", 3, 9.75),
            new Employee("Fedot", "Fedotov", 1, 100500.0),
            new Employee("Ivan", "Belov", 2, 5.0),
            new Employee("Anatoly", "Chernov", 2, 500.0),
            new Employee("Alex", "Alexandrov", 4, 499.0),
            new Employee("Sergey", "Belyaev", 5, 3.21),
            new Employee("Ivan", "Chizhov", 2, 750.0),
            new Employee("Denis", "Krasnov", 2, 450.0)
    ));

    public Employee findMaxSalaryInDept(int deptNumber) {
        return staff.stream()
                .filter(e -> e.getDepartment() == deptNumber)
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(() -> new RuntimeException("No such employee"));
    }

    public Employee findMinSalaryInDept(int deptNumber) {
        return staff.stream()
                .filter(e -> e.getDepartment() == deptNumber)
                .min(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(() -> new RuntimeException("No such employee"));
    }

    public List<Employee> getEmployeesOfDept(int deptNumber) {
        return staff.stream()
                .filter(e -> e.getDepartment() == deptNumber)
                .collect(Collectors.toList());
    }

    public List<Employee> getStaffByDept() {
        return staff.stream()
                .sorted(Comparator.comparingInt(Employee::getDepartment))
                .collect(Collectors.toList());
    }
}