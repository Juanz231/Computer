package esencialsGates;

public class or {
    byte inA = 0;
    byte inB = 0;
    byte Out = 0;

    /**
     * This function creates a new OR gate.
     *
     * @param inA The firsts bit to compare.
     * @param inB The second bit to compare.
     */
    public or(byte inA, byte inB) {
        this.inA = inA;
        this.inB = inB;
        this.Out = (byte) (inA | inB);
    }

    public or(int inA, int inB) {
        this((byte)inA, (byte)inB);
    }

    /**
     * This function return the result of the OR gate.
     *
     * @return The result of the OR gate.
     */
    public byte getOr(){
        return this.Out;
    }

    /**
     * This function set the bits to compare.
     *
     * @param inA The firsts bit to compare.
     * @param inB The second bit to compare.
     */
    public void setIn(byte inA, byte inB) {
        this.inA = inA;
        this.inB = inB;
        this.Out = (byte) (inA | inB);
    }
    public void setIn(int inA, int inB) {
        setIn((byte)inA, (byte)inB);
    }
}