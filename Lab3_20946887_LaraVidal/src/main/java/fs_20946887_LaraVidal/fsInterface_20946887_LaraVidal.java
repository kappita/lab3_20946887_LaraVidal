package fs_20946887_LaraVidal;

import file_20946887_LaraVidal.file_20946887_LaraVidal;

import java.util.ArrayList;

/**
 * La interfaz de fs.
 */
public interface fsInterface_20946887_LaraVidal {
    /**
     * Añadir drive al sistema.
     *
     * @param letter   la letra del drive
     * @param name     el nombre del drive
     * @param capacity la capacidad del drive
     */
    void addDrive(String letter, String name, int capacity);

    /**
     * Registrar usuario en el sistema
     *
     * @param name el nombre del usuario
     */
    void register(String name);

    /**
     * Iniciar sesión en el sistema
     *
     * @param name el nombre del usuario a iniciar sesión
     */
    void login(String name);

    /**
     * Cerrar sesión actual en el sistema
     */
    void logout();

    /**
     * Cambiar de drive en el sistema
     *
     * @param letter la letra del drive a cambiar
     */
    void switchDrive(String letter);

    /**
     * Crear carpeta en el sistema
     *
     * @param name el nombre de la carpeta
     */
    void mkdir(String name);

    /**
     * Cambiar directorio
     *
     * @param path La ruta objetivo
     */
    void cd(String path);

    /**
     * Agregar archivo al sistema. Puede ser archivo de texto, fuente o documento
     *
     * @param file el archivo
     */
    void addFile (file_20946887_LaraVidal file);

    /**
     * Eliminar archivos dentro del sistema
     *
     * @param pattern el patrón de nombre de los archivos
     */
    void del (String pattern);

    /**
     * Copiar archivos dentro del sistema.
     *
     * @param pattern el patrón de nombre de los archivos
     * @param target  la ruta objetivo pora los archivos
     */
    void copy (String pattern, String target);

    /**
     * Mover archivos dentro del sistema.
     *
     * @param pattern el patrón de nombre de los archivos
     * @param target  la ruta objetivo pora los archivos
     */
    void move (String pattern, String target);

    /**
     * Renombrar un archivo en el sistema.
     *
     * @param oldName el nombre previo del archivo/carpeta
     * @param newName el nuevo nombre para el archivo/carpeta
     */
    void ren (String oldName, String newName);

    /**
     * Mostrar los contenidos de la ruta actual
     *
     * @param args los argumentos para la muestra de archivos
     */
    void dir (ArrayList<String> args);

    /**
     * Formatear un drive del sistema
     *
     * @param letter  la letra del drive a formatear
     * @param newName el nuevo nombre para el drive
     */
    void format(String letter, String newName);

    /**
     * Encriptar archivos dentro del sistema
     *
     * @param password la contraseña para la encriptación
     * @param pattern  el patrón de nombre de los archivos
     */
    void encrypt(String password, String pattern);

    /**
     * Desencriptar archivos dentro del sistema
     *
     * @param password contraseña para la desencriptación
     * @param pattern  el patrón de nombre de los archivos
     */
    void decrypt(String password, String pattern);

    /**
     * Buscar texto dentro de los archivos
     *
     * @param pattern el patrón de texto a buscar
     * @param path    la ruta objetivo en la que buscar
     */
    void grep(String pattern, String path);

    /**
     * Ver la basura en la papelera del sistema
     */
    void viewTrash();

    /**
     * Restaurar elementos de la papelera
     *
     * @param pattern el patrón de nombre de los archivos a restaurar
     */
    void restore(String pattern);

}
