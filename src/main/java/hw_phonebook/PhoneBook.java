package hw_phonebook;

import java.util.*;

public class PhoneBook {
    private final Map<String, List<String>> phonebook;

    public PhoneBook(Map<String, List<String>> map) {
        this.phonebook = map;
    }

    public PhoneBook() {
        this(new HashMap<>());
    }

    public void add(String name, String phoneNumber) {
        //todo- saw examples of a getOrDefault
        //learn more later, looked like a simpler way to do what i'm doing below

        // does name already exists in the phonebook
        if (phonebook.containsKey(name)) {
            // If it exists, add the new phone number to it's list
            phonebook.get(name).add(phoneNumber);
        } else {
            // If it doesn't exist, create a new list, add the phone number to it then put it in the phonebook(map)
            List<String> nums = new ArrayList<>();
            nums.add(phoneNumber);
            phonebook.put(name, nums);
        }
    }

    public void addAll(String name, String... phoneNumbers) {
        // Create a list to hold the phone numbers
        List<String> numbersList = new ArrayList<>();

        // Add each phone number to the list
        for (String number : phoneNumbers) {
            numbersList.add(number);
        }
        // Put the name and list of numbers into the phonebook
        phonebook.put(name, numbersList);
         }

    public void remove(String name) {
        phonebook.remove(name);
    }

    public Boolean hasEntry(String name) {
        return phonebook.containsKey(name);
    }

    public List<String> lookup(String name) {
        return phonebook.get(name);
    }

    public String reverseLookup(String phoneNumber) {
        for (String key : phonebook.keySet()) {
           // creating a list to store all the numbers a contact(key) has
            List<String> numbers = phonebook.get(key);
            // Check if this key's value matches the target value
            if (numbers != null && numbers.contains(phoneNumber)) {
                return String.format("The name associated with %s is: %s",phoneNumber,key);
                 }
            }
        return "Number not found in phonebook.";
        }

    public List<String> getAllContactNames() {
        List<String> contactNames = new ArrayList<>(); // Create a list to store the names matching data type that has to be returned

        // now I can Loop through each contact in the phonebook
        for (String contact : phonebook.keySet()) {
            contactNames.add(String.format("Name: %s", contact)); // Add each name to the list with formatting
        }
        return contactNames; // Return the complete list of contact names
    }

    public Map<String, List<String>> getMap() {

        StringBuilder formattedEntries = new StringBuilder(); // wanted the map to print vertically instead
        for (Map.Entry<String, List<String>> entry : phonebook.entrySet()) {
            String contactName = entry.getKey();
            List<String> phoneNumbers = entry.getValue();
            formattedEntries.append(String.format("%s: %s%n", contactName, String.join(", ", phoneNumbers)));
        }
        System.out.println(formattedEntries.toString());
        return phonebook; //not sure if this structure is really optimal but it achieved my desired outcome (review later)
    }
}



