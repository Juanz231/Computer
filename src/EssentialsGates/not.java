package esencialsGates;



public class not {
    byte In;
    byte Out;

    /**
     * This function creates a new NOT gate.
     *
     * @param In The bit to negate.
     */
    public not(byte In) {
        this.In = In;
        this.Out = (byte) (~In);
    }

    /**
     * This function return the result of the NOT gate.
     *
     * @return The result of the NOT gate.
     */
    public int getNot(){
        return this.Out;
    }

    /**
     * This function set the bit to negate.
     *
     * @param In The bit to negate.
     */
    public void setIn(byte In) {
        this.In = In;
        this.Out = (byte) (~In);
    }
    public void setIn(int In) {
        setIn((byte)In);
    }
}
