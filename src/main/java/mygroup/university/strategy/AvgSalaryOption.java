package mygroup.university.strategy;

import java.math.BigInteger;
import mygroup.university.service.DepartmentService;

public class AvgSalaryOption implements Strategy {
    private DepartmentService departmentService;

    public AvgSalaryOption(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @Override
    public void completeOption(String input) {
        if (departmentService.calculateAvgSalary(input).isPresent()) {
            BigInteger avgSalary = departmentService.calculateAvgSalary(input).orElseThrow();
            System.out.println(String.format(
                    "Answer: The average salary of %s is %d",
                    input, avgSalary));
        }
    }
}
