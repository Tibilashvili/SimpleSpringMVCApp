package ua.tibilashvili.services;

import ua.tibilashvili.models.Person;

import java.util.List;
import java.util.Optional;

public interface PersonService {
    List<Person> getAll();

    Person getById(int id);

    Optional<Person> getByEmail(String email);

    void save(Person person);

    void update(int id, Person updatedPerson);

    void delete(int id);

    Optional<Person> getBookOwnerByBookId(int id);
}
