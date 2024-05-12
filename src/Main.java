import esencialsGates.*;

public class Main {
    public static void main(String[] args) {
        or Or = new or(0,0);
        System.out.printf("0 OR 0 = %d\n", Or.getOr());
        Or.setIn(0,1);
        System.out.printf("0 OR 1 = %d\n", Or.getOr());
        Or.setIn(1,0);
        System.out.printf("1 OR 0 = %d\n", Or.getOr());
        Or.setIn(1,1);
        System.out.printf("1 OR 1 = %d\n", Or.getOr());

        and And = new and((byte)0,(byte)0);
        System.out.printf("0 AND 0 = %d\n", And.getAnd());
        And.setIn(0,1);
        System.out.printf("0 AND 1 = %d\n", And.getAnd());
        And.setIn(1,0);
        System.out.printf("1 AND 0 = %d\n", And.getAnd());
        And.setIn(1,1);
        System.out.printf("1 AND 1 = %d\n", And.getAnd());

        xor Xor = new xor((byte) 0, (byte) 0);
        System.out.printf("0 XOR 0 = %d\n", Xor.getXor());
        Xor.setIn(0,1);
        System.out.printf("0 XOR 1 = %d\n", Xor.getXor());
        Xor.setIn(1,0);
        System.out.printf("1 XOR 0 = %d\n", Xor.getXor());
        Xor.setIn(1,1);
        System.out.printf("1 XOR 1 = %d\n", Xor.getXor());

        int a = 0b1111111; // binary representation of 127
        int b = 0b1010101; // binary representation of 85

        int resultOr = a | b; // bitwise OR
        int resultAnd = a & b; // bitwise AND
        int resultXor = a ^ b; // bitwise XOR


        System.out.printf("a = %d\n", a);
        System.out.printf("b = %d\n", b);
        System.out.printf("a OR b = %s\n", Integer.toBinaryString(resultOr));
        System.out.printf("a AND b = %s\n", Integer.toBinaryString(resultAnd));
        System.out.printf("a XOR b = %s\n", Integer.toBinaryString(resultXor));

    }
}