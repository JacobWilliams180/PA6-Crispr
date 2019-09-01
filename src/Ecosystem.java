import java.util.ArrayList;

public class Ecosystem {

    private ArrayList<ArrayList<ArrayList<Animal>>> board;
    private int maxRow;
    private int maxCol;

    /*
     * METHOD : Ecosystem
     * PURPOSE: this creates a board by a given row and col and sets fields
     */
    public Ecosystem(int row, int col) {
        ArrayList<ArrayList<ArrayList<Animal>>> board = new ArrayList<ArrayList<ArrayList<Animal>>>();
        maxRow = row - 1;
        maxCol = col - 1;
        for (int i = 0; i < row; i++) {
            board.add(new ArrayList<ArrayList<Animal>>());
            for (int j = 0; j < col; j++) {
                board.get(i).add(new ArrayList<Animal>());
            }
        }
        this.board = board;
            }

    /*
     * METHOD: PRINT
     * PURPOSE: this will print the board, if no animal is present in a location
     * then outputs "."
     * otherwise it will print first letter of the first animal in location
     */
    public void print() {
        for (int i = 0; i < board.size(); i++) {
            for (int j = 0; j < board.get(i).size(); j++) {
                if (board.get(i).get(j).size() == 0) {
                    System.out.print(".");
                } else {
                    System.out.print(board.get(i).get(j).get(0).getName()
                            .substring(0, 1));
                }
                }
            System.out.println();
            }
        }

    /*
     * METHOD: add
     * PURPOSE: this adds ana animal to a location on the board
     */
    public void add(Animal animal, int row, int col) {
        board.get(row).get(col).add(animal);
    }

    /*
     * METHOD: move
     * PURPOSE: this will go through all the locations and check if there are
     * animals there and then moves each of them
     */
    public void move() {
        ArrayList<Animal> moved = new ArrayList<Animal>();
        for (int i = 0; i < board.size(); i++) {
            for (int j = 0; j < board.get(i).size(); j++) {
                if (board.get(i).get(j).size() != 0) {
                    ArrayList<Animal> animals = board.get(i).get(j);
                    for (int k = 0; k < animals.size(); k++) {
                        Animal curr = animals.get(k);
                        if (!moved.contains(curr)) {
                            moved.add(curr);
                            String direction = curr.getDirection();
                            if (curr instanceof Mammal) {
                                Mammal currM = (Mammal) curr;
                                direction = currM.moveMammal();
                            } else if (curr instanceof Bird) {
                                Bird currB = (Bird) curr;
                                direction = currB.movesBird();
                                currB.updateMoves();
                            } else if (curr instanceof Insect) {
                                Insect currI = (Insect) curr;
                                direction = currI.moveInsect();
                                currI.updateMoves();
                            }
                        if (direction.equals("left")) {
                                animals.remove(curr);
                                animals.add(k, null);
                                if (j - 1 < 0) {
                                    board.get(i).get(maxCol).add(curr);
                                } else {
                                    board.get(i).get(j - 1).add(curr);
                                }
                        } else if (direction.equals("right")) {
                                animals.remove(curr);
                                animals.add(k, null);
                                if (j + 1 > maxCol) {
                                board.get(i).get(0).add(curr);
                                } else {
                                    board.get(i).get(j + 1).add(curr);
                            }
                        } else if (direction.equals("up")) {
                                animals.remove(curr);
                                animals.add(k, null);
                                if (i - 1 < 0) {
                                board.get(maxRow).get(j).add(curr);
                                } else {
                                    board.get(i - 1).get(j).add(curr);
                            }
                        } else if (direction.equals("down")) {
                                animals.remove(curr);
                                animals.add(k, null);
                                if (i + 1 > maxRow) {
                                board.get(0).get(j).add(curr);
                                } else {
                                    board.get(i + 1).get(j).add(curr);
                            }
                        }
                        }
                    }
                    for (int x = 0; x < board.get(i).get(j).size(); x++) {
                        if (moved.contains(board.get(i).get(j).get(x))) {
                            continue;
                        } else {
                            board.get(i).get(j).clear();
                        }
                    }
                }
            }
        }
    }

