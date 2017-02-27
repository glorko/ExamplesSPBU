package net.punklan.glorfindeil.study.lesson2;

/**
 * Created by Aleksandr_Kichev on 27-Feb-17.
 */
public class CustomObjectBefore {
    public CustomObjectBefore(String someField) {
        this.someField = someField;
    }

    public String getSomeField() {
        return someField;
    }

    private String someField;

    public static void main(String[] args) {
        String testString = "SomeTestString";
        CustomObjectBefore obj1 = new CustomObjectBefore(testString);
        CustomObjectBefore obj2 = new CustomObjectBefore(testString);
        System.out.println(obj1.toString());
        System.out.println(obj1.hashCode());
        System.out.println(obj2.hashCode());
        System.out.println(obj1.equals(obj2));
        //toString may produce NPE (NullPointerException)
        CustomObjectBefore nullObj = null;
        try {
            System.out.println(nullObj.toString());
        } catch (NullPointerException e) {
            System.out.println("Ok, i got an exception " + e);
        }
        //correct usage (calls toString when it can)
        System.out.println("" + nullObj);
    }
}