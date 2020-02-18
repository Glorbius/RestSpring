package kz.marat.controller;

import kz.marat.ConnectBD.ConnectMySQL;
import kz.marat.test.TestRepo;
import kz.marat.model.Person;
import org.springframework.web.bind.annotation.*;

@RestController
public class PersonController {

    TestRepo repository = new TestRepo();

    @GetMapping("/persons")
    public Object getAllPersons( ) {
        return ConnectMySQL.getAllUsers();
    }

    @GetMapping("/person")
    public Object getPersonById(@RequestParam(value = "id", required = true) Integer id) {
        return ConnectMySQL.getUsersById(id);
    }

    @PostMapping("/persons")
    public Object personUpdate(
            @RequestParam(value = "name", required = true) String name,
            @RequestParam(value = "age", required = true) int age,
            @RequestParam(value = "legsize", required = true) int legsize,
            @RequestParam(value = "sex", required = true) String sex,
            @RequestParam(value = "status", required = true) String status
    ) {
          return ConnectMySQL.setUser(new Person(name,age,legsize,sex,status));

    }

    @PostMapping("/person")
    public Object personDeleteById(
            @RequestParam(value = "id", required = true) int id) {
        ConnectMySQL.deleteUser(id);
        return id + " Удален!";
    }





    //@GetMapping("/persons/all")
    //public HashMap<String, Person> getPersonAll(){
    //    return repository.getAllMembers();
   // }



    /*@PostMapping("/persons")
    public Object personUpdate(
            @RequestParam(value = "name", required = true) String name,
            @RequestParam(value = "age", required = true) int age,
            @RequestParam(value = "legsize", required = true) int legsize,
            @RequestParam(value = "sex", required = true) String sex,
            @RequestParam(value = "status", required = true) String status
    ) {
        Person p = repository.getByName(name);

        if (p != null) {
            String errorName = " Пользователь с таким именем уже существует  ";
            return errorName + p.getName();
        } else return repository.addPerson(new Person(name, age, legsize, sex, status));
    }*/

   /* @DeleteMapping("/persons/delete")
    public Person personDelete(
            @RequestParam(value = "name", required = true) String name) {
        return repository.deletePerson(name);
    }*/






}
