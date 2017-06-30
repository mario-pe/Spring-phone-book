import dao.PhoneDao;
import model.Phone;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by mario on 29.06.2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/appServlet/appServlet-servlet.xml")
@WebAppConfiguration
@Transactional
@Rollback(true)
public class PhoneTest {
    @Autowired
    private PhoneDao phoneDao;

    @Test
    public void phone_number_should_be_equal_to_phone_number_added_to_DB() {
        Phone phone = new Phone();
        phone.setNumber("123-111-111");
        phone.setDiallingCode("666666");
        phone.setExtensionNumber("789789");
        phoneDao.addPhone(phone);

        Phone phoneTest = phoneDao.getPhoneById(phone.getId());
        Assert.assertEquals(phone.getNumber(), phoneTest.getNumber());
    }

    @Test
    public void phone_list_in_DB_should_larger_after_add_phone() {
        Phone phone = new Phone();
        List<Phone> listPhone = phoneDao.listPhone();
        phoneDao.addPhone(phone);
        List<Phone> newListPhone = phoneDao.listPhone();
        Assert.assertNotEquals(listPhone.size(), newListPhone.size());
    }

    @Test
    public void phone_number_should_be_different_after_update() {
        Phone phone = new Phone();
        phone.setNumber("123-111-111");
        phone.setDiallingCode("666666");
        phone.setExtensionNumber("789789");
        phone.setNumber("222-222-222");
        phone.setDiallingCode("456965");
        phone.setExtensionNumber("516846");
        phoneDao.updatePhone(phone);
        Assert.assertNotEquals(phone.getNumber(), "123-111-111");
    }

}
