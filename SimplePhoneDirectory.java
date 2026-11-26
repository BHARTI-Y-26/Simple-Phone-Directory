import java.util.Scanner;

class Contact {
    String name;
    String phone;
    Contact next;

    Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
        this.next = null;
    }
}

public class SimplePhoneDirectory {

    static Contact head = null;
    static Scanner sc = new Scanner(System.in);

    // Add Contact
    static void addContact() {
        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Phone Number: ");
        String phone = sc.nextLine();

        Contact newNode = new Contact(name, phone);

        if (head == null) {
            head = newNode;
        } else {
            Contact temp = head;

            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = newNode;
        }

        System.out.println("Contact added successfully!");
    }

    // Search Contact
    static void searchContact() {
        System.out.print("Enter name or phone number to search: ");
        String key = sc.nextLine();

        Contact temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.name.equalsIgnoreCase(key)
                    || temp.phone.equals(key)) {
                System.out.println("Contact Found!");
                System.out.println("Name: " + temp.name);
                System.out.println("Phone: " + temp.phone);
                found = true;
            }

            temp = temp.next;
        }

        if (!found) {
            System.out.println("Contact not found!");
        }
    }

    // Update Contact
    static void updateContact() {
        System.out.print("Enter name of contact to update: ");
        String key = sc.nextLine();

        Contact temp = head;

        while (temp != null) {
            if (temp.name.equalsIgnoreCase(key)) {
                System.out.print("Enter New Name: ");
                temp.name = sc.nextLine();

                System.out.print("Enter New Phone Number: ");
                temp.phone = sc.nextLine();

                System.out.println("Contact updated successfully!");
                return;
            }

            temp = temp.next;
        }

        System.out.println("Contact not found!");
    }

    // Delete Contact
    static void deleteContact() {
        System.out.print("Enter name of contact to delete: ");
        String key = sc.nextLine();

        if (head == null) {
            System.out.println("Phone Directory is empty!");
            return;
        }

        if (head.name.equalsIgnoreCase(key)) {
            head = head.next;
            System.out.println("Contact deleted successfully!");
            return;
        }

        Contact temp = head;

        while (temp.next != null) {
            if (temp.next.name.equalsIgnoreCase(key)) {
                temp.next = temp.next.next;
                System.out.println("Contact deleted successfully!");
                return;
            }

            temp = temp.next;
        }

        System.out.println("Contact not found!");
    }

    // Display All Contacts
    static void displayContacts() {
        if (head == null) {
            System.out.println("Phone Directory is empty!");
            return;
        }

        Contact temp = head;

        System.out.println("\n----- PHONE DIRECTORY -----");

        while (temp != null) {
            System.out.println("Name: " + temp.name);
            System.out.println("Phone: " + temp.phone);
            System.out.println("---------------------------");

            temp = temp.next;
        }
    }

    // Sort Contacts Alphabetically
    static void sortContacts() {
        if (head == null || head.next == null) {
            System.out.println("Not enough contacts to sort.");
            return;
        }

        Contact current;
        Contact index;

        for (current = head; current.next != null;
             current = current.next) {

            for (index = current.next; index != null;
                 index = index.next) {

                if (current.name.compareToIgnoreCase(index.name) > 0) {
                    String tempName = current.name;
                    String tempPhone = current.phone;

                    current.name = index.name;
                    current.phone = index.phone;

                    index.name = tempName;
                    index.phone = tempPhone;
                }
            }
        }

        System.out.println("Contacts sorted alphabetically!");
    }

    
    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== SIMPLE PHONE DIRECTORY =====");
            System.out.println("1. Add Contact");
            System.out.println("2. Search Contact");
            System.out.println("3. Update Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Display All Contacts");
            System.out.println("6. Sort Contacts");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1:
                        addContact();
                        break;

                    case 2:
                        searchContact();
                        break;

                    case 3:
                        updateContact();
                        break;

                    case 4:
                        deleteContact();
                        break;

                    case 5:
                        displayContacts();
                        break;

                    case 6:
                        sortContacts();
                        break;

                    case 7:
                        System.out.println("Thank you for using Phone Directory!");
                        break;

                    default:
                        System.out.println("Invalid choice! Please try again.");
                }

            } catch (NumberFormatException e) {
                choice = 0;
                System.out.println("Please enter a valid menu number!");
            }

        } while (choice != 7);

        sc.close();
    }
}