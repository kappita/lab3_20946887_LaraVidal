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



    @Override
    public ArrayList<element_20946887_LaraVidal> getContent() {
        return content;
    }


    @Override
    public void setContent(ArrayList<element_20946887_LaraVidal> newContent) {
        this.content = content;
    }


    @Override
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

    @Override
    public void grepFromRoute(String phrase, ArrayList<String> route) {
        if (route.size() == 0) {
            for (element_20946887_LaraVidal element : this.content) {
                if (element instanceof file_20946887_LaraVidal) {
                    System.out.printf("%s:%n", element.getName());
                    ((file_20946887_LaraVidal) element).grep(phrase);
                }
            }
            return;
        }
        if (route.size() > 1) {
            for (element_20946887_LaraVidal element : this.content) {
                if (element instanceof folder_20946887_LaraVidal && element.getName().equals(route.get(0))) {
                    route.remove(0);
                    ((folder_20946887_LaraVidal) element).grepFromRoute(phrase, route);
                    return;
                }
            }
            System.out.println("La ruta especificada no existe");
            return;
        }
        // Repetición de código para permitir retroalimentar el error de ruta
        // Caso route.size() == 1
        for (element_20946887_LaraVidal element : this.content) {
            if (element instanceof folder_20946887_LaraVidal && element.getName().equals(route.get(0))) {
                route.remove(0);
                ((folder_20946887_LaraVidal) element).grepFromRoute(phrase, route);
                return;
            }
            if (element instanceof file_20946887_LaraVidal && element.nameMatches(route.get(0))) {
                System.out.printf("%s:%n", element.getName());
                ((file_20946887_LaraVidal) element).grep(phrase);
            }
        }
    }

    @Override
    public boolean checkRouteExists(ArrayList<String> route) {
        if (route.size() == 0) {
            return true;
        }
        for (element_20946887_LaraVidal element : this.content) {
            if (element.getName().equals(route.get(0)) && element instanceof folder_20946887_LaraVidal) {
                route.remove(0);
                folder_20946887_LaraVidal folder = (folder_20946887_LaraVidal) element;
                return folder.checkRouteExists(route);
            }
        }
        return false;
    }

    @Override
    public void removeFromContent(String pattern) {
        ArrayList<element_20946887_LaraVidal> elements = new ArrayList<>();
        for (element_20946887_LaraVidal element : this.content) {
            if (!element.nameMatches(pattern)) {
                elements.add(element);
            }
        }
        this.setContent(elements);
    }

    @Override
    public void renameFromContent(String oldName, String newName) {
        if (this.getNamesFromContent().contains(newName)) {
            return;
        }
        ArrayList<element_20946887_LaraVidal> elements = new ArrayList<>();
        for (element_20946887_LaraVidal element : this.content) {
            if (element.getName().equals(oldName)) {
                element.setName(newName);
            }
            elements.add(element);
        }
        this.setContent(elements);
    }

    @Override
    public ArrayList<element_20946887_LaraVidal> getFromContent(String pattern) {
        ArrayList<element_20946887_LaraVidal> elements = new ArrayList<>();
        for (element_20946887_LaraVidal element : this.content) {
            if (element.nameMatches(pattern)) {
                elements.add(element);
            }
        }
        return elements;
    }

    @Override
    public ArrayList<String> getNamesFromContent() {
        ArrayList<String> names = new ArrayList<>();
        for (element_20946887_LaraVidal element : this.content) {
            names.add(element.getName());
        }
        return names;
    }

    @Override
    public void addToContent(ArrayList<element_20946887_LaraVidal> newElements) {
        ArrayList<String> names = new ArrayList<>();
        for (element_20946887_LaraVidal element : newElements) {
            names.add(element.getName());
        }
        for (element_20946887_LaraVidal element : this.content) {
            if (!names.contains(element.getName())) {
                newElements.add(element);
            } else {
                System.out.println("El archivo " + element.getName() + " fue reemplazado");
            }
        }
        this.setContent(newElements);
        System.out.println("El/Los elementos fueron añadidos correctamente");
    }

    @Override
    public void encryptRoute(String password, String pattern, ArrayList<String> route) {
        if (route.size() == 0) {
            this.encryptContent(password, pattern);
            return;
        }
        ArrayList<element_20946887_LaraVidal> newContent = this.getContent();
        String folderName = route.get(0);
        for (element_20946887_LaraVidal element : newContent) {
            if (element.getName().equals(folderName) && element instanceof folder_20946887_LaraVidal) {
                route.remove(0);
                ((folder_20946887_LaraVidal) element).encryptRoute(password, pattern, route);
            }
        }
        this.setContent(newContent);
    }

    @Override
    public void decryptRoute(String password, String pattern, ArrayList<String> route) {
        if (route.size() == 0) {
            this.decryptContent(password, pattern);
            return;
        }
        ArrayList<element_20946887_LaraVidal> newContent = this.getContent();
        String folderName = route.get(0);
        for (element_20946887_LaraVidal element : newContent) {
            if (element.getName().equals(folderName) && element instanceof folder_20946887_LaraVidal) {
                route.remove(0);
                ((folder_20946887_LaraVidal) element).decryptRoute(password, pattern, route);
            }
        }
        this.setContent(newContent);
    }

    @Override
    public void encryptContent(String password, String pattern) {
        for (element_20946887_LaraVidal element : this.content) {
            if (element.nameMatches(pattern)) {
                element.partialEncrypt(password);
            }
        }
    }

    @Override
    public void decryptContent(String password, String pattern) {
        for (element_20946887_LaraVidal element: this.content) {
            if (element.nameMatches(pattern)) {
                element.partialDecrypt(password);
            }
        }
    }

    @Override
    public void dirToRoute(ArrayList<String> route, ArrayList<String> args) {
        if (route.size() == 0) {
            this.dirContent(args, "");
            return;
        }
        for (element_20946887_LaraVidal element : this.content) {
            if (element instanceof folder_20946887_LaraVidal && element.getName().equals(route.get(0))) {
                route.remove(0);
                ((folder_20946887_LaraVidal) element).dirToRoute(route, args);
                return;
            }
        }
    }
    @Override
    public void dirContent(ArrayList<String> args, String offset) {
        if (args.contains("/o N")) {
            this.content.sort(Comparator.comparing(element_20946887_LaraVidal::getName));
        }
        if (args.contains("/o -N")) {
            this.content.sort(Comparator.comparing(element_20946887_LaraVidal::getName, Comparator.reverseOrder()));
        }
        if (args.contains("/o D")) {
            this.content.sort(Comparator.comparing(element_20946887_LaraVidal::getCreationDate));
        }
        if (args.contains("/o -D")) {
            this.content.sort(Comparator.comparing(element_20946887_LaraVidal::getCreationDate, Comparator.reverseOrder()));
        }

        for (element_20946887_LaraVidal element: this.content) {
            if (element.getName().charAt(0) == '.') {
                if (args.contains("/a")) {
                    System.out.println(offset + element.getName());
                    if (element instanceof folder_20946887_LaraVidal && args.contains("/s")) {
                        ((folder_20946887_LaraVidal) element).dirContent(args, offset + "  ");
                    }
                }

            } else {
                System.out.println(offset + element.getName());
                if (element instanceof folder_20946887_LaraVidal && args.contains("/s")) {
                    ((folder_20946887_LaraVidal) element).dirContent(args, offset + "  ");
                }

            }
        }
    }
}

