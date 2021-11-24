package mygroup.university.strategy;

import mygroup.university.dto.DepartmentStatistics;
import mygroup.university.service.DepartmentService;

public class DepartmentStatisticsOption implements Strategy {
    private DepartmentService departmentService;

    public DepartmentStatisticsOption(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @Override
    public void completeOption(String input) {
        if (departmentService.getDepartmentStatistics(input).isPresent()) {
            DepartmentStatistics departmentStatistics
                    = departmentService.getDepartmentStatistics(input).get();
            System.out.println(departmentStatistics);
        }
    }
}
