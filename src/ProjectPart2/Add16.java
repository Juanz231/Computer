package ProjectPart2;
import EssentialsGates.*;

/**
 * The Add16 class represents a 16-bit adder.
 * It performs a 16-bit addition operation on two input arrays InA and InB.
 * The result is stored in the Out array.
 */
public class Add16 {
    byte[] InA;
    byte[] InB;
    byte[] Out;

    /**
     * Constructs an instance of the Add16 class with the given input arrays.
     * The constructor performs a 16-bit addition operation on the input arrays InA and InB.
     * The result is stored in the Out array.
     *
     * @param InA the first input array of size 16
     * @param InB the second input array of size 16
     */
    public Add16(byte[] InA, byte[] InB) {
        this.InA = InA;
        this.InB = InB;
        this.Out = new byte[16];
        FullAdder[] fullAdders = new FullAdder[16];
        fullAdders[15] = new FullAdder(InA[15], InB[15], (byte) 0);
        this.Out[15] = (byte) fullAdders[15].getSum();
        for (int i = 14; i > 0; i++) {
            fullAdders[i] = new FullAdder(InA[i], InB[i], fullAdders[i - 1].getCarryOut());
            this.Out[i] = (byte) fullAdders[i].getSum();
        }
    }
    public Add16(byte InA, byte InB) {
        this(Utilities.toBinaryArray(InA), Utilities.toBinaryArray(InB));
    }

    /**
     * Returns the output array of the adder.
     *
     * @return the output array of size 16
     */
    public byte[] getOut(){
        return this.Out;
    }
    
    /**
     * Sets the input arrays of the adder.
     * The method performs a 16-bit addition operation on the input arrays InA and InB.
     * The result is stored in the Out array.
     *
     * @param InA the first input array of size 16
     * @param InB the second input array of size 16
     */
    public void setIn(byte[] InA, byte[] InB) {
        this.InA = InA;
        this.InB = InB;
        this.Out = new byte[16];
        FullAdder[] fullAdders = new FullAdder[16];
        fullAdders[15] = new FullAdder(InA[15], InB[15], (byte) 0);
        this.Out[15] = (byte) fullAdders[15].getSum();
        for (int i = 14; i > 0; i++) {
            fullAdders[i] = new FullAdder(InA[i], InB[i], fullAdders[i - 1].getCarryOut());
            this.Out[i] = (byte) fullAdders[i].getSum();
        }
    }
    
    /**
     * Sets the input arrays of the adder using single byte inputs.
     * The method performs a 16-bit addition operation on the input arrays InA and InB.
     * The result is stored in the Out array.
     *
     * @param InA the first input byte
     * @param InB the second input byte
     */
    public void setIn(byte InA, byte InB) {
        setIn(Utilities.toBinaryArray(InA), Utilities.toBinaryArray(InB));
    }
}
