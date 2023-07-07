package content_20946887_LaraVidal;
import element_20946887_LaraVidal.element_20946887_LaraVidal;


import java.util.ArrayList;

/**
 * The interface Has content 20946887 lara vidal.
 */
public interface hasContent_20946887_LaraVidal {
    void setContent(ArrayList<element_20946887_LaraVidal> newContent);

    ArrayList<element_20946887_LaraVidal> getContent();
    /**
     * Add to route.
     *
     * @param element the element
     * @param route   the route
     */
    void addToRoute(ArrayList<element_20946887_LaraVidal> element, ArrayList<String> route);

    /**
     * Ren to route.
     *
     * @param oldName the old name
     * @param newName the new name
     * @param route   the route
     */
    void renToRoute(String oldName, String newName, ArrayList<String> route);

    /**
     * Del from route.
     *
     * @param pattern the pattern
     * @param route   the route
     */
    void delFromRoute(String pattern, ArrayList<String> route);

    /**
     * Gets from route.
     *
     * @param pattern the pattern
     * @param route   the route
     * @return the from route
     */
    ArrayList<element_20946887_LaraVidal> getFromRoute(String pattern, ArrayList<String> route);

    /**
     * Check route exists boolean.
     *
     * @param route the route
     * @return the boolean
     */
    boolean checkRouteExists(ArrayList<String> route);

    /**
     * Add to content.
     *
     * @param element the element
     */
    void addToContent(ArrayList<element_20946887_LaraVidal> element);

    /**
     * Remove from content.
     *
     * @param pattern the pattern
     */
    void removeFromContent(String pattern);

    /**
     * Rename from content.
     *
     * @param oldName the old name
     * @param newName the new name
     */
    void renameFromContent(String oldName, String newName);

    /**
     * Gets from content.
     *
     * @param pattern the pattern
     * @return the from content
     */
    ArrayList<element_20946887_LaraVidal> getFromContent(String pattern);

    /**
     * Gets names from content.
     *
     * @return the names from content
     */
    ArrayList<String> getNamesFromContent();

    /**
     * Dir to route.
     *
     * @param route the route
     * @param args  the args
     */
    void dirToRoute(ArrayList<String> route, ArrayList<String> args);

    /**
     * Aplicar dir al contenido.
     *
     * @param args   Argumentos para la lectura de archivos
     * @param offset offset de caracteres para el formateo
     */
    void dirContent(ArrayList<String> args, String offset);

    /**
     * Encripta hacia la ruta entregada.
     *
     * @param password la contraseña de encriptación
     * @param pattern  el patrón de archivos a encriptar
     * @param route    la ruta en la que se encripta
     */
    void encryptRoute(String password, String pattern, ArrayList<String> route);

    /**
     * Desencripta hacia la ruta entregada.
     *
     * @param password la contraseña de desencriptación
     * @param pattern  el patrón de archivos a desencriptar
     * @param route    la ruta en la que se desencripta
     */
    void decryptRoute(String password, String pattern, ArrayList<String> route);
    void encryptContent(String password, String pattern);
    void decryptContent(String password, String pattern);

    /**
     * Grep desde una ruta.
     *
     * @param phrase la frase a ser buscada
     * @param route  la ruta, incluyendo el patrón
     */
    void grepFromRoute(String phrase, ArrayList<String>route);
    
}
