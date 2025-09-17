public class PalindromeChecker {
    public void check(String str){
        String rev ="" ;
        for(int i=str.length()-1;i>=0;i--){
            rev = rev + str.charAt(i);
        }
        System.out.println(rev);
        if(str.equals(rev)){
            System.out.println("This is palindrome ");
        }
        else{
            System.out.println("This is not a palindrome ");
        }
        }
        public static void main(String[] args){
            PalindromeChecker pc = new PalindromeChecker();
            pc.check("level");
     }
}
