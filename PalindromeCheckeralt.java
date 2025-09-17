public class PalindromeCheckeralt {
    public void check(String str){
        int start =0;
        int end = str.length()-1;
        while(start<end){
            if(str.charAt(start)!=str.charAt(end)){
                System.out.println("not a palindrome ");
                return;
            }
            start++;
            end--;
        }
        System.out.println("This is palindrome");
    }
    public static void main(String[] args) {
        PalindromeCheckeralt pc = new PalindromeCheckeralt();
        pc.check("rahul");
    }
}
