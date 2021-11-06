package managed_beans;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.util.logging.Logger;

@Named
@RequestScoped
public class KonfiguratorTopfDreieckInternesReservoir extends ManagedBean {
    private static final long serialVersionUID = 17L;
    private static final Logger log = Logger.getLogger(KonfiguratorTopfDreieckInternesReservoir.class.toString());
}
