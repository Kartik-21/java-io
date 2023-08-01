package org.example;

import org.apache.commons.io.output.ByteArrayOutputStream;

import java.io.*;


/*
* Inputesteam outputstream used for read and write data in a file
* read/write using bytes
* */
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


        InputStream stream = new FileInputStream("C:\\Users\\kartik\\IdeaProjects\\java-io\\text1.txt");
        System.out.println(stream.available());

        InputStream stream1 = new FileInputStream("C:\\Users\\kartik\\Desktop\\grokking the object oriented design.pdf");
        System.out.println(stream1.available());

        InputStream stream2 = new FileInputStream("C:\\Users\\kartik\\IdeaProjects\\java-io\\text.txt");
        System.out.println(stream2.available());

        OutputStream outputStream = new FileOutputStream("C:\\Users\\kartik\\IdeaProjects\\java-io\\text.txt",true);
        long start = System.currentTimeMillis();
        while (true) {
            int read = stream.read();
            if (read == -1) {
                System.out.println(" --end");
                break;
            }
            System.out.write(read);
            outputStream.write(read);
        }

        while (true) {
            int read = stream2.read();
            if (read == -1) {
                System.out.println(" --end");
                break;
            }
            System.out.write(read);
            outputStream.write(read);
        }
//        byte[] bytes=new byte[stream2.available()];
//        for (int i=0;i<bytes.length;i++){
//            outputStream.write(i);
//        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        outputStream.flush();



        FileInputStream fileInputStream=new FileInputStream("C:\\Users\\kartik\\IdeaProjects\\java-io\\text.txt");
        fileInputStream.getChannel();


        ///create class and extend thr filterinputsstream ... manipute the data
//        FilterInputStream filterInputStream=new FilterInputStream();





        InputStream inputStream=new BufferedInputStream(stream);

        OutputStream outputStream1=new BufferedOutputStream(outputStream);

//        ByteArrayInputStream byteArrayInputStream=new ByteArrayInputStream(stream.readAllBytes());


//        ByteArrayOutputStream.toBufferedInputStream()
    }
}
