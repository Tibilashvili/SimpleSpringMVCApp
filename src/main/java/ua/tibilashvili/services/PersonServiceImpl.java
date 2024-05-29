package ua.tibilashvili.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.tibilashvili.dao.PersonDAO;
import ua.tibilashvili.exceptions.NotFoundException;
import ua.tibilashvili.models.Person;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {
    private PersonDAO personDAO;

    @Autowired
    public PersonServiceImpl(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @Override
    public List<Person> getAll() {
        return personDAO.getAll();
    }

    @Override
    public Person getById(int id) {
        return personDAO.getById(id).orElseThrow(() -> new NotFoundException("Person was not found"));
    }

    @Override
    public Optional<Person> getByEmail(String email) {
        return personDAO.getByEmail(email);
    }

    @Override
    public void save(Person person) {
        personDAO.save(person);
    }

    @Override
    public void update(int id, Person updatedPerson) {
        personDAO.update(id, updatedPerson);
    }

    @Override
    public void delete(int id) {
        personDAO.delete(id);
    }

    @Override
    public Optional<Person> getBookOwnerByBookId(int id) {
        return personDAO.getBookOwnerByBookId(id);
    }
}
