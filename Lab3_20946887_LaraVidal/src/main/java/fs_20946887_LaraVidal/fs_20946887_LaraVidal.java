package fs_20946887_LaraVidal;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import drive_20946887_LaraVidal.drive_20946887_LaraVidal;
import folder_20946887_LaraVidal.folder_20946887_LaraVidal;
import trash_20946887_LaraVidal.trash_20946887_LaraVidal;
import element_20946887_LaraVidal.element_20946887_LaraVidal;
import file_20946887_LaraVidal.*;

public class fs_20946887_LaraVidal {
    String name;
    ArrayList<String> users;

    ArrayList<drive_20946887_LaraVidal> drives;

    String currentU;

    String currentD;

    ArrayList<String> currentR;

    Date creationDate;

    Date modificationDate;

    ArrayList<trash_20946887_LaraVidal> trash;

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

    public ArrayList<String> getUsers() {
        return users;
    }
    private boolean checkDriveExists(String letter) {
        for (int i = 0; i < this.drives.size(); i++) {
            if (this.drives.get(i).getLetter().equals(letter)) {
                return true;
            }
        }
        return false;
    }