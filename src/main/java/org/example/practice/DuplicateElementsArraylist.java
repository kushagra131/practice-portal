package org.example.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class DuplicateElementsArraylist {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ArrayList<String> list = new ArrayList<String>();
        list.add("java");
        list.add("j2ee");
        list.add("java");
        list.add("jsp");
        list.add("j2ee");
        list.add("servlet");
        list.add("struts");

        LinkedList<String> linkedlist = new LinkedList<String>(list);

        ListIterator<String> itr1 = list.listIterator();

        while (itr1.hasNext()) {
            System.out.println("Output of List with ListIterator: " + itr1.next());
        }

        Iterator<String> itr2 = linkedlist.descendingIterator();
        while (itr2.hasNext()) {
            System.out.println("Output of List Backwards with ListIterator: " + itr2.next());
        }

        for (String obj : list) {
            System.out.println("Output with for-each: " + obj);
        }

        System.out.println("Arraylist with given elements: " + list);

        HashSet<String> set = new HashSet<String>(list);

        System.out.println("HashSet with elements: " + set);

        ArrayList<String> list2 = new ArrayList<String>(set);

        System.out.println("Arraylist with unique elements: " + list2);

        int size = list.size();
        System.out.println(size);

        String[] strObj = new String[size];
        list.toArray(strObj);

        System.out.println("String[] is: " + Arrays.toString(strObj));
    }

}
