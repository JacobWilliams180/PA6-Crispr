
public class Mosquito extends Insect {
    private boolean val2;
    private boolean val3;

    /*
     * METHOD: Mosquito
     * PURPOSE: this constructs the object and sets fields
     */
    public Mosquito(String type, String gender, boolean val, boolean val2,
            boolean val3) {
        super(type, gender, val);
        this.val2 = val2;
        this.val3 = val3;
    }

}
