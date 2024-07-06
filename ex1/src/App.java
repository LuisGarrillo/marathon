

public class App {
    public static void main(String[] args) throws Exception {
        FileHandler FH = new FileHandler("IO/input.txt");
        System.out.println(FH.read());
    }
}
