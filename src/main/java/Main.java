import java.util.Scanner;

public class Main {
    public static int binaryToDenary (String binaryInput) {
        int denary = 0;
        int[] binary = new int[binaryInput.length()];
        int power = 1;

        for (int i = 0; i < binary.length; i++) {
            binary[i] = Integer.parseInt(binaryInput.substring(i, i + 1));
        }

        for (int j = binary.length - 1; j >= 0; j--) {
            denary += binary[j] * power;
            power *= 2;
        }

        return denary;
    }

    public static String binaryToHex (String binaryInput) {
        while (binaryInput.length() % 4 != 0) binaryInput = "0" + binaryInput;

        String[] binaryNibbles = new String[binaryInput.length() / 4];
        String hex = "";

        for (int i = 0; i < binaryNibbles.length; i += 4) {
            binaryNibbles[i] = binaryInput.substring(i, i + 4);
        }

        for (int j = 0; j < binaryNibbles.length; j++) {
            switch (binaryNibbles[j]) {
                case "1010": hex = "A" + hex;
                break;
                case "1011": hex = "B" + hex;
                break;
                case "1100": hex = "C" + hex;
                break;
                case "1101": hex = "D" + hex;
                break;
                case "1110": hex = "E" + hex;
                break;
                case "1111": hex = "F" + hex;
                break;
                default: hex = Integer.toString(binaryToDenary(binaryNibbles[j]));
            }
        }

        return hex;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int selection = 0;

        while (selection < 1 || selection > 6) {
            System.out.println("Choose a number:");
            System.out.println("1. Binary to Denary");
            System.out.println("2. Denary to Binary");
            System.out.println("3. Binary to Hex");
            System.out.println("4. Hex to Binary");
            System.out.println("5. Denary to Hex");
            System.out.println("6. Hex to Denary");
            System.out.println("Select an option");
            selection = scan.nextInt();
        }



        if (selection == 1) {
            System.out.println("Enter a binary number:");
            String input = scan.nextLine();
            System.out.println(binaryToDenary(input));
        } else if (selection == 3) {
            System.out.println("Enter a binary number:");
            String input = scan.nextLine();
            System.out.println(binaryToHex(input));
        }
    }
}
