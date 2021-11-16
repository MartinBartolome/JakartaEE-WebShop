package entities;

public interface ISessionSettings {
    String getSessionIdentifier();
    void setSessionIdentifier(final String sessionIdentifier);
    int getKundeIdentifier();
    void setKundeIdentifier(final int identifier);
}
