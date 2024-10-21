package emailapp;
public class EmailApplication {
    public static void main(String[] args) {
        Email email1 = new Email("Jack", "Jackson");
        System.out.println(email1.showInfo());

        Email email2 = new Email("John", "Johnson");
        System.out.println(email2.showInfo());

        Email email3 = new Email("Emma", "Emmerson");
        System.out.println(email3.showInfo());

        Email email4 = new Email("Roberta", "Robertason");
        System.out.println(email4.showInfo());

        email4.changeDepartment("acc");
        System.out.println(email4.showInfo());

        email4.changePassword("qwert");
        System.out.println(email4.showInfo());

    }
}