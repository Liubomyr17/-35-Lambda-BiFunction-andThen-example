package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.function.BiFunction;
import java.util.function.Function;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        BiFunction<String, Integer, Integer> biFunction = (designation, age) ->
            getSalaryByAgeAndDesign(designation, age);


    int salary = biFunction.apply("Manager", 31);
    System.out.println(salary);

    salary = biFunction.apply("Developer", 28);
    System.out.println(salary);

    Function<Integer, String> function2 = (sal) -> getBandBasedOnSalary(sal);

    String salaryBand = biFunction.andThen(function2).apply("Manager", 31);
    System.out.println(salaryBand);

    String salaryBand2 = biFunction.andThen(function2).apply("Developer", 26);
    System.out.println(salaryBand2);
    }

    private static String getBandBasedOnSalary(Integer sal) {
        if (sal >= 100000) {
            return "Band 5";
        } else if (sal >= 80000) {
            return "Band 4";
        } else {
            return "Band 3";
        }
    }

    private static Integer getSalaryByAgeAndDesign(String designation, Integer age) {
        if (designation != null && age != null) {
            if (designation.equalsIgnoreCase("Manager") && age > 30) {
                return 120000;
            } else if (designation.equalsIgnoreCase("Developer") && age > 25) {
                return 90000;
            } else {
                return 0;
            }
        } else {
            return 0;
        }
    }

}
