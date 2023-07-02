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
     * Gets content.
     *
     * @return the content
     */
    public String getContent() {
        return this.content;
    }

    /**
     * Sets content.
     *
     * @param newContent the new content
     */
    public void setContent(String newContent) {
        this.content = newContent;
        this.setModificationDate();
    }

    /**
     * Grep.
     *
     * @param phrase the phrase
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
