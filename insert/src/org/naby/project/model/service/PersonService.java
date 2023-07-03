package org.naby.project.model.service;

import org.naby.project.model.entity.Person;
import org.naby.project.model.repository.PersonRepository;

public class PersonService {
    private PersonService() {
    }

    private static final PersonService PERSON_SERVICE = new PersonService();

    public static PersonService getInstance() {
        return PERSON_SERVICE;
    }
    public Person save(Person person) throws Exception {
        try (PersonRepository personRepository = new PersonRepository()) {
            personRepository.insert(person);
            personRepository.commit();
        }
        return person;
    }
}
