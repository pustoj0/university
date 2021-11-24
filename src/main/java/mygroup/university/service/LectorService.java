package mygroup.university.service;

import java.util.List;
import mygroup.university.model.Lector;

public interface LectorService {
    List<Lector> searchByTemplate(String template);
}
