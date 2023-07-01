package routeParser_20946887_LaraVidal;

import java.util.ArrayList;

public class routeParser_20946887_LaraVidal {

    public routeParser_20946887_LaraVidal() {

    }
    public ArrayList<String> toTargetPath(String path) {
        ArrayList<String> targetPath = new ArrayList<>();
        String[] parts = path.split("/");
        if (parts.length == 0) {
            return null;
        }
        parts[0] = parts[0].substring(0, 1);
        for (String part: parts) {
            targetPath.add(part);
        }
        return targetPath;
    }

    public ArrayList<String> addToPath(ArrayList<String> currentPath, String path) {
        ArrayList<String> newPath = new ArrayList<>(currentPath);
        System.out.println(newPath);
        String[] parts = path.split("/");
        for (String part: parts) {
            System.out.println(part);
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
