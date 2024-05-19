package EssentialsGates;

public class or8way {
    byte[] in = new byte[8];
    byte Out = 0;

    /**
     * This function creates a new OR of 8 bits gate.
     *
     * @param in The 8 bits array to compare.
     */
    public or8way(byte[] in) {
        for (int i = 7; i > 0; i--) {
            this.in[i] = in[i];
            this.Out = (byte) (this.Out | this.in[i]);
        }
    }

    public or8way(byte in) {
        this(Utilities.toBinaryArray(in));
    }

    /**
     * This function return the result of the OR gate.
     *
     * @return The result of the OR gate.
     */
    public byte getOr() {
        return this.Out;
    }

    /**
     * This function set the 8 bits to compare.
     *
     * @param in The 8 bits array to compare.
     */
    public void setIn(byte[] in) {
        for (int i = 0; i < 8; i++) {
            this.in[i] = in[i];
            this.Out = (byte) (this.Out | this.in[i]);
        }
    }
}
