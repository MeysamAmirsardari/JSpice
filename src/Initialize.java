import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Initialize {
    public static List<Union> unionList = new ArrayList<Union>();
    public static HashMap<Union,Union> unionMap = new HashMap<>();

    public static void fileReader() {
        File file = new File("Input.txt");
        Scanner inScanner;
        List<String> inputLines = new ArrayList<String>();

        try {
            inScanner = new Scanner(file);
            while (inScanner.hasNextLine()){
                inputLines.add(inScanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < inputLines.size() ; i++) {
            if (!(inputLines.get(i).startsWith("*")&&(inputLines.get(i).equalsIgnoreCase("END")))){
                String line = inputLines.get(i).replaceAll("\\s+"," ").trim();
                String[] inLine = line.split(" ");

                if (Pattern.compile("[V]\\w+").matcher(inLine[0]).matches()){

                } else if (Pattern.matches("[I].+",inLine[0])){

                }else if (Pattern.matches("[V].+",inLine[0])){

                }else if (Pattern.matches("[R].+",inLine[0])){

                }else if (Pattern.matches("[C].+",inLine[0])){
                    Capacitor capacitor = new Capacitor(inLine);
                    Circuit.elementList.add(capacitor);
                }else if (Pattern.matches("[L].+",inLine[0])){

                }else if (Pattern.matches("[E].+",inLine[0])){

                }else if (Pattern.matches("[F].+",inLine[0])){

                }else if (Pattern.matches("[G].+",inLine[0])){

                }else if (Pattern.matches("[H].+",inLine[0])){

                }else if (Pattern.matches("[D].+",inLine[0])){

                }else {

                }

            }

        }

    }
}
