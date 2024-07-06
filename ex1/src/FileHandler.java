import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {
    File file;
    public FileHandler(String filename) {
        try {
            this.file = this.getFileFromResource(filename);
        }
        catch(URISyntaxException e) {
            System.err.print("Nombre del archivo invalido");
        }
    }

    private File getFileFromResource(String fileName) throws URISyntaxException{
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            // failed if files have whitespaces or special characters
            //return new File(resource.getFile());
            return new File(resource.toURI());
        }

    }

    public String read() {
        if (!file.canRead()) {
            System.err.print(file.getName() + " No se puede leer. \n");
            return null;
        }
        String content = "";

        try {
            Scanner reader = new Scanner(this.file);
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                //do something
                content += line + "\n";
            }
            reader.close();
        }
        catch (Exception e) {
            System.out.print("Ocurrio un error al leer el archivo: \n" + e);
        }

        return content;
    }
}
