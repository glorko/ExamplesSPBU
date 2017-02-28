package net.punklan.glorfindeil.study.lesson2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Aleksandr_Kichev on 28-Feb-17.
 */
public class ExceptionsExample {

    public class CustomException extends IOException {

        public CustomException(String s) {
            super(s);
        }
    }

    ;

    private void method1() throws IOException {
        throw new IOException("From method 1");
    }

    ;

    private void method2() throws Exception {
        throw new IllegalArgumentException("From method 2");
    }

    ;

    private void method3() throws IllegalArgumentException {
        throw new IllegalArgumentException("From method 3");
    }

    ;

    private void method4() throws CustomException {
        throw new CustomException("From method 4");
    }
    ;

    public static void main(String[] args) {
        ExceptionsExample ex = new ExceptionsExample();

        try (BufferedReader br =
                     new BufferedReader(new FileReader("file that not exists"))) {
            br.readLine();
        } catch (IOException e) {

        }
        try {
            ex.method4();
        } catch (CustomException e) {
            System.out.println("Zero catch "+e.getMessage());
        }
        try {
            ex.method1();
            ex.method2();
            ex.method3();
            ex.method4();
        } catch (CustomException e) {
            System.out.println("First catch "+e.getMessage());
        } catch (IOException e) {
            System.out.println("Second catch "+e.getMessage());
            try {
                ex.method2();
                ex.method3();
                ex.method4();
            } catch (Exception e1) {
                System.out.println("Third catch "+e1.getMessage());
            }

        } catch (Exception e) {
            System.out.println("Fourth catch "+e.getMessage());
        }
    }

}

