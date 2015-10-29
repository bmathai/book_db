/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book_db;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JFileChooser;

/**
 *
 * @author Sean
 */
public class Book_db {

    /**
     * @param args the command line arguments
     */
    
    public static String[][] tokens = new String[100][20];
    
    public static void main(String[] args) throws FileNotFoundException{
        String currentPath = "";
        final JFileChooser fc = new JFileChooser();
        if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                currentPath = fc.getSelectedFile().getAbsolutePath();
        }
        
        String fileName = currentPath;
        String line = null;
        
        Scanner infile = new Scanner(new File(fileName));
        String tokensArr[] = new String[100];
        int count = 0;
        while(infile.hasNextLine()) {
            line = infile.nextLine();
            System.out.println(line);
            //create array of individual entries without commas
            tokensArr = line.split(",");
            System.out.println(tokensArr[0]);
            tokens[count] = tokensArr;
            count++;
            System.out.println(count);
            //System.out.println(line); //test to see if reading file correctly
        }
        
        //blaise's work for publishers table
        System.out.println(tokens[0][0]);
        System.out.println(tokens[0][1]);
        System.out.println(tokens[0][2]);
        System.out.println(tokens[0][3]);
        System.out.println(tokens[2][0]);
        System.out.println(tokens[1][1]);
        
        
        
        
    }
}
    

