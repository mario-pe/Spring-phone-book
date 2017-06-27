package controller;

import dao.PhoneDao;
import model.Phone;
import model.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.PhoneService;

import java.util.List;

/**
 * Created by mario on 26.06.2017.
 */
@Controller
public class PhoneController {

    private PhoneService phoneService;
    @Autowired
    @Qualifier(value="phoneService")
    public void setPhoneService(PhoneService ps){ this.phoneService=ps;};

    @RequestMapping("/phone")
    public String personView(Model model){
        List<Phone> phoneList = this.phoneService.listPhone();
        model.addAttribute("phoneList",phoneList);
        return "phone";
    }

    @RequestMapping("/phone/add")
    public String index(Model model) {
        Phone phone= new Phone();
        model.addAttribute("phone", phone);
        return "phone/add";
    }
    @RequestMapping(value = "/phone/phoneAdding", method = RequestMethod.POST)
    public String addNewPhone(Phone phone) {
        this.phoneService.addPhone(phone);
        return "redirect:/phone";
    }

    @RequestMapping("/phone/edit/{id}")
    public String getPersonToUpdate(@PathVariable("id") int id, Model model) {
        model.addAttribute("phone", this.phoneService.getPhoneById(id));
        return "phone/edit";
    }

    @RequestMapping(value = "/phone/edit/phoneEdit", method = RequestMethod.POST)
    public String updatingPerson(Phone phone) {
        System.out.println(phone);
        this.phoneService.updatePhone(phone);
        return "redirect:/phone";
    }


    @RequestMapping(value = "/phone/remove/{id}", method = RequestMethod.GET)
    public String removePhone(@PathVariable("id") int id, Model model) {
        this.phoneService.removePhone(id);
        return "redirect:/phone";
    }


}
