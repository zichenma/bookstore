package controllers;
import models.Book;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.*;
import javax.inject.Inject;
import java.util.List;
import views.html.books.*;
import views.html.error.*;
import views.html.error._404;


public class BooksController extends Controller {

    @Inject
    FormFactory formFactory;

    // for all books
    public Result index () {
        // Set<Book> books = Book.allBooks();
        List<Book> books = Book.find.all();

        return ok(index.render(books));
    }

    // to create book

    public Result create() {
        Form<Book> bookForm = formFactory.form(Book.class);
        return ok(create.render(bookForm));
    }

    // to save book

    public Result save() {
        Form<Book> bookForm = formFactory.form(Book.class).bindFromRequest();
        if(bookForm.hasErrors()) {
            flash("danger", "Please Correct the Form Below");
            return badRequest(create.render(bookForm));
        }
        Book book = bookForm.get();
        book.save();
        flash("success", "Book Save Successfully");
        //Book.add(book);
        return redirect(routes.BooksController.index());

    }

    public Result edit (int id) {
        Book book = Book.find.byId(id);

        if (book == null) {
            return notFound(_404.render());
        }


        /*create a form and fill data from Book class*/
        Form<Book> bookForm = formFactory.form(Book.class).fill(book);

        /*pass form to view*/
        return ok(edit.render(bookForm));
    }

    public Result update () {
        Form<Book> bookForm = formFactory.form(Book.class).bindFromRequest();

        if (bookForm.hasErrors()) {
            flash("danger" , "Please Correct the Form Below");
            return badRequest(edit.render(bookForm));
        }

        Book book = bookForm.get();
        Book oldBook = Book.find.byId(book.id);
        if (oldBook == null) {
            return notFound("Book not Found");
        }
        oldBook.title = book.title;
        oldBook.author = book.author;
        oldBook.price = book.price;
        oldBook.update();
        flash("success", "Book Updated Successfully");

        return redirect(routes.BooksController.index());
    }

    public Result destroy (Integer id) {

        Book book = Book.find.byId(id);
        if (book == null) {
            // flash("danger", "Book Not Found");
            return notFound("Book Not Found");
        }

        book.delete();

        //flash("Success", "Book Deleted Successfully");

        return redirect(routes.BooksController.index());
    }

    // for book details

    public Result show (Integer id) {
        Book book = Book.find.byId(id);
        if (book == null) {
            return notFound(_404.render());
        }
        return ok(show.render(book));
    }


}
