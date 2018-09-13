package modul2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class no1 {

    private static void copy(File source, File dest)
            throws IOException {
        InputStream input = null;
        OutputStream output = null;
        try {
            input = new FileInputStream(source);
            output = new FileOutputStream(dest);
            byte[] buf = new byte[1024];
            int bytesRead;
            while ((bytesRead = input.read(buf)) > 0) {
                output.write(buf, 0, bytesRead);
            }
        } finally {
            input.close();
            output.close();
        }
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        String destination = "e:/writedocument.txt";
        OutputStream output = new FileOutputStream(destination);
        System.out.println("Opened "+destination+" for writing.");
        
        String data = "Try to write data using output stream";
        for (int i = 0; i <data.length(); i++){
            output.write((byte) data.charAt(i));
        }
        output.close();
        System.out.println("output stream closed");
        
        File source = new File (destination);
        File dest = new File("e:\\destfile1.txt");

        // copy file using FileStreams
        long start = System.nanoTime();
        long end;
        copy(source, dest);
        System.out.println("Time taken by FileStreams Copy = "
                + (System.nanoTime() - start));

    }
}
