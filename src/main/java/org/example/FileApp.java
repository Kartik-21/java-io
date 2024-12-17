package org.example;

import org.apache.commons.codec.EncoderException;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/*
 * file is used for create update delete operations
 *
 * */
public class FileApp {

    public static void main(String[] args) throws IOException, EncoderException {

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

        System.out.println("--");
        Base64.Encoder encoder = Base64.getEncoder();
        byte[] encoded = encoder.encode("Kartik".getBytes(StandardCharsets.UTF_8));
        Base64.Decoder decoder = Base64.getDecoder();
        System.out.println(new String(decoder.decode(encoded)));

        String originalInput = "test input";
        org.apache.commons.codec.binary.Base64 base64 = new org.apache.commons.codec.binary.Base64();
        String encodedString = new String(base64.encode(originalInput.getBytes()));
        String decodedString = new String(base64.decode(encodedString.getBytes()));


    }

}
