package ProjectPart3.PartA;

public class Bit {
    private byte value;  // Estado interno del bit

    public Bit(byte In, byte Load) {
        this.value = 0;  // Inicializa el valor a 0
        this.setIn(In, Load);
    }

    public Bit(int In, int Load) {
        this((byte) In, (byte) Load);
    }

    public byte getOut() {
        return this.value;
    }

    public void setIn(byte In, byte Load) {
        if (Load == 1) {
            this.value = In;
        }
    }

    public void setIn(int In, int Load) {
        this.setIn((byte) In, (byte) Load);
    }
}