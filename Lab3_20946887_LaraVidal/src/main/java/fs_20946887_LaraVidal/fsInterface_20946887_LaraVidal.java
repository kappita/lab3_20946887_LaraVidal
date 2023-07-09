package fs_20946887_LaraVidal;

import file_20946887_LaraVidal.file_20946887_LaraVidal;

import java.util.ArrayList;

public interface fsInterface_20946887_LaraVidal {
    void addDrive(String letter, String name, int capacity);
    void register(String name);

    void login(String name);

    void logout();

    void switchDrive(String letter);

    void mkdir(String name);

    void cd(String path);

    void addFile (file_20946887_LaraVidal file);

    void del (String pattern);

    void copy (String pattern, String target);

    void move (String pattern, String target);
    void ren (String oldName, String newName);
    void dir (ArrayList<String> args);
    void format(String letter, String newName);
    void encrypt(String password, String pattern);
    void decrypt(String password, String pattern);
    void grep(String pattern, String path);
    void viewTrash();
    void restore(String pattern);

}
