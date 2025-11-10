import java.util.ArrayList;
import java.util.List;

public class SocialMediaManager {

    static class User {
        int userId;
        String name;
        int age;
        List<Integer> friendIds;
        User next;

        public User(int userId, String name, int age) {
            this.userId = userId;
            this.name = name;
            this.age = age;
            this.friendIds = new ArrayList<>();
            this.next = null;
        }

        @Override
        public String toString() {
            return String.format("[ID: %d, Name: %s, Age: %d, Friends: %d]",
                userId, name, age, friendIds.size());
        }
    }

    static class UserList {
        User head;

        public UserList() {
            this.head = null;
        }

        public boolean isEmpty() {
            return head == null;
        }
        

        private User findUserNode(int userId) {
            User current = head;
            while (current != null) {
                if (current.userId == userId) {
                    return current;
                }
                current = current.next;
            }
            return null;
        }
        
        private User findUserNode(String name) {
            User current = head;
            while (current != null) {
                if (current.name.equalsIgnoreCase(name)) {
                    return current;
                }
                current = current.next;
            }
            return null;
        }

        public void addUser(User newUser) {
            if (isEmpty()) {
                head = newUser;
                return;
            }
            User current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newUser;
        }


        public void addFriendConnection(int userId1, int userId2) {
            User user1 = findUserNode(userId1);
            User user2 = findUserNode(userId2);

            if (user1 == null || user2 == null) {
                System.out.println(" Error: One or both User IDs not found.");
                return;
            }
            if (user1.friendIds.contains(userId2)) {
                System.out.println(" Connection already exists between " + user1.name + " and " + user2.name + ".");
                return;
            }

            user1.friendIds.add(userId2);
            user2.friendIds.add(userId1);

            System.out.println("Added connection between " + user1.name + " and " + user2.name + ".");
        }


        public void removeFriendConnection(int userId1, int userId2) {
            User user1 = findUserNode(userId1);
            User user2 = findUserNode(userId2);

            if (user1 == null || user2 == null) {
                System.out.println(" Error: One or both User IDs not found.");
                return;
            }
            if (!user1.friendIds.contains(userId2)) {
                System.out.println("Connection does not exist between " + user1.name + " and " + user2.name + ".");
                return;
            }

            user1.friendIds.remove((Integer) userId2);
            user2.friendIds.remove((Integer) userId1);

            System.out.println(" Removed connection between " + user1.name + " and " + user2.name + ".");
        }


        public void findMutualFriends(int userId1, int userId2) {
            User user1 = findUserNode(userId1);
            User user2 = findUserNode(userId2);
            List<String> mutualNames = new ArrayList<>();

            if (user1 == null || user2 == null) {
                System.out.println(" Error: One or both User IDs not found.");
                return;
            }

            List<Integer> commonFriends = new ArrayList<>(user1.friendIds);
            commonFriends.retainAll(user2.friendIds);

            for (int id : commonFriends) {
                User friend = findUserNode(id);
                if (friend != null) {
                    mutualNames.add(friend.name);
                }
            }

            System.out.println("\n Mutual friends between " + user1.name + " and " + user2.name + ":");
            if (mutualNames.isEmpty()) {
                System.out.println("  -> None.");
            } else {
                System.out.println("  -> " + mutualNames);
            }
        }


        public void displayUserFriends(int userId) {
            User user = findUserNode(userId);
            if (user == null) {
                System.out.println(" User with ID " + userId + " not found.");
                return;
            }

            System.out.println("\n Friends of " + user.name + ":");
            if (user.friendIds.isEmpty()) {
                System.out.println("  -> No friends yet.");
                return;
            }

            for (int friendId : user.friendIds) {
                User friend = findUserNode(friendId);
                if (friend != null) {
                    System.out.println("  - " + friend);
                }
            }
        }
        
        public void search(String query) {
            User user = null;
            try {
                int id = Integer.parseInt(query);
                user = findUserNode(id);
            } catch (NumberFormatException e) {
                user = findUserNode(query);
            }

            System.out.println("\nSearch result for '" + query + "':");
            if (user != null) {
                System.out.println("  -> Found: " + user);
            } else {
                System.out.println("  -> User not found.");
            }
        }


        public void countAllFriends() {
            User current = head;
            System.out.println("\n Friend Counts:");
            while (current != null) {
                System.out.println("  - " + current.name + ": " + current.friendIds.size() + " friends.");
                current = current.next;
            }
        }
    }


    public static void main(String[] args) {
        UserList network = new UserList();

        network.addUser(new User(10, "varun", 25));
        network.addUser(new User(20, "chirag", 30));
        network.addUser(new User(30, "kartik", 28));
        network.addUser(new User(40, "rahul", 35));
        network.addUser(new User(50, "priya", 22));

        System.out.println("--- 1. ADD CONNECTIONS ---");
        network.addFriendConnection(10, 20); 
        network.addFriendConnection(10, 30); 
        network.addFriendConnection(20, 30); 
        network.addFriendConnection(20, 40); 
        network.addFriendConnection(30, 50); 
        
        System.out.println("\n--- 2. DISPLAY FRIENDS ---");
        network.displayUserFriends(20); 

        System.out.println("\n--- 3. FIND MUTUAL FRIENDS ---");
        network.findMutualFriends(10, 20); 
        network.findMutualFriends(40, 50); 

        System.out.println("\n--- 4. COUNT FRIENDS ---");
        network.countAllFriends();
        
        System.out.println("\n--- 5. SEARCH USER ---");
        network.search("priya");
        network.search("99");

        System.out.println("\n--- 6. REMOVE CONNECTION ---");
        network.removeFriendConnection(10, 30); 
        
        System.out.println("\n--- 7. VERIFY AFTER REMOVAL ---");
        network.displayUserFriends(10);
        network.countAllFriends();
    }
}