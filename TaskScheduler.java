public class TaskScheduler {


    static class Task {
        int taskId;
        String taskName;
        int priority; 
        String dueDate;
        Task next; 

        public Task(int taskId, String taskName, int priority, String dueDate) {
            this.taskId = taskId;
            this.taskName = taskName;
            this.priority = priority;
            this.dueDate = dueDate;
            this.next = null; 
        }

        @Override
        public String toString() {
            return String.format("[ID: %d, Name: %s, Priority: %d, Due: %s]",
                taskId, taskName, priority, dueDate);
        }
    }


    static class TaskCircularList {
        Task head;      
        Task last;      
        Task current;   

        public TaskCircularList() {
            this.head = null;
            this.last = null;
            this.current = null;
        }

        public boolean isEmpty() {
            return head == null;
        }

        private void initializeList(Task newTask) {
            head = newTask;
            last = newTask;
            head.next = head; 
            current = head;  
        }

        public void addFirst(Task newTask) {
            if (isEmpty()) {
                initializeList(newTask);
            } else {
                newTask.next = head;
                last.next = newTask; 
                head = newTask;     
            }
            System.out.println("Added first: " + newTask.taskName);
        }

        public void addLast(Task newTask) {
            if (isEmpty()) {
                initializeList(newTask);
            } else {
                newTask.next = head; 
                last.next = newTask; 
                last = newTask;      
            }
            System.out.println("Added last: " + newTask.taskName);
        }

        public void addAtPosition(Task newTask, int position) {
            if (position <= 0) {
                System.out.println("Position must be positive.");
                return;
            }
            if (position == 1) {
                addFirst(newTask);
                return;
            }
            if (isEmpty()) {
                System.out.println("List is empty. Adding at position 1 instead.");
                addFirst(newTask);
                return;
            }

            Task temp = head;
            int count = 1;

            do {
                if (count == position - 1) {
                    newTask.next = temp.next; 
                    temp.next = newTask;      

                    if (temp == last) {
                        last = newTask; 
                    }
                    System.out.println("Added at position " + position + ": " + newTask.taskName);
                    return;
                }
                temp = temp.next;
                count++;
            } while (temp != head);
            
            System.out.println("Position " + position + " is beyond the list size. Task not added.");
        }


        public void removeByTaskId(int taskId) {
            if (isEmpty()) {
                System.out.println("List is empty. Cannot remove.");
                return;
            }

            Task current = head;
            Task prev = last;
            String removedName = "";

            do {
                if (current.taskId == taskId) {
                    removedName = current.taskName;
                                        
                    if (head == last) {
                        head = null;
                        last = null;
                        current = null;
                        System.out.println("Removed last task: " + removedName + ". List is now empty.");
                        return;
                    }
                    
                    if (current == head) {
                        head = head.next;
                        last.next = head; 
                        if (current == this.current) {
                             this.current = head; 
                        }
                    } 
                    
                    else if (current == last) {
                        last = prev;
                        last.next = head; 
                        if (current == this.current) {
                             this.current = head; 
                        }
                    }
                    
                    else {
                        prev.next = current.next; 
                        if (current == this.current) {
                             this.current = current.next;
                        }
                    }
                    
                    System.out.println("Removed task: " + removedName);
                    return;
                }
                prev = current;
                current = current.next;
            } while (current != head);

            System.out.println("Task with ID " + taskId + " not found.");
        }


        public void viewAndMoveNext() {
            if (isEmpty()) {
                System.out.println("Scheduler is empty. No tasks to view.");
                return;
            }

            System.out.println("\n Currently Processing: " + current);

            current = current.next; 
            
            System.out.println("   Next Task in queue: " + current.taskName);
        }
        

        public void displayAllTasks() {
            if (isEmpty()) {
                System.out.println("\nList is empty. No tasks to display.");
                return;
            }

            System.out.println("\n All Tasks (Starting from Head, Loop Detected):");
            Task temp = head;
            int count = 1;
            
            do {
                System.out.println(String.format("  %d. %s", count, temp));
                temp = temp.next;
                count++;
            } while (temp != head);
        }
        

        public void searchByPriority(int priority) {
            if (isEmpty()) {
                System.out.println("List is empty. Cannot search.");
                return;
            }
            if (priority < 1 || priority > 5) {
                System.out.println("Invalid priority level. Must be between 1 and 5.");
                return;
            }

            Task temp = head;
            boolean found = false;

            System.out.println("\nSearch Results (Priority Level: " + priority + "):");
            
            do {
                if (temp.priority == priority) {
                    System.out.println("  -> Found: " + temp);
                    found = true;
                }
                temp = temp.next;
            } while (temp != head);

            if (!found) {
                System.out.println("  -> No tasks found with Priority " + priority + ".");
            }
        }
    }

    public static void main(String[] args) {
        TaskCircularList scheduler = new TaskCircularList();

        System.out.println("--- 1. ADD OPERATIONS ---");
        scheduler.addLast(new Task(101, "Review Code", 2, "2025-11-10"));
        scheduler.addFirst(new Task(100, "Fix Critical Bug", 1, "2025-11-08")); // New Head
        scheduler.addLast(new Task(103, "Design UI Mockup", 3, "2025-11-15"));
        scheduler.addAtPosition(new Task(102, "Write Documentation", 2, "2025-11-12"), 3); 
        scheduler.addAtPosition(new Task(104, "Order supplies", 5, "2025-11-20"), 5); // Add to the end

        scheduler.displayAllTasks();
        
        System.out.println("\n--- 2. VIEW & CYCLE OPERATIONS ---");
        scheduler.viewAndMoveNext(); 
        scheduler.viewAndMoveNext(); 
        scheduler.viewAndMoveNext(); 
        
        System.out.println("\n--- 3. REMOVE OPERATION ---");
        scheduler.removeByTaskId(102); 
        scheduler.removeByTaskId(100); 
        
        scheduler.displayAllTasks();
        
        System.out.println("\n--- 4. SEARCH OPERATIONS ---");
        scheduler.searchByPriority(2); 
        scheduler.searchByPriority(4); 
        
        System.out.println("\n--- 5. CYCLE AFTER REMOVAL ---");
        scheduler.viewAndMoveNext();
        scheduler.viewAndMoveNext(); 
    }
}