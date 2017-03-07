package net.punklan.glorfindeil.study.lesson3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;

/**
 * Created by Aleksandr_Kichev on 06-Mar-17.
 */
public class CreateDirectoryExample {
    public static void main(String[] args) throws IOException {
        Set<PosixFilePermission> perms = PosixFilePermissions.fromString("rwxrwx--x");
        FileAttribute<Set<PosixFilePermission>> fileAttributes = PosixFilePermissions.asFileAttribute(perms);
        Path path = Paths.get("D:", "Parent","Child");

        //This line of code will not work in Windows OS
        //Files.createDirectories(path,fileAttributes);

        //creates Directory as Directory as D:\Parent\Child
        Files.createDirectories(path);

        Path path1 = Paths.get("D:", "Parent","Child1");

        //creates Directory as Directory Child1 under  as D:\Parent
        Files.createDirectory(path1);

        //creates temp directory in file system temp directory
        Files.createTempDirectory("Concretepage");

        //creates temp directory in the specified path
        Files.createTempDirectory(path,"Concretepage");
    }
}

