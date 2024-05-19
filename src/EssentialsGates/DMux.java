package EssentialsGates;

public class DMux {
    byte In;
    byte Sel;
    byte a;
    byte b;

    public DMux(byte In, byte Sel) {
        this.In = (byte) In;
        this.Sel = Sel;
        this.a = (byte) (In & ~Sel);
        this.b = (byte) (In & Sel);
    }
    public DMux(int In, int Sel) {
        this((byte) In, (byte) Sel);
    }

    public byte getA() {
        return this.a;
    }
    public byte getB() {
        return this.b;
    }

    public void setIn(byte In, byte Sel) {
        this.In = In;
        this.Sel = Sel;
        this.a = (byte) (In & ~Sel);
        this.b = (byte) (In & Sel);
    }
    public void setIn(int In, int Sel) {
        this.setIn((byte) In, (byte) Sel);
    }

}
