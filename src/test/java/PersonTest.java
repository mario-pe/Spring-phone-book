import dao.PersonDao;
import model.Person;
import org.junit.*;

import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by mario on 28.06.2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration({"classpath:**/appServlet-servlet-test.xml","classpath:**/root-context.xml"})
//@ContextConfiguration("classpath:appServlet-servlet-test.xml")
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/appServlet/appServlet-servlet.xml")
@WebAppConfiguration
@Rollback(true)
public class PersonTest {

        @Autowired
    private PersonDao personDao;

    @Test
    @Transactional
    public void testFindById() {

        Person person = new Person("testN", "testS");
        personDao.addPerson(person);

        List<Person> persons = personDao.listPerson();
        Assert.assertEquals(person.getName(), persons.get(0).getName());
    }
}
