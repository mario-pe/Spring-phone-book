package dao;

import model.Person;
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

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    @Override
    public void addPerson(Person p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(p);
        logger.info("Person saved successfully, Person Details="+p);
    }

    @Override
    public void updatePerson(Person person) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(person);
        logger.info("Person updated successfully, Person Details="+person);
    }

    @Override
    public List<Person> listPerson() {
        Session session = this.sessionFactory.getCurrentSession();
        List personsList = session.createQuery("from Person").list();
        logger.info("PersonList loaded successfully");
        return personsList;
    }

    @Override
    public Person getPersonById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Person person =(Person) session.load(Person.class, new Integer(id));
        logger.info("Person delete successfully, Person Details="+ person);
        return person;
    }

    @Override
    public void removePerson(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Person person =(Person) session.load(Person.class, new Integer(id));
        if(person != null)
            session.delete(person);
            logger.info("Person deleted successfully, person details="+person);
    }
}
