package routeParser_20946887_LaraVidal;

import java.util.ArrayList;

/**
 * El tipo routeParser.
 */
public class routeParser_20946887_LaraVidal {

    /**
     * Instancia un nuevo routeParser.
     */
    public routeParser_20946887_LaraVidal() {

    }

    /**
     * Transforma el string entregado a un path en ArrayList
     *
     * @param path el path objetivo
     * @return el arraylist con la ruta
     */
    public ArrayList<String> toTargetPath(String path) {
        ArrayList<String> targetPath = new ArrayList<>();
        String[] parts = path.split("/");
        if (parts.length == 0) {
            return targetPath;
        }
        parts[0] = parts[0].substring(0, 1);
        for (String part: parts) {
            targetPath.add(part);
        }
        return targetPath;
    }

    /**
     * Agrega un path a la ruta actual.
     *
     * @param currentPath la ruta actual
     * @param path        el path
     * @return el arraylist de nueva ruta
     */
    public ArrayList<String> addToPath(ArrayList<String> currentPath, String path) {
        ArrayList<String> newPath = new ArrayList<>(currentPath);
        String[] parts = path.split("/");
        for (String part: parts) {
            if (part.equals(".") || part.equals("")) {
                // Do nothing
            } else if (part.equals("..") && currentPath.size() > 1) {
                newPath.remove(newPath.size() - 1);
            } else {
                newPath.add(part);
            }
        }
        return newPath;

    }
}
