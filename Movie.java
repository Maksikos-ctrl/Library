class Movie extends Item implements BorrowAble {
    private double movieLength;

    public Movie(double movieLength, int id, String nazov, String borrower) {
        super(id, nazov);
        this.movieLength = movieLength;
    }

    public String identifikujSa() {
        return "Movie - " + getNazov();
    }

    public void returnItem() {
        setBorrowed(false);
        setBorrower(null);
    }

    public boolean borrowItem(String borrower) {
        if (!isBorrowed()) {
            setBorrowed(true);
            setBorrower(borrower);
            return true;
        } else {
            return false;
        }
    }
    

    public boolean isAvailable() {
        return !isBorrowed();
    }
}