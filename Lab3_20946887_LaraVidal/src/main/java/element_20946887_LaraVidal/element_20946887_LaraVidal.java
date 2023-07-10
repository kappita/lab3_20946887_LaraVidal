package element_20946887_LaraVidal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import file_20946887_LaraVidal.file_20946887_LaraVidal;
import folder_20946887_LaraVidal.folder_20946887_LaraVidal;

public class element_20946887_LaraVidal implements elementInterface_20946887_LaraVidal{
    /**
     * The Name.
     */
    protected String name;
    /**
     * The Creation date.
     */
    Date creationDate;
    /**
     * The Modification date.
     */
    Date modificationDate;
    /**
     * The Passkey.
     */
    int passkey;

    /**
     * Instantiates a new Element 20946887 lara vidal.
     *
     * @param name the name
     */
    public element_20946887_LaraVidal(String name) {
        this.name = name;
        this.creationDate = new Date();
        this.modificationDate = new Date();
        this.passkey = 0;
    }


    public String getName() {
        return this.name;
    }


    public void setName(String name) {
        this.name = name;
        this.setModificationDate();
    }


    public int getPasskey() {
        return this.passkey;
    }

    public void setPasskey(int passkey) {
        this.passkey = passkey;
        this.setModificationDate();
    }

    public void setModificationDate() {
        this.modificationDate = new Date();
    }

    /**
     * Name matches boolean.
     *
     * @param pattern the pattern
     * @return the boolean
     */
    public boolean nameMatches(String pattern) {
        if (pattern.equals("*")) {
            return true;
        }
        if (this instanceof folder_20946887_LaraVidal) {
            return matchStrings(this.name, pattern);
        }
        String[] nameParts = this.name.split("\\.");
        String[] patternParts = pattern.split("\\.");
        if (patternParts.length < 2) {
            return false;
        }
        return matchStrings(nameParts[nameParts.length - 1], patternParts[patternParts.length - 1]) &&
                matchStrings(nameParts[nameParts.length - 2], patternParts[patternParts.length - 2]);

    }

    public void partialEncrypt(String password) {
        this.setPasskey(this.getPasskeyFromString(password));
        if (this instanceof folder_20946887_LaraVidal) {
            ArrayList<element_20946887_LaraVidal> content = ((folder_20946887_LaraVidal) this).getContent();
            for (element_20946887_LaraVidal element: content) {
                element.fullEncrypt(password);
            }
            ((folder_20946887_LaraVidal) this).setContent(content);
            return;
        }

        ((file_20946887_LaraVidal) this).setContent(this.encryptString(((file_20946887_LaraVidal)this).getContent(), this.getEncryptionValue(password)));


    }
    public void fullEncrypt(String password) {
        this.setPasskey(this.getPasskeyFromString(password));
        this.setName(this.encryptString(this.getName(), this.getEncryptionValue(password)));
        if (this.getClass() == folder_20946887_LaraVidal.class) {
            ArrayList<element_20946887_LaraVidal> content = ((folder_20946887_LaraVidal) this).getContent();
            for (element_20946887_LaraVidal element: content) {
                element.fullEncrypt(password);
            }
            ((folder_20946887_LaraVidal) this).setContent(content);
            return;
        }
        ((file_20946887_LaraVidal) this).setContent(this.encryptString(((file_20946887_LaraVidal)this).getContent(), this.getEncryptionValue(password)));
    }

    /**
     * Partial decrypt.
     *
     * @param password the password
     */
    public void partialDecrypt(String password) {
        if (!(this.getPasskeyFromString(password) == this.passkey)) {
            System.out.println("Error al desencriptar: contraseña incorrecta");
            return;
        }

        if (this instanceof folder_20946887_LaraVidal) {
            ArrayList<element_20946887_LaraVidal> content = ((folder_20946887_LaraVidal) this).getContent();
            for (element_20946887_LaraVidal element: content) {
                element.fullDecrypt(password);
            }
            ((folder_20946887_LaraVidal) this).setContent(content);
            return;
        }

        ((file_20946887_LaraVidal) this).setContent(this.decryptString(((file_20946887_LaraVidal)this).getContent(), this.getEncryptionValue(password)));
    }

    private void fullDecrypt(String password) {
        this.setName(this.decryptString(this.getName(), this.getEncryptionValue(password)));
        if (this.getClass() == folder_20946887_LaraVidal.class) {
            ArrayList<element_20946887_LaraVidal> content = ((folder_20946887_LaraVidal) this).getContent();
            for (element_20946887_LaraVidal element: content) {
                element.fullDecrypt(password);
            }
            ((folder_20946887_LaraVidal) this).setContent(content);
            return;
        }
        ((file_20946887_LaraVidal) this).setContent(this.decryptString(((file_20946887_LaraVidal)this).getContent(), this.getEncryptionValue(password)));
    }

    private boolean matchStrings(String firstWord, String secondWord) {
        char[] firstChars = firstWord.toCharArray();
        char[] secondChars = secondWord.toCharArray();
        int i = 0;
        if (secondChars.length > firstChars.length) {
            return false;
        }
        while (i < secondChars.length) {
            if (secondChars[i] == '*') {
                return true;
            }
            if (secondChars[i] != firstChars[i]) {
                return false;
            }
            i++;
        }
        return true;
    }

    private int getPasskeyFromString(String word) {
        int total = 0;
        char[] characters = word.toCharArray();
        for (char character: characters) {
            total = total + (int) character;
        }
        return total;
    }

    private int getEncryptionValue(String password) {
        int total = 0;
        char[] characters = password.toCharArray();
        for (char character: characters) {
            total += (int) character;
        }
        return total % 5;
    }

    private String encryptString(String word, int value) {
        char[] characters = word.toCharArray();
        for (int i = 0; i < characters.length; i++) {
            characters[i] = (char)((int)characters[i] + value);
        }
        return new String(characters);
    }
    
    private String decryptString(String word, int value) {
        char[] characters = word.toCharArray();
        for (int i = 0; i < characters.length; i++) {
            characters[i] = (char)((int)characters[i] - value);
        }
        return new String(characters);
    }

}
