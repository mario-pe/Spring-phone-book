package service;

import dao.PersonDao;
import model.Person;
import model.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by mario on 26.06.2017.
 */
@Service
public class PersonServiceImpl implements PersonService {


    private PersonDao personDao;
    public void setPersonDao(PersonDao personDao) {
        this.personDao = personDao;
    }

    @Override
    @Transactional
    public void addPerson(Person person) {
        this.personDao.addPerson(person);
    }

    @Override
    @Transactional
    public void updatePerson(Person person) {
        this.personDao.updatePerson(person);
    }

    @Override
    @Transactional
    public List<Person> listPersons() {
        return this.personDao.listPerson();
    }

    @Override
    @Transactional
    public Person getPersonById(int id) {
        return this.personDao.getPersonById(id);
    }

    @Override
    @Transactional
    public void removePerson(int id) {
        this.personDao.removePerson(id);
    }

    @Override
    @Transactional
    public List<Phone> getPhoneListById(int id) {
        return this.personDao.getPhoneListById(id);
    }
}
