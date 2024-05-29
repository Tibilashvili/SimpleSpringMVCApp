package ua.tibilashvili.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ua.tibilashvili.models.Person;

import java.util.List;
import java.util.Optional;

@Repository
public class PersonDAOImpl implements PersonDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Person> getAll() {
        return jdbcTemplate.query("SELECT * FROM Person", new BeanPropertyRowMapper<>(Person.class));
    }

    @Override
    public Optional<Person> getById(int id) {
        return jdbcTemplate.query("SELECT * FROM Person WHERE id =?", new Object[]{id},
                new BeanPropertyRowMapper<>(Person.class)).stream().findAny();
    }

    @Override
    public Optional<Person> getByEmail(String email) {
        return jdbcTemplate.query("SELECT * FROM Person WHERE email=?", new Object[]{email},
                new BeanPropertyRowMapper<>(Person.class)).stream().findAny();
    }

    @Override
    public void save(Person person) {
        jdbcTemplate.update("INSERT INTO Person(first_name, last_name, year_of_birth, email) VALUES(?, ?, ?, ?)", person.getFirstName(), person.getLastName(),
                person.getYearOfBirth(), person.getEmail());
    }

    @Override
    public void update(int id, Person updatedPerson) {
        jdbcTemplate.update("UPDATE Person SET first_name=?, last_name=?, year_of_birth=? WHERE id=?",
                updatedPerson.getFirstName(), updatedPerson.getLastName(), updatedPerson.getYearOfBirth(), id);
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM Person WHERE id=?", id);
    }

    @Override
    public Optional<Person> getBookOwnerByBookId(int id) {
        return jdbcTemplate.query("SELECT Person.* FROM Book JOIN Person ON Book.person_id = Person.id WHERE Book.id=?", new Object[]{id},
                new BeanPropertyRowMapper<>(Person.class)).stream().findAny();
    }
}
