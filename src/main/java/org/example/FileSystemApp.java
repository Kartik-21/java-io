package org.example;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.*;
import java.nio.file.spi.FileSystemProvider;
import java.util.List;

public class FileSystemApp {
    public static void main(String[] args) throws IOException {

        List<FileSystemProvider> fileSystemProviders = FileSystemProvider.installedProviders();
        fileSystemProviders.forEach(e -> System.out.println(e));


        FileSystem aDefault = FileSystems.getDefault();
        System.out.println(aDefault);

        Path path = Path.of("C:\\Users\\kartik\\IdeaProjects\\java-io\\src");
//        FileSystem fileSystem = FileSystems.newFileSystem(path);
//        fileSystem.getFileStores().forEach(fileStore -> System.out.println(fileStore));

        aDefault.getRootDirectories().forEach(pa -> System.out.println(pa));
        aDefault.getFileStores().forEach(fileStore -> System.out.println(fileStore.name() + "--" + fileStore.type()));

        for (File file : File.listRoots()) {
            System.out.println(file);
        }


        Path pdfPath = Path.of("C:\\Users\\kartik\\IdeaProjects\\java-io\\text1.pdf");
        Path pdfPath1 = Path.of("C:\\Users\\kartik\\IdeaProjects\\java-io\\text1.pdf");


        InputStream stream = Files.newInputStream(pdfPath);
        Long start = System.currentTimeMillis();
        byte[] bytes = stream.readAllBytes();
        System.out.println("len: " + bytes.length);
        Long end = System.currentTimeMillis();
        System.out.println(end - start);


        FileSystemProvider provider = aDefault.provider();
        InputStream stream1 = provider.newInputStream(pdfPath1);
        Long start1 = System.currentTimeMillis();
        byte[] bytes1 = stream1.readAllBytes();
        System.out.println("len: " + bytes1.length);
        Long end1 = System.currentTimeMillis();
        System.out.println(end1 - start1);


//        BasicFileAttributes basicFileAttributes = provider.readAttributes(pdfPath1, BasicFileAttributes.class);
//        System.out.println(basicFileAttributes.size());
//
//        PosixFileAttributes posixFileAttributes = provider.readAttributes(pdfPath1, PosixFileAttributes.class);
//        System.out.println(posixFileAttributes.group());

        provider.newDirectoryStream(path, entry -> {
            System.out.println(entry);
            return true;
        }).forEach(path1 -> System.out.println(path1));

        FileStore fileStore = provider.getFileStore(path);
        System.out.println(fileStore.name());

//        Files.walkFileTree(path,)
//        Files.walk()
//        Files.find()

        Files.createDirectories(path);
        provider.createDirectory(path);
    }
}
