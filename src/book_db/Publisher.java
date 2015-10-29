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
  public String publisherName;
  public String publisherAdd;
  
  public void addToPublisher(){
      //Book_db.tokens; 4 and 5
      
      for(int i = 0; i < Book_db.tokens.size(); i++){
          publisherName = Book_db.tokens.get(i)[4];
          publisherAdd = Book_db.tokens.get(i)[5];
         // publishers.set(i, );
      }
  }
    
}
