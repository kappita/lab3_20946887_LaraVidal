package file_20946887_LaraVidal;
import element_20946887_LaraVidal.element_20946887_LaraVidal;


/**
 * El tipo archivo
 */
public class file_20946887_LaraVidal extends element_20946887_LaraVidal {
    /**
     * El contenido del archivo.
     */
    String content;


    /**
     * Instancia un nuevo archivo.
     *
     * @param name    el nombre del archivo
     * @param content el contenido del archivo
     */
    public file_20946887_LaraVidal(String name, String content) {
        super(name);
        this.content = content;

    }

    /**
     * Obtiene el contenido del archivo.
     *
     * @return el contenido
     */
    public String getContent() {
        return this.content;
    }

    /**
     * Cambia el contenido del archivo
     *
     * @param newContent el nuevo contenido
     */
    public void setContent(String newContent) {
        this.content = newContent;
        this.setModificationDate();
    }

    /**
     * Grep en el contenido del archivo.
     *
     * @param phrase la frase a buscar
     */
    public void grep(String phrase) {
        char[] chars = this.getContent().toCharArray();
        char[] phraseChars = phrase.toCharArray();
        boolean match;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == phraseChars[0]) {
                match = true;
                for (int j = 1; j < phraseChars.length; j++) {
                    if (chars[i+j] != phraseChars[j]) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    // Por algún motivo printf modifica el valor de i
                    System.out.println("Ocurrencia encontrada en la posición [" + i + " " + (i+phraseChars.length-1) + "]");
                }

            }
        }
    }
}
