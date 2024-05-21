package EssentialsGates;

public class DMux4Way {
    byte In;
    byte[] Sel;
    byte a;
    byte b;
    byte c;
    byte d;

    public DMux4Way(byte In, byte[] Sel) {
        this.In = In;
        this.Sel = Sel;
        DMux dmux1 = new DMux(In, Sel[1]);
        DMux dmux2 = new DMux(dmux1.getA(), Sel[0]);
        DMux dmux3 = new DMux(dmux1.getB(), Sel[0]);
        this.a = dmux2.getA();
        this.b = dmux2.getB();
        this.c = dmux3.getA();
        this.d = dmux3.getB();
    }
    public DMux4Way(byte In, byte Sel) {
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

    public void setIn(byte In, byte[] Sel){
        this.In = In;
        this.Sel = Sel;
        DMux dmux1 = new DMux(In, Sel[1]);
        DMux dmux2 = new DMux(dmux1.getA(), Sel[0]);
        DMux dmux3 = new DMux(dmux1.getB(), Sel[0]);
        this.a = dmux2.getA();
        this.b = dmux2.getB();
        this.c = dmux3.getA();
        this.d = dmux3.getB();
    }
    public void setIn(byte In, byte Sel){
        this.setIn(In, Utilities.toBinaryArray(Sel));
    }

}
