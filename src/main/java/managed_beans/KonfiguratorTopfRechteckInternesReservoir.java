package managed_beans;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.util.logging.Logger;

@Named
@RequestScoped
public class KonfiguratorTopfRechteckInternesReservoir extends ManagedBean {
    private static final long serialVersionUID = 23L;
    private static final Logger log = Logger.getLogger(KonfiguratorTopfRechteckInternesReservoir.class.toString());
}
