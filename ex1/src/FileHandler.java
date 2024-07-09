import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileHandler {
    File input;
    File output;
    public FileHandler(String projectName) {
        try {
            this.input = new File(projectName + "/IO/input.txt");
            this.output = new File(projectName + "/IO/output.txt");
        }
        catch(NullPointerException e) {
            System.err.print("Nombre del archivo invalido.");
        }

        try {
            if (!this.output.exists()) {
                this.output.createNewFile();
            }
        }
        catch (IOException e) {
            System.err.print("No se pudo crear el archivo.");
        }
    }

    public String read() {
        if (!input.canRead()) {
            System.err.print(input.getName() + " No se puede leer. \n");
            return null;
        }
        String content = "";
        try {
            Scanner reader = new Scanner(this.input);
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

    public void write(String content) {
        try {
            FileWriter writer = new FileWriter(this.output.getPath());
            writer.write(content);
            writer.close();
            System.out.println("Archivo de salida escrito.");
        }
        catch (IOException e) {
            System.err.print("Ocurrio un error al escribir el archivo: \n" + e);
        }
    }
}
