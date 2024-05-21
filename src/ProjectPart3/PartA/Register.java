package ProjectPart3.PartA;

import EssentialsGates.Utilities;

public class Register {
    private Bit[] bits = new Bit[16];  // Estado interno del registro representado por una matriz de Bits
    private byte[] Out = new byte[16];  // Salida del registro
    private byte load;

    // Constructor que inicializa el registro con un array de bytes y una señal de carga
    public Register(byte[] In, byte Load) {
        this.load = Load;
        for (int i = 0; i < 16; i++) {
            bits[i] = new Bit(In[i], Load);
        }
        updateOut();
    }

    // Constructor que inicializa el registro con un byte y una señal de carga
    public Register(byte In, byte Load) {
        this(Utilities.toBinaryArray(In), Load);
    }
    public Register(){
        this(Utilities.toBinaryArray((byte) 0),(byte) 0);
    }

    // Método para obtener el estado actual del registro
    public byte[] getOut() {
        return this.Out;
    }

    // Método para establecer el estado del registro con un array de bytes y una señal de carga
    public void setIn(byte[] In, byte Load) {
        this.load = Load;
        for (int i = 0; i < 16; i++) {
            bits[i].setIn(In[i], Load);
        }
        updateOut();
    }

    // Método para establecer el estado del registro con un byte y una señal de carga
    public void setIn(byte In, byte Load) {
        setIn(Utilities.toBinaryArray(In), Load);
    }

    // Método para actualizar la salida del registro
    private void updateOut() {
        for (int i = 0; i < 16; i++) {
            this.Out[i] = bits[i].getOut();
        }
    }
}