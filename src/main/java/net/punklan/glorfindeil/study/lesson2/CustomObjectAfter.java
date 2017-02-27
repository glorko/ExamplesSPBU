package net.punklan.glorfindeil.study.lesson2;

/**
 * Created by Aleksandr_Kichev on 27-Feb-17.
 */
public class CustomObjectAfter {
    public CustomObjectAfter(String someField) {
        this.someField = someField;
    }

    public String getSomeField() {
        return someField;
    }

    @Override
    public boolean equals(Object o) {
        CustomObjectAfter that = (CustomObjectAfter) o;
        return someField != null ? someField.equals(that.someField) : that.someField == null;
    }

    @Override
    public int hashCode() {
        return someField != null ? someField.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "CustomObjectAfter{" +
                "someField='" + someField + '\'' +
                '}';
    }

    private String someField;

    public static void main(String[] args) {
        String testString = "SomeTestString";
        CustomObjectAfter obj1 = new CustomObjectAfter(testString);
        CustomObjectAfter obj2 = new CustomObjectAfter(testString);
        System.out.println(obj1.toString());
        System.out.println(obj1.hashCode());
        System.out.println(obj2.hashCode());
        System.out.println(obj1.equals(obj2));
    }
}
