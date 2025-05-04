//https://youtu.be/ZLYt9fqeMWU

class EducationalInstitution {
    String institutionName;
    String location;
    int establishedYear;

    public EducationalInstitution(String institutionName, String location, int establishedYear) {
        this.institutionName = institutionName;
        this.location = location;
        this.establishedYear = establishedYear;
    }

    public void displayDetails() {
        System.out.println("Institution Name: " + institutionName);
        System.out.println("Location: " + location);
        System.out.println("Established Year: " + establishedYear);
    }

    public int calculateAge() {
        int currentYear = 2025;
        return currentYear - establishedYear;
    }
}

class HighSchool extends EducationalInstitution {
    String schoolType;
    int numberOfStudents;

    public HighSchool(String institutionName, String location, int establishedYear, String schoolType, int numberOfStudents) {
        super(institutionName, location, establishedYear);
        this.schoolType = schoolType;
        this.numberOfStudents = numberOfStudents;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("School Type: " + schoolType);
        System.out.println("Number of Students: " + numberOfStudents);
    }
}

class University extends EducationalInstitution {
    int numberOfDepartments;
    boolean isResearchInstitution;

    public University(String institutionName, String location, int establishedYear,int numberOfDepartments, boolean isResearchInstitution) {
        super(institutionName, location, establishedYear);
        this.numberOfDepartments = numberOfDepartments;
        this.isResearchInstitution = isResearchInstitution;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Number of Departments: " + numberOfDepartments);
        System.out.println("Research Institution: " + (isResearchInstitution ? "Yes" : "No"));
    }
}

public class Main {
    public static void main(String[] args) {
        HighSchool hs = new HighSchool("IIUC School & College", "Kumira,Chittagong", 2005, "Private", 800);
        System.out.println("------> High School Details <------");
        hs.displayDetails();
        System.out.println("Age: " + hs.calculateAge() + " years\n");

        University uni = new University("International Islamic University Chittagong", "Kumira,Chittagong", 1999, 30, true);
        System.out.println("------> University Details <------");
        uni.displayDetails();
        System.out.println("Age: " + uni.calculateAge() + " years");
    }
}
