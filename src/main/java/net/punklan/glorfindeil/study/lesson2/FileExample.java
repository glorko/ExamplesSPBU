package net.punklan.glorfindeil.study.lesson2;

import java.io.File;

/**
 * Created by Aleksandr_Kichev on 01-Mar-17.
 */
public class FileExample {

    private void readDir(File dir, int level) {
        if (dir.canRead()) {
            for (File file : dir.listFiles()) {
                try {
                    for (int i = 0; i < level; i++) {
                        System.out.print("  ");
                    }
                    System.out.print("|");
                    System.out.println(file.isDirectory() ? "Directory" : "File"
                            + ":  " + file.getName() + " | " + (file.canExecute() ? "E" : "")
                            + (file.canRead() ? "R" : "")
                            + (file.canWrite() ? "W" : ""));
                    if (file.isDirectory()) {
                        readDir(file, level + 1);
                    }
                }catch (NullPointerException e){
                    System.out.println("NPE");
                }
            }
        } else {
            for (int i = 0; i < level; i++) {
                System.out.print("  ");
            }
            System.out.print("|");
            System.out.println("Directory "+dir.getName()+" cannot be readed");
        }
    }

    public static void main(String[] args) {
        FileExample ex = new FileExample();
        ex.readDir(new File("C:\\Program Files"), 0);
    }
}
