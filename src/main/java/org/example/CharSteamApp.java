package org.example;

import java.io.*;

// it is used for char read/write
public class CharSteamApp {
    public static void main(String[] args) throws IOException {


        Reader reader=new FileReader("");
        Writer writer=new FileWriter("");

        /*
        * it support mark and reset support /// filereader doesn't support
        * in memory operation
        * */
        Reader reader1=new CharArrayReader(new char[10]);
        Writer writer1=new CharArrayWriter();

        Reader reader2=new StringReader("");
        Writer writer2=new StringWriter();

        /*
        * it is used mostly used for reading from disk
        * it is faster because of buffer
        * */
        Reader reader3=new BufferedReader(reader);
        Writer writer3=new BufferedWriter(writer);



    }
}
