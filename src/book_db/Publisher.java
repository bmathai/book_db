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
        publishers.add(i, temp);
      }
  }
  
  private boolean isCopy(String[] arr){
      for( int i = 0; i < publishers.size(); i++){
          if(arr == publishers.get(i)){
              return true;
          }
      }
      return false;
  }

}

