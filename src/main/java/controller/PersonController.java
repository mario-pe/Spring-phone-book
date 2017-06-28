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

    //    @RequestMapping(value= "/person/add", method = RequestMethod.POST)
//    public String addPerson(@ModelAttribute("person") Person p){
//
//        if(p.getId() == 0){
//            //new person, add it
//            this.personService.addPerson(p);
//        }else{
//            //existing person, call update
//            this.personService.updatePerson(p);
//        }
//
//        return "redirect:/persons";
    //    }
    @RequestMapping("/person")
    public String personView(Model model) {
        List<Person> personList = this.personService.listPersons();
        model.addAttribute("personList", personList);
        return "person";
    }


    @RequestMapping("/person/add")
    public String getNewPersonForm(Model model) {

        Person person = new Person();
        model.addAttribute("person", person);
        return "person/add";
    }

    @RequestMapping(value = "/person/personAdding", method = RequestMethod.POST)
    public String addNewPerson(Person person) {
        System.out.println(person);

        this.personService.addPerson(person);
        return "redirect:/person";
    }

    @RequestMapping("/person/edit/{id}")
    public String getPersonToUpdate(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", this.personService.getPersonById(id));
        return "person/edit";
    }

    @RequestMapping(value = "/person/edit/personEdit", method = RequestMethod.POST)
    public String updatingPerson(Person person) {
        System.out.println(person);
        this.personService.updatePerson(person);
        return "redirect:/person";
    }


    @RequestMapping(value = "/person/remove/{id}", method = RequestMethod.GET)
    public String removePerson(@PathVariable("id") int id, Model model) {
        this.personService.removePerson(id);
        return "redirect:/person";
    }

    @RequestMapping(value = "/person/details/{id}", method = RequestMethod.GET)
    public String detailsPerson(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", this.personService.getPersonById(id));
        model.addAttribute("phoneList", this.personService.getPhoneListById(id));
        return "person/details";
    }

    //    /{surname},{number}
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
    @RequestMapping(value = "/removePhoneFromPerson/{id}/{id}")
    public String removePhoneFromPerson(@PathVariable("id") int id, @PathVariable("id") int personId, Model model){
        this.personService.deleteNumberFromPerson(id);
        String path = "/person/details/"+personId;
        return path;
    }
    @RequestMapping(value = "/addPhoneToPerson")
    public String addPhoneToPerson(@RequestParam("idPhone") int idPhone, @RequestParam("idPerson") int idPerson, Model model){
        int idPh  = idPhone;
        int idPe  = idPerson;
        this.personService.addPhoneToPerson(idPhone,idPerson);
        String path = "/person/details/"+ idPerson;
        return path;
    }

    @RequestMapping("/")
    public String index(Model model) {
        return "index";
    }
}
