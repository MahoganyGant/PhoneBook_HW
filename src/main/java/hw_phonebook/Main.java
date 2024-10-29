package hw_phonebook;

public class Main {

    public static void main(String[] args) {

        PhoneBook Mikes_Phonebook = new PhoneBook();
        Mikes_Phonebook.add("Cassie","111-111-1111");
        Mikes_Phonebook.add("Brenda","222-222-2222");
        Mikes_Phonebook.add("dad","333-333-3333");
        Mikes_Phonebook.add("Patrick","444-444-4444");

        System.out.println(Mikes_Phonebook.getAllContactNames() + "\n");

        Mikes_Phonebook.addAll("Mom","000-000-0000","267-000-0000","215-111-1111");

        Mikes_Phonebook.remove("Brenda");

        System.out.println(Mikes_Phonebook.getAllContactNames()+"\n");

        System.out.println("Contact labeled Mom?: " + Mikes_Phonebook.hasEntry("Mom")+"\n");

        System.out.println("what is Patrick's number: " +  Mikes_Phonebook.lookup("Patrick")+"\n");

        System.out.println(Mikes_Phonebook.reverseLookup("267-000-0000")+"\n");

        System.out.println("All Contact Names: \n" + Mikes_Phonebook.getAllContactNames()+"\n");

//already has a print statement inside
        Mikes_Phonebook.getMap();
    }
}
