public class Newspapers extends Item {
   

    private int weekNumber;

    public Newspapers(int weekNumber, int id, String nazov) {
        super(id, nazov);
        this.weekNumber = weekNumber;
    }

    @Override
    public String identifikujSa() {
        return "Newspapers - " + getNazov();
    }
}