package ua.tibilashvili.services;

import ua.tibilashvili.models.Book;
import ua.tibilashvili.models.Person;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> getAll();

    Book getById(int id);

    void save(Book book);

    void update(int id, Book updatedBook);

    void deleteById(int id);

    Optional<Book> getByTitle(String title);

    void release(int id);

    void assign(int id, Person selectedPerson);

    List<Book> getBooksByPersonId(int person_id);
}
