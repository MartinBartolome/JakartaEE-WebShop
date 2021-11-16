package dataAccessObjects;

import beans.IMerkmal;
import entities.GruppeMerkmal;
import java.util.List;
import java.util.Map;

public interface IMerkmale {
    List<GruppeMerkmal> getSprachen();
    Map<String, IMerkmal> getMerkmaleFuerKonfiguration(int artikelIdentifier, int sprache);
    Map<String, IMerkmal> getMerkmaleFuerKalkulation(int artikelIdentifier, int sprache);
    List<IMerkmal> getMerkmaleFuerInformation(int artikelIdentifier, int sprache);
    Map<String, IMerkmal> getMerkmaleFuerKalkulation(int sprache);
}
