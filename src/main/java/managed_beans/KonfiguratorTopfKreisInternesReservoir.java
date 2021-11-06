package managed_beans;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.util.logging.Logger;

@Named
@RequestScoped
public class KonfiguratorTopfKreisInternesReservoir extends ManagedBean {
    private static final long serialVersionUID = 19L;
    private static final Logger log = Logger.getLogger(KonfiguratorTopfKreisInternesReservoir.class.toString());
}
