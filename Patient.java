public class Patient {
    private static String hospitalName = "Default Hospital";
    private static int totalPatients = 0;

    private final int patientID;
    private String name;
    private int age;
    private String ailment;

    public Patient(int patientID, String name, int age, String ailment) {
        this.patientID = patientID;
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        totalPatients++;
    }

    public static void setHospitalName(String name) {
        hospitalName = name;
    }

    public static int getTotalPatients() {
        return totalPatients;
    }

    public void displayDetails() {
        if (this instanceof Patient) {
            System.out.println("Hospital Name: " + hospitalName);
            System.out.println("Patient ID: " + patientID);
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("Ailment: " + ailment);
        } else {
            System.out.println("Not a valid Patient object.");
        }
    }

    public static void main(String[] args) {
        Patient.setHospitalName("Copilot Hospital");
        Patient p1 = new Patient(1, "Alice", 30, "Flu");
        Patient p2 = new Patient(2, "Bob", 45, "Fracture");

        p1.displayDetails();
        System.out.println();
        p2.displayDetails();

        System.out.println("\nTotal Patients: " + Patient.getTotalPatients());
    }
}