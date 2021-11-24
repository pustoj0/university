package mygroup.university.repository;

import mygroup.university.model.Lector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LectorRepository extends JpaRepository<Lector, Long> {
    @Query("FROM Lector l WHERE l.name LIKE CONCAT('%', ?1, '%')")
    List<Lector> searchByTemplate(String template);
}
