package EssentialsGates;

public class Mux16 {
    byte[] InA = new byte[16];
    byte[] InB = new byte[16];
    byte Sel;
    byte[] Out = new byte[16];

    public Mux16(byte[] InA, byte[] InB, byte Sel) {
        this.InA = InA;
        this.InB = InB;
        this.Sel = Sel;
        for (int i = 0; i < 16; i++) {
            this.Out[i] = (byte) ((~Sel & InA[i]) | (Sel & InB[i]));
        }
    }
    public Mux16(byte InA, byte InB, byte Sel) {
        this(Utilities.toBinaryArray(InA), Utilities.toBinaryArray(InB), Sel);
    }

    public byte[] getOut() {
        return this.Out;
    }

    public void setIn(byte[] InA, byte[] InB, byte Sel) {
        this.InA = InA;
        this.InB = InB;
        this.Sel = Sel;
        for (int i = 0; i < 16; i++) {
            this.Out[i] = (byte) ((~Sel & InA[i]) | (Sel & InB[i]));
        }
    }

}
