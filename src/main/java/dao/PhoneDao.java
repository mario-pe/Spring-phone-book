package dao;

import model.Phone;

import java.util.List;

/**
 * Created by mario on 26.06.2017.
 */
public interface PhoneDao {
    public void addPhone(Phone p);
    public void updatePhone(Phone p);
    public List<Phone> listPhone(Phone p);
    public Phone getPhoneById(int id);
    public void removePhone(int id);
}
