package service;

import dao.PersonDao;
import model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by mario on 26.06.2017.
 */
@Service
public class PersonServiceImpl implements PersonService {


    private PersonDao personDao;
    public void setPersonDao(PersonDao personDAO) {
        this.personDao = personDAO;
    }

    @Override
    public void addPerson(Person p) {

    }

    @Override
    public void updatePerson(Person p) {

    }

    @Override
    public List<Person> listPersons(Person p) {
        return null;
    }

    @Override
    public Person getPersonById(int id) {
        return null;
    }

    @Override
    public void removePerson(int id) {

    }
}
