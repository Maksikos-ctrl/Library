import java.util.ArrayList;
import java.util.List;

public class Library
{
    private Item[] poleItemov;
    private String nazov;
   
    
    public Library(String nazov, int dlzka)
    {
        this.nazov = nazov;
        poleItemov = new Item[dlzka];
    }
    
       
    public boolean borrowItem(String borrower, String nazov)
    {
        for(int i = 0; i < poleItemov.length; i++)
        {
            if(poleItemov[i].getNazov().equals(nazov))
            {
                if(poleItemov[i] instanceof BorrowAble)
                {
                    BorrowAble b = (BorrowAble) poleItemov[i];
                    b.borrowItem(borrower);
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
                    System.out.println(borrowableItem.getNazov() + " is available");
                } else {
                    System.out.println(borrowableItem.getNazov() + " is not available");
                }
            }
        }
    }



}