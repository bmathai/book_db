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
public class Author {
  public static ArrayList<Author> authors = new ArrayList();
  public int authorId;
  public String authorLname;
  public String authorFname;
    
  
  public static int getId(String lastName, String firstName){
      for(int i = 0; i<authors.size(); i++){
          Author temp = authors.get(i);
          if(temp.authorLname.equals(lastName) && temp.authorFname.equals(firstName)){
              return temp.authorId;
          }
      }
      return -1;
  }
}
