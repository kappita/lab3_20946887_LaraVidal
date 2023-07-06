package drive_20946887_LaraVidal;
import content_20946887_LaraVidal.hasContent_20946887_LaraVidal;
import content_20946887_LaraVidal.content_20946887_LaraVidal;
import element_20946887_LaraVidal.element_20946887_LaraVidal;
import folder_20946887_LaraVidal.folder_20946887_LaraVidal;
import file_20946887_LaraVidal.file_20946887_LaraVidal;

import java.util.ArrayList;

import java.util.Comparator;


/**
 * The type Drive 20946887 lara vidal.
 */
public class drive_20946887_LaraVidal extends content_20946887_LaraVidal implements hasContent_20946887_LaraVidal{
    /**
     * The Letter.
     */
    String letter;
    /**
     * The Name.
     */
    String name;
    /**
     * The Capacity.
     */
    int capacity;


    /**
     * Instantiates a new Drive 20946887 lara vidal.
     *
     * @param letter   the letter
     * @param name     the name
     * @param capacity the capacity
     */
    public drive_20946887_LaraVidal(String letter, String name, Integer capacity) {
        super();
        this.letter = letter;
        this.name = name;
        this.capacity = capacity;
    }

    /**
     * Gets letter.
     *
     * @return the letter
     */
    public String getLetter() {
        return letter;
    }


    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }


    /**
     * Gets content.
     *
     * @return the content
     */
    public ArrayList<element_20946887_LaraVidal> getContent() {
        return content;
    }

    /**
     * Sets content.
     *
     * @param content the content
     */
    public void setContent(ArrayList<element_20946887_LaraVidal> content) {
        this.content = content;
    }



    public String toString() {
        return "drive_20946887_LaraVidal{" +
                "letter='" + letter + '\'' +
                ", name='" + name + '\'' +
                ", capacity=" + capacity +
                ", content=" + content +
                '}';
    }


    public void addToRoute(ArrayList<element_20946887_LaraVidal> elements, ArrayList<String> route) {
        if (route.size() == 0) {
            this.addToContent(elements);
            return;
        }
        for (element_20946887_LaraVidal element : this.content) {
            if (element.getName().equals(route.get(0)) && element instanceof folder_20946887_LaraVidal) {
                route.remove(0);
                ((folder_20946887_LaraVidal) element).addToRoute(elements, route);
                return;
            }
        }
        System.out.println("La ruta no entregada no existe");
    }

    @Override
    public void renToRoute(String oldName, String newName, ArrayList<String> route) {
        if (route.size() == 0) {
            this.renameFromContent(oldName, newName);
            return;
        }
        for (element_20946887_LaraVidal element : this.content) {
            if (element.getName().equals(route.get(0)) && element instanceof folder_20946887_LaraVidal) {
                route.remove(0);
                ((folder_20946887_LaraVidal) element).renToRoute(oldName, newName, route);
                return;
            }
        }
        System.out.println("La ruta no entregada no existe");
    }

    @Override
    public void delFromRoute(String pattern, ArrayList<String> route) {
        if (route.size() == 0) {
            this.removeFromContent(pattern);
            return;
        }
        for (element_20946887_LaraVidal element : this.content) {
            if (element.getName().equals(route.get(0)) && element instanceof folder_20946887_LaraVidal) {
                route.remove(0);
                ((folder_20946887_LaraVidal) element).removeFromContent(pattern);
                return;
            }
        }
        System.out.println("La ruta no entregada no existe");
    }

    @Override
    public ArrayList<element_20946887_LaraVidal> getFromRoute(String pattern, ArrayList<String> route) {
        if (route.size() == 0) {
            return this.getFromContent(pattern);
        }
        for (element_20946887_LaraVidal element : this.content) {
            if (element.getName().equals(route.get(0)) && element instanceof folder_20946887_LaraVidal) {
                route.remove(0);
                folder_20946887_LaraVidal newFolder = (folder_20946887_LaraVidal) element;
                return newFolder.getFromRoute(pattern, route);

            }
        }
        return new ArrayList<>();

    }

    /**
     * Grep from route.
     *
     * @param phrase the phrase
     * @param route  the route
     */
    public void grepFromRoute(String phrase, ArrayList<String>route) {
        if (route.size() == 0) {
            for (element_20946887_LaraVidal element: this.content) {
                if (element instanceof file_20946887_LaraVidal) {
                    System.out.printf("%s:%n", element.getName());
                    ((file_20946887_LaraVidal)element).grep(phrase);
                }
            }
            return;
        }
        if (route.size() > 1) {
            for (element_20946887_LaraVidal element: this.content) {
                if (element instanceof folder_20946887_LaraVidal && element.getName().equals(route.get(0))) {
                    route.remove(0);
                    ((folder_20946887_LaraVidal)element).grepFromRoute(phrase, route);
                    return;
                }
            }
            System.out.println("La ruta especificada no existe");
            return;
        }
        // Repetición de código para permitir retroalimentar el error de ruta
        // Caso route.size() == 1
        for (element_20946887_LaraVidal element: this.content) {
            if (element instanceof folder_20946887_LaraVidal && element.getName().equals(route.get(0))) {
                route.remove(0);
                ((folder_20946887_LaraVidal)element).grepFromRoute(phrase, route);
                return;
            }
            if (element instanceof file_20946887_LaraVidal && element.nameMatches(route.get(0))){
                System.out.printf("%s:%n", element.getName());
                ((file_20946887_LaraVidal)element).grep(phrase);
            }
        }
    }

    
}
