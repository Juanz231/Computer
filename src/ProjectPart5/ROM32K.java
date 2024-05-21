package ProjectPart5;

import ProjectPart3.PartB.*;
import EssentialsGates.DMux;
import EssentialsGates.Mux16;
import EssentialsGates.Utilities;

public class ROM32K {
    private byte[] Address;
    private byte[] Out;

    private RAM16K ram;

    public ROM32K(byte[] Address) {
        this.Address = Address;
        this.Out = new byte[16];

        // Inicializar los bancos de RAM16K

        ram = new RAM16K(new byte[16], (byte) 0, new byte[15]);


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
        this.Out = ram.getOut();
    }
    public void write(byte[] value, byte[] address) {
        // Convertir los valores a arrays de bytes

        // Escribir el valor en el banco de RAM16K correspondiente
        ram.setIn(value, (byte) 1, address);

        // Actualizar la salida
        updateRAMsAndOut();
    }
    public void read(byte[] value,byte[] address){
        ram.setIn(value, (byte) 0, address);
        updateRAMsAndOut();
    }

}