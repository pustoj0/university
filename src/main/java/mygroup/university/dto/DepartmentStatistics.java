package mygroup.university.dto;

public class DepartmentStatistics {
    private long assistantsCount;
    private long associateProfessorsCount;
    private long professorsCount;

    public DepartmentStatistics(long assistantsCount, long associateProfessorsCount, long professorsCount) {
        this.assistantsCount = assistantsCount;
        this.associateProfessorsCount = associateProfessorsCount;
        this.professorsCount = professorsCount;
    }

    public long getAssistantsCount() {
        return assistantsCount;
    }

    public void setAssistantsCount(long assistantsCount) {
        this.assistantsCount = assistantsCount;
    }

    public long getAssociateProfessorsCount() {
        return associateProfessorsCount;
    }

    public void setAssociateProfessorsCount(long associateProfessorsCount) {
        this.associateProfessorsCount = associateProfessorsCount;
    }

    public long getProfessorsCount() {
        return professorsCount;
    }

    public void setProfessorsCount(long professorsCount) {
        this.professorsCount = professorsCount;
    }

    @Override
    public String toString() {
        return "assistants - " + assistantsCount + "\n"
                + "associate professors - " + associateProfessorsCount + "\n"
                + "professors - " + professorsCount + "\n";
    }
}
