/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book_db;

import java.util.*;

/**
 *
 * @author lclarke
 */

public class Books {
 public static ArrayList<String[]> books = new ArrayList();
    public int isbn;
    public String title;
    public String publisherName;
    public int totalCopiesOrdered;
    public int copiesInStock;
    public Date publicationDate;
    public String category;
    public double cost;
    
      public Books(){
      for( int i = 0; i < Book_db.tokens.size(); i++){
        String[] temp = new String[8];
        
        temp[0] = Book_db.tokens.get(i)[1];
        temp[1] = Book_db.tokens.get(i)[0];
        temp[2] = Book_db.tokens.get(i)[4];
        temp[3] = Book_db.tokens.get(i)[7];
        temp[4] = Book_db.tokens.get(i)[6];
        temp[5] = Book_db.tokens.get(i)[8];
        temp[6] = Book_db.tokens.get(i)[9];
        temp[7] = Book_db.tokens.get(i)[11];
        if(!isCopy(temp)){
            books.add(temp);
        }
      }
  }
      
      private boolean isCopy(String[] arr){
      for( int i = 0; i < books.size(); i++){
          if(Arrays.equals(arr, books.get(i))){
              return true;
          }
      }
      return false;
  }  
      
    public static String sqlInsertToString() {
        String output = new String();
        output = "INSERT INTO\n"
                + "books(isbn, title, publisherName, totalCopiesOrdered, copiesInStock, publicationDate, category, cost )\n"
                + "VALUES ";
        
        for (int i = 0; i < books.size(); i++) {
            String[] temp = books.get(i);
            output = output + "(" + temp[0] + ",'" + temp[1] + "','" + temp[2] + "','" 
                  + temp[3] + "','" + temp[4] + "','" + temp[5] + "','" + temp[6] + "'," + temp[7] +")";
            if (i == books.size() - 1) {
                output = output + ";";
            } else {
                output = output + ",\n";
            }
        }
        return output;
    }

}
