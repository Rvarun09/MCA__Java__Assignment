/*3. Multi-Level University Course Management System
Concepts: Generic Classes, Wildcards, Bounded Type Parameters
Problem Statement:
Develop a university course management system where different departments offer courses with different evaluation types (e.g., Exam-Based, Assignment-Based, Research-Based).
Hints:
Create an abstract class CourseType (e.g., ExamCourse, AssignmentCourse, ResearchCourse).
Implement a generic class Course<T extends CourseType> to manage different courses.
Use wildcards (List<? extends CourseType>) to handle any type of course dynamically. */
import java.util.*;

public class UniversityCourseManagementSystem {

    static abstract class CourseType { 
        String name;
        CourseType(String name) { this.name = name; }
        public String toString() { return name; }
    }
    static class ExamCourse extends CourseType {
        ExamCourse() { super("Exam Based"); }
    }

    static class AssignmentCourse extends CourseType {
        AssignmentCourse() { super("Assignment Based"); }
    }

    static class ResearchCourse extends CourseType {
        ResearchCourse() { super("Research Based"); }
    }
    static class Course<T extends CourseType> {
        String courseName;
        T type;

        Course(String courseName, T type) {
            this.courseName = courseName;
            this.type = type;
        }

        public String toString() {
            return courseName + " (" + type + ")";
        }
    }

    static void displayCourses(List<? extends CourseType> list) {
        for (CourseType ct : list) {
            System.out.println(ct);
        }
    }

    public static void main(String[] args) {
        Course<ExamCourse> c1 = new Course<>("Math 101", new ExamCourse());
        Course<AssignmentCourse> c2 = new Course<>("Java Programming", new AssignmentCourse());
        Course<ResearchCourse> c3 = new Course<>("AI Research", new ResearchCourse());
        List<CourseType> courses = new ArrayList<>();
        courses.add(c1.type);
        courses.add(c2.type);
        courses.add(c3.type);
        displayCourses(courses);
    }
}
