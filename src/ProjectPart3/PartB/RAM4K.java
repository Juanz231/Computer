package ProjectPart3.PartB;

import EssentialsGates.DMux8Way;
import EssentialsGates.Mux8Way16;
import EssentialsGates.Utilities;

public class RAM4K {
    private byte[] In;
    private byte Load;
    private byte[] Address;
    private byte[] Out;

    private RAM512[] rams = new RAM512[8];

    public RAM4K(byte[] In, byte Load, byte[] Address) {
        this.In = In;
        this.Load = Load;
        this.Address = Address;
        this.Out = new byte[16];

        // Inicializar los bancos de RAM512
        for (int i = 0; i < 8; i++) {
            rams[i] = new RAM512(new byte[16], (byte) 0, new byte[12]);
        }

        // Actualizar los bancos de RAM512 y la salida
        updateRAMsAndOut();
    }

    public RAM4K(byte In, byte Load, byte Address) {
        this(Utilities.toBinaryArray(In), Load, Utilities.toBinaryArray(Address));
    }

    public byte[] getOut() {
        return this.Out;
    }

    public void setIn(byte[] In, byte Load, byte[] Address) {
        this.In = In;
        this.Load = Load;
        this.Address = Address;
        updateRAMsAndOut();
    }

    public void setIn(byte In, byte Load, byte Address) {
        setIn(Utilities.toBinaryArray(In), Load, Utilities.toBinaryArray(Address));
    }

    private void updateRAMsAndOut() {
        // Dividir la dirección en dos partes
        byte[] address_9_11 = {Address[9], Address[10], Address[11]};
        byte[] address_0_8 = {Address[0], Address[1], Address[2], Address[3], Address[4], Address[5], Address[6], Address[7], Address[8]};

        // Demultiplexar la señal de carga a los bancos de RAM512 correctos
        DMux8Way dmux8Way = new DMux8Way(Load, address_9_11);
        byte sel0 = dmux8Way.getA();
        byte sel1 = dmux8Way.getB();
        byte sel2 = dmux8Way.getC();
        byte sel3 = dmux8Way.getD();
        byte sel4 = dmux8Way.getE();
        byte sel5 = dmux8Way.getF();
        byte sel6 = dmux8Way.getG();
        byte sel7 = dmux8Way.getH();

        // Actualizar cada banco de RAM512 con la señal de carga correspondiente
        rams[0].setIn(In, sel0, address_0_8);
        rams[1].setIn(In, sel1, address_0_8);
        rams[2].setIn(In, sel2, address_0_8);
        rams[3].setIn(In, sel3, address_0_8);
        rams[4].setIn(In, sel4, address_0_8);
        rams[5].setIn(In, sel5, address_0_8);
        rams[6].setIn(In, sel6, address_0_8);
        rams[7].setIn(In, sel7, address_0_8);

        // Multiplexar la salida de los bancos de RAM512 a la salida del RAM4K
        Mux8Way16 mux8Way16 = new Mux8Way16(
                rams[0].getOut(),
                rams[1].getOut(),
                rams[2].getOut(),
                rams[3].getOut(),
                rams[4].getOut(),
                rams[5].getOut(),
                rams[6].getOut(),
                rams[7].getOut(),
                address_9_11
        );

        this.Out = mux8Way16.getOut();
    }
}