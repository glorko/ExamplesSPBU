package net.punklan.glorfindeil.study.lesson3;

/**
 * Created by Aleksandr_Kichev on 06-Mar-17.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Scanner; // импортируем класс

public class ScannerExample {
    public static void main(String[] args) {
        URL url = Thread.currentThread().getContextClassLoader().getResource("test_data.txt");
        File file = new File(url.getPath());
        Scanner sc = new Scanner(System.in); // создаём объект класса Scanner
        int i = 2;
        System.out.print("Введите целое число: ");
        if (sc.hasNextInt()) { // возвращает истинну если с потока ввода можно считать целое число
            i = sc.nextInt(); // считывает целое число с потока ввода и сохраняем в переменную
            System.out.println(i * 2);
        } else {
            System.out.println("Вы ввели не целое число");
        }
        try (Scanner sc2 = new Scanner(file)) {
            while (sc2.hasNextInt()) {
                System.out.println(Integer.toBinaryString(sc2.nextInt()));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
