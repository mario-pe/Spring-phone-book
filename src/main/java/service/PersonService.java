package service;

import model.Person;
import model.Phone;

import java.util.List;

/**
 * An interface for PersonService
 * Created by mario on 26.06.2017.
 */
public interface PersonService {
    public void addPerson(Person p);
    public void updatePerson(Person p);
    public List<Person> listPersons();
    public Person getPersonById(int id);
    public void removePerson(int id);
    public List<Phone> getPhoneListById(int id);
    public List<Person> getPersonListBySurname(String surname);
    public List<Person> getPersonListByNumber(String number);
    public List<Person> getPersonListByNumberSurname(String number, String surname);
    public void deleteNumberFromPerson(int idPhone);
    public void addPhoneToPerson(int idPhone, int idPerson);

}
