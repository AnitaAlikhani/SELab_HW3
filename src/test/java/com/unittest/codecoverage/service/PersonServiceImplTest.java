package com.unittest.codecoverage.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.unittest.codecoverage.services.impl.PersonServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.unittest.codecoverage.exceptions.PersonException;
import com.unittest.codecoverage.models.Person;
import com.unittest.codecoverage.models.validators.PersonValidator;
import com.unittest.codecoverage.repositories.PersonRepository;

public class PersonServiceImplTest {

    @InjectMocks
    private PersonServiceImpl personService;

    @Mock
    private PersonRepository repository;

    @Mock
    private PersonValidator validator;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        personService = new PersonServiceImpl();
        personService.repository = repository;
        personService.validator = validator;
    }

    @Test
    public void testGet_NormalFlow() {
        String name = "John Doe";
        Person person = new Person();
        person.setName(name);

        when(validator.requiredName(name)).thenReturn(false);
        when(repository.get(name)).thenReturn(person);

        Person result = personService.get(name);
        assertNotNull(result);
        assertEquals(name, result.getName());

        verify(validator).requiredName(name);
        verify(repository).get(name);
    }

    @Test
    public void testGet_ExceptionFlow() {
        String name = "";

        when(validator.requiredName(name)).thenReturn(true);

        assertThrows(PersonException.class, () -> {
            personService.get(name);
        });

        verify(validator).requiredName(name);
        verify(repository, never()).get(name);
    }

    @Test
    public void testDelete_NormalFlow() {
        String name = "John Doe";

        when(validator.requiredName(name)).thenReturn(false);

        assertDoesNotThrow(() -> {
            personService.delete(name);
        });

        verify(validator).requiredName(name);
        verify(repository).delete(name);
    }

    @Test
    public void testDelete_ExceptionFlow() {
        String name = "";

        when(validator.requiredName(name)).thenReturn(true);

        assertThrows(PersonException.class, () -> {
            personService.delete(name);
        });

        verify(validator).requiredName(name);
        verify(repository, never()).delete(name);
    }
}
