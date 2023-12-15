package week3;

/**
  * Name: Shannon Jones
  * Date: 2020-10-27
  * Description: Student class
  * Notes: Modularity.
  */

public class Student {
    private String name;
    private int test1;
    private int test2;
    private int test3;
    
    public Student() {
        name = "";
        test1 = 0;
        test2 = 0;
        test3 = 0;
    } // end of Student
    
    public Student (String nm, int t1, int t2, int t3) {
        name = nm;
        test1 = t1;
        test2 = t2;
        test3 = t3;
    } // end of Student
    
    public Student (Student s) {
        name = s.name;
        test1 = s.test1;
        test2 = s.test2;
        test3 = s.test3;
    } // end of Student
    
    void setName(String nm) {
        name = nm;
    } // end of setName
    
    String getName() {
        return name;
    } // end of getName
    
    void setScore(int x, int test) {
        if (x == 1) {
            test1 = test;
        }
        else if (x == 2) {
            test2 = test;
        }
        else if (x == 3) {
            test3 = test;
        }
    } // end of setScore
    
    int getScore(int x) {
        if (x == 1) {
            return test1;
        }
        else if (x == 2) {
            return test2;
        }
        else if (x == 3) {
            return test3;
        }
        return -1;
    } // end of getScore
    
    double getAverage() {
        double average = (test1+test2+test3)/3;
        return average;
    } // end of get Average
    
    int getHighScore () {
        int highScore = 0;
        if (highScore < test1) {
            highScore = test1;
        }
        if (highScore < test2) {
            highScore = test2;
        }
        if (highScore < test3) {
            highScore = test3;
        }
        return highScore;
    } // end of getHighScore
    
    public String toString () {
        String str;
        str = "Name:" + "\t" + name + "\n" +
              "Test 1: " + "\t" + test1 + "\n" +
              "Test 2: " + "\t" + test2 + "\n" +
              "Test 3: " + "\t" + test3 + "\n" +
              "Average:" + "\t" + getAverage();
        return str;
    } // end of toString
    
    } // end of Student
