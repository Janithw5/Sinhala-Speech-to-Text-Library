/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SSTT_Interfaces;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author TOSHIBA
 */
public class WriteToFile {
    public static void main(String[] args) {
        try {
//            PrintWriter pw=new PrintWriter("C:/SSTT/myTextFile.txt");
//            pw.println("THis is text");
//            pw.close();
            
            File f=new File("C:/SSTT/myTextFile.txt");
            FileWriter fw=new FileWriter(f);
            BufferedWriter bw=new BufferedWriter(fw);
            bw.write("This is from buffered writer");
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
