package managed_beans;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.util.logging.Logger;

@Named
@RequestScoped
public class AktivierungsCodeEingeben extends ManagedBean {
    private static final long serialVersionUID = 2L;
    private static final Logger logger = Logger.getLogger(AktivierungsCodeEingeben.class.toString());
}
