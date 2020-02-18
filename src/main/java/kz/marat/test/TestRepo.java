package kz.marat.test;

import kz.marat.model.Person;

import java.util.HashMap;

public class TestRepo {

    static HashMap<String, Person> persons = new HashMap<String, Person>();

    static {
        persons.put("Жомарт", new Person(12,"Zhoma", 25,40,"men","member"));
        persons.put("Марат", new Person(13,"Marat", 24,40,"men","member"));
        persons.put("Еркеш", new Person(14,"Erkew", 33,40,"men","baqtawi"));
    }

    public Person getByName(String name) {
        return persons.get(name);
    }

    public HashMap<String, Person> getAllMembers(){
        return persons;
    }

    public Person addPerson(Person p) {
        persons.put(p.getName(), p);
        return p;
    }

    public Person deletePerson(String name) {
        return persons.remove(name);
    }
}
