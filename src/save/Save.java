package save;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Save {
    private static String path = "/Users/adan/Documents/uber_simulator/src/save/game_saves";

    static void createFile(String fileName) throws IOException {
        String newFilePath = path + "/" + fileName;
        File file = new File(newFilePath);
        file.createNewFile();
    }

    public static void saveGame(int id) throws IOException {
        checkSaveFile();
        FileWriter fw = new FileWriter(path + "/save.txt");
        fw.write(id + "");
        fw.close();


    }

    private static void checkSaveFile() throws IOException {
        File file = new File(path);
        if (file.list().length == 0) {
            createFile("save.txt");
            FileWriter fw = new FileWriter(path + "/save.txt");
            fw.write("0");
            fw.close();
        }
    }

    public static int getSave() throws IOException{
        checkSaveFile();
        FileReader fr = new FileReader(path + "/save.txt");
        char[] buffer = new char[1];
        fr.read(buffer);
        fr.close();
        int save = Integer.parseInt(buffer[0] + "");
        return save;

    }

}
