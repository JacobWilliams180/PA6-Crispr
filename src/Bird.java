
public class Bird extends Animal {
    private int moves;
    private String[] course;
    private String direction;
    private int movesMax;

    /*
     * METHOD: bird
     * PURPOSE: this constructs the Bird object and sets fields
     */
    public Bird(String type, String gender, int number) {
        super(type, gender);
        this.moves = number;
        movesMax = number;
        String[] course = new String[3];
        course[0] = "down";
        course[1] = "right";
        course[2] = "up";
        direction = course[0];
        this.course = course;
    }

    /*
     * METHOD: updateMoves
     * PURPOSE: this updates the moves
     */
    public void updateMoves() {
        moves--;
    }

    /*
     * METHOD: movesBird
     * PURPOSE: this returns the direction of the bird
     */
    public String movesBird() {
        if (moves == 0) {
            // change directions
            for (int i = 0; i < course.length; i++) {
                if (course[i].equals(direction)) {
                    if (i + 1 > course.length - 1) {
                        direction = course[0];
                    } else {
                        direction = course[i + 1];
                    }
                    moves = movesMax;
                    return direction;
                }
            }
        }
        return direction;
    }

}
