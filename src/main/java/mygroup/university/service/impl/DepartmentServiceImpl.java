package mygroup.university.service.impl;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import mygroup.university.dto.DepartmentStatistics;
import mygroup.university.model.Department;
import mygroup.university.model.Lector;
import mygroup.university.repository.DepartmentRepository;
import mygroup.university.service.DepartmentService;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Optional<Lector> getHeadOfDepartment(String departmentName) {
        Optional<Department> departmentOptional = getDepartment(departmentName);
        if (departmentOptional.isEmpty()) {
            return Optional.empty();
        }
        Lector lector = departmentOptional.get().getHead();
        if (lector == null) {
            System.out.println("Head of department " + departmentName + " is empty");
            return Optional.empty();
        }
        return Optional.of(lector);
    }

    @Override
    public Optional<DepartmentStatistics> getDepartmentStatistics(String departmentName) {
        Optional<Department> departmentOptional = getDepartment(departmentName);
        if (departmentOptional.isEmpty()) {
            return Optional.empty();
        }
        List<Lector> lectors = departmentOptional.get().getLectors();
        long assistantsCount = 0;
        long associateProfessorsCount = 0;
        long professorsCount = 0;
        for(Lector lector : lectors) {
            switch (lector.getDegree()) {
                case ASSISTANT:
                    assistantsCount++;
                    break;
                case ASSOCIATE_PROFESSOR:
                    associateProfessorsCount++;
                    break;
                case PROFESSOR:
                    professorsCount++;
                    break;
                default:
                    throw new RuntimeException("Wrong degree of lector: " + lector.getName());
            }
        }
        return Optional.of(new DepartmentStatistics(
                assistantsCount, associateProfessorsCount, professorsCount));
    }

    @Override
    public Optional<BigInteger> calculateAvgSalary(String departmentName) {
        Optional<Department> departmentOptional = getDepartment(departmentName);
        if (departmentOptional.isEmpty()) {
            return Optional.empty();
        }
        List<Lector> lectors = departmentOptional.get().getLectors();
        if (lectors != null && lectors.size() != 0) {
            BigInteger sumOfSalary = BigInteger.ZERO;
            for (Lector lector : lectors) {
                sumOfSalary = sumOfSalary.add(lector.getSalary());
            }
            return Optional.of(sumOfSalary.divide(BigInteger.valueOf(lectors.size())));
        }
        System.out.println("No lectors in department: " + departmentName);
        return Optional.empty();

    }

    @Override
    public Optional<Integer> countOfEmployee(String departmentName) {
        Optional<Department> departmentOptional = getDepartment(departmentName);
        if (departmentOptional.isEmpty()) {
            return Optional.empty();
        }
        List<Lector> lectors = departmentOptional.get().getLectors();
        return lectors == null ? Optional.of(0) : Optional.of(lectors.size());
    }

    private Optional<Department> getDepartment(String departmentName) {
        Optional<Department> departmentOptional
                = departmentRepository.getDepartmentByName(departmentName);
        if (departmentOptional.isEmpty()) {
            System.out.println("Can't find department with name: " + departmentName);
            return Optional.empty();
        }
        return departmentOptional;
    }
}
