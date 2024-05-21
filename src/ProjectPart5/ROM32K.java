package ProjectPart5;

import ProjectPart3.PartB.*;
import EssentialsGates.DMux;
import EssentialsGates.Mux16;
import EssentialsGates.Utilities;

public class ROM32K {
    private byte[] Address;
    private byte[] Out;

    private RAM16K[] rams = new RAM16K[2];

    public ROM32K(byte[] Address) {
        this.Address = Address;
        this.Out = new byte[16];

        // Inicializar los bancos de RAM16K
        for (int i = 0; i < 2; i++) {
            rams[i] = new RAM16K(new byte[16], (byte) 0, new byte[15]);
        }

        // Actualizar los bancos de RAM16K y la salida
        updateRAMsAndOut();
    }

    public ROM32K(byte Address) {
        this(Utilities.toBinaryArray(Address));
    }

    public byte[] getOut() {
        return this.Out;
    }

    public void setAddress(byte[] Address) {
        this.Address = Address;
        updateRAMsAndOut();
    }

    public void setAddress(byte Address) {
        setAddress(Utilities.toBinaryArray(Address));
    }

    private void updateRAMsAndOut() {
        // Dividir la dirección en dos partes
        byte address_14 = Address[14];


        // Multiplexar la salida de los bancos de RAM16K a la salida del ROM32K
        Mux16 mux2Way16 = new Mux16(
                rams[0].getOut(),
                rams[1].getOut(),
                address_14
        );

        this.Out = mux2Way16.getOut();
    }
    public void write(byte[] value, byte[] address) {
        // Convertir los valores a arrays de bytes


        // Dividir la dirección en dos partes
        byte address_14 = address[14];
        byte[] address_0_13 = Utilities.SliceArray(address, 0, 13);

        // Escribir el valor en el banco de RAM16K correspondiente
        if (address_14 == (byte) 0) {
            rams[0].setIn(value, (byte) 1, address_0_13);
        } else {
            rams[1].setIn(value, (byte) 1, address_0_13);
        }

        // Actualizar la salida
        updateRAMsAndOut();
    }

}