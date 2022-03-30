package repository;

import model.Book;

import java.util.List;
import java.util.UUID;

public interface CRUD {
    void add(Book book);
    Book update(Book book);
    void remove(String ISBN);
    Book getByKey(String ISBN);
    List<Book> getAll();
    void clear();
}
