package lesson2;

import java.util.ArrayList;

public class MainClass {
    public static void main(String[] args) {
        MyArrayList<Integer> arrayList = new MyArrayList<>();

        arrayList.add(12);
        arrayList.add(13);
        arrayList.add(14);
        arrayList.add(15);
        arrayList.add(16);

        System.out.println(arrayList);

        arrayList.remove(3);

        System.out.println(arrayList);

        System.out.println(arrayList.getElement(3));


        MyLinkList<Integer> linkList = new MyLinkList<>();
        linkList.addToEnd(21);
        linkList.addToEnd(22);
        linkList.addToEnd(23);
        linkList.addToEnd(24);
        linkList.addToEnd(25);

        System.out.println(linkList.len);
        System.out.println(linkList.getElement());
        System.out.println(linkList.getElement(2));

        System.out.println((Integer) linkList.getFirstNode().element);

        System.out.println(linkList);

        linkList.remove(2);
        System.out.println(linkList);
        linkList.remove(2);
        System.out.println(linkList);
        linkList.remove(2);
        System.out.println(linkList);
        linkList.remove(2);
        System.out.println(linkList);

        linkList.addToEnd(24);
        linkList.addToEnd(25);
        System.out.println(linkList);
    }
}
