package database.beans;

public class SessionSettings implements ISessionSettings {
    @Override
    public String getSessionIdentifier() {
        return null;
    }

    @Override
    public void setSessionIdentifier(final String sessionIdentifier) {

    }

    @Override
    public int getKundeIdentifier() {
        return 0;
    }

    @Override
    public void setKundeIdentifier(final int identifier) {

    }
}
