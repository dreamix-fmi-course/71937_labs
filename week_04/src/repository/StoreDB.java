package repository;

import model.Book;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;

public class StoreDB implements CRUD {
    // private Set<Book> db = new HashSet<>();
    private Map<String, Book> db = new ConcurrentHashMap<>();

    @Override
    public void add(Book book) {
        String ISBN = UUID.randomUUID().toString();
        book.setISBN(ISBN);
        db.put(ISBN, book);
    }

    @Override
    public Book update(Book book) {
        Book bookFromDB = getByKey(book.getISBN());
        if (!book.equals(bookFromDB)) {
            db.put(book.getISBN(), book);
        }

        return book;
    }

    @Override
    public void remove(String ISBN) {
        db.remove(ISBN);
    }

    @Override
    public Book getByKey(String ISBN) {
        return db.get(ISBN);
    }

    @Override
    public List<Book> getAll() {
        return new ArrayList<>(db.values());
    }

    @Override
    public void clear() {
        this.db.clear();
    }
}