    /*
     * METHOD: move (int , int)
     * PURPOSE: this will move any animals at a given location
     */
    public void move(int i, int j) {
        ArrayList<Animal> moved = new ArrayList<Animal>();
        ArrayList<Animal> animals = board.get(i).get(j);
        for (int k = 0; k < animals.size(); k++) {
            Animal curr = animals.get(k);
            if (!moved.contains(curr)) {
                moved.add(curr);
                String direction = curr.getDirection();
                if (curr instanceof Mammal) {
                    Mammal currM = (Mammal) curr;
                    direction = currM.moveMammal();
                } else if (curr instanceof Bird) {
                    Bird currB = (Bird) curr;
                    direction = currB.movesBird();
                    currB.updateMoves();
                } else if (curr instanceof Insect) {
                    Insect currI = (Insect) curr;
                    direction = currI.moveInsect();
                    currI.updateMoves();
                }
                if (direction.equals("left")) {
                    animals.remove(curr);
                    animals.add(k, null);
                    if (j - 1 < 0) {
                        board.get(i).get(maxCol).add(curr);
                    } else {
                        board.get(i).get(j - 1).add(curr);
                    }
                } else if (direction.equals("right")) {
                    animals.remove(curr);
                    animals.add(k, null);
                    if (j + 1 > maxCol) {
                        board.get(i).get(0).add(curr);
                    } else {
                        board.get(i).get(j + 1).add(curr);
                    }
                } else if (direction.equals("up")) {
                    animals.remove(curr);
                    animals.add(k, null);
                    if (i - 1 < 0) {
                        board.get(maxRow).get(j).add(curr);
                    } else {
                        board.get(i - 1).get(j).add(curr);
                    }
                } else if (direction.equals("down")) {
                    animals.remove(curr);
                    animals.add(k, null);
                    if (i + 1 > maxRow) {
                        board.get(0).get(j).add(curr);
                    } else {
                        board.get(i + 1).get(j).add(curr);
                    }
                }

            }
        }
        for (int x = 0; x < board.get(i).get(j).size(); x++) {
            if (moved.contains(board.get(i).get(j).get(x))) {
                continue;
            } else {
                board.get(i).get(j).clear();
            }
        }
    }

