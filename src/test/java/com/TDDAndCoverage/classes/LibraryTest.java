package com.TDDAndCoverage.classes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {

    private Book book = new Book("A Fraction of the Whole", "Steve Toltz", 1);
    private Student student = new Student("Mark", 1);
    private Library library = new Library();

    @BeforeEach
    public void setUp() {
        library = new Library();
        library.addBook(new Book("Effective Java", "Joshua Bloch", 1));
        library.addBook(new Book("Clean Code", "Robert C. Martin", 2));
        library.addBook(new Book("The Pragmatic Programmer", "Andrew Hunt", 3));

        library.addStudent(new Student("Alice", 1));
        library.addStudent(new Student("Bob", 2));
        library.addStudent(new Student("Charlie", 3));
    }

    @Test
    public void testStudentExistenceInLendingBook() {
        library.addBook(book);
        assertFalse(library.lendBook(book, student), "Student is not in library list, lendBook must return False");
    }

    @Test
    public void testRemovingBookFromStudentListInReturningBook() {
        library.addBook(book);
        library.addStudent(student);
        library.lendBook(book, student);
        library.returnBook(book, student);
        assertFalse(student.hasBook(book), "Student must not have the book, because she returns it");
    }


    @Test
    public void testSearchStudentsById() {
        ArrayList<Object> ids = new ArrayList<>();
        ids.add(1);
        ids.add(3);
        ArrayList<Student> students = library.searchStudents(SearchByType.ID, ids);
        assertEquals(2, students.size());
        assertEquals("Alice", students.get(0).getName());
        assertEquals("Charlie", students.get(1).getName());
    }

    @Test
    public void testSearchStudentsByName() {
        ArrayList<Object> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        ArrayList<Student> students = library.searchStudents(SearchByType.NAME, names);
        assertEquals(2, students.size());
        assertEquals("Alice", students.get(0).getName());
        assertEquals("Bob", students.get(1).getName());
    }
}