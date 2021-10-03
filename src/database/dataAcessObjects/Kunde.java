package database.dataAcessObjects;

public class Kunde implements IKunde {
    @Override
    public database.beans.IKunde read(int identifier) {
        return null;
    }

    @Override
    public database.beans.IKunde read(String eMailAdresse) {
        return null;
    }

    @Override
    public void overwrite(database.beans.IKunde kunde) {

    }

    @Override
    public void write(database.beans.IKunde kunde) {

    }
}
