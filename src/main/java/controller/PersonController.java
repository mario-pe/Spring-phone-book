package controller;

import model.Person;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.PersonService;

import java.util.List;

/**
 * Created by mario on 26.06.2017.
 */
@Controller
public class PersonController {


    private PersonService personService;

    @Autowired(required=true)
    @Qualifier(value="personService")
    public void setPersonService(PersonService ps){
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
    public String personView(Model model){
        List<Person> personList = this.personService.listPersons();
        model.addAttribute("personList",personList);
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
    public String detailsPerson(@PathVariable("id")int id, Model model){
        model.addAttribute("person",this.personService.getPersonById(id));
        model.addAttribute("phoneList",this.personService.getPhoneListById(id));
        return "person/details";
    }

    @RequestMapping("/")
    public String index(){
        return "index";
    }
}
