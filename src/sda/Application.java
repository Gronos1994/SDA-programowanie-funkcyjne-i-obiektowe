package sda;

import sda.workers.AbstrackEmployee;
import sda.workers.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by RENT on 2017-02-18.
 */
public class Application {
    public static void main(String[] args) {
        List<AbstrackEmployee> employeeList = new ArrayList<>();
        employeeList.add(new AbstrackEmployee("Lukasz", "Gronowski", 5000, "JAVA"));
        employeeList.add(new AbstrackEmployee("Szymon", "Nowaczyk", 2500, "JAVA"));
        employeeList.add(new AbstrackEmployee("Maciej", "Olejniczak", 300, "JAVA"));
        employeeList.add(new AbstrackEmployee("Kasia", "Jakatam", 300, "PR"));
        employeeList.add(new AbstrackEmployee("Agnieszka", "Wojt", 10000, "TM"));
//        employeeList.stream()
//                .filter(e -> e.getDepartament().equals("JAVA"))
//                .forEach(e -> System.out.println(e));
//        employeeList.stream()
//                .filter(e -> e.getSalary() >= 3000)
//                .forEach(e -> System.out.println(e));
//        employeeList.stream()
//                .filter(e-> e.getDepartament().equals("JAVA"))
//                .filter(e -> e.getSalary() >= 3000)
//                .forEach(e -> System.out.println(e));
//        employeeList.stream()
//                .filter(e -> e.getFirstName().endsWith("a"))
//                .forEach(e -> System.out.println(e));
//        List<AbstrackEmployee> javaEmployees = employeeList.stream()
//                 .filter(e -> e.getDepartament().equals("JAVA"))
//                .collect(Collectors.toList());
//        System.out.println(javaEmployees);
//        employeeList.stream()
//                .filter(e -> e.getLastName().equals("Nowak"))
//                .forEach(e -> System.out.println(e));
//         Map<String, AbstrackEmployee> map = employeeList.stream()
//                .collect(Collectors.toMap(e -> e.getFirstName(), e -> e));
//        map.forEach((k, v) -> System.out.println(k + ": " + v));
//        employeeList.sort((e1,e2) -> e1.getSalary() > e2.getSalary() ? 1 : -1);
//        employeeList.forEach(e -> System.out.println(e.getFirstName()+ ": " + e.getSalary()));
//        employeeList.stream()
//                .filter(e -> (e.getFirstName() + " " + e.getLastName()).equals("Agnieszka Wojt"))
//                .forEach(e -> System.out.println(e));
        employeeList.sort((e1, e2) -> e1.getSalary() < e2.getSalary() ? 1 : -1);
        System.out.println(employeeList.get(0));
        AbstrackEmployee richestEmployee = employeeList.stream()
                .max((e1, e2) -> e1.getSalary() > e2.getSalary() ? 1 : -1)
                .get();
        System.out.println(richestEmployee);
        AbstrackEmployee poorestEmployee = employeeList.stream()
                .min((e1, e2) -> e1.getSalary() > e2.getSalary() ? 1 : -1)
                .get();
        System.out.println(poorestEmployee);
        Map<String, List<AbstrackEmployee>> stringListMap = listToMap(employeeList);
        List<AbstrackEmployee> tmpList = new ArrayList<>();
        stringListMap.entrySet().stream()
                .forEach(e -> {
                    List<AbstrackEmployee> value = e.getValue();
                    value.stream()
                            .filter(e1 -> e1.getSalary() > 3000)
                            .forEach(e1 -> tmpList.add(e1));

                });
    }

    public static Map<String, List<AbstrackEmployee>> listToMap(List<AbstrackEmployee> employees) {
        Map<String, List<AbstrackEmployee>> map = new HashMap<>();
        for (AbstrackEmployee employee : employees) {

                if (map.containsKey(employee.getDepartament())) {

                    List<AbstrackEmployee> listOffEmployees = map.get(employee.getDepartament());
                    listOffEmployees.add(employee);
                } else {
                    ArrayList<AbstrackEmployee> listOfEmployyes = new ArrayList<>();
                    listOfEmployyes.add(employee);
                    map.put(employee.getDepartament(), listOfEmployyes);
                }

            }
            return map;

        }
    }
