package service;

import dao.PhoneDao;
import model.Phone;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *  implemntation of functionality
 * service use PhoneDao
 * Created by mario on 26.06.2017.
 */
@Service
public class PhoneServiceImpl implements PhoneService {

    private PhoneDao phoneDao;
    public void setPhoneDao(PhoneDao pd){
        this.phoneDao=pd;
    }

    @Override
    @Transactional
    public void addPhone(Phone phone){
        this.phoneDao.addPhone(phone);
    }

    @Override
    @Transactional
    public void updatePhone(Phone phone) {
        this.phoneDao.updatePhone(phone);
    }

    @Override
    @Transactional
    public List<Phone> listPhone() {
        return this.phoneDao.listPhone();
    }

    @Override
    @Transactional
    public Phone getPhoneById(int id) {

        return this.phoneDao.getPhoneById(id);
    }

    @Override
    @Transactional
    public void removePhone(int id) {
        this.phoneDao.removePhone(id);
    }
}
