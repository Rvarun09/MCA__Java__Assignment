public class TicketReservationSystem {

    static class Ticket {
        int ticketId;
        String customerName;
        String movieName;
        String seatNumber;
        String bookingTime;
        Ticket next;

        public Ticket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
            this.ticketId = ticketId;
            this.customerName = customerName;
            this.movieName = movieName;
            this.seatNumber = seatNumber;
            this.bookingTime = bookingTime;
            this.next = null;
        }

        @Override
        public String toString() {
            return String.format("[ID: %d, Customer: %s, Movie: %s, Seat: %s, Time: %s]",
                ticketId, customerName, movieName, seatNumber, bookingTime);
        }
    }

    static class TicketCircularList {
        Ticket head;
        Ticket last;
        int count;

        public TicketCircularList() {
            this.head = null;
            this.last = null;
            this.count = 0;
        }

        public boolean isEmpty() {
            return head == null;
        }

        private void initializeList(Ticket newTicket) {
            head = newTicket;
            last = newTicket;
            head.next = head;
            count++;
        }


        public void addReservation(Ticket newTicket) {
            if (isEmpty()) {
                initializeList(newTicket);
                System.out.println("Reservation added: " + newTicket.customerName);
                return;
            }
            newTicket.next = head;
            last.next = newTicket;
            last = newTicket;
            count++;
            System.out.println("Reservation added: " + newTicket.customerName);
        }


        public void removeTicket(int ticketId) {
            if (isEmpty()) {
                System.out.println(" Cannot cancel: Reservation list is empty.");
                return;
            }

            Ticket current = head;
            Ticket prev = last;
            String removedName = "";

            do {
                if (current.ticketId == ticketId) {
                    removedName = current.customerName;

                    if (head == last) {
                        head = last = null;
                        count = 0;
                        System.out.println(" Reservation cancelled for " + removedName + ". List is now empty.");
                        return;
                    }

                    prev.next = current.next;

                    if (current == head) {
                        head = current.next;
                    } else if (current == last) {
                        last = prev;
                    }

                    count--;
                    System.out.println(" Reservation cancelled for " + removedName + " (ID: " + ticketId + ").");
                    return;
                }
                prev = current;
                current = current.next;
            } while (current != head);

            System.out.println(" Ticket with ID " + ticketId + " not found.");
        }


        public void displayTickets() {
            if (isEmpty()) {
                System.out.println("\nNo active reservations to display.");
                return;
            }

            Ticket temp = head;
            System.out.println("\n--- Current Ticket Reservations ---");
            do {
                System.out.println(temp);
                temp = temp.next;
            } while (temp != head);
        }

        // --- 4. Search for a Ticket ---

        public void searchTicket(String query, String type) {
            if (isEmpty()) {
                System.out.println("Cannot search: Reservation list is empty.");
                return;
            }

            Ticket temp = head;
            boolean found = false;

            System.out.println("\nSearch Results (By " + type + ": " + query + "):");

            do {
                boolean match = false;
                if (type.equalsIgnoreCase("Customer Name") && temp.customerName.equalsIgnoreCase(query)) {
                    match = true;
                } else if (type.equalsIgnoreCase("Movie Name") && temp.movieName.equalsIgnoreCase(query)) {
                    match = true;
                }

                if (match) {
                    System.out.println("  -> Found: " + temp);
                    found = true;
                }
                temp = temp.next;
            } while (temp != head);

            if (!found) {
                System.out.println("  -> No tickets found matching the query.");
            }
        }

        public int getTotalBookedTickets() {
            return this.count;
        }
    }


    public static void main(String[] args) {
        TicketCircularList reservations = new TicketCircularList();

        System.out.println("----WELCOME TO TICKET RESERVATION----");
        System.out.println("--- 1. ADD RESERVATIONS ---");
        reservations.addReservation(new Ticket(501, "varun", "Dune: Part Two", "A12", "18:00"));
        reservations.addReservation(new Ticket(502, "priya", "Inception", "B05", "19:30"));
        reservations.addReservation(new Ticket(503, "gurjot", "Dune: Part Two", "A13", "18:00"));
        reservations.addReservation(new Ticket(504, "chirag", "Matrix", "C08", "21:00"));

        reservations.displayTickets();

        System.out.println("\n--- 2. COUNT TOTAL ---");
        System.out.println("Total booked tickets: " + reservations.getTotalBookedTickets());

        System.out.println("\n--- 3. SEARCH OPERATIONS ---");
        reservations.searchTicket("Dune: Part Two", "Movie Name");
        reservations.searchTicket("varun", "Customer Name");

        System.out.println("\n--- 4. REMOVE OPERATION ---");
        reservations.removeTicket(502); 
        reservations.removeTicket(504); 

        reservations.displayTickets();

        System.out.println("\n--- 5. FINAL COUNT ---");
        System.out.println("Total booked tickets after cancellation: " + reservations.getTotalBookedTickets());
    }
}