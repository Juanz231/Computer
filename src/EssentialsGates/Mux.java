package EssentialsGates;

public class Mux {
    byte InA;
    byte InB;
    byte Sel;
    byte Out;

    public Mux(byte InA, byte InB, byte Sel) {
        this.InA = InA;
        this.InB = InB;
        this.Sel = Sel;
        this.Out = (byte) ((~Sel & InA) | (Sel & InB));
    }

    public byte getOut() {
        return this.Out;
    }

    public void setIn(byte InA, byte InB, byte Sel) {
        this.InA = InA;
        this.InB = InB;
        this.Sel = Sel;
        this.Out = (byte) ((~Sel & InA) | (Sel & InB));
    }
}
