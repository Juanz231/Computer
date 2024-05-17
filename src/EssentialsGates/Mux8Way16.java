package EssentialsGates;

public class Mux8Way16 {
    byte[] InA = new byte[16];
    byte[] InB = new byte[16];
    byte[] InC = new byte[16];
    byte[] InD = new byte[16];
    byte[] InE = new byte[16];
    byte[] InF = new byte[16];
    byte[] InG = new byte[16];
    byte[] InH = new byte[16];
    byte[] Sel = new byte[3];
    byte[] Out = new byte[16];

    public Mux8Way16(byte[] InA, byte[] InB, byte[] InC, byte[] InD, byte[] InE, byte[] InF, byte[] InG, byte[] InH, byte[] Sel) {
        this.InA = InA;
        this.InB = InB;
        this.InC = InC;
        this.InD = InD;
        this.InE = InE;
        this.InF = InF;
        this.InG = InG;
        this.InH = InH;
        this.Sel = Sel;
        Mux16 mux1 = new Mux16(InA, InB, Sel[2]);
        Mux16 mux2 = new Mux16(InC, InD, Sel[2]);
        Mux16 mux3 = new Mux16(InE, InF, Sel[2]);
        Mux16 mux4 = new Mux16(InG, InH, Sel[2]);
        Mux16 mux5 = new Mux16(mux1.getOut(), mux2.getOut(), Sel[1]);
        Mux16 mux6 = new Mux16(mux3.getOut(), mux4.getOut(), Sel[1]);
        Mux16 mux7 = new Mux16(mux5.getOut(), mux6.getOut(), Sel[0]);
        this.Out = mux7.getOut();
    }
    public Mux8Way16(byte InA, byte InB, byte InC, byte InD, byte InE, byte InF, byte InG, byte InH, byte[] Sel) {
        this(Utilities.toBinaryArray(InA), Utilities.toBinaryArray(InB), Utilities.toBinaryArray(InC), Utilities.toBinaryArray(InD), Utilities.toBinaryArray(InE), Utilities.toBinaryArray(InF), Utilities.toBinaryArray(InG), Utilities.toBinaryArray(InH), Sel);
    }

    public byte[] getOut() {
        return this.Out;
    }

    public void setIn(byte[] InA, byte[] InB, byte[] InC, byte[] InD, byte[] InE, byte[] InF, byte[] InG, byte[] InH, byte[] Sel) {
        this.InA = InA;
        this.InB = InB;
        this.InC = InC;
        this.InD = InD;
        this.InE = InE;
        this.InF = InF;
        this.InG = InG;
        this.InH = InH;
        this.Sel = Sel;
        Mux16 mux1 = new Mux16(InA, InB, Sel[2]);
        Mux16 mux2 = new Mux16(InC, InD, Sel[2]);
        Mux16 mux3 = new Mux16(InE, InF, Sel[2]);
        Mux16 mux4 = new Mux16(InG, InH, Sel[2]);
        Mux16 mux5 = new Mux16(mux1.getOut(), mux2.getOut(), Sel[1]);
        Mux16 mux6 = new Mux16(mux3.getOut(), mux4.getOut(), Sel[1]);
        Mux16 mux7 = new Mux16(mux5.getOut(), mux6.getOut(), Sel[0]);
        this.Out = mux7.getOut();
    }
    public void setIn(byte InA, byte InB, byte InC, byte InD, byte InE, byte InF, byte InG, byte InH, byte Sel) {
        this.setIn(Utilities.toBinaryArray(InA), Utilities.toBinaryArray(InB), Utilities.toBinaryArray(InC), Utilities.toBinaryArray(InD), Utilities.toBinaryArray(InE), Utilities.toBinaryArray(InF), Utilities.toBinaryArray(InG), Utilities.toBinaryArray(InH), Utilities.toBinaryArray(Sel));
    }
}
