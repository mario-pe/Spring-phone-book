package controller;


import model.Phone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.PhoneService;


import javax.validation.Valid;
import java.util.List;

/**
 * Main Contoroller for Phone
 *@Autowired with PhoneService
 * Created by mario on 26.06.2017.
 */
@Controller
public class PhoneController {

    private PhoneService phoneService;
    @Autowired
    @Qualifier(value="phoneService")
    public void setPhoneService(PhoneService ps){ this.phoneService=ps;};

    /**
     *  prepare list of all phones existing in data base
     * @param model
     * @return send user to phone.jsp
     */
    @RequestMapping("/phone")
    public String phoneView(Model model){
        List<Phone> phoneList = this.phoneService.listPhone();
        model.addAttribute("phoneList",phoneList);
        return "phone";
    }

    /**
     * prepare object to add new Phone
     * @param model
     * @return send user to phone/add.jsp
     */
    @RequestMapping("/phone/add")
    public String index(Model model){
        Phone phone= new Phone();
        model.addAttribute("phone", phone);
        return "phone/add";
    }

    /**
     * use @Validation number  just numbers 0-9  '-' and space
     * if form  is correctly fill add new person to DB
     * else send  back to phone/add.jsp
     * @param phone
     * @param result
     * @return
     */
    @RequestMapping(value = "/phone/phoneAdding", method = RequestMethod.POST)
    public String addNewPhone(@Valid Phone phone,BindingResult result) {
        if(result.hasErrors()){
            return "phone/add";
        }
        this.phoneService.addPhone(phone);
        return "redirect:/phone";
    }

    /**
     * prepare object Phone to edit and update information in DB
     * @param id
     * @param model
     * @return phone/edit.jsp
     */
    @RequestMapping("/phone/edit/{id}")
    public String getPersonToUpdate(@PathVariable("id") int id, Model model) {
        model.addAttribute("phone", this.phoneService.getPhoneById(id));
        return "phone/edit";
    }

    /**
     * use @Validation number  just numbers 0-9  '-' and space
     * if form  is correctly fill add new person to DB and redirect to phone.jsp
     * else send  back to phone/add.jsp
     * @param phone
     * @param result
     * @return
     */
    @RequestMapping(value = "/phone/edit/phoneEdit", method = RequestMethod.POST)
    public String updatingPhone(@Valid Phone phone,BindingResult result) {
        if(result.hasErrors()){
            return "phone/edit";
        }
        this.phoneService.updatePhone(phone);
        return "redirect:/phone";
    }
    /**
     * delete Phone from DB
     *
     * @param id
     * @param model
     * @return redirect user to person.jsp
     */

    @RequestMapping(value = "/phone/remove/{id}", method = RequestMethod.GET)
    public String removePhone(@PathVariable("id") int id, Model model) {
        this.phoneService.removePhone(id);
        return "redirect:/phone";
    }


}
