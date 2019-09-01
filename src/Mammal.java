
public class Mammal extends Animal {
    private int moves;
    private String[] course;
    private int reproduceNum;

    /*
     * METHOD: Mammal
     * PURPOSE: this constructs the mammal object and sets fields
     */
    public Mammal(String type, String gender, String direction) {
        super(type, gender);
        String[] course = new String[2];
        if (direction.equals("right")) {
            course[0] = "down";
            course[1] = "right";
        } else if (direction.equals("left")) {
            course[0] = "up";
            course[1] = "left";
        }
        reproduceNum = 5;
        this.course = course;
    }

    /*
     * METHOD: moveMammal
     * PURPOSE: this returns the direction the mammal takes per turn
     */
    public String moveMammal() {
        if (moves % 2 != 0) {
            moves++;
            return course[1];
        } else {
            moves++;
            return course[0];
        }
    }

    /*
     * METHOD: updateReproduction
     * PURPOSE: this updates the produceNum every time the animal reproduces
     */
    public void updateReproduceNum() {
        reproduceNum--;
    }

    /*
     * METHOD: reproduceNum
     * PURPOSE: this returns the number of times the animal can reproduce
     */
    public int reproduceNum() {
        return reproduceNum;
    }
}
