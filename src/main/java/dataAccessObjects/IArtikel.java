package dataAccessObjects;

import java.util.List;

public interface IArtikel {
    List<beans.IArtikel> get(int sprache);
    beans.IArtikel get(int identifier, int sprache);
}
