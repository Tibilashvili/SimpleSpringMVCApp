package ua.tibilashvili.dao;

import ua.tibilashvili.models.Person;

import java.util.List;
import java.util.Optional;

public interface PersonDAO {
    List<Person> getAll();

    Optional<Person> getById(int id);

    Optional<Person> getByEmail(String email);

    void save(Person person);

    void update(int id, Person updatedPerson);

    void delete(int id);

    Optional<Person> getBookOwnerByBookId(int id);
}
