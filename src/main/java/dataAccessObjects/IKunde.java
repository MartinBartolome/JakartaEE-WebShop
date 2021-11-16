package dataAccessObjects;

public interface IKunde {
    int get(beans.IAnmeldeDaten anmeldeDaten);
    void insert(beans.IKunde kunde);
    void update(beans.IKunde kunde);
    beans.IKunde get(int kundeIdentifier);
}
