public class App {
    public static void main(String[] args) throws Exception {
        FileHandler FH = new FileHandler("Preparing");
        String content = FH.read();

        String[] values = content.split(" ");
        int solutions = Integer.parseInt(values[0]);
        int t1 = Integer.parseInt(values[1]);
        int t2 = Integer.parseInt(values[2].strip());

        int accomplishedSolutions = 0;
        int accumulatedTime = 0;
        boolean working1 = true;
        boolean working2 = true;
        boolean accomplished1 = false;
        boolean accomplished2 = false;
        
        int i = 1;
        while(true) {
            if (working1 && (i % t1 == 0)) {
                accomplishedSolutions++;
                accomplished1 = true;
            }
            if (working2 && (i % t2 == 0)) {
                accomplishedSolutions++;
                accomplished2 = true;
            }

            if (accomplished1 && accomplishedSolutions >= solutions) {
                working1 = false;
            }
            else {
                accomplished1 = false;
            }

            if (accomplished2 && accomplishedSolutions >= solutions) {
                working2 = false;
            }
            else {
                accomplished2 = false;
            }

            accumulatedTime++;
            i++;
            if (!working1 && !working2) {
                break;
            }
        }
        FH.write(String.valueOf(accomplishedSolutions) + " " + String.valueOf(accumulatedTime));

    }
}
