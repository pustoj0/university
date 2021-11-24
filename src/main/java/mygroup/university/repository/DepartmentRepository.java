package mygroup.university.repository;

import java.util.Optional;
import mygroup.university.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DepartmentRepository
        extends JpaRepository<Department, Long> {

    @Query(value = "FROM Department d "
            + "LEFT JOIN FETCH d.lectors "
            + "WHERE d.name = ?1")
    Optional<Department> getDepartmentByName(String departmentName);
}
