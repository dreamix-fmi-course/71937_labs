package service;

import model.Book;
import repository.CRUD;
import repository.StoreDB;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class BookStore implements Store {
    private CRUD dbCrud = new StoreDB();

    @Override
    public boolean add(Book book) {
        Book byKey = dbCrud.getByKey(book.getISBN());
        if (byKey.equals(book)) {
            return false;
        }

        dbCrud.add(book);
        return true;
    }

    @Override
    public void remove(Book book) {
        dbCrud.remove(book.getISBN());
    }

    @Override
    public List<Book> getAllBooksByAuthor(String author) {
        return dbCrud.getAll().stream().filter(b -> b.getAuthor().equals(author)).collect(Collectors.toList());
    }

    @Override
    public List<Book> getAllBooksPublishedAfter(LocalDate from) {
        return dbCrud.getAll().stream()
                .filter(b -> b.getPublishedYear().isAfter(from))
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> getAllBooksBetween(LocalDate from, LocalDate to) {
        return dbCrud.getAll().stream()
                .filter(b -> b.getPublishedYear().isAfter(from))
                .filter(b -> b.getPublishedYear().isBefore(to))
                .collect(Collectors.toList());
    }

    @Override
    public void clear() {
        dbCrud.clear();
        // dbCrud.getAll().forEach(b -> dbCrud.remove(b.getISBN()));
    }

    @Override
    public Map<String, List<Book>> getAllBooksGroupByAuthor() {
        return dbCrud.getAll().stream().collect(Collectors.groupingBy(Book::getAuthor));
    }

    @Override
    public Map<String, List<Book>> getAllBooksGroupByPublisher() {
        return dbCrud.getAll().stream().collect(Collectors.groupingBy(Book::getPublisher));
    }

    @Override
    public List<Book> getAllBooksFilterBy(Predicate<Book> bookPredicate) {
        return dbCrud.getAll().stream().filter(bookPredicate).collect(Collectors.toList());
    }
}
