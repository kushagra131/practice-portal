package org.example.practice;

public class StringContainsRotation {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String str1 = new String("JavaJ2eeStrutsHibernate");
        String str2 = new String("HibernateJavaStrutsJ2ee");

        if (str1.length() != str2.length()) {
            System.out.println("No rotation");
        } else {
            String str3 = str1 + str2;
            System.out.println("String 3 is: " + str3);
            if (str3.contains(str1)) {
                System.out.println("rotation is present");
            } else {
                System.out.println("No rotation inside if loop");
            }
        }
    }

}
