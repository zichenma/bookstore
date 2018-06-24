package models;

import java.util.HashSet;
import java.util.Set;
// check documentation if errors happen
//import com.avaje.ebean.Model; this doesn't work for V2.6
import io.ebean.Finder;
import io.ebean.Model;
import play.data.validation.Constraints;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Book extends Model {


    @Id // this means using Id as primary key
    @Constraints.Required
    public int id;
    @Constraints.MaxLength(255)
    @Constraints.MinLength(5)
    public String title;
    @Constraints.Required
    @Constraints.Min(5)
    @Constraints.Max(100)
    public int price;
    @Constraints.Required
    public String author;

    public static Finder<Integer, Book> find = new Finder<>(Book.class);



    // domy data:

    // default constructor
    /*public Book () {

    }


    public Book (int id, String title, int price, String author) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.author = author;
    }


    private static Set<Book> books;

    static {
        books = new HashSet<>();
        books.add(new Book(1, "C++", 20, "ABC"));
        books.add(new Book(2, "Java", 30, "XYZ"));
    }

    public static Set<Book> allBooks () {
        return books;
    }

    public static Book findById (int id) {
        for (Book book : books) {
            if (id == book.id) {
                return book;
            }
        }

        return null;
    }

    public static void add (Book book) {
        books.add(book);
    }

    public static boolean remove (Book book) {
        return books.remove(book);
    }*/
}
