package database.dataAcessObjects;

import java.util.ArrayList;

public interface IBestellungPositionMerkmal {
    database.beans.IBestellungPositionMerkmal readFuerBestellungPosition(int identifier);
    database.beans.IBestellungPositionMerkmal read(int identifier);
}
