package org.naby.model.service;

import org.naby.common.API;
import org.naby.common.JSON;
import org.naby.common.Web;
import org.naby.common.exception.WrongNameException;
import org.naby.common.exception.WrongPhoneException;
import org.naby.model.entity.Person;

public class PersonService {
    private static final PersonService PERSON_SERVICE = new PersonService();

    private PersonService() {
    }

    public static PersonService getInstance() {
        return PERSON_SERVICE;
    }

    public String save(Person person) throws Exception {
//        checkNameValidation(person.getName());
        checkPhoneValidation(person.getPhone());
        return Web.sendRequestByGet(String.format(API.SAVE_PERSON, person.getName(), person.getFamily(), person.getPhone()));
    }

    public String findOne(Person person) throws Exception {
        return Web.sendRequestByGet(String.format(API.SELECT_PERSON, person.getId()));
    }

    public String update(Person person) throws Exception {
        String one = findOne(person);
        Person foundPerson = JSON.map(one, Person.class);
        Web.sendRequestByGet(String.format(API.UPDATE_PERSON, foundPerson.getId()));
        return save(person);
    }

    public String remove(Person person) throws Exception {
        String one = findOne(person);
        Person foundPerson = JSON.map(one, Person.class);
        return Web.sendRequestByGet(String.format(API.UPDATE_PERSON, person.getId(), person.getName(), person.getFamily(), person.getPhone()));
    }

    private void checkNameValidation(String name) throws Exception {
        if (name.length() != 20) {
            throw new WrongNameException();
        }
    }

    private void checkPhoneValidation(String phone) throws Exception {
        try {
            Long.parseLong(phone);
        } catch (Exception e) {
            throw new WrongPhoneException();
        }
    }
}