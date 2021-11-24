package mygroup.university.strategy;

import mygroup.university.model.Lector;
import mygroup.university.service.DepartmentService;

public class DepartmentHeadOption implements Strategy {
    private DepartmentService departmentService;

    public DepartmentHeadOption(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @Override
    public void completeOption(String departmentName) {
        if (departmentService.getHeadOfDepartment(departmentName).isPresent()) {
            Lector lector = departmentService.getHeadOfDepartment(departmentName).get();
            System.out.println(String.format(
                    "Answer: Head of %s department is %s",
                    departmentName, lector.getName()));
        }
    }
}
