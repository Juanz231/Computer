package ProjectPart3.PartB;

import EssentialsGates.DMux4Way;
import EssentialsGates.Mux4Way16;
import EssentialsGates.Utilities;

public class RAM16K {
    private byte[] In;
    private byte Load;
    private byte[] Address;
    private byte[] Out;

    private RAM4K[] rams = new RAM4K[4];

    public RAM16K(byte[] In, byte Load, byte[] Address) {
        this.In = In;
        this.Load = Load;
        this.Address = Address;
        this.Out = new byte[16];

        // Inicializar los bancos de RAM4K
        for (int i = 0; i < 4; i++) {
            rams[i] = new RAM4K(new byte[16], (byte) 0, new byte[14]);
        }

        // Actualizar los bancos de RAM4K y la salida
        updateRAMsAndOut();
    }

    public RAM16K(byte In, byte Load, byte Address) {
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
        byte[] address_12_13 = {Address[12], Address[13]};
        byte[] address_0_11 = {Address[0], Address[1], Address[2], Address[3], Address[4], Address[5], Address[6], Address[7], Address[8], Address[9], Address[10], Address[11]};

        // Demultiplexar la señal de carga a los bancos de RAM4K correctos
        DMux4Way dmux4Way = new DMux4Way(Load, address_12_13);
        byte sel0 = dmux4Way.getA();
        byte sel1 = dmux4Way.getB();
        byte sel2 = dmux4Way.getC();
        byte sel3 = dmux4Way.getD();

        // Actualizar cada banco de RAM4K con la señal de carga correspondiente
        rams[0].setIn(In, sel0, address_0_11);
        rams[1].setIn(In, sel1, address_0_11);
        rams[2].setIn(In, sel2, address_0_11);
        rams[3].setIn(In, sel3, address_0_11);

        // Multiplexar la salida de los bancos de RAM4K a la salida del RAM16K
        Mux4Way16 mux4Way16 = new Mux4Way16(
                rams[0].getOut(),
                rams[1].getOut(),
                rams[2].getOut(),
                rams[3].getOut(),
                address_12_13
        );

        this.Out = mux4Way16.getOut();
    }
}
