
import dao.PersonDao;
import dao.PhoneDao;
import model.Person;
import model.Phone;


import org.junit.*;

import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;


/**
 * Created by mario on 28.06.2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/appServlet/appServlet-servlet.xml")
@WebAppConfiguration
@Transactional
@Rollback(true)
public class PersonTest {
    //   private Person person;
    @Autowired
    private PersonDao personDao;

    @Autowired
    private PhoneDao phoneDao;


    @Test
    public void person_surname_should_be_equal_to_person_added_to_DB() {
        Person person = new Person();
        person.setSurname("kowalski");
        person.setName("Jan");
        personDao.addPerson(person);

        List<Person> persons = personDao.getPersonListBySurname("kowalski");
        Assert.assertEquals(person.getName(), persons.get(0).getName());
    }

    @Test
    public void person_list_in_DB_should_be_larger_after_add_person(){
        Person person = new Person();
        List<Person> listPerson = personDao.listPerson();
        personDao.addPerson(person);
        List<Person> newListPerson = personDao.listPerson();
        Assert.assertNotEquals(listPerson.size(),newListPerson.size());
    }
    @Test
    public void person_name_should_be_different_after_update(){
        Person person = new Person("testN","testS");
        personDao.addPerson(person);
        person.setName("name");
        person.setSurname("surname");
        personDao.updatePerson(person);
        assertNotEquals(person.getName(),"testN");
    }


    @Test
    public void return_list_person_who_have_phone_with_number(){
        Person person = new Person("testName", "testSurname1");
        Phone phone1 = new Phone("1234539", "123435", "123453");
        personDao.addPerson(person);
        phoneDao.addPhone(phone1);
        int idPhone1 = phone1.getId();
        int idPerson = person.getId();
        personDao.addPhoneToPerson(idPhone1,idPerson);
        List<Person> phoneList = personDao.getPersonListByNumber("1234539");
        Assert.assertEquals(1,phoneList.size());
    }


}
