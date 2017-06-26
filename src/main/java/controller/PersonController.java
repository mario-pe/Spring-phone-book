package controller;

import model.Person;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.PersonService;

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

    @RequestMapping(value= "/person/add", method = RequestMethod.POST)
    public String addPerson(@ModelAttribute("person") Person p){

        if(p.getId() == 0){
            //new person, add it
            this.personService.addPerson(p);
        }else{
            //existing person, call update
            this.personService.updatePerson(p);
        }

        return "redirect:/persons";
    }

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("someAttribute", "someValue");

        Person person = new Person();
        person.setName("henio");

        model.addAttribute("person", person);
        return "index";
    }
    @RequestMapping("/print")
    public String index(Person person) {
        System.out.println(person);
        this.personService.addPerson(person);
        return "index";
    }
}
