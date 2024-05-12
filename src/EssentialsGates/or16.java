package esencialsGates;

public class or16 {
    byte[] inA = new byte[16];
    byte[] inB = new byte[16];
    byte[] Out = new byte[16];

    /**
     * This function creates a new OR of 16 bits gate.
     *
     * @param inA The firsts 16 bits array to compare. [List]
     * @param inB The second 16 bits array to compare. [List]
     */
    public or16(byte[] inA, byte[] inB) {
        for (int i = 0; i < 16; i++) {
            this.inA[i] = inA[i];
            this.inB[i] = inB[i];
            this.Out[i] = (byte) (this.inA[i] | this.inB[i]);
        }
    }
    public or16(byte inA, byte inB) {
        this(Utilities.toBinaryArray(inA), Utilities.toBinaryArray(inB));
    }



    /**
     * This function return the result of the OR gate.
     *
     * @return The result of the OR gate. [List]
     */
    public byte[] getOr() {
        return this.Out;
    }

    /**
     * This function set the 16 bits to compare.
     *
     * @param inA The firsts 16 bits array to compare. [List]
     * @param inB The second 16 bits array to compare. [List]
     */
    public void setIn(byte[] inA, byte[] inB) {
        for (int i = 0; i < 16; i++) {
            this.inA[i] = inA[i];
            this.inB[i] = inB[i];
            this.Out[i] = (byte) (this.inA[i] | this.inB[i]);
        }
    }
}