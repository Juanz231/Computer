package EssentialsGates;

public class not16 {
    byte[] In = new byte[16];
    byte[] Out = new byte[16];

    /**
     * This function creates a new NOT of 16 bits gate.
     *
     * @param In The 16 bits array to negate.
     */
    public not16(byte[] In) {
        setIn(In);
    }
    public not16(byte In) {
        this(Utilities.toBinaryArray(In));
    }

    /**
     * This function return the result of the NOT gate.
     *
     * @return The result of the NOT gate.
     */
    public byte[] getNot() {
        return this.Out;
    }

    /**
     * This function set the 16 bits array to negate.
     *
     * @param In The 16 bits array negated.
     */
    public void setIn(byte[] In) {
        for (int i = 0; i < 16; i++) {
            this.In[i] = In[i];
            this.Out[i] = (byte) (~this.In[i]);
        }
    }
}