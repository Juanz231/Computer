package ProjectPart2;

public class HalfAdder {
    byte InA;
    byte InB;
    byte Sum;
    byte Carry;

    public HalfAdder(byte InA, byte InB) {
        this.InA = InA;
        this.InB = InB;
        this.Sum = (byte) (InA ^ InB);
        this.Carry = (byte) (InA & InB);
    }
    public HalfAdder(int InA, int InB) {
        this((byte)InA, (byte)InB);
    }

    public int getSum(){
        return this.Sum;
    }

    public int getCarry(){
        return this.Carry;
    }

    public void setIn(byte InA, byte InB) {
        this.InA = InA;
        this.InB = InB;
        this.Sum = (byte) (InA ^ InB);
        this.Carry = (byte) (InA & InB);
    }
    public void setIn(int InA, int InB) {
        setIn((byte)InA, (byte)InB);
    }
}
