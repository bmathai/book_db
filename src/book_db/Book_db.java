/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book_db;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
import javax.swing.JFileChooser;

/**
 * Lucas Clarke, Konstantin Kazantsev, Blaise Mathai, Sean Stamm, Andrew
 * Proctor, Amanda Lail
 *
 * @author Sean
 */
public class Book_db {

    /**
     * @param args the command line arguments
     */
    public static ArrayList<String[]> tokens = new ArrayList();

    public static void main(String[] args) throws FileNotFoundException {
        String currentPath = "";
        final JFileChooser fc = new JFileChooser();
        if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            currentPath = fc.getSelectedFile().getAbsolutePath();
        }

        String fileName = currentPath;
        String line = null;

        Scanner infile = new Scanner(new File(fileName));
        while (infile.hasNextLine()) {
            line = infile.nextLine();
            //System.out.println(line);
            //create array of individual entries without commas
            String tokensArr[];
            tokensArr = line.split(", ");
            //System.out.println(tokensArr[0]);
            tokens.add(tokensArr);
            //System.out.println(tokens.size()-1);
            //System.out.println(line); //test to see if reading file correctly
        }
        Author.importData();
        BookHasAuthor.importData();
        new Publisher();
        new Books();
        
        fc.setDialogType(javax.swing.JFileChooser.SAVE_DIALOG);
        
        currentPath= currentPath + ".insert.sql";
        if (fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            currentPath = fc.getSelectedFile().getAbsolutePath();
        }
        
        try (PrintWriter writer = new PrintWriter(currentPath)) {
            writer.print(sqlInsertToString());
        }
    
        
    }

    public static String sqlInsertToString() {
        return Author.sqlInsertToString() + "\n\n" + Publisher.sqlInsertToString() + "\n\n" + Books.sqlInsertToString() + "\n\n" + BookHasAuthor.sqlToString();
    }
}
