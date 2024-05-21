package ProjectPart3.PartA;

import EssentialsGates.DMux8Way;
import EssentialsGates.Mux8Way16;
import EssentialsGates.Utilities;

public class RAM8 {
    private Register[] registers = new Register[8];
    private byte[] In;
    private byte Load;
    private byte[] Address;
    private byte[] Out;

    public RAM8(byte[] In, byte Load, byte[] Address) {
        this.In = In;
        this.Load = Load;
        this.Address = Address;
        this.Out = new byte[16];

        // Inicializar los registros
        for (int i = 0; i < 8; i++) {
            registers[i] = new Register(new byte[16], (byte) 0);
        }

        // Actualizar los registros y salida
        updateRegistersAndOut();
    }

    public RAM8(byte In, byte Load, byte Address) {
        this(Utilities.toBinaryArray(In), Load, Utilities.toBinaryArray(Address));
    }

    public byte[] getOut() {
        return this.Out;
    }

    public void setIn(byte[] In, byte Load, byte[] Address) {
        this.In = In;
        this.Load = Load;
        this.Address = Address;
        updateRegistersAndOut();
    }

    public void setIn(byte In, byte Load, byte Address) {
        setIn(Utilities.toBinaryArray(In), Load, Utilities.toBinaryArray(Address));
    }

    private void updateRegistersAndOut() {
        // Demultiplexar la señal de carga a los registros correctos
        DMux8Way dmux8Way = new DMux8Way(Load, Address);
        byte sel0 = dmux8Way.getA();
        byte sel1 = dmux8Way.getB();
        byte sel2 = dmux8Way.getC();
        byte sel3 = dmux8Way.getD();
        byte sel4 = dmux8Way.getE();
        byte sel5 = dmux8Way.getF();
        byte sel6 = dmux8Way.getG();
        byte sel7 = dmux8Way.getH();

        // Actualizar cada registro con la señal de carga correspondiente
        registers[0].setIn(In, sel0);
        registers[1].setIn(In, sel1);
        registers[2].setIn(In, sel2);
        registers[3].setIn(In, sel3);
        registers[4].setIn(In, sel4);
        registers[5].setIn(In, sel5);
        registers[6].setIn(In, sel6);
        registers[7].setIn(In, sel7);

        // Multiplexar la salida de los registros a la salida del RAM8
        Mux8Way16 mux8Way16 = new Mux8Way16(
                registers[0].getOut(),
                registers[1].getOut(),
                registers[2].getOut(),
                registers[3].getOut(),
                registers[4].getOut(),
                registers[5].getOut(),
                registers[6].getOut(),
                registers[7].getOut(),
                Address
        );

        this.Out = mux8Way16.getOut();
    }
}