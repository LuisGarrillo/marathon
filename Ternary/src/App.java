public class App {
    public static void main(String[] args) throws Exception {
        FileHandler FH = new FileHandler("Ternary");
        String content = FH.read();
        FH.write(refactorPassword(content));
        
    }

    public static String refactorPassword(String content) {
        String[] dividedContent = content.split("\n");
        String[] values = dividedContent[0].split(" ");
        int passwordLength = Integer.parseInt(values[0]);
        int a = Integer.parseInt(values[1]);
        int b = Integer.parseInt(values[2].strip());
        String password =  dividedContent[1];

        if (password.length() < passwordLength) {
            password += "2".repeat(passwordLength - password.length());
        }
        else if (password.length() > passwordLength) {
            String aux = password;
            password = "";
            for (int i = 0, length = passwordLength; i < length; i++) {
                password += aux.charAt(i);
            }
        }

        int replacements = 0;
        int aCount = 0;
        for (int i = 0, length = password.length(); i < length; i++) {
            if (password.charAt(i) == '0') {
                aCount++;
            }
        }
        String passwordRev1 = "";
        if (aCount > a) {
            for (int i = 0, length = password.length(); i < length; i++) {
                if (password.charAt(i) == '0' && aCount > a) {
                    passwordRev1 += "2";
                    aCount--;
                }
                else {
                    passwordRev1 += password.charAt(i);
                }
            }
        }
        else if (aCount < a) {
            for (int i = 0, length = password.length(); i < length; i++) {
                if (password.charAt(i) != '0' && aCount < a) {
                    passwordRev1 += "0";
                    replacements++;
                    System.out.println(replacements);
                    aCount++;
                }
                else {
                    passwordRev1 += password.charAt(i);
                }
            }
        }
        System.out.println(passwordRev1);
        int bCount = 0;
        for (int i = 0, length = passwordRev1.length(); i < length; i++) {
            if (passwordRev1.charAt(i) == '1') {
                bCount++;
            }
        }
        String passwordRev2 = "";
        if (bCount > b) {
            
            for (int i = 0, length = passwordRev1.length(); i < length; i++) {
                if (passwordRev1.charAt(i) == '1' && bCount > b) {
                    passwordRev2 += "2";
                    bCount--;
                }
                else {
                    passwordRev2 += passwordRev1.charAt(i);
                }
            }
        }
        else if (bCount < b) {
            System.out.println(".");
            for (int i = 0, length = passwordRev1.length(); i < length; i++) {
                if (passwordRev1.charAt(i) == '2' && bCount < b) {
                    passwordRev2 += "1";
                    replacements++;
                    bCount++;
                }
                else {
                    passwordRev2 += passwordRev1.charAt(i);
                }
            }
        }
        else {
            
            passwordRev2 = passwordRev1;
        }
        return replacements + "\n" + passwordRev2;
    }
}
