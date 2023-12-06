import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Library implements Serializable
{
    private Item[] poleItemov;
    private String nazov;
   
    
    public Library(String nazov, int dlzka)
    {
        this.nazov = nazov;
        poleItemov = new Item[dlzka];
    }
    
       
    public boolean borrowItem(String borrower, String nazov) {
        for (Item item : poleItemov) {
            if (item.getNazov().equals(nazov)) {
                if (item instanceof Book) {
                    ((Book) item).borrowItem(borrower);
                    return true;
                } else if (item instanceof EBook) {
                    ((EBook) item).borrowItem(borrower);
                    return true;
                } else if (item instanceof Newspapers) {
                    System.out.println("Newspapers cannot be borrowed.");
                    return false;
                } else {
                    System.out.println("Unrecognized item type: " + item.getNazov());
                    return false;
                }
            }
        }
        return false;
    }
    
    
    public Movie[] getAllMovies()
    {
       
        List<Movie> movies = new ArrayList<>();
        for (Item item : poleItemov) {
            if (item instanceof Movie) {
                movies.add((Movie) item);
            }
        }
        return movies.toArray(new Movie[0]);

    }    



  
    public void addingItem(Item item) {
        for (int i = 0; i < poleItemov.length; i++) {
            if (poleItemov[i] == null) {
                poleItemov[i] = item;
                break;
            }
        }
    }


    public void removingItem(Item item) {

        for (int i = 0; i < poleItemov.length; i++) {
            if (poleItemov[i] != null && poleItemov[i].getNazov().equals(item)) {
                poleItemov[i] = null;
                break;
            }
        }


    }

  
    public Item[] getBorrowableItems() {
        List<Item> borrowableItems = new ArrayList<>();
        for (Item item : poleItemov) {
            if (item instanceof BorrowAble) {
                borrowableItems.add(item);
            }
        }
        return borrowableItems.toArray(new Item[0]);
    }


    public void printHistory() {
        for (Item item : poleItemov) {
            if (item instanceof BorrowAble) {
                BorrowAble borrowableItem = (BorrowAble) item;
                if (borrowableItem.getBorrower() != null) {
                    System.out.println(borrowableItem.getNazov() + " was borrowed by " + borrowableItem.getBorrower());
                }
            }
        }
    }


    public void printBorrowedItems() {
        for (Item item : poleItemov) {
            if (item instanceof BorrowAble) {
                BorrowAble borrowableItem = (BorrowAble) item;
                if (borrowableItem.isAvailable()) {
                    System.out.println(borrowableItem.getNazov() + " is available" + "with " + borrowableItem.getPocetStranAleboFilmov() + " pages || filmov");
                } else {
                    System.out.println(borrowableItem.getNazov() + " is not available");
                }
            }
        }
    }


    public List<Item> getAvailableItems() {
        List<Item> availableItems = new ArrayList<>();
        for (Item item : poleItemov) {
            if (item instanceof BorrowAble) {
                BorrowAble borrowableItem = (BorrowAble) item;
                if (borrowableItem.isAvailable()) {
                    availableItems.add(item);
                }
            }
        }
        return availableItems;
    }


    
   


   


}