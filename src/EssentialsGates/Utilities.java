package EssentialsGates;

public class Utilities {
    public static byte[] toBinaryArray(byte input) {
        String binaryString = String.format("%16s", Integer.toBinaryString(input & 0xFF)).replace(' ', '0');
        byte[] binaryArray = new byte[16];
        for (int i = 0; i < binaryString.length(); i++) {
            binaryArray[i] = (byte) (binaryString.charAt(i) - '0');
        }
        return binaryArray;
    }

    public static byte[] SliceArray(byte[] input, int start, int end) {
        byte[] output = new byte[end - start + 1];
        for (int i = start; i <= end; i++) {
            output[i - start] = input[i];
        }
        return output;
    }

    public static int toDecimal(byte[] input) {
        int output = 0;
        boolean isNegative = (input[0] == 1); // Check if the number is negative

        // Convert to decimal
        for (int i = 0; i < input.length; i++) {
            output += input[i] << (input.length - 1 - i);
        }

        // If it's negative, convert to negative number
        if (isNegative) {
            // Calculate the negative value in complement to two
            output = (int) (output - Math.pow(2, input.length));
        }

        return output;
    }
}
