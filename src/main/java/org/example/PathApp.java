package org.example;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathApp {

    public static void main(String[] args) throws IOException {

        Path path = Paths.get("../readme.txt");


        System.out.println(path.getFileName());
        System.out.println(path.toAbsolutePath());
//        System.out.println(path.toRealPath());
        System.out.println(path.toFile());
        System.out.println(path.toUri());
        System.out.println(path.getFileSystem().provider());
        System.out.println(path.normalize());


        Files.exists(path, LinkOption.NOFOLLOW_LINKS);
        Path filePath = Path.of("C:\\Users\\kartik\\IdeaProjects\\java-io\\readme.txt");
        Path filePath1 = Path.of("C:\\Users\\kartik\\IdeaProjects\\java-io\\readme.txt");

        InputStream inputStream = new BufferedInputStream(new FileInputStream(filePath.toFile()));
        Long startLong = System.currentTimeMillis();
        byte[] bytes1 = inputStream.readAllBytes();
        System.out.println("len: " + bytes1.length);
        Long endLong = System.currentTimeMillis();
        System.out.println(endLong - startLong);


        InputStream stream = Files.newInputStream(filePath1);
        Long start = System.currentTimeMillis();
        byte[] bytes = stream.readAllBytes();
        System.out.println("len: " + bytes.length);
        Long end = System.currentTimeMillis();
        System.out.println(end - start);


//        ByteBuffer buffer=ByteBuffer.allocate(1024);
//        buffer.putInt(10);
//        buffer.flip();
//
//        FileChannel fileChannel=FileChannel.open(path, StandardOpenOption.CREATE);
//        fileChannel.write(buffer);


    }
}
