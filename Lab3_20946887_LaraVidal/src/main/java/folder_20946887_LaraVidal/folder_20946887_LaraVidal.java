package folder_20946887_LaraVidal;

import element_20946887_LaraVidal.element_20946887_LaraVidal;
import content_20946887_LaraVidal.hasContent_20946887_LaraVidal;
import file_20946887_LaraVidal.file_20946887_LaraVidal;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * La clase carpeta
 */
public class folder_20946887_LaraVidal extends element_20946887_LaraVidal implements hasContent_20946887_LaraVidal {

    /**
     * El autor de la carpeta
     */
    String author;
    /**
     * El contenido de la carpeta
     */
    ArrayList<element_20946887_LaraVidal> content;


    /**
     * Constructor de una nueva carpeta
     *
     * @param name   El nombre de la carpeta
     * @param author El autor de la carpeta
     */
    public folder_20946887_LaraVidal(String name, String author) {
        super(name);
        this.author = author;
        this.content = new ArrayList<>();
    }

    /**
     * Cambia el contenido de la carpeta
     *
     * @param newContent el nuevo contenido para la carpeta
     */
    public void setContent(ArrayList<element_20946887_LaraVidal> newContent) {
        this.content = newContent;
        this.setModificationDate();
    }

    /**
     * Obtiene el contenido de la carpeta
     *
     * @return el contenido de la carpeta
     */
    public ArrayList<element_20946887_LaraVidal> getContent() {
        return new ArrayList<>(this.content);
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
                this.setModificationDate();
                return;
            }
        }
        System.out.println("La ruta no entregada no existe");
    }


    public void renToRoute(String oldName, String newName, ArrayList<String> route) {
        if (route.size() == 0) {
            this.renameFromContent(oldName, newName);
            return;
        }
        for (element_20946887_LaraVidal element : this.content) {
            if (element.getName().equals(route.get(0)) && element instanceof folder_20946887_LaraVidal) {
                route.remove(0);
                ((folder_20946887_LaraVidal) element).renToRoute(oldName, newName, route);
                this.setModificationDate();
                return;
            }
        }
        System.out.println("La ruta no entregada no existe");
    }


    public void delFromRoute(String pattern, ArrayList<String> route) {
        if (route.size() == 0) {
            this.removeFromContent(pattern);
            return;
        }
        for (element_20946887_LaraVidal element : this.content) {
            if (element.getName().equals(route.get(0)) && element instanceof folder_20946887_LaraVidal) {
                route.remove(0);
                ((folder_20946887_LaraVidal) element).removeFromContent(pattern);
                this.setModificationDate();
                return;
            }
        }
        System.out.println("La ruta no entregada no existe");

    }


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


    public void encryptRoute(String password, String pattern, ArrayList<String> route) {
        if (route.size() == 0) {
            this.encryptContent(password, pattern);
            return;
        }
        for (element_20946887_LaraVidal element : this.content) {
            if (element.getName().equals(route.get(0)) && element instanceof folder_20946887_LaraVidal) {
                route.remove(0);
                ((folder_20946887_LaraVidal) element).encryptRoute(password, pattern, route);
                this.setModificationDate();
                return;
            }
        }
        System.out.println("La ruta no entregada no existe");
    }

    public void decryptRoute(String password, String pattern, ArrayList<String> route) {
        if (route.size() == 0) {
            this.decryptContent(password, pattern);
            return;
        }
        for (element_20946887_LaraVidal element : this.content) {
            if (element.getName().equals(route.get(0)) && element instanceof folder_20946887_LaraVidal) {
                route.remove(0);
                ((folder_20946887_LaraVidal) element).decryptRoute(password, pattern, route);
                this.setModificationDate();
                return;
            }
        }
        System.out.println("La ruta no entregada no existe");
    }

    public void encryptContent(String password, String pattern) {
        for (element_20946887_LaraVidal element: this.content) {
            if (element.nameMatches(pattern)) {
                element.partialEncrypt(password);
            }
        }
    }
    public void decryptContent(String password, String pattern) {
        for (element_20946887_LaraVidal element: this.content) {
            if (element.nameMatches(pattern)) {
                element.partialDecrypt(password);
            }
        }
    }



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

    public boolean checkRouteExists(ArrayList<String> route) {
        if (route.size() == 0) {
            return true;
        }
        for (element_20946887_LaraVidal element: this.content) {
            if (element.getName().equals(route.get(0)) && element.getClass() == folder_20946887_LaraVidal.class) {
                route.remove(0);
                return ((folder_20946887_LaraVidal)element).checkRouteExists(route);
            }
        }
        return false;
    }

    public void removeFromContent(String pattern) {
        ArrayList<element_20946887_LaraVidal> elements = new ArrayList<>();
        for (element_20946887_LaraVidal element: this.content) {
            if (!element.nameMatches(pattern)) {
                elements.add(element);
            }
        }
        this.setContent(elements);
    }


    public void renameFromContent(String oldName, String newName) {
        if (this.getNamesFromContent().contains(newName)) {
            System.out.println("El nombre ingresado ya existe");
            return;
        }

        for (element_20946887_LaraVidal element: this.content) {
            if (element.getName().equals(oldName)) {
                element.setName(newName);
                System.out.println("El archivo fue renombrado exitosamente");
                return;
            }

        }

    }


    public ArrayList<element_20946887_LaraVidal> getFromContent(String pattern) {
        ArrayList<element_20946887_LaraVidal> elements = new ArrayList<>();
        for (element_20946887_LaraVidal element: this.content) {
            if (element.nameMatches(pattern)) {
                elements.add(element);
            }
        }
        return elements;
    }


    public ArrayList<String> getNamesFromContent() {
        ArrayList<String> names = new ArrayList<>();
        for (element_20946887_LaraVidal element : this.content) {
            names.add(element.getName());
        }
        return names;
    }

    public void addToContent(ArrayList<element_20946887_LaraVidal> newElements) {
        ArrayList<String> names = new ArrayList<>();
        for (element_20946887_LaraVidal element: newElements) {
            names.add(element.getName());
        }
        for (element_20946887_LaraVidal element : this.content) {
            if (!names.contains(element.getName())) {
                newElements.add(element);
            }
            else {
                System.out.println("El archivo " + element.getName() + " fue reemplazado");
            }
        }

        this.setContent(newElements);
        System.out.println("El/Los elementos fueron añadidos correctamente");
    }


    public void dirToRoute(ArrayList<String> route, ArrayList<String> args) {
        if (route.size() == 0) {
            this.dirContent(args, "");
            return;
        }
        for (element_20946887_LaraVidal element : this.content) {
            if (element instanceof folder_20946887_LaraVidal && element.getName().equals(route.get(0))) {
                route.remove(0);
                ((folder_20946887_LaraVidal) element).dirToRoute(route, args);
            }
        }
    }


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

