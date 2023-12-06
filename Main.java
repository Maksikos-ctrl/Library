import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class Main {
    private static Scanner scanner;

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {

       

        Library library = null;
        File libraryDataFile = new File("libraryData.dat");

        if (libraryDataFile.exists()) {
        
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(libraryDataFile));
            library = (Library) ois.readObject();
            ois.close();
        } else {
            
            library = new Library("My Library", 10);
        }
        
    
        



        try (Scanner scanner = new Scanner(System.in)) {
            do {
                System.out.println("1. Add Book");
                System.out.println("2. Add EBook");
                System.out.println("3. Add Newspaper");
                System.out.println("4. Add borrowings: ");
                System.out.println("5. History of borrowings: ");
                System.out.println("6. Saved items: ");
                System.out.println("7. Load saved data: ");
                System.out.println("8. Exit and Save");

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
                        addBorrowedItem(scanner, library);
                        break;
                    case 5:
                        library.printHistory();
                        break;
                    case 6:
                        library.printBorrowedItems();
                        break;
                    case 7:
                        if (libraryDataFile.exists()) {
                            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(libraryDataFile))) {
                                library = (Library) ois.readObject();
                                ois.close();
                                System.out.println("Data loaded successfully.");

                                
                                System.out.println("Loaded data:");
                                library.printBorrowedItems();
                            } catch (Exception e) {
                                System.out.println("Error loading data: " + e.getMessage());
                            }
                        } else {
                            System.out.println("No saved data found.");
                        }
                        break;

                    case 8:
                        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(libraryDataFile))) {
                            oos.writeObject(library);
                            oos.close();
                            System.out.println("Data saved successfully.");
                        } catch (Exception e) {
                            System.out.println("Error saving data: " + e.getMessage());
                        }
                        System.exit(0);
                        
                          
                        
                    default:
                        System.out.println("Wrong choice. Please enter a valid option (1-4).");
                }
            } while (true);
        }
    }

    private static void addBorrowedItem(Scanner scanner2, Library library) {
        try {
            System.out.print("Enter borrower name: ");
            String borrower = scanner2.next();

       
            List<Item> availableItems = library.getAvailableItems();
            for (int i = 0; i < availableItems.size(); i++) {
                Item item = availableItems.get(i);
                System.out.println(i + 1 + ". " + item.getNazov());
            }

            
            System.out.print("Select the item to borrow (enter the number): ");
            int choice = scanner2.nextInt();

      
            if (choice <= 0 || choice > availableItems.size()) {
                System.out.println("Invalid choice. Please enter a valid option.");
                return;
            }

            
            Item selectedItem = availableItems.get(choice - 1);
            library.borrowItem(borrower, selectedItem.getNazov());
        } catch (Exception e) {
            System.out.println("Wrong input. Please try again.");
        }
    }

    private static void addBook(Scanner scanner, Library library) {
        try {
            System.out.print("Enter book title: ");
            String title = scanner.next();

            System.out.print("Enter number of pages: ");
            int numberOfPages = scanner.nextInt();

            library.addingItem(new Book(1, title, numberOfPages));
        } catch (Exception e) {
            System.out.println("Wrong input. Please try again.");
        }
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

