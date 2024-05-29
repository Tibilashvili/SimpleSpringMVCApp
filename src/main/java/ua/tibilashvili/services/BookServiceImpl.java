package ua.tibilashvili.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.tibilashvili.dao.BookDAO;
import ua.tibilashvili.exceptions.NotFoundException;
import ua.tibilashvili.models.Book;
import ua.tibilashvili.models.Person;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    private BookDAO bookDAO;

    @Autowired
    public BookServiceImpl(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @Override
    public List<Book> getAll() {
        return bookDAO.getAll();
    }

    @Override
    public Book getById(int id) {
        return bookDAO.getById(id).orElseThrow(() -> new NotFoundException("Book was not found"));
    }

    @Override
    public void save(Book book) {
        bookDAO.save(book);
    }

    @Override
    public void update(int id, Book updatedBook) {
        bookDAO.update(id, updatedBook);
    }

    @Override
    public void deleteById(int id) {
        bookDAO.deleteById(id);
    }

    @Override
    public Optional<Book> getByTitle(String title) {
        return bookDAO.getByTitle(title);
    }

    @Override
    public void release(int id) {
        bookDAO.release(id);
    }

    @Override
    public void assign(int id, Person selectedPerson) {
        bookDAO.assign(id, selectedPerson);
    }

    @Override
    public List<Book> getBooksByPersonId(int person_id) {
        return bookDAO.getBooksByPersonId(person_id);
    }
}
