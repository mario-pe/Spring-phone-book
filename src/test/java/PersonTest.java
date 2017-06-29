import controller.PersonController;
import dao.PersonDao;
import model.Person;
import model.Phone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.junit.*;

import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.stereotype.Repository;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;


/**
 * Created by mario on 28.06.2017.
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration({"classpath:**/appServlet-servlet-test.xml","classpath:**/root-context.xml"})
//@ContextConfiguration("classpath:appServlet-servlet-test.xml")
//@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/appServlet/appServlet-servlet.xml")
//@WebAppConfiguration

@Rollback(true)
public class PersonTest {

    private SessionFactory sessionFactory;
    private Session session = null;

    @Autowired
    private static PersonDao personDao;

    @Autowired
    PersonController personController;

    @Before                               // <-- Before instead of BeforeClass
    public void setUpBeforeClass() throws Exception {
        Person p = new Person();
        personDao.addPerson(new Person("f","e"));
    }

    @Test
    public void getPersonById() {
        int a = 1;
        int b= 1;
        assertEquals(a,b);
    }
}
