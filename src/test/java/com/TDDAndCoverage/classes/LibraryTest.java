package com.TDDAndCoverage.classes;

import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;

public class LibraryTest {

    private Book book = new Book("A Fraction of the Whole", "Steve Toltz", 1);
    private Student student = new Student("Mark", 1);
    private Library library = new Library();

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
}