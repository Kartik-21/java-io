package org.example;

import java.io.File;
import java.io.IOException;

/*
 * file is used for create update delete operations
 *
 * */
public class FileApp {
    public static void main(String[] args) throws IOException {

        File dir = new File("dir");
        if (!dir.exists())
            dir.mkdir();
        System.out.println(dir.exists());

        File file = new File(dir, "p.txt");
        if (!file.exists())
            file.createNewFile();
        System.out.println(file.exists());
        System.out.println(file.length());


        System.out.println(file.getParent());
        System.out.println(file.getPath());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getCanonicalPath());
    }

}
