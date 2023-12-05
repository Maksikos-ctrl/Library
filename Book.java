public class Book extends Item implements BorrowAble
{
    protected int numberOfPages;
    
    public Book(int id, String nazov, int numberOfPages)
    {
        super(id, nazov);
        this.numberOfPages = numberOfPages;
    }
    
    public String identifikujSa()
    {
        return "Kniha - " + getNazov();
    }
    
    public boolean borrowItem(String borrower){
        if(!isAvailable())
        {
            return false;
        }
        setBorrower(borrower);
        setBorrowed(true);
        return true;
    }
    public void returnItem()
    {
        setBorrower(null);
        setBorrowed(false);
    }
    public boolean isAvailable()
    {
        return !isBorrowed();
    }
}