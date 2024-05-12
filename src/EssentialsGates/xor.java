package EssentialsGates;

public class xor {
    byte inA = 0;
    byte inB = 0;
    byte Out = 0;

    /**
     * This function creates a new XOR gate.
     *
     * @param inA The firsts bit to compare.
     * @param inB The second bit to compare.
     */
    public xor(byte inA, byte inB) {
        this.inA = inA;
        this.inB = inB;
        this.Out = (byte) (inA ^ inB);
    }
    public xor(int inA, int inB) {
        this((byte)inA, (byte)inB);
    }
    /**
     * This function return the result of the XOR gate.
     *
     * @return The result of the XOR gate.
     */
    public byte getXor(){
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
        this.Out = (byte) (inA ^ inB);
    }
    public void setIn(int inA, int inB) {
        setIn((byte)inA, (byte)inB);
    }
}