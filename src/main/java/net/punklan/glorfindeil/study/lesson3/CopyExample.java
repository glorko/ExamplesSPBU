package net.punklan.glorfindeil.study.lesson3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * Created by Aleksandr_Kichev on 06-Mar-17.
 */
public class CopyExample {
    public static void main(String[] args) throws IOException {

        //Get the instance of Path of Source File
        Path pathSource = Paths.get("c:/windows","system.ini");

        // Using Path and OutputStream with Files.copy
        //get the File to be written
        File destFile = new File("new_ini.ini");
        FileOutputStream fos = new FileOutputStream(destFile);

        //copy a file to destination file and returns no of bytes written
        long noOfBytes = Files.copy(pathSource, fos);
        System.out.println(noOfBytes);

        //Using InputStream and Path with Files.copy
        File sourceFile = new File("c:/windows/system.ini");
        FileInputStream fis = new FileInputStream(sourceFile);
        Path destPath1 = Paths.get("new_ini2.ini");

        noOfBytes = Files.copy(fis,destPath1, StandardCopyOption.REPLACE_EXISTING);
        System.out.println(noOfBytes);


    }
}