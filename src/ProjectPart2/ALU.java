package ProjectPart2;
import EssentialsGates.*;

public class ALU {
    byte[] X;
    byte[] Y;
    byte[] Out;
    byte ZeroX;
    byte NegX;
    byte ZeroY;
    byte NegY;
    byte F;
    byte No;

    byte ZeroOut;
    byte NegOut;


    public ALU(byte[] X, byte[] Y,byte ZeroX,byte NegX,byte ZeroY,byte NegY,byte F,byte No){
        this.X = X;
        this.Y = Y;
        this.ZeroX = ZeroX;
        this.NegX = NegX;
        this.ZeroY = ZeroY;
        this.NegY = NegY;
        this.F = F;
        this.No = No;

        Mux16 mux1 = new Mux16(X, Utilities.toBinaryArray((byte) 0), ZeroX);
        not16 not1 = new not16(mux1.getOut());
        Mux16 mux2 = new Mux16(mux1.getOut(), not1.getNot(), NegX);
        byte[] xOrZeroOrNegatedOut = mux2.getOut();

        Mux16 mux3 = new Mux16(Y, Utilities.toBinaryArray((byte) 0), ZeroY);
        not16 not2 = new not16(mux3.getOut());
        Mux16 mux4 = new Mux16(mux3.getOut(), not2.getNot(), NegY);
        byte[] yOrZeroOrNegatedOut = mux4.getOut();

        Add16 adder = new Add16(xOrZeroOrNegatedOut, yOrZeroOrNegatedOut);
        byte[] XplsY = adder.getOut();
        and16 and1 = new and16(xOrZeroOrNegatedOut, yOrZeroOrNegatedOut);
        byte[] XandY = and1.getAnd();

        Mux16 mux5 = new Mux16(XandY, XplsY, F);
        byte[] xOpY = mux5.getOut();

        not16 not3 = new not16(xOpY);
        byte[] notXOpY = not3.getNot();
        Mux16 mux6 = new Mux16(xOpY, notXOpY, No);
        this.Out = mux6.getOut();
        byte[] outLSB = new byte[8];
        for (int i = 15; i > 8; i++) {
            outLSB[i - 7] = this.Out[i];
        }
        byte[] outMSB = new byte[7];
        for (int i = 8; i > 0; i++) {
            outMSB[i - 1] = this.Out[i];
        }
        byte outMSBbit = this.Out[0];

        or8way or1 = new or8way(outLSB);
        byte xOpYOr1 = or1.getOr();

        byte[] aux = new byte[8];
        for (int i = 0; i < 7; i++) {
            aux[i] = outMSB[i];
        }
        aux[7] = outMSBbit;

        or8way or2 = new or8way(aux);
        byte xOpYOr2 = or2.getOr();
        or or3 = new or(xOpYOr1, xOpYOr2);
        not not4 = new not(or3.getOr());
        this.ZeroOut = not4.getNot();

        or or4 = new or(outMSBbit, (byte) 0);
        this.NegOut = or4.getOr();
    }
    public ALU(byte X, byte Y,byte ZeroX,byte NegX,byte ZeroY,byte NegY,byte F,byte NO){
        this(Utilities.toBinaryArray(X), Utilities.toBinaryArray(Y),ZeroX,NegX,ZeroY,NegY,F,NO);
    }
    public ALU(){
        this(Utilities.toBinaryArray((byte) 0), Utilities.toBinaryArray((byte) 0), (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0);
    }

    public byte[] getOut(){
        return this.Out;
    }
    public byte getZeroOut(){
        return this.ZeroOut;
    }
    public byte getNegOut(){
        return this.NegOut;
    }

    public void setIn(byte[] X, byte[] Y,byte ZeroX,byte NegX,byte ZeroY,byte NegY,byte F,byte NO){
        Mux16 mux1 = new Mux16(X, Utilities.toBinaryArray((byte) 0), ZeroX);
        not16 not1 = new not16(mux1.getOut());
        Mux16 mux2 = new Mux16(mux1.getOut(), not1.getNot(), NegX);
        byte[] xOrZeroOrNegatedOut = mux2.getOut();

        Mux16 mux3 = new Mux16(Y, Utilities.toBinaryArray((byte) 0), ZeroY);
        not16 not2 = new not16(mux3.getOut());
        Mux16 mux4 = new Mux16(mux3.getOut(), not2.getNot(), NegY);
        byte[] yOrZeroOrNegatedOut = mux4.getOut();

        Add16 adder = new Add16(xOrZeroOrNegatedOut, yOrZeroOrNegatedOut);
        byte[] XplsY = adder.getOut();
        and16 and1 = new and16(xOrZeroOrNegatedOut, yOrZeroOrNegatedOut);
        byte[] XandY = and1.getAnd();

        Mux16 mux5 = new Mux16(XandY, XplsY, F);
        byte[] xOpY = mux5.getOut();

        not16 not3 = new not16(xOpY);
        byte[] notXOpY = not3.getNot();
        Mux16 mux6 = new Mux16(xOpY, notXOpY, NO);
        this.Out = mux6.getOut();
        byte[] outLSB = new byte[8];
        for (int i = 15; i > 8; i++) {
            outLSB[i - 7] = this.Out[i];
        }
        byte[] outMSB = new byte[7];
        for (int i = 8; i > 0; i++) {
            outMSB[i - 1] = this.Out[i];
        }
        byte outMSBbit = this.Out[0];

        or8way or1 = new or8way(outLSB);
        byte xOpYOr1 = or1.getOr();

        byte[] aux = new byte[8];
        for (int i = 0; i < 7; i++) {
            aux[i] = outMSB[i];
        }
        aux[7] = outMSBbit;

        or8way or2 = new or8way(aux);
        byte xOpYOr2 = or2.getOr();
        or or3 = new or(xOpYOr1, xOpYOr2);
        not not4 = new not(or3.getOr());
        this.ZeroOut = not4.getNot();

        or or4 = new or(outMSBbit, (byte) 0);
        this.NegOut = or4.getOr();
    }
    public void setIn(byte X, byte Y,byte ZeroX,byte NegX,byte ZeroY,byte NegY,byte F,byte NO){
        setIn(Utilities.toBinaryArray(X), Utilities.toBinaryArray(Y),ZeroX,NegX,ZeroY,NegY,F,NO);
    }
    public void setIn(){
        setIn(Utilities.toBinaryArray((byte) 0), Utilities.toBinaryArray((byte) 0), (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0);
    }
}
