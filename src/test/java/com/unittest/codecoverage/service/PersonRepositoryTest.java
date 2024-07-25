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
    void testInsertValidPerson_ReturnsSamePerson() {
        Person person = new Person();
        person.setName("New Name");

        Person result = repository.insert(person);

        assertSame(person, result);
    }

    @Test
    void testInsertNullPerson_ThrowsNullPointerException() {
        assertThrows(NullPointerException.class, () -> repository.insert(null));
    }

    @Test
    void testUpdateValidPerson_DoesNotThrowException() {
        Person person = new Person();
        person.setName("New Name");

        assertDoesNotThrow(() -> repository.update(person));
    }

    @Test
    void testUpdateNullPerson_ThrowsNullPointerException() {
        assertThrows(NullPointerException.class, () -> repository.update(null));
    }

    @Test
    void testDeleteValidName_DoesNotThrowException() {
        assertDoesNotThrow(() -> repository.delete("New Name"));
    }

    @Test
    void testDeleteNullName_ThrowsNullPointerException() {
        assertThrows(NullPointerException.class, () -> repository.delete(null));
    }

    @Test
    void testGetValidName_ReturnsNull() {
        Person result = repository.get("New Name");
        assertNull(result);
    }

    @Test
    void testGetNullName_ThrowsNullPointerException() {
        assertThrows(NullPointerException.class, () -> repository.get(null));
    }
}