    /*
     * METHOD: move (string)
     * PURPOSE: this will either move animals with the same type or name
     * depending on the given string
     */
    public void move(String check) {
        // type
        ArrayList<Animal> moved = new ArrayList<Animal>();
            for (int i = 0; i < board.size(); i++) {
                for (int j = 0; j < board.get(i).size(); j++) {
                    if (board.get(i).get(j).size() != 0) {
                        ArrayList<Animal> animals = board.get(i).get(j);
                        for (int k = 0; k < animals.size(); k++) {
                            Animal curr = animals.get(k);
                            if (curr.getClass().getSimpleName().toLowerCase()
                                    .equals(check)
                                    || curr.getName().toLowerCase()
                                            .equals(check)) {
                            if (!moved.contains(curr)) {
                                moved.add(curr);
                                String direction = curr.getDirection();
                                if (curr instanceof Mammal) {
                                    Mammal currM = (Mammal) curr;
                                    direction = currM.moveMammal();
                                } else if (curr instanceof Bird) {
                                    Bird currB = (Bird) curr;
                                    direction = currB.movesBird();
                                    currB.updateMoves();
                                } else if (curr instanceof Insect) {
                                    Insect currI = (Insect) curr;
                                    direction = currI.moveInsect();
                                    currI.updateMoves();
                                }
                                if (direction.equals("left")) {
                                    animals.remove(curr);
                                    animals.add(k, null);
                                    if (j - 1 < 0) {
                                        board.get(i).get(maxCol).add(curr);
                                    } else {
                                        board.get(i).get(j - 1).add(curr);
                                    }
                                } else if (direction.equals("right")) {
                                    animals.remove(curr);
                                    animals.add(k, null);
                                    if (j + 1 > maxCol) {
                                        board.get(i).get(0).add(curr);
                                    } else {
                                        board.get(i).get(j + 1).add(curr);
                                    }
                                } else if (direction.equals("up")) {
                                    animals.remove(curr);
                                    animals.add(k, null);
                                    if (i - 1 < 0) {
                                        board.get(maxRow).get(j).add(curr);
                                    } else {
                                        board.get(i - 1).get(j).add(curr);
                                    }
                                } else if (direction.equals("down")) {
                                    animals.remove(curr);
                                    animals.add(k, null);
                                    if (i + 1 > maxRow) {
                                        board.get(0).get(j).add(curr);
                                    } else {
                                        board.get(i + 1).get(j).add(curr);
                                    }
                                }

                            }
                        }
                            ArrayList<Animal> tempAnimals = board.get(i).get(j);
                            while (checkIfIn(i, j, check)) {
                                for (int x = 0; x < tempAnimals.size(); x++) {
                                if (!moved.contains(tempAnimals.get(x))
                                        || !(tempAnimals.get(x) == null)) {
                                        board.get(i).get(j)
                                                .remove(tempAnimals.get(x));
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

    /*
     * METHOD: checkIfIn
     * PURPOSE: this returns a boolean value if a string is in a list or if
     * there is a null in the list
     */
    public boolean checkIfIn(int x, int y, String check) {
        for (int z = 0; z < board.get(x).get(y).size(); z++) {
            Animal temp = board.get(x).get(y).get(z);
            if (temp == null) {
                return true;
            }
            if (!temp.getClass().getSimpleName().equals(check)
                    || !temp.getName().equals(check)) {
                return true;
                }
            }
        return false;
    }

    /*
     * METHOD: reproduce (int, int)
     * PURPOSE: this reproduces animals at a given location
     */
    public void reproduce(int i, int j) {
        ArrayList<Animal> used = new ArrayList<Animal>();
        if (board.get(i).get(j).size() >= 2) {
            ArrayList<Animal> animals = board.get(i).get(j);
            for (int x = 0; x < animals.size(); x++) {
                Animal curr = animals.get(x);
                for (int y = 0; y < animals.size(); y++) {
                    Animal compare = animals.get(y);
                    if (curr != compare
                            && !curr.getGender().equals(compare.getGender())
                            && curr.getClass().equals(compare.getClass())) {
                        String animalClass = curr.getClass().getSimpleName();
                        if (animalClass.equals("Insect")) {
                            if (!used.contains(curr)
                                    && !used.contains(compare)) {
                                Animal baby = (new Insect(curr.getName(),
                                        "female", false));
                                board.get(i).get(j).add(baby);
                                used.add(curr);
                                used.add(compare);
                            }
                        } else if (animalClass.equals("Mammal")) {
                            if (!used.contains(curr)
                                    && !used.contains(compare)) {
                                Mammal currM = (Mammal) curr;
                                Mammal compareM = (Mammal) compare;
                                if (currM.reproduceNum() <= 5
                                        && compareM.reproduceNum() <= 5) {
                                    Animal baby = new Mammal(currM.getName(),
                                            "female", "right");
                                    board.get(i).get(j).add(baby);
                                    currM.updateReproduceNum();
                                    compareM.updateReproduceNum();
                                    used.add(curr);
                                    used.add(compare);
                                    continue;
                                }
                            }
                        } else if (animalClass.equals("Bird")) {
                            if (!used.contains(curr)
                                    && !used.contains(compare)) {
                                Animal baby = new Bird(curr.getName(), "female",
                                        5);
                                board.get(i).get(j).add(baby);
                                used.add(curr);
                                used.add(compare);
                            }
                        }
                    }
                }
            }
        }
    }
    /*
     * METHOD: reproduce
     * PURPOSE: this goes thought the ecosystem and checks if any animal at a
     * given location can reproduce
     */
    public void reproduce() {
        ArrayList<Animal> used = new ArrayList<Animal>();
        for (int i = 0; i < board.size(); i++) {
            for (int j = 0; j < board.get(i).size(); j++) {
                if (board.get(i).get(j).size() >= 2) {
                    ArrayList<Animal> animals = board.get(i).get(j);
                    for (int x = 0; x < animals.size(); x++) {
                        Animal curr = animals.get(x);
                        for (int y = 0; y < animals.size(); y++) {
                            Animal compare = animals.get(y);
                            if (curr != compare
                                    && !curr.getGender()
                                            .equals(compare.getGender())
                                    && curr.getClass()
                                            .equals(compare.getClass())) {
                                String animalClass = curr.getClass()
                                        .getSimpleName();
                                if (animalClass.equals("Insect")) {
                                    if (!used.contains(curr)
                                            && !used.contains(compare)) {
                                    Animal baby = (new Insect(
                                            curr.getName(), "female", false));
                                    board.get(i).get(j).add(baby);
                                        used.add(curr);
                                        used.add(compare);
                                    }
                                } else if (animalClass.equals("Mammal")) {
                                    if (!used.contains(curr)
                                            && !used.contains(compare)) {
                                    Mammal currM = (Mammal) curr;
                                    Mammal compareM = (Mammal) compare;
                                    if (currM.reproduceNum() <= 5
                                            && compareM.reproduceNum() <= 5) {
                                        Animal baby = new Mammal(
                                                currM.getName(),
                                            "female", "right");
                                        board.get(i).get(j).add(baby);
                                        currM.updateReproduceNum();
                                        compareM.updateReproduceNum();
                                            used.add(curr);
                                            used.add(compare);
                                        continue;
                                    }
                                    }
                                } else if (animalClass.equals("Bird")) {
                                    if (!used.contains(curr)
                                            && !used.contains(compare)) {
                                    Animal baby = new Bird(curr.getName(),
                                            "female", 5);
                                    board.get(i).get(j).add(baby);
                                        used.add(curr);
                                        used.add(compare);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
