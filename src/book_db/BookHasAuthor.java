/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book_db;

import java.util.*;

/**
 *
 * @author alprocto
 */
public class BookHasAuthor {
    public static ArrayList<BookHasAuthor> bookHasAuthors = new ArrayList();
    public int isbn;
    public int authorId;
    
    
    public BookHasAuthor(int isbn, int authorId){
        boolean check = false;
        for(int i = 0; i < bookHasAuthors.size(); i++){
            BookHasAuthor temp = bookHasAuthors.get(i);
            if(temp.isbn == isbn && temp.authorId == authorId){
                check = true;
            }
        }
        if(check == false){
            this.isbn = isbn;
            this.authorId = authorId;
            bookHasAuthors.add(this);
        }
        
    }
    
    
    public static void importData(){
        for(int x = 0; x < Book_db.tokens.size(); x++){
            String[] temp = Book_db.tokens.get(x);
            new BookHasAuthor(Integer.parseInt(temp[1]), Author.getId(temp[2], temp[3]));
            
        }
    }
    
    
    public static String sqlInsertToString(){
        //INSERT INTO BookHasAuthor (isbn, authorId) VALUES (temp[1], temp[2]);
        String output = new String();
        output = "INSERT INTO\n"
                + "bookhasauthor(isbn, authorId)\n"
                + "VALUES ";

        for (int i = 0; i < bookHasAuthors.size(); i++) {
            BookHasAuthor temp = bookHasAuthors.get(i);
            output = output + "(" + temp.isbn + ",'" + temp.authorId + "')";
            if (i == bookHasAuthors.size() - 1) {
                output = output + ";";
            } else {
                output = output + ",\n";
            }
        }
        return output;
    }
    
}
