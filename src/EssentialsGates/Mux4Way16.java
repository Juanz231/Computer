package EssentialsGates;

public class Mux4Way16 {
    byte[] InA = new byte[16];
    byte[] InB = new byte[16];
    byte[] InC = new byte[16];
    byte[] InD = new byte[16];
    byte[] Sel = new byte[2];
    byte[] Out = new byte[16];

    public Mux4Way16(byte[] InA, byte[] InB, byte[] InC, byte[] InD, byte[] Sel) {
        this.InA = InA;
        this.InB = InB;
        this.InC = InC;
        this.InD = InD;
        this.Sel = Sel;
        Mux16 mux1 = new Mux16(InA, InB, Sel[1]);
        Mux16 mux2 = new Mux16(InC, InD, Sel[1]);
        Mux16 mux3 = new Mux16(mux1.getOut(), mux2.getOut(), Sel[0]);
        this.Out = mux3.getOut();
    }
    public Mux4Way16(byte InA, byte InB, byte InC, byte InD,byte Sel) {
        this(Utilities.toBinaryArray(InA), Utilities.toBinaryArray(InB), Utilities.toBinaryArray(InC), Utilities.toBinaryArray(InD), Utilities.toBinaryArray(Sel));
    }

    public byte[] getOut() {
        return this.Out;
    }

    public void setIn(byte[] InA, byte[] InB, byte[] InC, byte[] InD, byte[] Sel) {
        this.InA = InA;
        this.InB = InB;
        this.InC = InC;
        this.InD = InD;
        this.Sel = Sel;
        Mux16 mux1 = new Mux16(InA, InB, Sel[1]);
        Mux16 mux2 = new Mux16(InC, InD, Sel[1]);
        Mux16 mux3 = new Mux16(mux1.getOut(), mux2.getOut(), Sel[0]);
        this.Out = mux3.getOut();
    }
    public void setIn(byte InA, byte InB, byte InC, byte InD, byte Sel) {
        this.setIn(Utilities.toBinaryArray(InA), Utilities.toBinaryArray(InB), Utilities.toBinaryArray(InC), Utilities.toBinaryArray(InD), Utilities.toBinaryArray(Sel));
    }
}
