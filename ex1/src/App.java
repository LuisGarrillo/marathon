import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        FileHandler FH = new FileHandler("ex1");
        String content = FH.read();
        String[] set = content.split("\n");
        if (Integer.parseInt(set[0]) > 50 || Integer.parseInt(set[0]) < 1) {
            System.err.println("El primer valor debe estar dentro del rango de 1 y 50 inclusivo");
            System.exit(1);
        }
        String[] stringSet = new String[Integer.parseInt(set[0])];
        for (int i = 1, length = set.length; i < length; i++) {
                stringSet[i-1] = set[i];
        }
        FH.write(sortSet(stringSet));
    }

    public static String sortSet(String[] stringSet) {
        String result = "";
        for (String string: stringSet) {
            String[] words = string.split(" ");
            if (words.length < 1 || words.length > 50) {
                System.err.println("la cantidad de palabras debe estar dentro del rango de 1 y 50 inclusivo");
                System.exit(1);
            }
            for (int i = 0, length = words.length; i < length; i++) {
                for (int j = i + 1; j < length; j++) {
                    if (words[j].length() > words[i].length()) {
                        String aux = words[i];
                        words[i] = words[j];
                        words[j] = aux;
                    }
                }
            }

            for (String word: words) {
                result += word + " "; 
            }
            result += "\n";
        }
        return result;
    }
}
