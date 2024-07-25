package com.unittest.codecoverage.service;

import com.unittest.codecoverage.models.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import com.unittest.codecoverage.repositories.PersonRepository;

class PersonRepositoryTest {

    private PersonRepository repository;

    @BeforeEach
    void setUp() {
        repository = new PersonRepository();
    }

    @Test
    void testInsertValidPersonReturnsSamePerson() {
        Person person = new Person();
        person.setName("New Name");

        Person result = repository.insert(person);

        assertSame(person, result);
    }

    @Test
    void testInsertNullPersonThrowsNullPointerException() {
        assertThrows(NullPointerException.class, () -> repository.insert(null));
    }

    @Test
    void testUpdateValidPersonDoesNotThrowException() {
        Person person = new Person();
        person.setName("New Name");

        assertDoesNotThrow(() -> repository.update(person));
    }

    @Test
    void testUpdateNullPersonThrowsNullPointerException() {
        assertThrows(NullPointerException.class, () -> repository.update(null));
    }

    @Test
    void testDeleteValidNameDoesNotThrowException() {
        assertDoesNotThrow(() -> repository.delete("New Name"));
    }

    @Test
    void testDeleteNullNameThrowsNullPointerException() {
        assertThrows(NullPointerException.class, () -> repository.delete(null));
    }

    @Test
    void testGetValidNameReturnsNull() {
        Person result = repository.get("New Name");
        assertNull(result);
    }

    @Test
    void testGetNullNameThrowsNullPointerException() {
        assertThrows(NullPointerException.class, () -> repository.get(null));
    }
}
