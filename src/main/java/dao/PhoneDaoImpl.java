package dao;

import model.Person;
import model.Phone;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;


/**DAO class for Phone with all methods necessary to operate with DB
 * use sessionFacktory hibernate 3
 * Created by mario on 25.06.2017.
 */
@Repository
public class PhoneDaoImpl implements PhoneDao {

    private static final Logger logger = LoggerFactory.getLogger(PersonDaoImpl.class);
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    /**
     * Add new Phone to DB
     * @param phone
     */
    @Override
    public void addPhone(Phone phone) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(phone);
        logger.info("Phone saved successfully");
    }

    /**
     * update information about phone in DB
     * @param phone
     */
    @Override
    public void updatePhone(Phone phone) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(phone);
        logger.info("Phone updated successfully, Phone Details=" + phone);
    }

    /**
     * return list of all phone in DB
     * @return list of all phone in DB
     */
    @Override
    public List<Phone> listPhone() {
        Session session = this.sessionFactory.getCurrentSession();
        List phoneList = session.createQuery("from Phone").list();
        logger.info("PhoneList loaded successfully");
        return phoneList;
    }

    /**
     * return phone with given ID
     * @param id
     * @return phone with given ID
     */
    @Override
    public Phone getPhoneById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Phone phone = (Phone) session.load(Phone.class, new Integer(id));
        logger.info("Phone delete successfully, Phone Details=" + phone);
        return phone;
    }

    /**
     * remove phone from DB
     * @param id
     */
    @Override
    public void removePhone(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Phone phone =(Phone) session.load(Phone.class, new Integer(id));
        if(phone != null)
            session.delete(phone);
        logger.info("Phone deleted successfully, Phone details=" + phone);
    }

    /**
     * return Phone object by given number
     * @param numberP
     * @return Phone object by given number
     */
    @Override
    public Phone getPhoneByNumber(String numberP) {
        Session session = this.sessionFactory.getCurrentSession();
        Phone phone =(Phone)  session.createQuery("Select new model.Phone(p.id,p.number,p.extensionNumber,p.diallingCode) from Phone as p where number = :numberP").setParameter("numberP",numberP).uniqueResult();
        logger.info("Phone delete successfully, Phone Details=" + phone);
        return phone;
    }

}
