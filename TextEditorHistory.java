import java.util.LinkedList;

public class TextEditorHistory {

    static class TextState {
        String content;
        TextState prev;
        TextState next;

        public TextState(String content) {
            this.content = content;
            this.prev = null;
            this.next = null;
        }

        @Override
        public String toString() {
            return content;
        }
    }

    static class HistoryManager {
        TextState head;
        TextState tail;
        TextState currentState;
        int historyLimit;
        int size;

        public HistoryManager(int limit, String initialText) {
            this.historyLimit = limit;
            this.size = 0;
            TextState initialState = new TextState(initialText);
            this.head = initialState;
            this.tail = initialState;
            this.currentState = initialState;
            this.size = 1;
        }


        public void executeAction(String newContent) {
            TextState newState = new TextState(newContent);
            
            if (currentState != tail) {
            
                currentState.next = newState;
                this.tail = newState;
                newState.prev = currentState;
                this.size = 0; 
                
                TextState temp = head;
                while (temp != null) {
                    this.size++;
                    temp = temp.next;
                }
            } else {
                this.tail.next = newState;
                newState.prev = this.tail;
                this.tail = newState;
                this.size++;
            }

            this.currentState = newState;

            if (this.size > historyLimit) {
    
                this.head = this.head.next;
                this.head.prev = null;
                this.size--;
            }
            
            System.out.println(" Executed: '" + newContent + "'");
        }


        public boolean undo() {
            if (currentState.prev == null) {
                System.out.println(" Cannot Undo: At the oldest state.");
                return false;
            }
            this.currentState = this.currentState.prev;
            System.out.println(" Undid action.");
            return true;
        }


        public boolean redo() {
            if (currentState.next == null) {
                System.out.println(" Cannot Redo: At the newest state.");
                return false;
            }
            this.currentState = this.currentState.next;
            System.out.println(" Redid action.");
            return true;
        }


        public void displayCurrentState() {
            String status = (currentState.prev == null ? " (Oldest)" : (currentState.next == null ? " (Newest)" : ""));
            System.out.println("\n--- Current Text State (Size: " + size + "/" + historyLimit + ") ---");
            System.out.println("Text: " + currentState.content + status);
            System.out.println("-------------------------------------------------");
        }
    }


    public static void main(String[] args) {
        HistoryManager editor = new HistoryManager(5, "Hello, world!"); 

        editor.displayCurrentState();

        System.out.println("\n--- 1. Executing Actions ---");
        editor.executeAction("Hello, world! I");
        editor.executeAction("Hello, world! I am");
        editor.executeAction("Hello, world! I am building");
        editor.executeAction("Hello, world! I am building an editor.");
        editor.executeAction("Hello, world! I am building an editor."); // Total 5 states

        editor.displayCurrentState();
        
        System.out.println("\n--- 2. Testing Undo/Redo ---");
        editor.undo();
        editor.undo(); 
        editor.displayCurrentState(); 
        
        editor.redo();
        editor.displayCurrentState(); 
        
        System.out.println("\n--- 3. Executing After Undo (Truncates Redo) ---");
        editor.executeAction("Hello, world! I am now writing a new sentence.");
        editor.displayCurrentState();
        editor.redo(); 
        
        
        System.out.println("\n--- 4. Testing History Limit (Executing 3 more actions) ---");
        editor.executeAction("Line 6"); 
        editor.executeAction("Line 7"); 
        editor.executeAction("Line 8 (Oldest should be removed)"); 

        editor.displayCurrentState(); 
        editor.undo();
        editor.undo();
        editor.undo();
        editor.undo();
        editor.undo(); 
        editor.undo();
    }
}