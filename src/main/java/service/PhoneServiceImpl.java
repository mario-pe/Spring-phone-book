package service;

import model.Phone;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by mario on 26.06.2017.
 */
@Service
public class PhoneServiceImpl implements PhoneService {
    @Override
    @Transactional
    public void addPhone(Phone p) {

    }

    @Override
    @Transactional
    public void updatePhone(Phone p) {

    }

    @Override
    @Transactional
    public List<Phone> listPhone(Phone p) {
        return null;
    }

    @Override
    @Transactional
    public Phone getPhoneById(int id) {
        return null;
    }

    @Override
    @Transactional
    public void removePhone(int id) {

    }
}
