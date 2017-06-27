package service;

import model.Phone;

import java.util.List;

/**
 * Created by mario on 26.06.2017.
 */
public interface PhoneService {
    public void addPhone(Phone p);
    public void updatePhone(Phone p);
    public List<Phone> listPhone();
    public Phone getPhoneById(int id);
    public void removePhone(int id);
}
