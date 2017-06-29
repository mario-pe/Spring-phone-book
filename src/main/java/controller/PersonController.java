package controller;

import model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.PersonService;

import java.util.List;

/**
 * Main Contoroller for Person
 *@Autowired with PersonService
 * Created by mario on 26.06.2017.
 */
@Controller
public class PersonController {


    private PersonService personService;

    @Autowired(required = true)
    @Qualifier(value = "personService")
    public void setPersonService(PersonService ps) {
        this.personService = ps;
    }

    /**
     * prepare list of all persons existing in data base
     *
     * @param model
     * @return send user to person.jsp
     */
    @RequestMapping("/person")
    public String personView(Model model) {
        List<Person> personList = this.personService.listPersons();
        model.addAttribute("personList", personList);
        return "person";
    }

    /**
     * prepare object to add new Person
     *
     * @param model
     * @return send user to person/add.jsp
     */
    @RequestMapping("/person/add")
    public String getNewPersonForm(Model model) {

        Person person = new Person();
        model.addAttribute("person", person);
        return "person/add";
    }
    /**
     * after  fill form add new person to DB
     *
     * @param person
     * @return redirect person.jsp
     */
    @RequestMapping(value = "/person/personAdding", method = RequestMethod.POST)
    public String addNewPerson(Person person) {
        System.out.println(person);

        this.personService.addPerson(person);
        return "redirect:/person";
    }
    /**
     * prepare object Person to edit and update information in DB
     *
     * @param id
     * @param model
     * @return send user to edit.jsp
     */
    @RequestMapping("/person/edit/{id}")
    public String getPersonToUpdate(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", this.personService.getPersonById(id));
        return "person/edit";
    }
    /**
     * after correctly fill form update Person in DB
     *
     * @param person
     * @return redairect user to index.jsp
     */
    @RequestMapping(value = "/person/edit/personEdit", method = RequestMethod.POST)
    public String updatingPerson(Person person) {
        System.out.println(person);
        this.personService.updatePerson(person);
        return "redirect:/person";
    }
    /**
     * delete Person from DB
     *
     * @param id
     * @param model
     * @return redirect user to person.jsp
     */

    @RequestMapping(value = "/person/remove/{id}", method = RequestMethod.GET)
    public String removePerson(@PathVariable("id") int id, Model model) {
        this.personService.removePerson(id);
        return "redirect:/person";
    }
    /**
     * prepare  object Person to display his phones
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/person/details/{id}", method = RequestMethod.GET)
    public String detailsPerson(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", this.personService.getPersonById(id));
        model.addAttribute("phoneList", this.personService.getPhoneListById(id));
        return "person/details";
    }

    /**
     * search for person by surname or number or both
     *
     *
     * @param surname
     * @param number
     * @param model
     * @return send user to result.jsp
     */
    @RequestMapping(value = "/searchPerson", method = RequestMethod.POST)
    public String searchPerson(@RequestParam("surname") String surname, @RequestParam("number") String number, Model model) {
        System.out.println("nazwisko: " + surname);
        System.out.println("number: " + number);

        if (!number.equals("") && !surname.equals("")) {
            model.addAttribute("personList", this.personService.getPersonListByNumberSurname(number,surname));
        } else if (number.equals("") && !surname.equals("")) {
            model.addAttribute("personList", this.personService.getPersonListBySurname(surname));
        } else if (!number.equals("")&& surname.equals("")) {
            model.addAttribute("personList", this.personService.getPersonListByNumber(number));
        }else {
            model.addAttribute("info","niepodales parametrów wyszukiwania ");
            return "index";
        }
        return "person/result";
    }
    /**
     * delete relation between Person and Phone
     * @param model
     * @return redirect:/person
     */
    @RequestMapping(value = "/removePhoneFromPerson/{id}/{id}")
    public String removePhoneFromPerson(@PathVariable("id") int id, @PathVariable("id") int personId, Model model){
        this.personService.deleteNumberFromPerson(id);
        String path = "redirect:/person";
        return path;
    }

    /**
     * add phone from DB to person
     * @param idPhone
     * @param idPerson
     * @param model
     * @return redirect:/person
     */
    @RequestMapping(value = "/addPhoneToPerson")
    public String addPhoneToPerson(@RequestParam("idPhone") int idPhone, @RequestParam("idPerson") int idPerson, Model model){
        int idPh  = idPhone;
        int idPe  = idPerson;
        this.personService.addPhoneToPerson(idPhone,idPerson);
        String path = "redirect:/person";
        return path;
    }

    /**
     * send user to index.jsp
     * @param model
     * @return
     */
    @RequestMapping("/")
    public String index(Model model) {
        return "index";
    }
}
