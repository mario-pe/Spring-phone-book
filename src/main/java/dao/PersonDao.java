package dao;

import model.Phone;

import java.util.List;

/**
 * Created by mario on 25.06.2017.
 */
public interface PersonDao {
    public void addPhone(Phone p);
    public void updatePhone(Phone p);
    public List<Phone> listPhone(Phone p);
    public Phone getPhoneById(int id);
    public void removePhone(int id);
}
