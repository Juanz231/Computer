package ProjectPart3.PartA;
import EssentialsGates.Mux;

public class Bit {
    byte In = 0;
    byte Load = 0;
    DFF dff = new DFF(this.In);
    
    byte Out = 0;

    public Bit(byte In, byte Load) {
        this.dff.setIn(this.In);
        this.In = In;
        if (Load == (byte) 1){
            Mux mux = new Mux(dff.getOut(), In, Load);
            this.dff.setIn(mux.getOut());
        }
        this.Out = dff.getOut();
    }

    public Bit(int In, int Load) {
        this((byte) In, (byte) Load);
    }

    public byte getOut(){
        return this.Out;
    }

    public void setIn(byte In, byte Load){
        this.dff.setIn(this.In);
        this.In = In;
        if (Load == (byte) 1){
            Mux mux = new Mux(dff.getOut(), In, Load);
            this.dff.setIn(mux.getOut());
        }
        this.Out = dff.getOut();
    }
    public void setIn(int In, int Load){
        setIn((byte) In, (byte) Load);
    }
}
