public class LibraryManagementSystem {

    static class Book {
        String title;
        String author;
        String genre;
        int bookId;
        String availabilityStatus; 
        Book next;
        Book prev;

        public Book(String title, String author, String genre, int bookId, String availabilityStatus) {
            this.title = title;
            this.author = author;
            this.genre = genre;
            this.bookId = bookId;
            this.availabilityStatus = availabilityStatus;
            this.next = null;
            this.prev = null;
        }

        @Override
        public String toString() {
            return String.format("[ID: %d, Title: %s, Author: %s, Genre: %s, Status: %s]",
                bookId, title, author, genre, availabilityStatus);
        }
    }

    static class LibraryList {
        Book head;
        Book tail;
        int count;

        public LibraryList() {
            this.head = null;
            this.tail = null;
            this.count = 0;
        }

        public boolean isEmpty() {
            return head == null;
        }

        private void updateCount(int change) {
            this.count += change;
        }


        public void addFirst(Book newBook) {
            if (isEmpty()) {
                head = newBook;
                tail = newBook;
            } else {
                newBook.next = head;
                head.prev = newBook;
                head = newBook;
            }
            updateCount(1);
            System.out.println("Added first: " + newBook.title);
        }

        public void addLast(Book newBook) {
            if (isEmpty()) {
                addFirst(newBook);
                return;
            }
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
            updateCount(1);
            System.out.println("Added last: " + newBook.title);
        }

        public void addAtPosition(Book newBook, int position) {
            if (position <= 0) {
                System.out.println("Position must be positive.");
                return;
            }
            if (position == 1) {
                addFirst(newBook);
                return;
            }

            Book current = head;
            int currentPos = 1;

            while (current != null && currentPos < position - 1) {
                current = current.next;
                currentPos++;
            }

            if (current == null) {
                System.out.println("Position " + position + " is beyond the list size.");
            } else if (current == tail) {
                addLast(newBook);
            } else {
                newBook.next = current.next;
                newBook.prev = current;
                current.next.prev = newBook;
                current.next = newBook;
                updateCount(1);
                System.out.println("Added at position " + position + ": " + newBook.title);
            }
        }


        public void removeById(int bookId) {
            if (isEmpty()) {
                System.out.println("Library is empty. Cannot remove.");
                return;
            }

            Book current = head;
            while (current != null && current.bookId != bookId) {
                current = current.next;
            }

            if (current == null) {
                System.out.println("Book with ID " + bookId + " not found.");
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

            updateCount(-1);
            System.out.println("Removed book: " + current.title);
        }


        public void search(String query, String type) {
            Book current = head;
            boolean found = false;
            
            System.out.println("\nSearch Results (By " + type + ": " + query + "):");

            while (current != null) {
                boolean match = false;
                if (type.equalsIgnoreCase("Title") && current.title.equalsIgnoreCase(query)) {
                    match = true;
                } else if (type.equalsIgnoreCase("Author") && current.author.equalsIgnoreCase(query)) {
                    match = true;
                }

                if (match) {
                    System.out.println("Found: " + current);
                    found = true;
                }
                current = current.next;
            }
            
            if (!found) {
                System.out.println("No book found matching the query.");
            }
        }
        

        public void updateStatus(int bookId, String newStatus) {
            Book current = head;
            while (current != null) {
                if (current.bookId == bookId) {
                    System.out.println("Updated status for " + current.title + ": " + current.availabilityStatus + " -> " + newStatus);
                    current.availabilityStatus = newStatus;
                    return;
                }
                current = current.next;
            }
            System.out.println("Book with ID " + bookId + " not found. Status not updated.");
        }


        public void displayForward() {
            if (isEmpty()) {
                System.out.println("\nLibrary is empty.");
                return;
            }
            System.out.println("\n--- Books (Forward Order) ---");
            Book current = head;
            while (current != null) {
                System.out.println(current);
                current = current.next;
            }
        }

        public void displayReverse() {
            if (isEmpty()) {
                System.out.println("\nLibrary is empty.");
                return;
            }
            System.out.println("\n--- Books (Reverse Order) ---");
            Book current = tail;
            while (current != null) {
                System.out.println(current);
                current = current.prev;
            }
        }


        public int getTotalBookCount() {
            return this.count;
        }
    }


    public static void main(String[] args) {
        LibraryList library = new LibraryList();

        System.out.println("------WELCOME TO LIBRARY MANAGEMENT SYSTEM...");
        System.out.println("--- 1. ADD OPERATIONS ---");
        library.addLast(new Book("Dune", "Frank Herbert", "Sci-Fi", 101, "Available"));
        library.addFirst(new Book("1984", "George Orwell", "Dystopian", 100, "Available"));
        library.addLast(new Book("To Kill a Mockingbird", "Harper Lee", "Fiction", 103, "Checked Out"));
        library.addAtPosition(new Book("Foundation", "Isaac Asimov", "Sci-Fi", 102, "Available"), 3);

        library.displayForward();
        
        System.out.println("\n--- 2. COUNT TOTAL ---");
        System.out.println("Total books in library: " + library.getTotalBookCount());

        System.out.println("\n--- 3. UPDATE STATUS ---");
        library.updateStatus(103, "Available"); 

        System.out.println("\n--- 4. SEARCH OPERATIONS ---");
        library.search("Foundation", "Title");
        library.search("Harper Lee", "Author");
        
        System.out.println("\n--- 5. REMOVE OPERATION ---");
        library.removeById(101);

        System.out.println("\n--- 6. FINAL DISPLAY ---");
        library.displayForward();
        library.displayReverse();
        
        System.out.println("\n--- 7. FINAL COUNT ---");
        System.out.println("Total books after removal: " + library.getTotalBookCount());
    }
}