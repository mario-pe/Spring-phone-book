package dao;

import model.Person;
import model.Phone;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by mario on 25.06.2017.
 */
@Repository
public class PersonDaoImpl implements PersonDao {

    private static final Logger logger = LoggerFactory.getLogger(PersonDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    @Override
    public void addPerson(Person p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(p);
        logger.info("Person saved successfully, Person Details=" + p);
    }

    @Override
    public void updatePerson(Person person) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(person);
        logger.info("Person updated successfully, Person Details=" + person);
    }

    @Override
    public List<Person> listPerson() {
        Session session = this.sessionFactory.getCurrentSession();
        List personList = session.createQuery("from Person").list();
        logger.info("PersonList loaded successfully");
        return personList;
    }

    @Override
    public Person getPersonById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Person person = (Person) session.load(Person.class, new Integer(id));
        logger.info("Person delete successfully, Person Details=" + person);
        return person;
    }

    @Override
    public void removePerson(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Person person = (Person) session.load(Person.class, new Integer(id));
        if (person != null)
            session.delete(person);
        logger.info("Person deleted successfully, person details=" + person);
    }

    @Override
    public List<Phone> getPhoneListById(int id) {

        Session session = this.sessionFactory.openSession();
        List phoneList = session.createQuery("from Phone where person_id = :id").setParameter("id", id).list();
        return phoneList;
    }

    @Override
    public List<Person> getPersonListBySurname(String surname) {
        Session session = this.sessionFactory.getCurrentSession();
        List personList = session.createQuery("FROM  Person where  surname = :surname").setParameter("surname",surname).list();
        return personList;
    }

    @Override
    public List<Person> getPersonListByNumber(String number) {
        Session session = this.sessionFactory.getCurrentSession();
        List<Person> personList = session.createQuery("SELECT new model.Person(pe.id, pe.name, pe.surname) FROM Phone as ph, Person as pe where  ph.person = pe.id and ph.number = :number").setParameter("number",number).list();
        return personList;
    }

    @Override
    public List<Person> getPersonListByNumberSurname(String number, String surname) {
        Session session = this.sessionFactory.getCurrentSession();
        List<Person> personList =session.createQuery("SELECT new model.Person(pe.id, pe.name, pe.surname)" +
                                                       " FROM Phone as ph, Person as pe" +
                                                        " where  ph.person = pe.id and ph.number = :number and pe.surname = :surname").
                                                        setParameter("number",number).setParameter("surname",surname).list();
        return personList;
    }

    @Override
    public void deleteNumberFromPerson(int idPhone) {
        Session session = this.sessionFactory.getCurrentSession();
        session.createQuery("update Phone set person_id = null where id = :idPhone").setParameter("idPhone",idPhone).executeUpdate();    }

    @Override
    public void addPhoneToPerson(int idPhone, int idPerson) {
        Session session = this.sessionFactory.getCurrentSession();
        session.createQuery("update Phone set person_id = :idPerson where id = :idPhone").setParameter("idPerson",idPerson).setParameter("idPhone",idPhone).executeUpdate();
    }
}
