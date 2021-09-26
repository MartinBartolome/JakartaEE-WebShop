package database.beans;

public class Gruppe implements IGruppe {
    private int identifier;
    private String kommentar;

    @Override
    public int GetIdentifier() {
        return this.identifier;
    }

    @Override
    public void SetIdentifier(int identifier) {
        this.identifier = this.identifier;
    }

    @Override
    public String GetKommentar() {
        return this.kommentar;
    }

    @Override
    public void SetKommentar(String kommentar) {
        this.kommentar = this.kommentar;
    }
}
