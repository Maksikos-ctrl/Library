public abstract class Item {
    private int id;
    private String nazov;
    private boolean borrowed;
    private String borrower; 
    
    public Item(int id, String nazov) {
        this.id = id;
        this.nazov = nazov;
        this.borrowed = false; 
        this.borrower = null; 
    }
    
    public int getId() {
        return id;
    }
    
    public String getNazov() {
        return nazov;
    }
    
    public void setNazov(String nazov) {
        this.nazov = nazov;
    }
    
    public boolean isBorrowed() {
        return borrowed;
    }
    
    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }
    
    public String getBorrower() {
        return borrower;
    }
    
    public void setBorrower(String borrower) {
        this.borrower = borrower;
    }
    
    public abstract String identifikujSa();


}




