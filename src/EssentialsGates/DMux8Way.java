package EssentialsGates;

public class DMux8Way {
    byte In;
    byte[] Sel = new byte[3];
    byte a;
    byte b;
    byte c;
    byte d;
    byte e;
    byte f;
    byte g;
    byte h;

    public DMux8Way(byte In, byte[] Sel) {
        this.In = In;
        this.Sel = Sel;
        DMux dmux1 = new DMux(In, Sel[2]);
        DMux dmux2 = new DMux(dmux1.getA(), Sel[1]);
        DMux dmux3 = new DMux(dmux1.getB(), Sel[1]);
        DMux dmux4 = new DMux(dmux2.getA(), Sel[0]);
        DMux dmux5 = new DMux(dmux2.getB(), Sel[0]);
        DMux dmux6 = new DMux(dmux3.getA(), Sel[0]);
        DMux dmux7 = new DMux(dmux3.getB(), Sel[0]);
        this.a = dmux4.getA();
        this.b = dmux4.getB();
        this.c = dmux5.getA();
        this.d = dmux5.getB();
        this.e = dmux6.getA();
        this.f = dmux6.getB();
        this.g = dmux7.getA();
        this.h = dmux7.getB();
    }
    public DMux8Way(byte In, byte Sel) {
        this(In, Utilities.toBinaryArray(Sel));
    }

    public byte getA() {
        return this.a;
    }
    public byte getB() {
        return this.b;
    }
    public byte getC() {
        return this.c;
    }
    public byte getD() {
        return this.d;
    }
    public byte getE() {
        return this.e;
    }
    public byte getF() {
        return this.f;
    }
    public byte getG() {
        return this.g;
    }
    public byte getH() {
        return this.h;
    }

    public void setIn(byte In, byte[] Sel) {
        this.In = In;
        this.Sel = Sel;
        DMux dmux1 = new DMux(In, Sel[2]);
        DMux dmux2 = new DMux(dmux1.getA(), Sel[1]);
        DMux dmux3 = new DMux(dmux1.getB(), Sel[1]);
        DMux dmux4 = new DMux(dmux2.getA(), Sel[0]);
        DMux dmux5 = new DMux(dmux2.getB(), Sel[0]);
        DMux dmux6 = new DMux(dmux3.getA(), Sel[0]);
        DMux dmux7 = new DMux(dmux3.getB(), Sel[0]);
        this.a = dmux4.getA();
        this.b = dmux4.getB();
        this.c = dmux5.getA();
        this.d = dmux5.getB();
        this.e = dmux6.getA();
        this.f = dmux6.getB();
        this.g = dmux7.getA();
        this.h = dmux7.getB();
    }
}
