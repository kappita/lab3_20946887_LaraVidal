package element_20946887_LaraVidal;

/**
 * The interface Element interface 20946887 lara vidal.
 */
public interface elementInterface_20946887_LaraVidal {
    /**
     * Obtiene el nombre
     *
     * @return the name
     */
    String getName();
    /**
     * Cambia el nombre
     *
     * @param name the name
     */
    void setName(String name);
    /**
     * Cambia la passkey
     *
     * @param passkey la passkey
     */
    void setPasskey(int passkey);

    /**
     * Gets creation date.
     *
     * @return the creation date
     */
    Date getCreationDate();
    /**
     * Cambia la fecha de modificación
     */
    void setModificationDate();

    /**
     * Encripta parcialmente el elemento
     *
     * @param password la contraseña para la encriptación
     */
    void partialEncrypt(String password);


    /**
     * Encripta completamente un elemento
     *
     * @param password la contraseña para la encriptación
     */
    void fullEncrypt(String password);

    /**
     * Desencripta parcialmente un elemento
     *
     * @param password la contraseña para la encriptación
     */
    void partialDecrypt(String password);

    /**
     * Desencripta completamente un elemento
     *
     * @param password la contraseña para la desencriptación
     */
    void fullDecrypt(String password);
    /**
     * Name matches boolean.
     *
     * @param pattern the pattern
     * @return the boolean
     */
    boolean nameMatches(String pattern);
}
