package com.abhishek;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.*;

public class Main {

    public static void main(String[] args) {
        Employee fEmp = new Employee("first Emp", 30);
        Employee sEmp = new Employee("sec Emp",32);
        Employee tEmp = new Employee("third Emp", 34);
        Employee foEmp = new Employee("forth Emp", 36);
        Employee fiEmp = new Employee("fifth Emp", 28);
        Employee siEmp = new Employee("sixth Emp", 26);

        List<Employee> employees = new ArrayList<>();
        employees.add(fEmp);
        employees.add(sEmp);
        employees.add(tEmp);
        employees.add(foEmp);
        employees.add(fiEmp);
        employees.add(siEmp);

        System.out.println("Employees over 30:");
        System.out.println("=======================");

        employees.forEach(employee -> {
            if(employee.getAge() > 30){
                System.out.println(employee.getName());
            }
        });

        // 1st is the parameter type and the second type is the return type
        Function<Employee, String> getLastName = (Employee employee) -> {
            return employee.getName().substring(employee.getName().indexOf(' ') + 1);
        };

        Function<Employee, String> getFirstName = (Employee employee) -> {
            return employee.getName().substring(0, employee.getName().indexOf(' '));
        };

        Random random = new Random();
        for(Employee employee : employees){
            if(random.nextBoolean()){
                System.out.println(getAName(getFirstName, employee));
            }else{
                System.out.println(getAName(getLastName, employee));
            }
        }
        System.out.println(getLastName.apply(employees.get(2)));

    // CHAINING FUNCTIONS
        Function<Employee, String> upperCase = employee -> employee.getName().toUpperCase();
        Function<String, String> firstName = name -> name.substring(0, name.indexOf(' '));

        // The function passed an the argument is the function that gets called first and it returns a value to the calling
        // function - Chaining functions
        Function changeName = upperCase.andThen(firstName);
        System.out.println(changeName.apply(employees.get(2)));

        System.out.println(getLastName.apply(employees.get(2)));

        printEmployee(employees, "Age String", employee -> employee.getAge() > 30);


    // BIFUNCTIONS
        BiFunction<String, Employee, String> concatAge = (String name, Employee employee) -> {
            return name.concat(" " + employee.getAge());
        };

        String upperName = upperCase.apply(employees.get(2));
        String newName = concatAge.apply(upperName, employees.get(2));

        System.out.println(newName);

    // IntUnaryOperator
        IntUnaryOperator incBy5 = i -> i + 5;
        System.out.println(incBy5.applyAsInt(10));


    // Consumer
        Consumer<String> c1 = name -> name.toUpperCase();
        Consumer<String> c2 = name -> System.out.println(name);
        c1.andThen(c2).accept(employees.get(1).getName());

    // If we need to pass an argument and get true/false - use predicates
    // If we need to pass arguments and get arguments use function


        // using an anonymous class
        printEmployee(employees, "Age Printing", new Predicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getAge() <= 30;
            }
        });

        // Predicates take only one parameter and return true/false
//        IntPredicate intGreater = i -> i > 20;
//        IntPredicate intLesser = i -> i < 50;
//        System.out.println(intGreater.and(intLesser).test(30));
//        System.out.println(intGreater.or(intLesser).test(40));
//
//        // Suppliers do not take parameters
//        Random random = new Random();
//        Supplier<Integer> randSupply = () -> random.nextInt(1000);
//
//        for(int i = 0; i< 10; i++){
//            System.out.println(randSupply.get());
//        }
    }

    public static String getAName(Function<Employee, String> getName, Employee employee){
        return getName.apply(employee);
    }

    private static void printEmployee(List<Employee> employees, String ageText, Predicate<Employee> condition){
        System.out.println(ageText);

        for(Employee employee : employees){
            if(condition.test(employee)){
                System.out.println(employee.getName());
            }
        }
    }
}
