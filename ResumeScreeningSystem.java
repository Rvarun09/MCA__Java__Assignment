/*5. AI-Driven Resume Screening System
Concepts: Generic Classes, Generic Methods, Bounded Type Parameters, Wildcards
Problem Statement:
Develop an AI-Driven Resume Screening System that can process resumes for different job roles like Software Engineer, Data Scientist, and Product Manager while ensuring type safety.
Hints:
Create an abstract class JobRole (SoftwareEngineer, DataScientist, ProductManager).
Implement a generic class Resume<T extends JobRole> to process resumes dynamically.
Use a wildcard method (List<? extends JobRole>) to handle multiple job roles in the screening pipeline. */
import java.util.*;

public class ResumeScreeningSystem {
    static abstract class JobRole {
        String role;
        JobRole(String role) { this.role = role; }
        public String toString() { return role; }
    }
    static class SoftwareEngineer extends JobRole {
        SoftwareEngineer() { super("Software Engineer"); }
    }

    static class DataScientist extends JobRole {
        DataScientist() { super("Data Scientist"); }
    }

    static class ProductManager extends JobRole {
        ProductManager() { super("Product Manager"); }
    }
    static class Resume<T extends JobRole> {
        String candidateName;
        T jobRole;

        Resume(String candidateName, T jobRole) {
            this.candidateName = candidateName;
            this.jobRole = jobRole;
        }

        public String toString() {
            return candidateName + " applying for " + jobRole;
        }
    }
    static <T extends JobRole> void screenResume(Resume<T> resume) {
        System.out.println("Screening Resume: " + resume);
        System.out.println("Status: Eligible for next round.");
    }
    static void processJobRoles(List<? extends JobRole> roles) {
        System.out.println("\nJob Roles in Screening Pipeline:");
        for (JobRole role : roles) {
            System.out.println("- " + role);
        }
    }

    public static void main(String[] args) {
        Resume<SoftwareEngineer> r1 = new Resume<>("Alice", new SoftwareEngineer());
        Resume<DataScientist> r2 = new Resume<>("Bob", new DataScientist());
        Resume<ProductManager> r3 = new Resume<>("Charlie", new ProductManager());
        screenResume(r1);
        screenResume(r2);
        screenResume(r3);

        List<JobRole> pipeline = Arrays.asList(
                new SoftwareEngineer(), new DataScientist(), new ProductManager()
        );
        processJobRoles(pipeline);
    }
}
