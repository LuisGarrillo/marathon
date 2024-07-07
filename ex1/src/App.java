

public class App {
    public static void main(String[] args) throws Exception {
        FileHandler FH = new FileHandler();
        System.out.println(FH.read());
        FH.write("holahola");
    }
}
