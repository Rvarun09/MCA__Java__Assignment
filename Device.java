public class Device {
    String deviceId;
    String status;  
    Device(String deviceId, String status) {
        this.deviceId = deviceId;
        this.status = status;
    }
    void displayStatus() {
        System.out.println("Device ID: " + deviceId);
        System.out.println("Status: " + status);
    }
}
class Thermostat extends Device {
    double temperatureSetting;
    Thermostat(String deviceId, String status, double temperatureSetting) {
        super(deviceId, status);
        this.temperatureSetting = temperatureSetting;
    }
    @Override
    void displayStatus() {
        super.displayStatus();
        System.out.println("Temperature Setting: " + temperatureSetting + "°C");
    }
}
class HomeAuto {
    public static void main(String[] args) {
        Device gd = new Device("D1001", "OFF");
        Thermostat st = new Thermostat("T2001", "ON", 22.5);
        System.out.println("General Device:");
        gd.displayStatus();
        System.out.println("\nThermostat Device:");
        st.displayStatus();
    }
}

