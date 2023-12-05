package LR4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class task2 {
    public static void main(String[] args) throws IOException {
        File file = new File("D:/ITIP_LABS/LABS/src/lab4/first.txt");
        File filenew = new File("D:/ITIP_LABS/LABS/src/lab4/second.txt");
        try{
            filenew.createNewFile();
            Scanner scan = new Scanner(file);
            FileWriter writer = new FileWriter("D:/ITIP_LABS/LABS/src/lab4/second.txt");
            while (scan.hasNextLine()){
                String line = scan.nextLine();
                writer.write(line);
                writer.write("\n");
                System.out.println(line);
            }
            scan.close();
            writer.close();
        } catch (FileNotFoundException e){
            System.out.println("File Not Founded");
        } catch (java.lang.IllegalStateException e){
            System.out.println("Reading error");
        } catch (IOException e){
            System.out.println("Write error");
        }
    }
}