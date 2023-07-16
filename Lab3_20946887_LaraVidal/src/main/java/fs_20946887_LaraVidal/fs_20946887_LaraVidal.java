package fs_20946887_LaraVidal;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import drive_20946887_LaraVidal.drive_20946887_LaraVidal;
import folder_20946887_LaraVidal.folder_20946887_LaraVidal;
import trash_20946887_LaraVidal.trash_20946887_LaraVidal;
import element_20946887_LaraVidal.element_20946887_LaraVidal;
import file_20946887_LaraVidal.*;
import routeParser_20946887_LaraVidal.routeParser_20946887_LaraVidal;

public class fs_20946887_LaraVidal implements fsInterface_20946887_LaraVidal {
    /**
     * El nombre del sistema.
     */
    String name;
    /**
     * Lista de usuarios del sistema.
     */
    ArrayList<String> users;

    /**
     * Drives del sistema.
     */
    ArrayList<drive_20946887_LaraVidal> drives;

    /**
     * El usuario actual del sistema.
     */
    String currentU;

    /**
     * El drive actual del sistema.
     */
    String currentD;

    /**
     * La ruta actual del sistema.
     */
    ArrayList<String> currentR;

    /**
     * Fecha de creación del sistema.
     */
    Date creationDate;

    /**
     * Fecha de modificación del sistema.
     */
    Date modificationDate;

    /**
     * La papelera del sistema.
     */
    ArrayList<trash_20946887_LaraVidal> trash;

    /**
     * Instancia un fs.
     *
     * @param name nombre del sistema
     */

    public fs_20946887_LaraVidal (String name) {
        this.name = name;
        this.users = new ArrayList<>();
        this.drives = new ArrayList<>();
        this.currentU = null;
        this.currentD = null;
        this.currentR = new ArrayList<>();
        this.creationDate = new Date();
        this.modificationDate = new Date();
        this.trash = new ArrayList<>();
    }


    @Override
    public String toString() {
        return "fs{" +
                "name='" + name + '\'' +
                ", users=" + users +
                ", drives=" + drives +
                ", currentU='" + currentU + '\'' +
                ", currentD='" + currentD + '\'' +
                ", currentR=" + currentR +
                ", creationDate=" + creationDate +
                ", modificationDate=" + modificationDate +
                ", trash=" + trash +
                '}';
    }

    /**
     * Obtiene los usuarios del sistema.
     *
     * @return Los usuarios del sistema
     */
    public ArrayList<String> getUsers() {
        return new ArrayList<>(this.users);
    }
    private boolean checkDriveExists(String letter) {
        for (drive_20946887_LaraVidal drive : this.drives) {
            if (drive.getLetter().equals(letter)) {
                return true;
            }
        }
        return false;
    }
    public void addDrive(String letter, String name, int capacity) {
        if (this.checkDriveExists(letter)) {
            System.out.println("Ya existe un drive con esa letra. Pruebe con otra");
            return;
        }
        this.drives.add(new drive_20946887_LaraVidal(letter, name, capacity));
        this.setModificationDate();
        System.out.println("Drive " + letter + " ha sido añadido correctamente");
    }

    public void register(String name) {
        ArrayList<String> existingUsers = this.getUsers();
        if (existingUsers.contains(name)) {
            System.out.println("El usuario " + name + " ya existe. Pruebe otro nombre");
            return;
        }
        existingUsers.add(name);
        this.setUsers(existingUsers);
        System.out.println("El usuario " + name + " ha sido registrado correctamente");
    }

    public void login(String name) {
        if (!(this.getCurrentU() == null)) {
            System.out.println("Ya hay un usuario con sesión iniciada. Cierre sesión primero");
            return;
        }

        ArrayList<String> existingUsers = this.getUsers();
        if (!(existingUsers.contains(name))) {
            System.out.println("El usuario ingresado no existe en el sistema. Los usuarios existentes son: \n ");
            for (String user: existingUsers) {
                System.out.println(user);
            }
            return;
        }

        this.setCurrentU(name);
        System.out.println("Ha iniciado sesión con: " + name);
    }

    public void logout() {
        this.setCurrentU(null);
        System.out.println("La sesión ha sido cerrada.");

    }

