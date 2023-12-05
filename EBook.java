import java.util.Random;




public class EBook extends Book {
    
    private int numberOfPreviewPages;
    private int[] previewPages;


    public EBook(int id, String nazov, int numberOfPages, int numberOfPreviewPages, int[] previewPages) {

        super(id, nazov, numberOfPages);
        setNumberOfPreviewPages(numberOfPreviewPages);
        setPreviewPages(previewPages);
       

    }

    public String identifikujSa() {

        return "EBook - " + getNazov();

    }

    public boolean borrowItem(String borrower) {

        if (!isAvailable()) {
            return false;
        }

        setBorrower(borrower);

        setBorrowed(true);

        return true;

    }


    public void returnItem() {

        setBorrower(null);
        setBorrowed(false);

    }


    public boolean isAvailable() {

        return !isBorrowed();

    }

    public int getNumberOfPreviewPages() {

        return numberOfPreviewPages;

    }

    public void setNumberOfPreviewPages(int numberOfPreviewPages) {

        this.numberOfPreviewPages = numberOfPreviewPages;

    }

    public int[] getPreviewPages() {

        return previewPages;

    } 
    
    public void setPreviewPages(int[] previewPages) {

        this.previewPages = previewPages;

    }

    public int[] setRandomPreviewPages() {
        Random random = new Random();
        int[] randomPreviewPages = new int[numberOfPreviewPages];

        for (int i = 0; i < numberOfPreviewPages; i++) {

            randomPreviewPages[i] = random.nextInt(numberOfPages) + 1;
        }

        return randomPreviewPages;
    }


   
}
