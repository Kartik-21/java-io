package org.example;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;


/**
 * Inputesteam outputstream used for read and write data in a file
 * read/write using bytes
 */
public class SteamApp {
    public static void main(String[] args) throws IOException {

        System.out.write(65);
        System.out.flush();
        System.out.println();


        String s = "23456  ";
        byte[] b = s.getBytes();
        System.out.write(b);
        System.out.flush();
        System.out.println();


        InputStream stream = new FileInputStream(Path.of("C:\\Users\\kartik\\Documents\\test.txt").toFile());
        System.out.println(stream.available());

//        InputStream stream1 = new FileInputStream("C:\\Users\\kartik\\Desktop\\grokking the object oriented design.pdf");
//        System.out.println(stream1.available());


        OutputStream outputStream = new FileOutputStream("C:\\Users\\kartik\\IdeaProjects\\java-io\\text.txt", false);

        long start = System.currentTimeMillis();
        while (true) {
            // read next bytes(1byte=256) which is int, but console support uft-8 so,
            // it converted into ascii value
            int read = stream.read();
            if (read == -1) {
                System.out.println(" --end");
                break;
            }
            System.out.write(read); //write on console
            outputStream.write(read);
        }

//        byte[] bytes = new byte[stream1.available()];
//        for (int i = 0; i < bytes.length; i++) {
//            outputStream.write(i);
//        }
//        long end = System.currentTimeMillis();
//        System.out.println(end - start);
//        outputStream.flush();


        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\kartik\\IdeaProjects\\java-io\\text.txt");
        fileInputStream.getChannel();


        ///create class and extend the filterinputstream ... manipulate the data
//        FilterInputStream filterInputStream=new FilterInputStream();


        InputStream inputStream = new BufferedInputStream(stream);

        OutputStream outputStream1 = new BufferedOutputStream(outputStream);

//        ByteArrayInputStream byteArrayInputStream=new ByteArrayInputStream(stream.readAllBytes());


//        ByteArrayOutputStream.toBufferedInputStream()


        InputStream newInputStream = Files.newInputStream(Path.of("C:\\Users\\kartik\\IdeaProjects\\java-io\\redme.txt"));

        byte[] bytes = new byte[1000];
        newInputStream.read(bytes, 0, 1000);
        System.out.write(bytes);

    }
}
