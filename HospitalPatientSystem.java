abstract class Patient {
    private int patientId;
    private String name;
    private int age;
    private String diagnosis;

    public Patient(int patientId, String name, int age, String diagnosis) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.diagnosis = diagnosis;
    }

    public int getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    protected String getDiagnosis() {
        return diagnosis;
    }

    public void getPatientDetails() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Diagnosis: " + diagnosis);
    }

    public abstract double calculateBill();
}

interface MedicalRecord {
    void addRecord(String record);
    void viewRecords();
}

class InPatient extends Patient implements MedicalRecord {
    private int daysAdmitted;
    private double dailyRate;
    private String records = "";

    public InPatient(int patientId, String name, int age, String diagnosis, int daysAdmitted, double dailyRate) {
        super(patientId, name, age, diagnosis);
        this.daysAdmitted = daysAdmitted;
        this.dailyRate = dailyRate;
    }

    @Override
    public double calculateBill() {
        return daysAdmitted * dailyRate;
    }

    @Override
    public void addRecord(String record) {
        records += "- " + record + "\n";
    }

    @Override
    public void viewRecords() {
        System.out.println("Medical Records of " + getName() + ":");
        if (records.isEmpty()) {
            System.out.println("No records available.");
        } else {
            System.out.print(records);
        }
    }
}

class OutPatient extends Patient implements MedicalRecord {
    private double consultationFee;
    private String records = "";

    public OutPatient(int patientId, String name, int age, String diagnosis, double consultationFee) {
        super(patientId, name, age, diagnosis);
        this.consultationFee = consultationFee;
    }

    @Override
    public double calculateBill() {
        return consultationFee;
    }

    @Override
    public void addRecord(String record) {
        records += "- " + record + "\n";
    }

    @Override
    public void viewRecords() {
        System.out.println("Medical Records of " + getName() + ":");
        if (records.isEmpty()) {
            System.out.println("No records available.");
        } else {
            System.out.print(records);
        }
    }
}

public class HospitalPatientSystem {
    public static void main(String[] args) {
        InPatient ip = new InPatient(101, "Alice", 30, "Pneumonia", 5, 2000);
        OutPatient op = new OutPatient(102, "Bob", 40, "Fever", 500);

        ip.getPatientDetails();
        System.out.println("Bill: " + ip.calculateBill());
        ip.addRecord("X-Ray done");
        ip.addRecord("Antibiotics prescribed");
        ip.viewRecords();

        System.out.println("------------------------");

        op.getPatientDetails();
        System.out.println("Bill: " + op.calculateBill());
        op.addRecord("Blood test done");
        op.viewRecords();
    }
}
