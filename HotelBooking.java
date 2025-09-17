public class HotelBooking {
    String guestName;
    String roomType;
    int nights;

    HotelBooking() {
        guestName = "Unknown";
        roomType = "Standard";
        nights = 1;
    }

    HotelBooking(String g, String r, int n) {
        guestName = g;
        roomType = r;
        nights = n;
    }

    HotelBooking(HotelBooking hb) {
        guestName = hb.guestName;
        roomType = hb.roomType;
        nights = hb.nights;
    }

    void display() {
        System.out.println("Guest: " + guestName);
        System.out.println("Room: " + roomType);
        System.out.println("Nights: " + nights);
        System.out.println();
    }

    public static void main(String[] args) {
        HotelBooking b1 = new HotelBooking();
        HotelBooking b2 = new HotelBooking("Alice", "Deluxe", 3);
        HotelBooking b3 = new HotelBooking(b2);

        b1.display();
        b2.display();
        b3.display();
    }
}
