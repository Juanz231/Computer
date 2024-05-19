package EssentialsGates;

/**
* This class represents an AND gate.
*/
public class and {
    byte inA = 0;
    byte inB = 0;
    byte Out = 0;

    
    
    /**
     * This function creates a new AND gate.
     *
     * @param inA The first bit to compare.
     * @param inB The second bit to compare.
     */
    public and(byte inA, byte inB) {
        this.inA = inA;
        this.inB = inB;
        this.Out = (byte) (inA & inB);
    }

    /**
     * This function creates a new AND gate.
     *
     * @param inA The first bit to compare.
     * @param inB The second bit to compare.
     */
    public and(int inA, int inB) {
        this((byte)inA, (byte)inB);
    }

    /**
     * This function returns the result of the AND gate.
     *
     * @return The result of the AND gate.
     */
    public byte getAnd(){
        return this.Out;
    }

    /**
     * This function sets the bits to compare.
     *
     * @param inA The first bit to compare.
     * @param inB The second bit to compare.
     */
    public void setIn(byte inA, byte inB) {
        this.inA = inA;
        this.inB = inB;
        this.Out = (byte) (inA & inB);
    }

    /**
     * This function sets the bits to compare.
     *
     * @param inA The first bit to compare.
     * @param inB The second bit to compare.
     */
    public void setIn(int inA, int inB) {
        setIn((byte)inA, (byte)inB);
    }
}