    public void switchDrive(String letter) {
        if (this.currentU == null) {
            System.out.println("Debe tener una sesión iniciada para seleccionar un drive");
            return;
        }
        if (!this.checkDriveExists(letter)) {
            System.out.println("El drive seleccionado no existe. Los drives disponibles son:");
            for (drive_20946887_LaraVidal drive: this.getDrives()) {
                System.out.println(drive.getLetter());
            }
            return;
        }
        this.setCurrentD(letter);
        ArrayList<String> newRoute = new ArrayList<>();
        newRoute.add(letter);
        this.setCurrentR(newRoute);
        System.out.println("El drive " + letter + " fue seleccionado correctamente.");


    }
    public void mkdir(String name) {
        if (this.getCurrentR().size() == 0) {
            System.out.println("Necesita seleccionar un drive para interactuar con los archivos");
            return;
        }
        ArrayList<element_20946887_LaraVidal> elements = new ArrayList<>();
        folder_20946887_LaraVidal newFolder = new folder_20946887_LaraVidal(name, this.getCurrentU());
        elements.add(newFolder);
        this.addToDrives(elements, this.getCurrentR());
        this.setModificationDate();
    }

    public void cd(String path) {
        routeParser_20946887_LaraVidal parser = new routeParser_20946887_LaraVidal();
        ArrayList<String> newPath = parser.addToPath(this.getCurrentR(), path);
        ArrayList<String> newPathCopy = new ArrayList<>(newPath);
        if (this.checkRouteExists(newPathCopy)) {
            this.setCurrentR(newPath);
            System.out.println("Su ruta actual es: ");
            for (String folder: newPath) {
                System.out.print(folder + "/");
            }
            System.out.print("\n");
            return;
        }
        System.out.println("La ruta entregada no existe");
    }
    public void addFile (file_20946887_LaraVidal file) {
        if (this.getCurrentR().size() == 0) {
            System.out.println("Necesita seleccionar un drive para interactuar con los archivos");
            return;
        }
        ArrayList<element_20946887_LaraVidal> elements = new ArrayList<>();
        elements.add(file);
        this.addToDrives(elements, this.getCurrentR());
        this.setModificationDate();
    }

    public void del (String pattern) {
        if (this.getCurrentR().size() == 0) {
            System.out.println("Necesita seleccionar un drive para interactuar con los archivos");
            return;
        }
        ArrayList<element_20946887_LaraVidal> elements = this.getFromDrives(pattern);
        removeFromDrives(pattern);
        this.addToTrash(elements, this.currentR);

    }

    public void copy (String pattern, String target) {
        if (this.getCurrentR().size() == 0) {
            System.out.println("Necesita seleccionar un drive para interactuar con los archivos");
            return;
        }

        ArrayList<element_20946887_LaraVidal> elements = this.getFromDrives(pattern);
        routeParser_20946887_LaraVidal parser = new routeParser_20946887_LaraVidal();
        if (!checkRouteExists(parser.toTargetPath(target))) {
            System.out.println("La ruta destino entregada no existe");
            return;
        }
        this.addToDrives(elements, parser.toTargetPath(target));
        System.out.println("Los archivos fueron copiados exitosamente");
    }

    public void move (String pattern, String target) {
        if (this.getCurrentR().size() == 0) {
            System.out.println("Necesita seleccionar un drive para interactuar con los archivos");
            return;
        }
        ArrayList<element_20946887_LaraVidal> elements = this.getFromDrives(pattern);
        routeParser_20946887_LaraVidal parser = new routeParser_20946887_LaraVidal();
        if (!checkRouteExists(parser.toTargetPath(target))) {
            System.out.println("La ruta destino entregada no existe");
            return;
        }
        this.removeFromDrives(pattern);
        this.addToDrives(elements, parser.toTargetPath(target));
        System.out.println("Los archivos fueron movidos exitosamente");

    }

    public void ren (String oldName, String newName) {
        if (this.getCurrentR().size() == 0) {
            System.out.println("Necesita seleccionar un drive para interactuar con los archivos");
            return;
        }

        this.renToDrives(oldName, newName);
    }


    public void dir (ArrayList<String> args) {
        if (this.getCurrentR().size() == 0) {
            System.out.println("Necesita seleccionar un drive para interactuar con los archivos");
            return;
        }
        System.out.println("------ DIRECTORIO DE ARCHIVOS -------");
        ArrayList<String> route = this.getCurrentR();
        for (drive_20946887_LaraVidal drive: this.getDrives()) {
            if (drive.getLetter().equals(route.get(0))) {
                route.remove(0);
                drive.dirToRoute(route, args);
                return;
            }
        }
        System.out.println("-------------------------------------");


    }
    public void format(String letter, String newName) {
        ArrayList<drive_20946887_LaraVidal> newDrives = this.getDrives();
        if (!(checkDriveExists(letter))) {
            System.out.println("El drive seleccionado no existe. Los drives disponibles son:");
            for (drive_20946887_LaraVidal drive: this.getDrives()) {
                System.out.println(drive.getLetter());
            }
        }

        for (drive_20946887_LaraVidal drive: newDrives) {
            if (drive.getLetter().equals(letter)) {
                drive.setContent(new ArrayList<>());
                drive.setName(newName);
            }
        }
        this.setDrives(newDrives);
        System.out.println("El drive " + letter + " ha sido formateado exitosamente y ahora se llama " + newName);
    }

