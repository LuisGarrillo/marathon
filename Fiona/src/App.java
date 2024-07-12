public class App {
    public static void main(String[] args) throws Exception {
        FileHandler FH = new FileHandler("Fiona");
        String content = FH.read();
        String[] sentenceList = content.split("\n");
        FH.write(tautoCheck(sentenceList));
    }

    public static String tautoCheck(String[] sentenceList) {
        String result = "";
        for (String sentence: sentenceList) {
            String firstLetter = String.valueOf(sentence.charAt(0)).toLowerCase();
            
            if (firstLetter.equals("*")) {
                break;
            }

            String[] wordList = sentence.split(" ");
            int score = 1;
            for (int i = 1, length = wordList.length; i < length; i++) {
                if (wordList[i].toLowerCase().startsWith(firstLetter)) {
                    score++; 
                }
            }
            System.out.println(score);
            if (score == wordList.length) {
                result += "Y\n";
            }
            else {
                result += "N\n";
            }
        }
        return result;
    }
}
