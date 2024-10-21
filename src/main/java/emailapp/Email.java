package emailapp;

import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private int mailboxCapacity = 500;
    private final int DEFAULT_PASSWORD_LENGTH = 10;
    private String alternateEmail;
    private String email;
    private String companySuffix = "company.com";

    public Email(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;

        // Call a method asking for the department - return the department
        this.department = setDepartment();

        // Call a method that returns a random password
        this.password = randomPassword(DEFAULT_PASSWORD_LENGTH);
        //System.out.println("Your password is: " + this.password);

        // combine elements to create email
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;


    }
    // Ask for department
    private String setDepartment() {
        boolean isGood = false;
        String department = "";

        do {
            System.out.print("\nNew Worker: " + firstName + " \nDEPARTMENT CODES: \n1 for Sales\n2 for Development\n3 for Accounting\n0 for None\n\nEnter Department Code: ");
            Scanner scanner = new Scanner(System.in);

            if (scanner.hasNextInt()) {
                int departmentChoice = scanner.nextInt();
                if (departmentChoice == 1 || departmentChoice == 2 || departmentChoice == 3 || departmentChoice == 0) {
                    isGood = true;
                    switch (departmentChoice) {
                        case 1:
                            department = "sales";
                            break;
                        case 2:
                            department = "dev";
                            break;
                        case 3:
                            department = "acc";
                            break;
                        case 0:
                            department = "";
                            break;
                    }
                } else {
                    System.out.println("Please enter a valid response. Try again.\n");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
        } while (!isGood);

        return department;

    }

    // Generate a random password
    private String randomPassword(int length) {
        String passwordSet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!\"£$%^&*()@#?/\\\'";
        char[] password = new char[length];
        for (int i = 0; i < length; i++){
            int random = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(random);
        }
        return new String(password);
    }

    // Set the mailbox capacity
    public void setMailboxCapacity(int capacity){
    this.mailboxCapacity = capacity;
    }

    // Set alternate email
    public void setAlternateEmail(String altEmail){
        this.alternateEmail = altEmail;
    }

    // change password
    public void changePassword(String password){
        boolean confirmedChange = false;
        do {
            if (password.length() >= DEFAULT_PASSWORD_LENGTH) {
                this.password = password;
                confirmedChange = true;

            } else {
                System.out.println("Password must be a minimum of 10 characters. Try again.");
                Scanner scanner = new Scanner(System.in);
                password = scanner.nextLine();
                if (password.length() >= DEFAULT_PASSWORD_LENGTH) {
                    this.password = password;
                    confirmedChange = true;
                }


            }

        }while (!confirmedChange);
        System.out.println("Password successfully changed.");
    }
    public void changeDepartment(String department){
        this.department = department;
        this.email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
    }
    public int getMailboxCapacity(){
        return mailboxCapacity;
    }
    public String getAlternateEmail(){
        return alternateEmail;
    }
    public String getPassword(){
        return password;
    }
    public String showInfo() {
        return "Display Name: " + firstName + " " + lastName +
                "\nCompany Email: " + email +
                "\nMailbox Capacity: " + mailboxCapacity + "mb" +
                "\nPassword: " + password;
    }
}
