package mygroup.university.service.impl;

import java.util.List;
import mygroup.university.model.Lector;
import mygroup.university.repository.LectorRepository;
import mygroup.university.service.LectorService;
import org.springframework.stereotype.Service;

@Service
public class LectorServiceImpl implements LectorService {
    private LectorRepository lectorRepository;

    public LectorServiceImpl(LectorRepository lectorRepository) {
        this.lectorRepository = lectorRepository;
    }

    @Override
    public List<Lector> searchByTemplate(String template) {
        return lectorRepository.searchByTemplate(template);
    }
}
