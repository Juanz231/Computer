package ProjectPart3.PartA;
import EssentialsGates.Utilities;


public class Register {
    byte[] In = new byte[16];
    byte Load;;
    
    byte[] Out = new byte[16];
    
    public Register(byte[] In, byte Load) {
        this.In = In;
        this.Load = Load;
        Bit[] bits = new Bit[16];
        for (int i = 0; i < 16; i++){
            bits[i] = new Bit(In[i], Load);
        }
        this.Out = new byte[16];
        for (int i = 0; i < 16; i++){
            this.Out[i] = bits[i].getOut();
        }
    }
    public Register(byte In, byte Load) {
        this(Utilities.toBinaryArray(In), Load);
    }

    public byte[] getOut(){
        return this.Out;
    }

    public void setIn(byte[] In, byte Load){
        this.In = In;
        this.Load = Load;
        Bit[] bits = new Bit[16];
        for (int i = 0; i < 16; i++){
            bits[i] = new Bit(In[i], Load);
        }
        this.Out = new byte[16];
        for (int i = 0; i < 16; i++){
            this.Out[i] = bits[i].getOut();
        }
    }
    public void setIn(byte In, byte Load){
        setIn(Utilities.toBinaryArray(In), Load);
    }

}
