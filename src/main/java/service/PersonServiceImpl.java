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

    @Override
    @Transactional
    public List<Person> getPersonListBySurname(String surname) {
        return this.personDao.getPersonListBySurname(surname);
    }

    @Override
    @Transactional
    public List<Person> getPersonListByNumber(String number) {
        return this.personDao.getPersonListByNumber(number);
    }

    @Override
    @Transactional
    public List<Person> getPersonListByNumberSurname(String number, String surname) {
        return this.personDao.getPersonListByNumberSurname(number,surname);
    }

    @Override
    @Transactional
    public void deleteNumberFromPerson(int idPhone){
        this.personDao.deleteNumberFromPerson(idPhone);
    }
    @Override
    @Transactional
    public void addPhoneToPerson(int idPhone, int idPerson){
        this.personDao.addPhoneToPerson(idPhone, idPerson);
    }
}
