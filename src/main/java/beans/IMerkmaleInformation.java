package beans;

import java.util.List;

public interface IMerkmaleInformation {
    void setMerkmale(List<IMerkmal> merkmale);
    List<IMerkmal> getMerkmale();
}
