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
public class Books {
    public static ArrayList<Books> books = new ArrayList();
    public int isbn;
    public String title;
    public int authorId;
    public String publisherName;
    public int totalCopiesOrdered;
    public int copiesInStock;
    public Date publicationDate;
    public String category;
    public double sellingPrice;
    public double cost;
    
}