    public void encrypt(String password, String pattern) {
        if (this.getCurrentR().size() == 0) {
            System.out.println("Necesita seleccionar un drive para interactuar con los archivos");
            return;
        }
        this.encryptDrives(password, pattern);
    }

    public void decrypt(String password, String pattern) {
        if (this.getCurrentR().size() == 0) {
            System.out.println("Necesita seleccionar un drive para interactuar con los archivos");
            return;
        }
        this.decryptDrives(password, pattern);
    }

    public void grep(String pattern, String path) {
        if (this.getCurrentR().size() == 0) {
            System.out.println("Necesita seleccionar un drive para interactuar con los archivos");
            return;
        }
        this.grepFromDrives(pattern, path);
    }
    private void encryptDrives(String password, String pattern) {
        ArrayList<String> route = this.getCurrentR();
        ArrayList<drive_20946887_LaraVidal> newDrives = this.getDrives();
        String letter = route.get(0);
        for (drive_20946887_LaraVidal drive: newDrives) {
            if (drive.getLetter().equals(letter)) {
                route.remove(0);
                drive.encryptRoute(password, pattern, route);
            }
        }
        this.setDrives(newDrives);
    }

    private void decryptDrives(String password, String pattern) {
        ArrayList<String> route = this.getCurrentR();
        ArrayList<drive_20946887_LaraVidal> newDrives = this.getDrives();
        String letter = route.get(0);
        for (drive_20946887_LaraVidal drive: newDrives) {
            if (drive.getLetter().equals(letter)) {
                route.remove(0);
                drive.decryptRoute(password, pattern, route);
            }
        }
        this.setDrives(newDrives);
    }


    private void setUsers(ArrayList<String> users) {
        this.users = users;
        this.modificationDate = new Date();
    }

    /**
     * Obtiene los drives del sistema.
     *
     * @return los drives
     */

    public ArrayList<drive_20946887_LaraVidal> getDrives() {
        return new ArrayList<>(this.drives);
    }

    /**
     * Modifica los drives del sistema.
     *
     * @param drives los nuevos drives.
     */

    public void setDrives(ArrayList<drive_20946887_LaraVidal> drives) {
        this.drives = drives;
        this.setModificationDate();
    }

    /**
     * Obtiene el usuario actual del sistema.
     *
     * @return el usuario actual
     */
    public String getCurrentU() {
        return currentU;
    }

    /**
     * Modifica el usuario actual del sistema
     *
     * @param currentU el usuario actual
     */
    public void setCurrentU(String currentU) {
        this.currentU = currentU;
        this.setModificationDate();
    }

    /**
     * Modifica el drive actual del sistema
     *
     * @param currentD el nuevo drive actual
     */
    public void setCurrentD(String currentD) {
        this.currentD = currentD;
        this.setModificationDate();
    }

    /**
     * Obtiene la ruta actual del sistema
     *
     * @return la ruta actual
     */
    public ArrayList<String> getCurrentR() {
        return new ArrayList<>(this.currentR);
    }
    /**
     * Modifica la ruta actual del sistema
     *
     * @param currentR la nueva ruta del sistema
     */
    public void setCurrentR(ArrayList<String> currentR) {
        this.currentR = currentR;
        this.setModificationDate();
    }

    /**
     * Modifica la fecha de modificación del sistema
     */
    public void setModificationDate() {
        this.modificationDate = new Date() ;
    }

    public ArrayList<trash_20946887_LaraVidal> getTrash() {
        return trash;
    }

    public void setTrash(ArrayList<trash_20946887_LaraVidal> trash) {
        this.trash = trash;
    }

    /**
     * Agregar elementos a los drives del sistema.
     *
     * @param elements los elementos a agregar a los drives
     * @param target   el destino de los archivos
     */
    public void addToDrives(ArrayList<element_20946887_LaraVidal> elements, ArrayList<String> target) {

        ArrayList<drive_20946887_LaraVidal> newDrives = new ArrayList<>();
        String letter = target.get(0);
        for (drive_20946887_LaraVidal drive: this.getDrives()) {
            if (drive.getLetter().equals(letter)) {
                target.remove(0);
                drive.addToRoute(elements, target);
                newDrives.add(drive);
            }
            else {
                newDrives.add(drive);
            }
        }
        this.setDrives(newDrives);
    }

