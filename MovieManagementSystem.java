public class MovieManagementSystem {


    static class Movie {
        String title;
        String director;
        int year;
        double rating;
        Movie next;
        Movie prev;

        public Movie(String title, String director, int year, double rating) {
            this.title = title;
            this.director = director;
            this.year = year;
            this.rating = rating;
            this.next = null;
            this.prev = null;
        }

        @Override
        public String toString() {
            return "Title: " + title + ", Director: " + director + ", Year: " + year + ", Rating: " + rating;
        }
    }

    static class MovieDoublyLinkedList {

        Movie head;
        Movie tail;

        public MovieDoublyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void addFirst(Movie newMovie) {
            if (head == null) {
                head = newMovie;
                tail = newMovie;
            } else {
                newMovie.next = head;
                head.prev = newMovie;
                head = newMovie;
            }
            System.out.println("Added at start: " + newMovie.title);
        }

        public void addLast(Movie newMovie) {
            if (head == null) {
                addFirst(newMovie);
            } else {
                tail.next = newMovie;
                newMovie.prev = tail;
                tail = newMovie;
            }
            System.out.println("Added at end: " + newMovie.title);
        }

        public void addAtPosition(Movie newMovie, int position) {
            if (position <= 0) {
                System.out.println("Position must be greater than 0.");
                return;
            }
            if (position == 1) {
                addFirst(newMovie);
                return; 
            }

            Movie current = head;
            int count = 1;

            while (current != null && count < position - 1) {
                current = current.next;
                count++;
            }

            if (current == null) {
                System.out.println("Position " + position + " is beyond the list size.");
            } else if (current == tail) {
                addLast(newMovie);
            } else {
                // Insert in the middle
                newMovie.next = current.next;
                newMovie.prev = current;
                current.next.prev = newMovie;
                current.next = newMovie;
                System.out.println("Added at position " + position + ": " + newMovie.title);
            }
        }


        public void removeByTitle(String title) {
            if (head == null) {
                System.out.println("List is empty. Cannot remove.");
                return;
            }

            Movie current = head;

            while (current != null && !current.title.equalsIgnoreCase(title)) {
                current = current.next;
            }

            if (current == null) {
                System.out.println("Movie not found: " + title);
                return;
            }

            if (current == head) {
                head = head.next;
                if (head != null) {
                    head.prev = null;
                } else {
                    tail = null;
                }
            } else if (current == tail) {
                tail = tail.prev;
                tail.next = null;
            } else {
                current.prev.next = current.next;
                current.next.prev = current.prev;
            }

            System.out.println(" Removed movie: " + title);
        }

        // --- SEARCH Functionality ---

        public void search(String director, double rating) {
            if (head == null) {
                System.out.println("List is empty. Cannot search.");
                return;
            }

            Movie current = head;
            boolean found = false;

            System.out.println("\n Search Results (Director: " + (director.isEmpty() ? "Any" : director) + ", Min Rating: " + (rating == -1 ? "Any" : rating) + "):");

            while (current != null) {
                boolean matchesDirector = director.isEmpty() || current.director.equalsIgnoreCase(director);
                boolean matchesRating = rating == -1 || current.rating >= rating;

                if (matchesDirector && matchesRating) {
                    System.out.println("  -> " + current);
                    found = true;
                }

                current = current.next;
            }
            
        
            if (!found) { 
                System.out.println(" No movies found matching the criteria.");
            }
        }

        // --- DISPLAY Functionalities ---

        public void displayForward() {
            if (head == null) {
                System.out.println("\nList is empty.");
                return;
            }

            System.out.println("\n Movie Records (Forward Order):");
            Movie current = head;
            while (current != null) {
                System.out.println("  " + current);
                current = current.next;
            }
        }

        public void displayReverse() {
            if (tail == null) {
                System.out.println("\nList is empty.");
                return;
            }

            System.out.println("\n⬅Movie Records (Reverse Order):");
            Movie current = tail;
            while (current != null) {
                System.out.println("  " + current);
                current = current.prev;
            }
        }


        public void updateRating(String title, double newRating) {
            if (head == null) {
                System.out.println("List is empty. Cannot update rating.");
                return;
            }

            Movie current = head;

            while (current != null && !current.title.equalsIgnoreCase(title)) {
                current = current.next;
            }

            if (current == null) {
                System.out.println("Movie not found: " + title + ". Rating not updated.");
            } else {
                double oldRating = current.rating;
                current.rating = newRating;
                System.out.println("successfully updated rating for '" + title + "': " + oldRating + " -> " + newRating);
            }
        }
    }

    public static void main(String[] args) {
        MovieDoublyLinkedList movieList = new MovieDoublyLinkedList();

        System.out.println("--- 1. ADD OPERATIONS ---");
        movieList.addFirst(new Movie("Inception", "Christopher Nolan", 2010, 8.8));
        movieList.addLast(new Movie("Pulp Fiction", "Quentin Tarantino", 1994, 8.9));
        movieList.addFirst(new Movie("The Godfather", "Francis Ford Coppola", 1972, 9.2));
        movieList.addAtPosition(new Movie("Dune", "Denis Villeneuve", 2021, 8.0), 3);
        movieList.addAtPosition(new Movie("Parasite", "Bong Joon-ho", 2019, 8.5), 5);

        movieList.displayForward();

        System.out.println("\n--- 2. UPDATE OPERATION ---");
        movieList.updateRating("Dune", 8.2);

        System.out.println("\n--- 3. SEARCH OPERATIONS ---");
        movieList.search("Quentin Tarantino", -1);
        movieList.search("", 8.8);


        System.out.println("\n--- 4. REMOVE OPERATION ---");
        movieList.removeByTitle("Pulp Fiction");
        movieList.removeByTitle("NonExistent Movie");

        System.out.println("\n--- 5. FINAL DISPLAY OPERATIONS ---");
        movieList.displayForward();
        movieList.displayReverse();
    }
}