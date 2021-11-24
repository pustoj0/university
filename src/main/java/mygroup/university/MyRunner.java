package mygroup.university;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import mygroup.university.repository.LectorRepository;
import mygroup.university.service.DepartmentService;
import mygroup.university.service.LectorService;
import mygroup.university.strategy.AvgSalaryOption;
import mygroup.university.strategy.Context;
import mygroup.university.strategy.DepartmentHeadOption;
import mygroup.university.strategy.DepartmentStatisticsOption;
import mygroup.university.strategy.EmployeeCountOption;
import mygroup.university.strategy.Strategy;
import mygroup.university.strategy.TemplateSearchOption;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements CommandLineRunner {
    private final static String WRITE_DEPARTMENT = "Write department_name=";
    private final static String WRITE_TEMPLATE = "Write template=";
    private DepartmentService departmentService;
    private LectorService lectorService;
    private LectorRepository lectorRepository;

    public MyRunner(DepartmentService departmentService, LectorService lectorService, LectorRepository lectorRepository) {
        this.departmentService = departmentService;
        this.lectorService = lectorService;
        this.lectorRepository = lectorRepository;
    }

    @Override
    public void run(String... args) {
        Map<String, Strategy> optionsMap = new LinkedHashMap<>();
        optionsMap.put("1", new DepartmentHeadOption(departmentService));
        optionsMap.put("2", new DepartmentStatisticsOption(departmentService));
        optionsMap.put("3", new AvgSalaryOption(departmentService));
        optionsMap.put("4", new EmployeeCountOption(departmentService));
        optionsMap.put("5", new TemplateSearchOption(lectorService));
        Context context = new Context(optionsMap);
        Scanner in = new Scanner(System.in);
        String input = "";
        while (!input.equals("exit")) {
            writeOptions();
            input = in.nextLine();
            switch (input) {
                case "1":
                case "2":
                case "3":
                case "4":
                    System.out.print(WRITE_DEPARTMENT);
                    context.executeStrategy(input, in);
                    break;
                case "5":
                    System.out.print(WRITE_TEMPLATE);
                    context.executeStrategy(input, in);
                    break;
                case "exit":
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Option was written incorrectly");
            }
            System.out.println("To exit write 'exit'");
        }
    }

    private void writeOptions() {
        System.out.println("1. Who is head of department {department_name}.");
        System.out.println("2. Show {department_name} statistics.");
        System.out.println("3. Show the average salary for the department {department_name}.");
        System.out.println("4. Show count of employee for {department_name}.");
        System.out.println("5. Global search by {template}.");
        System.out.print("Choose option: ");
    }
}
