package element_20946887_LaraVidal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import file_20946887_LaraVidal.file_20946887_LaraVidal;
import folder_20946887_LaraVidal.folder_20946887_LaraVidal;

public class element_20946887_LaraVidal implements elementInterface_20946887_LaraVidal{
    protected String name;
    Date creationDate;
    Date modificationDate;
    int passkey;

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
