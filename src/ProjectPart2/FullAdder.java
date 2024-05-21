package ProjectPart2;

public class FullAdder {
    byte InA;
    byte InB;
    byte CarryIn;
    byte Sum;
    byte CarryOut;

    public FullAdder(byte InA, byte InB, byte CarryIn) {
        this.InA = InA;
        this.InB = InB;
        this.CarryIn = CarryIn;
        HalfAdder halfAdder1 = new HalfAdder(InA, InB);
        HalfAdder halfAdder2 = new HalfAdder(halfAdder1.getSum(), CarryIn);
        this.Sum = (byte) halfAdder2.getSum();
        this.CarryOut = (byte) (halfAdder1.getCarry() | halfAdder2.getCarry());
    }
    public FullAdder(int InA, int InB, int CarryIn) {
        this((byte)InA, (byte)InB, (byte)CarryIn);
    }

    public byte getSum(){
        return this.Sum;
    }
    public byte getCarryOut(){
        return this.CarryOut;
    }

    public void setIn(byte InA, byte InB, byte CarryIn) {
        this.InA = InA;
        this.InB = InB;
        this.CarryIn = CarryIn;
        HalfAdder halfAdder1 = new HalfAdder(InA, InB);
        HalfAdder halfAdder2 = new HalfAdder(halfAdder1.getSum(), CarryIn);
        this.Sum = (byte) halfAdder2.getSum();
        this.CarryOut = (byte) (halfAdder1.getCarry() | halfAdder2.getCarry());
    }
    public void setIn(int InA, int InB, int CarryIn) {
        setIn((byte)InA, (byte)InB, (byte)CarryIn);
    }


}
