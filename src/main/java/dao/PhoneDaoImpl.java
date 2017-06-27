package dao;

import model.Person;
import model.Phone;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


/**
 * Created by mario on 25.06.2017.
 */
public class PhoneDaoImpl implements PhoneDao {

    private static final Logger logger = LoggerFactory.getLogger(PersonDaoImpl.class);
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    @Override
    public void addPhone(Phone phone) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(phone);
        logger.info("Phone saved successfully");
    }

    @Override
    public void updatePhone(Phone phone) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(phone);
        logger.info("Phone updated successfully, Phone Details=" + phone);
    }

    @Override
    public List<Phone> listPhone() {
        Session session = this.sessionFactory.getCurrentSession();
        List phoneList = session.createQuery("from Phone").list();
        logger.info("PhoneList loaded successfully");
        return phoneList;


    }

    @Override
    public Phone getPhoneById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Phone phone = (Phone) session.load(Phone.class, new Integer(id));
        logger.info("Phone delete successfully, Phone Details=" + phone);
        return phone;
    }

    @Override
    public void removePhone(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Phone phone =(Phone) session.load(Phone.class, new Integer(id));
        if(phone != null)
            session.delete(phone);
        logger.info("Phone deleted successfully, Phone details=" + phone);
    }
}
