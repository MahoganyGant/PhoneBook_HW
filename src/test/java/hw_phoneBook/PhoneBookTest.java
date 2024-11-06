package hw_phoneBook;
import hw_phonebook.PhoneBook;
    import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

    class PhoneBookTest {
        private PhoneBook phoneBook;

        @BeforeEach
        void setUp() {
            phoneBook = new PhoneBook();
        }

        @Test
        void testAddAll() {
            // Add multiple phone numbers for a contact
            phoneBook.addAll("Alice", "123-456-7890", "234-567-8901", "345-678-9012");

            // find and verify the added phone numbers
            List<String> numbers = phoneBook.lookup("Alice");
            assertNotNull(numbers, "Phone numbers should not be null");
            assertEquals(3, numbers.size(), "Alice should have 3 phone numbers");
            assertTrue(numbers.contains("123-456-7890"), "Phone number not found");
            assertTrue(numbers.contains("234-567-8901"), "Phone number not found");
            assertTrue(numbers.contains("345-678-9012"), "Phone number not found");
        }

        @Test
        void testRemove() {
            // Add a contact and then remove it
            phoneBook.add("Bob", "456-789-0123");
            phoneBook.remove("Bob");

            // Check that the contact was removed
            assertNull(phoneBook.lookup("Bob"), "Bob should be removed from the phonebook");
            assertFalse(phoneBook.hasEntry("Bob"), "Phonebook should not contain Bob");
        }

        @Test
        void testReverseLookup() {
            // Add contacts with different phone numbers
            phoneBook.add("Charlie", "567-890-1234");
            phoneBook.add("Daisy", "678-901-2345");

            //reverse lookup, confirm results
            String result1 = phoneBook.reverseLookup("567-890-1234");
            assertEquals("The name associated with 567-890-1234 is: Charlie", result1, "Reverse lookup failed for Charlie");

            String result2 = phoneBook.reverseLookup("678-901-2345");
            assertEquals("The name associated with 678-901-2345 is: Daisy", result2, "Reverse lookup failed for Daisy");

            // Test reverse lookup for a non-existent number
            String result3 = phoneBook.reverseLookup("000-000-0000");
            assertEquals("Number not found in phonebook.", result3, "Reverse lookup should return 'Number not found'");
        }
    }

