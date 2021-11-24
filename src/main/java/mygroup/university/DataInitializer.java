package mygroup.university;

import java.math.BigInteger;
import java.util.List;
import javax.annotation.PostConstruct;
import mygroup.university.model.Degree;
import mygroup.university.model.Department;
import mygroup.university.model.Lector;
import mygroup.university.repository.DepartmentRepository;
import mygroup.university.repository.LectorRepository;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {
    private final LectorRepository lectorRepository;
    private final DepartmentRepository departmentRepository;

    public DataInitializer(LectorRepository lectorRepository,
                           DepartmentRepository departmentRepository) {
        this.lectorRepository = lectorRepository;
        this.departmentRepository = departmentRepository;
    }

    @PostConstruct
    public void inject() {
        Lector lector1 = new Lector();
        lector1.setName("Ivan Petrenko");
        lector1.setDegree(Degree.ASSISTANT);
        lector1.setSalary(BigInteger.valueOf(1000));
        lectorRepository.save(lector1);
        Lector lector2 = new Lector();
        lector2.setName("Petrenko Ivanov");
        lector2.setDegree(Degree.ASSOCIATE_PROFESSOR);
        lector2.setSalary(BigInteger.valueOf(2378));
        lectorRepository.save(lector2);
        Lector lector3 = new Lector();
        lector3.setName("John Smith");
        lector3.setDegree(Degree.PROFESSOR);
        lector3.setSalary(BigInteger.valueOf(3457));
        lectorRepository.save(lector3);
        Department department1 = new Department();
        department1.setLectors(List.of(lector1, lector2));
        department1.setHead(lector1);
        department1.setName("dep1");
        departmentRepository.save(department1);
        Department department2 = new Department();
        department2.setLectors(List.of(lector2, lector3));
        department2.setHead(lector2);
        department2.setName("dep2");
        departmentRepository.save(department2);
    }
}
