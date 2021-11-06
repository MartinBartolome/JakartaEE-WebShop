package managed_beans;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.util.logging.Logger;

@Named
@RequestScoped
public class KonfiguratorTopfQuadratInternesReservoir extends ManagedBean {
    private static final long serialVersionUID = 21L;
    private static final Logger log = Logger.getLogger(KonfiguratorTopfQuadratInternesReservoir.class.toString());
}
