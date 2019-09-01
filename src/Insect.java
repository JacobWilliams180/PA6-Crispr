
public class Insect extends Animal {
    private boolean val;
    private int moves;
    private int movesMax;
    private int counter;
    private String[] course;
    private String direction;

    /*
     * METHOD: Insect
     * PURPOSE: this constructs the Insect object and sets fields
     */
    public Insect(String type, String gender, Boolean val) {
        super(type, gender);
        this.val = val;
        String[] course = new String[4];
        course[0] = "left";
        if (!val) {
            course[1] = "up";
            course[2] = "right";
            course[3] = "down";
        } else {
            course[1] = "down";
            course[2] = "right";
            course[3] = "up";
        }
        direction = course[0];
        moves = 1;
        movesMax = 4;
        counter = 0;
        this.course = course;
    }

    /*
     * METHOD: updateMoves
     * PURPOSE: this updates the moves for the insects
     */
    public void updateMoves() {
        moves--;
        counter++;
        if (counter == movesMax) {
            movesMax += 4;
            counter = 0;
            moves = movesMax / 4;
            direction = course[0];
        }
    }

    /*
     * METHOD: moveInsect
     * PURPOSE: this returns the string direction for the insect to take
     */
    public String moveInsect() {
        if (moves == 0) {
            for (int i = 0; i < course.length - 1; i++) {
                if (course[i].equals(direction)) {
                    if (i + 1 > course.length - 1) {
                        direction = course[0];
                    } else {
                        direction = course[i + 1];
                    }
                    moves = movesMax / 4;
                    break;
            }
        }
        }
        return direction;
    }
}
