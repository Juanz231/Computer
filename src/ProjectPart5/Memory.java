package ProjectPart5;

import EssentialsGates.Utilities;
import ProjectPart3.PartB.RAM16K;

public class Memory {
    private byte[] out;
    private RAM16K ram16K;

    public Memory(byte[] in, byte load, byte[] address) {
        this.out = new byte[16];
        this.ram16K = new RAM16K(in, load, address);

        updateMemory();
    }

    public Memory(byte in, byte load, byte address) {
        this(Utilities.toBinaryArray(in), load, Utilities.toBinaryArray(address));
    }

    public byte[] getOut() {
        return out;
    }

    public void setIn(byte[] in, byte load, byte[] address) {
        this.ram16K.setIn(in, load, address);

        updateMemory();
    }

    public void setIn(byte in, byte load, byte address) {
        setIn(Utilities.toBinaryArray(in), load, Utilities.toBinaryArray(address));
    }

    private void updateMemory() {
        out = ram16K.getOut();
    }
}