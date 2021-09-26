package database.dataAcessObjects;

import java.util.ArrayList;

public interface IBestellungPositionMerkmal {
    database.beans.IBestellungPositionMerkmal ReadFuerBestellungPosition(int identifier);
    database.beans.IBestellungPositionMerkmal Read(int identifier);
}
