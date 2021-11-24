package mygroup.university.strategy;

import mygroup.university.service.DepartmentService;

public class EmployeeCountOption implements Strategy {
    private DepartmentService departmentService;

    public EmployeeCountOption(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @Override
    public void completeOption(String input) {
        if (departmentService.countOfEmployee(input).isPresent()) {
            Integer employeeCount = departmentService.countOfEmployee(input).get();
            System.out.println(String.format("Answer: %d", employeeCount));
        }
    }
}
