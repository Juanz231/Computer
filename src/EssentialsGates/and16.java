package esencialsGates;


public class and16 {
    byte[] inA = new byte[16];
    byte[] inB = new byte[16];
    byte[] Out = new byte[16];

    /**
     * This function creates a new AND of 16 bits gate.
     *
     * @param inA The firsts 16 bits word to compare.
     * @param inB The second 16 bits word to compare.
     */
    public and16(byte[] inA, byte[] inB) {
        for (int i = 0; i < 16; i++) {
            this.inA[i] = inA[i];
            this.inB[i] = inB[i];
            this.Out[i] = (byte) (this.inA[i] & this.inB[i]);
        }
    }
    public and16(byte inA, byte inB) {
        this(Utilities.toBinaryArray(inA), Utilities.toBinaryArray(inB));
    }

    /**
     * This function return the result of the AND gate.
     *
     * @return The result of the AND gate.
     */
    public byte[] getAnd() {
        return this.Out;
    }

    /**
     * This function set the bits to compare.
     *
     * @param inA The firsts bit to compare.
     * @param inB The second bit to compare.
     */
    public void setIn(byte[] inA, byte[] inB) {
        for (int i = 0; i < 16; i++) {
            this.inA[i] = inA[i];
            this.inB[i] = inB[i];
            this.Out[i] = (byte) (this.inA[i] & this.inB[i]);
        }
    }
}
