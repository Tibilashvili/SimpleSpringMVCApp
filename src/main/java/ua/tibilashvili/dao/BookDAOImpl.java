package ua.tibilashvili.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ua.tibilashvili.models.Book;
import ua.tibilashvili.models.Person;

import java.util.List;
import java.util.Optional;

@Repository
public class BookDAOImpl implements BookDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public BookDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Book> getAll() {
        return jdbcTemplate.query("SELECT * FROM Book", new BeanPropertyRowMapper<>(Book.class));
    }

    @Override
    public Optional<Book> getById(int id) {
        return jdbcTemplate.query("SELECT * FROM Book WHERE id=?", new Object[]{id},
                new BeanPropertyRowMapper<>(Book.class)).stream().findAny();
    }

    @Override
    public void save(Book book) {
        jdbcTemplate.update("INSERT INTO Book(title, author_first_name, author_last_name, year) VALUES(?, ?, ?, ?)", book.getTitle(),
                book.getAuthorFirstName(), book.getAuthorLastName(), book.getYear());
    }

    @Override
    public void update(int id, Book updatedBook) {
        jdbcTemplate.update("UPDATE Book SET title=?, author_first_name=?, author_last_name=?, year=? WHERE id=?", updatedBook.getTitle(),
                updatedBook.getAuthorFirstName(), updatedBook.getAuthorLastName(), updatedBook.getYear(), id);
    }

    @Override
    public void deleteById(int id) {
        jdbcTemplate.update("DELETE FROM Book WHERE id=?", id);
    }

    @Override
    public Optional<Book> getByTitle(String title) {
        return jdbcTemplate.query("SELECT * FROM Book WHERE title=?", new Object[]{title},
                new BeanPropertyRowMapper<>(Book.class)).stream().findAny();
    }

    @Override
    public void release(int id) {
        jdbcTemplate.update("UPDATE Book SET person_id=NULL WHERE id=?", id);
    }

    @Override
    public void assign(int id, Person selectedPerson) {
        jdbcTemplate.update("UPDATE Book SET person_id=? WHERE id=?", selectedPerson.getId(), id);
    }

    @Override
    public List<Book> getBooksByPersonId(int person_id) {
        return jdbcTemplate.query("SELECT * FROM Book WHERE person_id=?", new Object[]{person_id}, new BeanPropertyRowMapper<>(Book.class));
    }
}
