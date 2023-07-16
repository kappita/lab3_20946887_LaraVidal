package content_20946887_LaraVidal;
import element_20946887_LaraVidal.element_20946887_LaraVidal;


import java.util.ArrayList;

/**
 * Interface hasContent
 */
public interface hasContent_20946887_LaraVidal {
    /**
     * Agrega elementos a la ruta
     *
     * @param element los elementos
     * @param route   la ruta destino
     */
    void addToRoute(ArrayList<element_20946887_LaraVidal> elements, ArrayList<String> route);

    /**
     * Renombra un elemento en la ruta.
     *
     * @param oldName el nombre original
     * @param newName el nuevo nombre
     * @param route   la ruta destino
     */
    void renToRoute(String oldName, String newName, ArrayList<String> route);

    /**
     * Elimina elementos en la ruta.
     *
     * @param pattern patrón de nombre
     * @param route   la ruta destino
     */
    void delFromRoute(String pattern, ArrayList<String> route);

    /**
     * Obtiene elementos de la ruta entregada
     *
     * @param pattern patrón de nombre
     * @param route   la ruta destino
     * @return los elementos de la ruta
     */
    ArrayList<element_20946887_LaraVidal> getFromRoute(String pattern, ArrayList<String> route);

    /**
     * Revisa si la ruta existe
     *
     * @param route la ruta destino
     * @return el resultado
     */
    boolean checkRouteExists(ArrayList<String> route);

    /**
     * Agrega al contenido
     *
     * @param element the element
     */
    void addToContent(ArrayList<element_20946887_LaraVidal> element);

    /**
     * Elimina del contenido
     *
     * @param pattern patrón de nombre
     */
    void removeFromContent(String pattern);

    /**
     * Renombra un elemento del contenido
     *
     * @param oldName el nombre original
     * @param newName el nuevo nombre
     */
    void renameFromContent(String oldName, String newName);

    /**
     * Obtiene elementos del contenido
     *
     * @param pattern el patrón del nombre
     * @return los elementos del contenido
     */
    ArrayList<element_20946887_LaraVidal> getFromContent(String pattern);

    /**
     * Obtiene los nombres de los elementos del contenido
     *
     * @return los nombres
     */
    ArrayList<String> getNamesFromContent();

    /**
     * Grep hacia la ruta.
     *
     * @param phrase la frase a buscar
     * @param route  la ruta destino
     */
    void grepFromRoute(String phrase, ArrayList<String>route);

    /**
     * Encriptar hacia la ruta.
     *
     * @param password la contraseña
     * @param pattern  el patrón
     * @param route    la ruta destino
     */
    void encryptRoute(String password, String pattern, ArrayList<String> route);

    /**
     * Encriptar el contenido
     *
     * @param password la contraseña
     * @param pattern  el patrón
     
     */
    void encryptContent(String password, String pattern);

    /**
     * Desencriptar hacia la ruta
     *
     * @param password la contraseña
     * @param pattern  el patrón
     * @param route    la ruta destino
     */
    void decryptRoute(String password, String pattern, ArrayList<String> route);

    /**
     * Desencriptar el contenido
     *
     * @param password la contraseña
     * @param pattern  el patrón
     * @param route    la ruta destino
     */
    void decryptContent(String password, String pattern);

    /**
     * Dir hacia la ruta.
     *
     * @param route la ruta de destino
     * @param args  los argumentos
     */
    void dirToRoute(ArrayList<String> route, ArrayList<String> args);

    /**
     * Dir en el contenido
     *
     * @param args  los argumentos
     * @param offset el offset para la impresión
     */
    void dirContent(ArrayList<String> args, String offset);

}
