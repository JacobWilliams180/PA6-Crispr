import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/* AUTHOR:  Jacob Williams
 * FILE:    PA6Main.java
 * ASSIGNMENT:  Programming Assignment 6- Crispr
 * COURSE:  CSC 210
 * PURPOSE: this takes in commands for a size of an ecosystem
 *          and creates a ecosystem and adds all the animals 
 *          there is the move, reproduce and print commands
 *          all have different variants but should work accordingly
 *          move: moves all animals 
 *          reproduce: if conditions are met makes another animal
 *          Print: prints the ecosystem
 * USAGE:   
 *          inflie 
 *          
 *          the infile should be a txt file
 *          
 *          ---------Example Input file----------
 *          row: 5
 *          col: 5
 *          
 *          CREATE (3,2) lion male right
 *          CREATE (2,2) warbler female 4
 *          CREAT (1,4) bee male true
 *          
 *          PRINT
 *          MOVE
 *          REPRODUCE
 *          PRINT
 *          MOVE (2,3)
 *          REPRODUCE lion
 *          ------------------------------------
 * 
 */
public class PA6Main {
    public static void main(String[] args) {
        Scanner input = openFile(args[0]);
        int row = Integer.parseInt(input.nextLine().split(" ")[1]);
        int col = Integer.parseInt(input.nextLine().split(" ")[1]);
        Ecosystem land = new Ecosystem(row, col);
        Scanner read = openFile(args[0]);
        addAnimals(input, land);
        readCommands(read, land);
    }

    /*
     * METHOD: readCommands
     * PURPOSE: this takes a scanner object and goes thought it
     * doing the command given from the scanner and prints
     * results
     */
    public static void readCommands(Scanner input, Ecosystem land) {
        while (input.hasNextLine()) {
            String[] line = input.nextLine().split("\\s+");
            if (line.length == 1 && line[0].toLowerCase().equals("print")) {
                System.out.println("> PRINT");
                land.print();
                System.out.println();
            } else if (line.length == 1
                    && line[0].toLowerCase().equals("move")) {
                System.out.println("> MOVE");
                System.out.println();
                land.move();
            } else if (line.length == 2 && line[0].toLowerCase().equals("move")
                    && line[1].substring(0, 1).equals("(")) {
                int i = Integer.parseInt(line[1].substring(1, 2));
                int j = Integer.parseInt(line[1].substring(3, 4));
                System.out.println("> MOVE" + " " + line[1]);
                System.out.println();
                land.move(i, j);
            } else if (line.length == 2 && line[0].toLowerCase().equals("move")
                    && !line[1].substring(0, 1).equals("(")) {
                // type
                String check = line[1].toLowerCase();
                System.out.println("> MOVE " + line[1]);
                System.out.println();
                land.move(check);
            } else if (line.length == 1
                    && line[0].toLowerCase().equals("reproduce")) {
                System.out.println("> REPRODUCE");
                System.out.println();
                land.reproduce();
            } else if (line.length == 2
                    && line[0].toLowerCase().equals("reproduce")
                    && line[1].substring(0, 1).equals("(")) {
                int i = Integer.parseInt(line[1].substring(1, 2));
                int j = Integer.parseInt(line[1].substring(3, 4));
                System.out.println("> REPRODUCE " + line[1]);
                System.out.println();
                land.reproduce(i, j);
            }
        }
    }

    /*
     * METHOD: addAnimals
     * PURPOSE: this takes a scanner and a ecosystem and adds
     * all the animals form the CREATE command.
     */
    public static Ecosystem addAnimals(Scanner sc, Ecosystem land) {
        String[] mammalsArray = "elephant rhinoceros lion giragge zebra"
                .split(" ");
        String[] birdsArray = "thrush owl warbler shrike".split(" ");
        String[] insectsArray = "mosquito bee fly ant".split(" ");
        List<String> mammals = Arrays.asList(mammalsArray);
        List<String> birds = Arrays.asList(birdsArray);
        List<String> insects = Arrays.asList(insectsArray);
        while (sc.hasNextLine()) {
            String curr = sc.nextLine();
            String[] line = curr.split(" ");
            if (line[0].equals("CREATE")) {
                int row = Integer.parseInt(line[1].substring(1, 2));
                int col = Integer.parseInt(line[1].substring(3, 4));
                if (mammals.contains(line[2])) {
                    Animal tempMammal = new Mammal(line[2], line[3], line[4]);
                    land.add(tempMammal, row, col);
                } else if (birds.contains(line[2])) {
                    int num = Integer.parseInt(line[4]);
                    Animal tempbird = new Bird(line[2], line[3], num);
                    land.add(tempbird, row, col);
                } else if (insects.contains(line[2])) {
                    boolean bool = Boolean.parseBoolean(line[3]);
                    Animal tempinsect = new Insect(line[2], line[3], bool);
                    land.add(tempinsect, row, col);
                }
            }
        }
        return land;
    }

    /*
     * METHOD: openFile
     * PURPOSE: this takes in a string file name and returns
     * a scanner used for the command line
     */
    public static Scanner openFile(String filename) {
        try {
            Scanner sc = new Scanner(new File(filename));
            return sc;
        } catch (FileNotFoundException e) {
            System.out.println("File not Found");
            return null;
        }
    }

}

