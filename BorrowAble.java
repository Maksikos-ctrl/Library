public interface BorrowAble {

    boolean borrowItem(String borrower);
    void returnItem();
    boolean isAvailable();
    Object getBorrower();
    String getNazov();
    String getPocetStranAleboFilmov();
    
}
