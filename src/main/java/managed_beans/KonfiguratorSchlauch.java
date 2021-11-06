package managed_beans;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.util.logging.Logger;

@Named
@RequestScoped
public class KonfiguratorSchlauch extends ManagedBean {
    private static final long serialVersionUID = 15L;
    private static final Logger log = Logger.getLogger(KonfiguratorSchlauch.class.toString());
}
