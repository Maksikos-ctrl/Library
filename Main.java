import java.util.Scanner;


public class Main {
    private static Scanner scanner;

    public static void main(String[] args) {

        Library library = new Library("My Library", 10);

        try (Scanner scanner = new Scanner(System.in)) {
            do {
                System.out.println("1. Add Book");
                System.out.println("2. Add EBook");
                System.out.println("3. Add Newspaper");
                System.out.println("4. History of borrowings: ");
                System.out.println("5. Saved items: ");
                System.out.println("6. Exit");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        addBook(scanner, library);
                        break;
                    case 2:
                        addEBook(scanner, library);
                        break;
                    case 3:
                        addNewspaper(scanner, library);
                        break;
                    case 4:
                        library.printHistory();
                        break;
                    case 5:
                        library.printBorrowedItems();
                        break;
                    case 6:
                        System.out.println("Exiting program...");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Wrong choice. Please enter a valid option (1-4).");
                }
            } while (true);
        }
    }

    private static void addBook(Scanner scanner, Library library) {
        System.out.print("Enter book title: ");
        String title = scanner.next();

        System.out.print("Enter number of pages: ");
        int numberOfPages = scanner.nextInt();

        library.addingItem(new Book(1, title, numberOfPages));
    }

    private static void addEBook(Scanner scanner, Library library) {
        System.out.print("Enter ebook title: ");
        String title = scanner.next();

        System.out.print("Enter number of pages: ");
        int numberOfPages = scanner.nextInt();

        System.out.print("Enter number of preview pages: ");
        int numberOfPreviewPages = scanner.nextInt();

        int[] previewPages = new int[numberOfPreviewPages];
        for (int i = 0; i < numberOfPreviewPages; i++) {
            System.out.print("Enter preview page " + (i + 1) + ": ");
            previewPages[i] = scanner.nextInt();
        }

        library.addingItem(new EBook(2, title, numberOfPages, numberOfPreviewPages, previewPages));
    }

    private static void addNewspaper(Scanner scanner, Library library) {
        System.out.print("Enter newspaper name: ");
        String name = scanner.next();

        System.out.print("Enter number of copies: ");
        int numberOfCopies = scanner.nextInt();

        library.addingItem(new Newspapers(3, numberOfCopies, name));
    }
}

