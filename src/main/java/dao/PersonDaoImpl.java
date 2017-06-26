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
    public void updatePerson(Person p) {

    }

    @Override
    public List<Person> listPerson(Person p) {
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
