import java.util.ArrayList;
import java.util.List;

public class CPUScheduler {

    static class Process {
        int processId;
        String name;
        int burstTime;
        int remainingTime;
        int priority;
        int arrivalTime;
        int completionTime;
        int turnAroundTime;
        int waitingTime;
        Process next;

        public Process(int processId, String name, int burstTime, int priority, int arrivalTime) {
            this.processId = processId;
            this.name = name;
            this.burstTime = burstTime;
            this.remainingTime = burstTime;
            this.priority = priority;
            this.arrivalTime = arrivalTime;
            this.completionTime = 0;
            this.turnAroundTime = 0;
            this.waitingTime = 0;
            this.next = null;
        }

        @Override
        public String toString() {
            return String.format("[P%d: %s, BT: %d, Rem: %d]",
                processId, name, burstTime, remainingTime);
        }
    }

    static class ProcessCircularList {
        Process head;
        Process last;

        public ProcessCircularList() {
            this.head = null;
            this.last = null;
        }

        public boolean isEmpty() {
            return head == null;
        }

        private void initializeList(Process newProcess) {
            head = newProcess;
            last = newProcess;
            head.next = head;
        }


        public void addLast(Process newProcess) {
            if (isEmpty()) {
                initializeList(newProcess);
                return;
            }
            newProcess.next = head;
            last.next = newProcess;
            last = newProcess;
        }


        public void removeById(int processId) {
            if (isEmpty()) {
                return;
            }

            if (head.processId == processId) {
                if (head == last) {
                    head = last = null;
                    return;
                }
                last.next = head.next;
                head = head.next;
                return;
            }

            Process current = head;
            Process prev = last;

            do {
                if (current.processId == processId) {
                    prev.next = current.next;
                    if (current == last) {
                        last = prev;
                    }
                    return;
                }
                prev = current;
                current = current.next;
            } while (current != head);
        }
    

        public void displayProcesses() {
            if (isEmpty()) {
                System.out.println("Queue is empty.");
                return;
            }

            Process temp = head;
            System.out.print("Current Queue: ");
            do {
                System.out.print(temp.toString() + (temp.next != head ? " -> " : " (Circular to P" + head.processId + ")"));
                temp = temp.next;
            } while (temp != head);
            System.out.println();
        }
    }


    public static void simulateRoundRobin(ProcessCircularList queue, int quantum) {
        if (queue.isEmpty()) {
            System.out.println("No processes to schedule.");
            return;
        }

        List<Process> finishedProcesses = new ArrayList<>();
        int currentTime = 0;
        Process currentProcess = queue.head;
        int round = 1;

        System.out.println("\n--- Starting Round Robin Simulation (Quantum = " + quantum + ") ---");

        while (!queue.isEmpty()) {
            System.out.println("\n--- Round " + round + " (Time: " + currentTime + ") ---");
            queue.displayProcesses();
            
            int executionTime = Math.min(currentProcess.remainingTime, quantum);
            currentProcess.remainingTime -= executionTime;
            currentTime += executionTime;

            System.out.println("Executing P" + currentProcess.processId + " for " + executionTime + " units. Remaining: " + currentProcess.remainingTime);

            if (currentProcess.remainingTime <= 0) {
                currentProcess.completionTime = currentTime;
                finishedProcesses.add(currentProcess);
                System.out.println("Process P" + currentProcess.processId + " Finished at time " + currentTime);
                
                Process nextProcess = currentProcess.next;
                queue.removeById(currentProcess.processId);
                
                if (!queue.isEmpty()) {
                    currentProcess = nextProcess;
                }
            } else {
                currentProcess = currentProcess.next;
            }
            round++;
        }
        
        calculateMetrics(finishedProcesses);
    }


    private static void calculateMetrics(List<Process> finishedProcesses) {
        double totalWaitingTime = 0;
        double totalTurnAroundTime = 0;
        
        System.out.println("\n--- RESULTS ---");
        System.out.printf("%-8s | %-12s | %-12s | %-12s | %-12s%n", 
                          "P_ID", "Burst Time", "Completion", "TurnAround", "Waiting");
        System.out.println("-----------------------------------------------------------------");

        for (Process p : finishedProcesses) {
            p.turnAroundTime = p.completionTime - p.arrivalTime;
            p.waitingTime = p.turnAroundTime - p.burstTime;

            totalTurnAroundTime += p.turnAroundTime;
            totalWaitingTime += p.waitingTime;
            
            System.out.printf("%-8d | %-12d | %-12d | %-12d | %-12d%n", 
                              p.processId, p.burstTime, p.completionTime, p.turnAroundTime, p.waitingTime);
        }

        double avgWaitingTime = totalWaitingTime / finishedProcesses.size();
        double avgTurnAroundTime = totalTurnAroundTime / finishedProcesses.size();

        System.out.println("\nAverage Waiting Time: " + String.format("%.2f", avgWaitingTime));
        System.out.println("Average Turn-Around Time: " + String.format("%.2f", avgTurnAroundTime));
    }

    public static void main(String[] args) {
        ProcessCircularList queue = new ProcessCircularList();
        int quantum = 2; 

        queue.addLast(new Process(1, "Task-A", 10, 2, 0));
        queue.addLast(new Process(2, "Task-B", 4, 1, 0));
        queue.addLast(new Process(3, "Task-C", 5, 3, 0));
        queue.addLast(new Process(4, "Task-D", 3, 1, 0));

        simulateRoundRobin(queue, quantum);
    }
}