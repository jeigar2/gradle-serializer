package es.comepiedras.serializable.ejemplo.model;

public class Member extends User {

    public Member(String name) {
        super(name);
    }

    @Override
    public void requestBook(Library library, int bookId) {
        library.lendBook(this, bookId);
    }

    @Override
    public String toString() {
        return "Member{name=" + super.getName() + "}";
    }
}
