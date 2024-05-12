package esencialsGates;

public class Utilities {
    public static byte[] toBinaryArray(byte input) {
        String binaryString = String.format("%16s", Integer.toBinaryString(input & 0xFF)).replace(' ', '0');
        byte[] binaryArray = new byte[16];
        for (int i = 0; i < binaryString.length(); i++) {
            binaryArray[i] = (byte) (binaryString.charAt(i) - '0');
        }
        return binaryArray;
    }
}
