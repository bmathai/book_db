/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book_db;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JDialog;
import javax.swing.JFileChooser;

/**
 *
 * @author Sean
 */
public class Book_db {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException{
        String currentPath = "";
        final JFileChooser fc = new JFileChooser();
        if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                currentPath = fc.getSelectedFile().getAbsolutePath();
        }
        
        String fileName = currentPath;
        String line = null;
        
        Scanner infile = new Scanner(new File(fileName));
        
        while(infile.hasNextLine()) {
            line = infile.nextLine();
            //create array of individual entries without commas
            String [] tokens = line.split(",");
            for (String token : tokens) {
                //add tokens to proper file, tab delimited
            }
            System.out.println(line); //test to see if reading file correctly
        }
        
        
    }
}
    

