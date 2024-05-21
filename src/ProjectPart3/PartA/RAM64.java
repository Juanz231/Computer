package ProjectPart3.PartA;

import EssentialsGates.DMux8Way;
import EssentialsGates.Mux8Way16;
import EssentialsGates.Utilities;

public class RAM64 {
    private RAM8[] rams = new RAM8[8];
    private byte[] In;
    private byte Load;
    private byte[] Address;
    private byte[] Out;

    public RAM64(byte[] In, byte Load, byte[] Address) {
        this.In = In;
        this.Load = Load;
        this.Address = Address;
        this.Out = new byte[16];

        // Inicializar los bancos de RAM
        for (int i = 0; i < 8; i++) {
            rams[i] = new RAM8(new byte[16], (byte) 0, new byte[3]);
        }

        // Actualizar los bancos de RAM y la salida
        updateRAMsAndOut();
    }

    public RAM64(byte In, byte Load, byte Address) {
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
        byte[] address_3_5 = {Address[3], Address[4], Address[5]};
        byte[] address_0_2 = {Address[0], Address[1], Address[2]};

        // Demultiplexar la señal de carga a los bancos de RAM correctos
        DMux8Way dmux8Way = new DMux8Way(Load, address_3_5);
        byte sel0 = dmux8Way.getA();
        byte sel1 = dmux8Way.getB();
        byte sel2 = dmux8Way.getC();
        byte sel3 = dmux8Way.getD();
        byte sel4 = dmux8Way.getE();
        byte sel5 = dmux8Way.getF();
        byte sel6 = dmux8Way.getG();
        byte sel7 = dmux8Way.getH();

        // Actualizar cada banco de RAM con la señal de carga correspondiente
        rams[0].setIn(In, sel0, address_0_2);
        rams[1].setIn(In, sel1, address_0_2);
        rams[2].setIn(In, sel2, address_0_2);
        rams[3].setIn(In, sel3, address_0_2);
        rams[4].setIn(In, sel4, address_0_2);
        rams[5].setIn(In, sel5, address_0_2);
        rams[6].setIn(In, sel6, address_0_2);
        rams[7].setIn(In, sel7, address_0_2);

        // Multiplexar la salida de los bancos de RAM a la salida del RAM64
        Mux8Way16 mux8Way16 = new Mux8Way16(
                rams[0].getOut(),
                rams[1].getOut(),
                rams[2].getOut(),
                rams[3].getOut(),
                rams[4].getOut(),
                rams[5].getOut(),
                rams[6].getOut(),
                rams[7].getOut(),
                address_3_5
        );

        this.Out = mux8Way16.getOut();
    }
}