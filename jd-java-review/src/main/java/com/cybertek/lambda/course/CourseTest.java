package com.cybertek.lambda;

public class CourseTest {

    public static void main(String[] args) {
        Course java = new Java();
        java.study();

        Selenium delphi = new Selenium();
        delphi.study();

        Course maths = new Course() {
            public void study(){
                System.out.println("Studying Java");
            }
        };
        maths.study();

        Selenium selenium = new Selenium() {
            public void study(){
                System.out.println("Studying selenium");
            }
        };
        selenium.study();

        Course javaCourse = () -> System.out.println("Java course");
        javaCourse.study();

    }
}
