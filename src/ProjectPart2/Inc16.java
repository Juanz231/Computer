package ProjectPart2;
import EssentialsGates.*;
public class Inc16 {
    byte[] In;
    byte[] Out;

    public Inc16(byte[] In) {
        this.In = In;
        this.Out = new byte[16];
        Add16 adder = new Add16(In, Utilities.toBinaryArray((byte) 1));
        this.Out = adder.getOut();
    }
    public Inc16(byte In) {
        this(Utilities.toBinaryArray(In));
    }

    public byte[] getOut(){
        return this.Out;
    }

    public void setIn(byte[] In) {
        this.In = In;
        this.Out = new byte[16];
        Add16 adder = new Add16(In, Utilities.toBinaryArray((byte) 1));
        this.Out = adder.getOut();
    }
    public void setIn(byte In) {
        setIn(Utilities.toBinaryArray(In));
    }
}
