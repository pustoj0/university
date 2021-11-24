package mygroup.university.strategy;

import java.util.Map;
import java.util.Scanner;

public class Context {
    private Map<String, Strategy> optionsMap;

    public Context(Map<String, Strategy> optionsMap) {
        this.optionsMap = optionsMap;
    }

    public void executeStrategy(String option, Scanner in) {
        String input = in.nextLine();
        optionsMap.get(option).completeOption(input);
    }
}
