package es.comepiedras.serializable.ejemplo;

import es.comepiedras.serializable.ejemplo.model.Book;
import es.comepiedras.serializable.ejemplo.model.Librarian;
import es.comepiedras.serializable.ejemplo.model.Library;
import es.comepiedras.serializable.ejemplo.model.Member;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class App {
    public static void main(String[] args) {
        Book book1 = new Book("Sherlock Holmes");
        Book book2 = new Book("Jesús ocupate tú");
        Book book3 = new Book("Por qué fracasan los paises");

        Librarian librarian = new Librarian("Bibliotecario");
        Member member = new Member("Jesús");
        Library library = new Library();
        librarian.addBook(library, book1);
        librarian.addBook(library, book2);
        librarian.addBook(library, book3);

        member.requestBook(library, book1.getId());
        member.requestBook(library, book2.getId());
        member.requestBook(library, book2.getId());

        System.out.println(librarian);
        System.out.println(member);
        System.out.println(library);

        try (FileOutputStream fos = new FileOutputStream("/home/igg/file-serializado.txt")){
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(book3);
            oos.flush();
            oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
