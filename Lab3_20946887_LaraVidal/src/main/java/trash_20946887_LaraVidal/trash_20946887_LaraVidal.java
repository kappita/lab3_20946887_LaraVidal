package trash_20946887_LaraVidal;

import java.util.ArrayList;
import element_20946887_LaraVidal.element_20946887_LaraVidal;

/**
 * El tipo basura, para la papelera.
 */
public class trash_20946887_LaraVidal {
    /**
     * El elemento que se manda a la papelera
     */
    element_20946887_LaraVidal element;
    /**
     * La ruta en la que se encontraba el elemento
     */
    ArrayList<String> route;

    /**
     * Instancia una basura.
     *
     * @param element el elemento
     * @param route   la ruta
     */
    public trash_20946887_LaraVidal(element_20946887_LaraVidal element, ArrayList<String> route) {
        this.element = element;
        this.route = route;
    }

    /**
     * Obtiene el elemento de la basura
     *
     * @return el elemento
     */
    public element_20946887_LaraVidal getElement() {
        return this.element;
    }

    /**
     * Obtiene la ruta de la basura
     *
     * @return la ruta
     */
    public ArrayList<String> getRoute() {
        return new ArrayList<>(this.route);
    }
}
