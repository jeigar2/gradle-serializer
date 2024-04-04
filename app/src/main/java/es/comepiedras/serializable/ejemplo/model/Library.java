package es.comepiedras.serializable.ejemplo.model;

import java.util.HashMap;

/**
 *
 */
public class Library {
    private HashMap<Integer, Book> books = new HashMap<>();

    public void addBook(Book book) {
        books.put(book.getId(), book);
    }

    public void lendBook(User user, int bookId){
        Book book = books.get(bookId);
        if (book != null && book.isAvailable()){
            book.setAvailable(false);
            System.out.println("The book " + book.getTitle() + " is lend now to " + user.getName());
        } else {
            System.out.println("The book " + book.getTitle() + " is not available");
        }
    }

    @Override
    public String toString() {
        return "Library{" +
                "books=" + books +
                '}';
    }
}
