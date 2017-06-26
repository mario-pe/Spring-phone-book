package service;

import model.Person;

import java.util.List;

/**
 * Created by mario on 26.06.2017.
 */
public interface PersonService {
    public void addPerson(Person p);
    public void updatePerson(Person p);
    public List<Person> listPersons(Person p);
    public Person getPersonById(int id);
    public void removePerson(int id);

}
