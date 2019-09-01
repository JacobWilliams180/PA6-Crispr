
public class Animal {
    private String type;
    private String gender;
    private String direction;
    private int moves;

    /*
     * METHOD: Animal
     * PURPOSE: this creates the animal object and sets fields
     */
    public Animal(String type, String gender) {
        this.type = type;
        this.gender = gender;
    }

    /*
     * METHOD: toString
     * PURPOSE: returns a string representation of the object
     */
    public String toString() {
        return type + " " + gender;
    }

    /*
     * METHOD: getName
     * PURPOSE: returns the name of the animal object
     */
    public String getName() {
        return type;
    }

    /*
     * METHOD: getMoves
     * PURPOSE: this returns an int of the moves
     */
    public int getMoves() {
        return moves;
    }

    /*
     * METHOD: getGender
     * PURPOSE: this returns the string of the gender of the animal
     */
    public String getGender() {
        return gender;
    }

    /*
     * METHOD: getDirection
     * PURPOSE: returns the string of the direction of the animal is taking
     */
    public String getDirection() {
        return direction;
    }

}
