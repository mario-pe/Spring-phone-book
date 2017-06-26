package dao;

import model.Phone;
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

//    private static final Logger logger = LoggerFactory.getLogger(PersonDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    @Override
    public void addPhone(Phone p) {

    }

    @Override
    public void updatePhone(Phone p) {

    }

    @Override
    public List<Phone> listPhone(Phone p) {
        return null;
    }

    @Override
    public Phone getPhoneById(int id) {
        return null;
    }

    @Override
    public void removePhone(int id) {

    }
}
