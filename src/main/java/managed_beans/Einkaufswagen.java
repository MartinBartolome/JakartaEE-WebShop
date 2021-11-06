package managed_beans;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.util.logging.Logger;

@Named
@RequestScoped
public class Einkaufswagen  extends ManagedBean {
    private static final long serialVersionUID = 10L;
    private static final Logger log = Logger.getLogger(Einkaufswagen.class.toString());
}
