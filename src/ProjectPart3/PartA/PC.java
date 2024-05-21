package ProjectPart3.PartA;
import ProjectPart2.*;
import EssentialsGates.*;

public class PC {
    private byte[] In;
    private byte Load;
    private byte Inc;
    private byte Reset;
    private byte[] Out;

    private Register register;

    public PC(byte[] In, byte Load, byte Inc, byte Reset) {
        this.In = In;
        this.Load = Load;
        this.Inc = Inc;
        this.Reset = Reset;
        this.Out = new byte[16];

        this.register = new Register(new byte[16], (byte) 0); // Inicializamos el registro con ceros

        updateOut();
    }

    public PC(byte In, byte Load, byte Inc, byte Reset) {
        this(Utilities.toBinaryArray(In), Load, Inc, Reset);
    }
    public PC(){
        this(Utilities.toBinaryArray((byte) 0), (byte) 0, (byte) 0, (byte) 0);
    }

    public byte[] getOut() {
        return this.Out;
    }

    public void setIn(byte[] In, byte Load, byte Inc, byte Reset) {
        this.In = In;
        this.Load = Load;
        this.Inc = Inc;
        this.Reset = Reset;
        updateOut();
    }

    public void setIn(byte In, byte Load, byte Inc, byte Reset) {
        setIn(Utilities.toBinaryArray(In), Load, Inc, Reset);
    }

    private void updateOut() {
        Inc16 inc16 = new Inc16(register.getOut());
        byte[] incOut = inc16.getOut();

        Mux16 mux1 = new Mux16(register.getOut(), incOut, Inc);
        byte[] muxOut1 = mux1.getOut();

        Mux16 mux2 = new Mux16(muxOut1, In, Load);
        byte[] muxOut2 = mux2.getOut();

        Mux16 mux3 = new Mux16(muxOut2, new byte[16], Reset);
        byte[] regInput = mux3.getOut();

        byte loadOrInc = (byte) (Load | Inc);
        byte loadOrIncOrReset = (byte) (loadOrInc | Reset);

        register.setIn(regInput, loadOrIncOrReset);
        this.Out = register.getOut();
    }
}