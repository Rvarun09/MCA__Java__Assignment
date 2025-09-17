public class MovieTicket {
    String movieName;
    int seatNumber;
    double price;
    public void bookTicket(String movieName, int seatNumber, double price) {
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.price = price;
        System.out.println("Ticket booked successfully!");
    }
    public void displayTicket() {
        System.out.println("---- Ticket Details ----");
        System.out.println("Movie Name : " + movieName);
        System.out.println("Seat Number: " + seatNumber);
        System.out.println("Price      : $" + price);
    }
    public static void main(String[] args) {
        MovieTicket ticket = new MovieTicket();
        ticket.bookTicket("Avengers: Endgame", 15, 12.50);
        ticket.displayTicket();
    }
}
