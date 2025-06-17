import java.util.ArrayList;
import java.util.Scanner;

class Contact {
    private String name;
    private String phoneNumber;
    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Phone Number: " + phoneNumber;
    }
}

public class PhoneBook {
    private ArrayList<Contact> contacts;

    public PhoneBook() {
        contacts = new ArrayList<>();
    }

    public void addContact(String name, String phoneNumber) {
        contacts.add(new Contact(name, phoneNumber));
        System.out.println("Contact added: " + name);
    }

    public void searchContact(String name) {
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                System.out.println("Contact found: " + contact);
                return;
            }
        }
        System.out.println("Contact not found.");
    }

    public void displayContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts in the phone book.");
            return;
        }
        System.out.println("Contacts in Phone Book:");
        for (Contact contact : contacts) {
            System.out.println(contact);
        }
    }

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nPhone Book Menu:");
            System.out.println("1. Add Contact");
            System.out.println("2. Search Contact");
            System.out.println("3. Display Contacts");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phoneNumber = scanner.nextLine();
                    phoneBook.addContact(name, phoneNumber);
                    break;
                case 2:
                    System.out.print("Enter name to search: ");
                    String searchName = scanner.nextLine();
                    phoneBook.searchContact(searchName);
                    break;
                case 3:
                    phoneBook.displayContacts();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
