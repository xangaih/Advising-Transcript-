import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;



//NOTES:  You will need the import statements that appear at the top of this file, so you should
//leave them in place.  Follow the list of steps on the project writeup to complete the CourseHistory
//class that is started below.  This entire block of comments should be deleted when you are done. 


public class CourseHistory
{
    private ArrayList<CompletedCourse> courseList;
    private CompletedCourse c;
    private String[] s;
    public CourseHistory()
    {
        courseList = new ArrayList<CompletedCourse>();
        String department;    //For example "CSC"
        String courseNumber;  //For example 121
        String semesterTaken; //For example 10708  or 20708
        String credit;        //The number of credits the course is worth, for example 1.0, .5, .25 
        String grade;         //For example 4.0, 3.
        String competency;    //Can be 'W', 'Q', 'S', or 'X' (for none)
        String distArea;
        try{
            FileReader reader = new FileReader("finishedcourses.txt");
            Scanner in = new Scanner(reader);
            
            while(in.hasNextLine())
            {
                department = in.nextLine();
                courseNumber = in.nextLine();
                semesterTaken = in.nextLine();
                credit = in.nextLine();
                grade = in.nextLine();
                competency = in.nextLine();
                distArea = in.nextLine();
                CompletedCourse c = new CompletedCourse(department, courseNumber, semesterTaken, credit, grade, competency, distArea);
                courseList.add(c);
            }
        }
        catch(IOException exception){exception.printStackTrace();{
        System.out.println("File not found.");}}
    }
   
    public void displayCourseHistory()
    {
        System.out.println("Course History: ");
        for(int i = 0; i < courseList.size(); i++)
        {
            System.out.println(courseList.get(i).getDepartment());
            System.out.println(courseList.get(i).getCourseNumber());
            System.out.println(courseList.get(i).getSemesterTaken());
            System.out.println(courseList.get(i).getCompetency());
            System.out.println(courseList.get(i).getCredit());
            System.out.println(courseList.get(i).getGrade());
            System.out.println(courseList.get(i).getDistArea());
        }
    }
    
    public void summaryReport()
    {
        System.out.println("Summary Report:");
        double total = 0;
        double gpa = 0;
        double creds = 0;
        for(int i = 0; i < courseList.size(); i++)
        {
            if(courseList.get(i).getGrade() > 0)
            {
                creds = creds + courseList.get(i).getCredit();
            }
            total = total + (courseList.get(i).getGrade()*courseList.get(i).getCredit());
        }
        gpa = total/creds;
        System.out.println("Total credits earned: " + creds);
        System.out.println("Cumulativw GPA: " + gpa);
    }
    
    public void distAreaReport()
    {
        System.out.println("Distribution Summary Report: ");
        double total = 0;
        double gpa = 0;
        double cAH = 0;
        double cSS = 0;
        double cSM = 0;
        double cLA = 0;
        for(int i = 0; i < courseList.size(); i++)
        {
            if(courseList.get(i).getDistArea() == "AH")
            {
                System.out.println(courseList.get(i).getDepartment());
                System.out.println(courseList.get(i).getCourseNumber());
                System.out.println(courseList.get(i).getSemesterTaken());
                System.out.println(courseList.get(i).getCompetency());
                System.out.println(courseList.get(i).getCredit());
                System.out.println(courseList.get(i).getGrade());
                System.out.println(courseList.get(i).getDistArea());
                if(courseList.get(i).getGrade() > 0)
                {
                    cAH = cAH + courseList.get(i).getCredit();
                }
            }
            if(courseList.get(i).getDistArea() == "SS")
            {
                System.out.println(courseList.get(i).getDepartment());
                System.out.println(courseList.get(i).getCourseNumber());
                System.out.println(courseList.get(i).getSemesterTaken());
                System.out.println(courseList.get(i).getCompetency());
                System.out.println(courseList.get(i).getCredit());
                System.out.println(courseList.get(i).getGrade());
                System.out.println(courseList.get(i).getDistArea());
                if(courseList.get(i).getGrade() > 0)
                {
                    cSS = cSS + courseList.get(i).getCredit();
                }
            }
            
            if(courseList.get(i).getDistArea() == "LA")
            {
                System.out.println(courseList.get(i).getDepartment());
                System.out.println(courseList.get(i).getCourseNumber());
                System.out.println(courseList.get(i).getSemesterTaken());
                System.out.println(courseList.get(i).getCompetency());
                System.out.println(courseList.get(i).getCredit());
                System.out.println(courseList.get(i).getGrade());
                System.out.println(courseList.get(i).getDistArea());
                if(courseList.get(i).getGrade() > 0)
                {
                    cLA = cLA + courseList.get(i).getCredit();
                }
            }
            
            if(courseList.get(i).getDistArea() == "SM")
            {
                System.out.println(courseList.get(i).getDepartment());
                System.out.println(courseList.get(i).getCourseNumber());
                System.out.println(courseList.get(i).getSemesterTaken());
                System.out.println(courseList.get(i).getCompetency());
                System.out.println(courseList.get(i).getCredit());
                System.out.println(courseList.get(i).getGrade());
                System.out.println(courseList.get(i).getDistArea());
                if(courseList.get(i).getGrade() > 0)
                {
                    cSM = cSM + courseList.get(i).getCredit();
                }
            }
            
        }
        System.out.println("Total Credits Earned for Arts & Humanities: " + cAH);
        System.out.println("Total Credits Earned for Language: " + cLA);
        System.out.println("Total Credits Earned for Science & Math: " + cSM);
        System.out.println("Total Credits Earned for Social Sciences: " + cSS);
        
    }
   
}












