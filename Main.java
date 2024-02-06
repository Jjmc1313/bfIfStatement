import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[30000];
        System.out.println("Arr init @:" + arr.length);
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter Args: ");
        String s = scan.nextLine();

        int arrPos = 0;
        int maxArrPos = arrPos;
        int loopPos = 0;
        int pos = 0;
        if (!s.isEmpty()) {
            for (pos = 0; pos < s.length(); pos++) {
                char c = s.charAt(pos);
                if (c == '+') {
                    if (arr[arrPos] == 255) {
                        arr[arrPos] = 0;
                    } else {
                        arr[arrPos]++;
                    }
                } else if (c == '-') {
                    if (arr[arrPos] == 0) {
                        arr[arrPos] = 255;
                    } else {
                        arr[arrPos]--;
                    }
                } else if (c == '<') {
                    if (arrPos == 0) {
                        arrPos = arr.length - 1;
                    } else {
                        arrPos--;
                    }
                } else if (c == '>') {
                    if (arrPos == arr.length - 1) {
                        arrPos = 0;
                    } else {
                        arrPos++;
                    }
                } else if (c == '.') {
                    System.out.print((char)arr[arrPos]);
                }
                else if (c == ',') {
                    String in = scan.next();
                    char inp = in.charAt(0);
                    arr[arrPos] = (int)inp;
                } else if (c == '[') {
                    int end = s.indexOf(']', pos);
                    loopPos = pos;
                    if (arr[arrPos] == 0) {
                        pos = end;
                    }
                    if (end == -1) {
                        System.err.println("Error: Unclosed loop at pos " + loopPos);
                        break;
                    }
                } else if (c == ']') {
                    pos = loopPos - 1;
                }
                if (maxArrPos < arrPos) {
                    maxArrPos = arrPos;
                }
            }
        }

        System.out.println("\nMemory Dump: ");
        for (int i = 0; i <= maxArrPos; i++) {
            if (i % 16 == 0 && i != 0) {
                System.out.println(arr[i]);
            } else {
                System.out.print(arr[i] + " ");
            }
        }
      System.out.println("\nAddress Range: 0 - " + maxArrPos);
    }
}
