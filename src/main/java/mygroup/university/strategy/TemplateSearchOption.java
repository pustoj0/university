package mygroup.university.strategy;

import java.util.List;
import mygroup.university.model.Lector;
import mygroup.university.service.LectorService;

public class TemplateSearchOption implements Strategy {
    private LectorService lectorService;

    public TemplateSearchOption(LectorService lectorService) {
        this.lectorService = lectorService;
    }

    @Override
    public void completeOption(String template) {
        List<Lector> lectors = lectorService.searchByTemplate(template);
        System.out.print("Answer: ");
        StringBuilder searchResult = new StringBuilder();
        for (Lector lector : lectors) {
            searchResult.append(lector.getName()).append(", ");
        }
        System.out.print(searchResult.length() != 0
                ? searchResult.delete(searchResult.length() - 2, searchResult.length())
                : " Lector names with '" + template + "' don't exist yet.");
        System.out.println();
    }
}
