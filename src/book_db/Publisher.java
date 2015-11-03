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
public class Publisher {
    //blaise is doing this now
  public static ArrayList<String[]> publishers = new ArrayList();
  
  public Publisher(){
      for( int i = 0; i < Book_db.tokens.size(); i++){
        String[] temp = new String[2];
        
        temp[0] = Book_db.tokens.get(i)[4];
        temp[1] = Book_db.tokens.get(i)[5];
        if(!isCopy(temp)){
            publishers.add(i, temp);
        }
      }
  }
  
  private boolean isCopy(String[] arr){
      for( int i = 0; i < publishers.size(); i++){
          if(Arrays.equals(arr, publishers.get(i))){
              return true;
          }
      }
      return false;
  }
  
  public static String sqlInsertToString() {
        String output = new String();
        output = "INSERT INTO\n"
                + "publisher(publisherName, publisherAdd)\n"
                + "VALUES ";

        for (int i = 0; i < publishers.size(); i++) {
            String[] temp = publishers.get(i);
            output = output + "('" + temp[0] + "','" + temp[1] + "')";
            if (i == publishers.size() - 1) {
                output = output + ";";
            } else {
                output = output + ",\n";
            }
        }
        return output;
    }

}