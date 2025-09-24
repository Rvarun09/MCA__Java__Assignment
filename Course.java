public class Course {
    String coursename;
    String duration;
    Course(String coursename , String duration){
        this.coursename=coursename;
        this.duration=duration;
    }
    public void display(){
        System.out.println("Course name: "+coursename);
        System.out.println("Duration: "+duration);
    }
}
class OnlineCourse extends Course{
    String platform;
    String isRecorded;
    OnlineCourse(String coursename , String duration , String platform , String isRecorded){
        super(coursename,duration);
        this.platform=platform;
        this.isRecorded=isRecorded;
    }
        public void display(){
        super.display();
        System.out.println("Platform: "+platform);
        System.out.println("Is Recorded: "+isRecorded);
    }
}
class PaidOnlineCourse extends OnlineCourse{
    int fees;
    int discount;
    PaidOnlineCourse(String coursename , String duration , String platform , String isRecorded , int fees , int discount){
        super(coursename, duration, platform, isRecorded);
        this.fees =fees;
        this.discount=discount;
    }
    public void display(){
        super.display();
        System.out.println("Fees: "+fees);
        System.out.println("Discout: "+discount);
    }
}
class Education{
    public static void main(String[] args) {
        Course c1 = new Course("MySql", "3hrs");
        c1.display();
        System.out.println(" ");
        OnlineCourse o1 = new OnlineCourse("PHP", "5hrs", "Udemy", "No");
        o1.display();
        System.out.println(" ");
        PaidOnlineCourse p1=new PaidOnlineCourse("JAVA", "15 hrs", "Bridge Labs", "Yess", 15000, 5);
        p1.display();
    }
}