    /**
     * Eliminar elementos de los drives.
     *
     * @param pattern el patrón de nombre de los archivos a eliminar
     */
    public void removeFromDrives(String pattern) {
        ArrayList<String> route = this.getCurrentR();
        ArrayList<drive_20946887_LaraVidal> newDrives = new ArrayList<>();
        for (drive_20946887_LaraVidal drive: this.getDrives()) {
            if (drive.getLetter().equals(route.get(0))) {
                route.remove(0);
                drive.delFromRoute(pattern, route);
                newDrives.add(drive);
            }
            else {
                newDrives.add(drive);
            }
        }
        this.setDrives(newDrives);
        this.setModificationDate();
    }

    /**
     * Renombrar un elemento del drive.
     *
     * @param oldName el antiguo nombre
     * @param newName el nuevo nombre
     */
    public void renToDrives(String oldName, String newName) {
        ArrayList<String> route = this.getCurrentR();
        ArrayList<drive_20946887_LaraVidal> newDrives = new ArrayList<>();
        for (drive_20946887_LaraVidal drive: this.getDrives()) {
            if (drive.getLetter().equals(route.get(0))) {
                route.remove(0);
                drive.renToRoute(oldName, newName, route);
                newDrives.add(drive);
            }
            else {
                newDrives.add(drive);
            }
        }
        this.setDrives(newDrives);

    }

    /**
     * Obtener elementos de los drives.
     *
     * @param pattern el patrón de los elementos a obtener
     * @return los elementos con el patrón especificado
     */
    public ArrayList<element_20946887_LaraVidal> getFromDrives(String pattern) {
        ArrayList<String> route = this.getCurrentR();
        for (drive_20946887_LaraVidal drive: this.getDrives()) {
            if (drive.getLetter().equals(route.get(0))) {
                route.remove(0);
                return drive.getFromRoute(pattern, route);
            }
        }
        return new ArrayList<>();
    }
    private boolean checkRouteExists(ArrayList<String> route) {
        if (route.size() == 0) {
            return false;
        }
        ArrayList<String> routeCopy = new ArrayList<>(route);
        for (drive_20946887_LaraVidal drive: this.getDrives()) {
            if (drive.getLetter().equals(route.get(0))) {
                routeCopy.remove(0);
                return drive.checkRouteExists(routeCopy);
            }
        }
        return false;
    }

    private void grepFromDrives(String pattern, String path) {
        routeParser_20946887_LaraVidal parser = new routeParser_20946887_LaraVidal();
        ArrayList<String> route = parser.addToPath(this.getCurrentR(), path);
        for (drive_20946887_LaraVidal drive: this.getDrives()) {
            if (drive.getLetter().equals(route.get(0))) {
                route.remove(0);
                drive.grepFromRoute(pattern, route);
                return;
            }
        }
    }

    /**
     * Añadir a la papelera.
     *
     * @param elements los elementos a agregar
     * @param route    la ruta de los elementos
     */
    public void addToTrash(ArrayList<element_20946887_LaraVidal> elements, ArrayList<String> route) {
        if (elements.size() == 0) {
            return;
        }
        for (element_20946887_LaraVidal element : elements) {
            trash_20946887_LaraVidal trash = new trash_20946887_LaraVidal(element, route);
            this.trash.add(trash);
        }
        this.setModificationDate();
    }

    public void viewTrash() {
        System.out.println("Los elementos en la papelera son: ");
        for (trash_20946887_LaraVidal trash: this.trash) {
            System.out.println(trash.getElement().getName());
        }
    }

    public void restore(String pattern) {
        for (trash_20946887_LaraVidal trash: this.trash) {
            if (trash.getElement().nameMatches(pattern)) {
                ArrayList<element_20946887_LaraVidal> toRestore = new ArrayList<>();
                toRestore.add(trash.getElement());
                addToDrives(toRestore, trash.getRoute());
            }
        }

        ArrayList<trash_20946887_LaraVidal> newTrash = new ArrayList<>();
        for (trash_20946887_LaraVidal trash: this.trash) {
            if (!trash.getElement().nameMatches(pattern)) {
                newTrash.add(trash);
            }
        }
        this.setTrash(newTrash);
    }
}
