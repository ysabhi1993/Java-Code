package com.abhishek;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    // Makes using interfaces with only one method, easier.
    // Lambda expression = argument list + arrow token + body
    // Lambda expressions are related to interfaces with only one method when passed without arguments in the argument list
    public static void main(String[] args) {
        // Lambda expression:
	    new Thread(()->{
            System.out.println("Line 1");
            System.out.println("Line 2");
            System.out.println("Line 3");
        }).start();

	    Employee fEmp = new Employee("first Emp", 30);
	    Employee sEmp = new Employee("sec Emp",32);
	    Employee tEmp = new Employee("third Emp", 34);
	    Employee foEmp = new Employee("forth Emp", 36);

        List<Employee> employees = new ArrayList<>();
        employees.add(fEmp);
        employees.add(sEmp);
        employees.add(tEmp);
        employees.add(foEmp);

//        Collections.sort(employees, new Comparator<Employee>() {
//            @Override
//            public int compare(Employee emp1, Employee emp2) {
//                return emp1.getName().compareTo(emp2.getName());
//            }
//        });

        // Here, in the argument list of the lambda expression, parameters will be assumed to be of type of objects
        // in collection
        Collections.sort(employees, (Employee emp1, Employee emp2) -> emp1.getName().compareTo(emp2.getName()));

        for(Employee employee : employees){
            System.out.println(employee.getName());
        }

//      This is using an anonymous class

//      String dumpString = doUpperConcat(new UpperConcat() {
//            @Override
//            public String upperAndConcat(String s1, String s2) {
//                return s1.toUpperCase() + " " + s2.toUpperCase();
//            }
//        }, employees.get(0).getName(), employees.get(1).getName());

//      Using Lambda expressions:

//        String dumpString2 = doUpperConcat((String s1, String s2) -> s1.toUpperCase() + " " + s2.toUpperCase(),
//                employees.get(0).getName(), employees.get(1).getName());
//


//      Lambdas can be assigned to variables

        //UpperConcat uc = (s1, s2) -> s1.toUpperCase() + " " + s2.toUpperCase();

        UpperConcat uc = (s1, s2) -> {
            String result = s1.toUpperCase() + " " + s2.toUpperCase();
            return result;
        };
        String dumpString3 = doUpperConcat(uc, employees.get(0).getName(), employees.get(1).getName());

        System.out.println(dumpString3);
    }

    public final static String doUpperConcat(UpperConcat uc, String s1, String s2){
        return uc.upperAndConcat(s1, s2);
    }
}

class Employee{
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

interface UpperConcat{
    public String upperAndConcat(String s1, String s2);
}

class AnotherClass{
    public String doSomething(){
        int i = 0;

        // Any local variable from the enclosing block has to be declared as final if it has to be used inside a
        // lambda expression or an anonymous class

        UpperConcat uc = (s1, s2) -> {
            System.out.println("Printing classname inside lambda expression: " + getClass().getSimpleName());
            System.out.println(i);
            String result = s1.toUpperCase() + s2.toUpperCase();
            return result;
        };

        System.out.println("Printing Another Class Name: " + getClass().getSimpleName());
        return Main.doUpperConcat(uc, "String1", "String2");
    }
}