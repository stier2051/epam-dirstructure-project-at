import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DirectoryStructure {

    static String[] filesForDogs = new String[] {
            "Afador.txt",
            "Affenpinscher.txt",
            "American Pugabull.txt",
            "American Water Spaniel.txt"
    };

    static String[] filesForCats = new String[] {
            "Abyssinian Cat.txt",
            "American Wirehair Cat.txt",
            "American Shorthair Cat.txt",
            "Bengal Cat.txt",
            "Burmese Cat.txt",
            "Bombay Cat.txt"
    };

    static String[] filesForRodents = new String[] {
            "Hamster.txt",
            "Chinchilla.txt",
            "Squirrel.txt",
            "Guinea pig.txt"
    };

    public static void main(String[] args) {

        File structureInfo = new File (args[0] + "/structure.txt");
        try {
            structureInfo.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(args[0] + "/structure.txt");
            } catch (IOException e) {
                e.printStackTrace();
        }

        File dirZooShop = new File(args[0] + "/Zoo Shop");
        boolean created = dirZooShop.mkdir();

        try {
            if (created && fileWriter != null) fileWriter.write(dirZooShop.getName() + '\n');
        } catch (IOException e) {
            e.printStackTrace();
        }

        File dirDog = new File(dirZooShop + "/Dogs/");
        dirDog.mkdir();
        File dirCat = new File(dirZooShop + "/Cats");
        dirCat.mkdir();
        File dirRodent = new File(dirZooShop + "/Rodents");
        dirRodent.mkdir();

        createFilesInDirectory(dirDog, filesForDogs);
        createFilesInDirectory(dirCat, filesForCats);
        createFilesInDirectory(dirRodent, filesForRodents);

        String[] dirStructure = dirZooShop.list();
        for (String directory : dirStructure) {
            File dir = new File(dirZooShop + "/" + directory);
            File[] files = dir.listFiles();
            try {
                if (fileWriter != null) fileWriter.write("|-----" + directory + '\n');
            } catch (IOException e) {
                e.printStackTrace();
            }
            for (File x : files) {
                try {
                    if (fileWriter != null) fileWriter.write("|     " + x.getName() + '\n');
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        try {
            if (fileWriter != null) fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createFilesInDirectory(File path, String[] strings) {
        for (String filesList : strings) {
            File file = new File(path + "/" + filesList);
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
