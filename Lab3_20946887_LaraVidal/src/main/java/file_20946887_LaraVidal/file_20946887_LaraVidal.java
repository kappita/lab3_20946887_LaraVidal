package file_20946887_LaraVidal;
import element_20946887_LaraVidal.element_20946887_LaraVidal;


/**
 * The type File 20946887 lara vidal.
 */
public class file_20946887_LaraVidal extends element_20946887_LaraVidal {
    /**
     * The Content.
     */
    String content;


    /**
     * Instantiates a new File 20946887 lara vidal.
     *
     * @param name    the name
     * @param content the content
     */
    public file_20946887_LaraVidal(String name, String content) {
        super(name);
        this.content = content;

    }

    /**
     * Obtiene el contenido.
     *
     * @return the content
     */
    public String getContent() {
        return this.content;
    }

    /**
     * Modifica el contenido
     *
     * @param newContent el nuevo contenido para el archivo
     */
    public void setContent(String newContent) {
        this.content = newContent;
        this.setModificationDate();
    }
    /**
     * Grep del contenido del archivo
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
                    // Por algún motivo printf modifica el valor de i, por lo que se escogió concatenación.
                    System.out.println("Ocurrencia encontrada en la posición [" + i + " " + (i+phraseChars.length-1) + "]");
                }
            }
        }
    }
}
