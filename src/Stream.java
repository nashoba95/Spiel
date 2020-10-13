

import java.io.*;

public class Stream {

    public static void main (String[] args){

        OutputStream os = null;
        String filename = "testFile.txt";
        String someText = "Hallo";
        byte[] textAsByte = someText.getBytes();
        byte[] readBuffer = new byte[100];

        try {

            os = new FileOutputStream(filename);
        } catch (FileNotFoundException ex) {
            System.err.println("couldn’t open file - fatal");
            System.exit(0); // brutal exception handling
        }


        try {
            os.write(textAsByte);
        } catch (IOException ex) {
            System.err.println("couldn’t write data (fatal)");
            System.exit(0);
        }

        InputStream is = null;
        try {
            //String filename;
            is = new FileInputStream(filename);
        } catch (FileNotFoundException ex) {
            System.err.println("couldn’t open file - fatal");
            System.exit(0);
        }


        try {
            is.read(readBuffer);
        } catch (IOException ex) {
            System.err.println("couldn’t read data (fatal)");
            System.exit(0);
        }

        String readString = new String(readBuffer);
        System.out.println("read something: " +  readString);

    }

}
