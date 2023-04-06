package HomeWork_1_2.Direct_4;

public class Main {
    public static void main(String[] args) {
        String string = "(10+(x*10)+)2+10(()";
        /////////////////012345678901234567
        char[] symbols = string.toCharArray();
        int d = 0;
        for (int i = symbols.length - 1; i >= 0; i--) {
            if (symbols[i] == ')') d++;
            else if (symbols[i] == '(') d--;
        }
        if (d != 0) {
            System.out.println("Error )(");
            System.exit(0);
        }
        for (int i = 0; i < symbols.length; i++) {
            System.out.print(symbols[i]);
        }
        System.out.println();

        for (int i = 0; i < symbols.length; i++) {
            if (symbols[i] == ')') {
                d++;
                method(symbols, i, d);
            }
        }
        System.out.println("expression is valid");
    }
    public static void method(char[] symbols, int i, int num) {
        int n = 0;
        for (int d = i; d >= 0; d--) {
            if (symbols[d] == '(') {
                n++;
                if (n == num) {
                    break;
                }
            } else if (d == 0) {
                System.out.println("Error )(");
                System.exit(0);
            }

        }
    }
}
