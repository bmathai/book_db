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

    public static int getId(String lastName, String firstName) {
        for (int i = 0; i < authors.size(); i++) {
            Author temp = authors.get(i);
            if (temp.authorLname.equals(lastName) && temp.authorFname.equals(firstName)) {
                return temp.authorId;
            }
        }
        return -1;
    }

    public static int createAuthor(String lastName, String firstName, boolean allowDuplicateAuthor) {
        Author newAuthor = new Author();
        if (allowDuplicateAuthor) {
            newAuthor.authorLname = lastName;
            newAuthor.authorFname = firstName;
            newAuthor.authorId = authors.size();
            authors.add(newAuthor);
            return newAuthor.authorId;
        } else {
            boolean check = false;
            for (int i = 0; i < authors.size(); i++) {
                Author temp = authors.get(i);
                if (temp.authorLname.equals(lastName) && temp.authorFname.equals(firstName)) {
                    check = true;
                }
            }
            if (!check) {
                newAuthor.authorLname = lastName;
                newAuthor.authorFname = firstName;
                newAuthor.authorId = authors.size();
                authors.add(newAuthor);
                return newAuthor.authorId;
            }
        }
        return -1;
    }

    public static void importData() {
        for (int i = 0; i < Book_db.tokens.size(); i++) {
            String[] temp = Book_db.tokens.get(i);
            createAuthor(temp[2], temp[3], false);

        }
    }

}
