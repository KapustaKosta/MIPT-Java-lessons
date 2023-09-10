import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        System.out.printf("Hello and welcome! \n");
        for (int i = 1; i <= 5; i++) {
            System.out.println("i = " + i);
        }
    }

    static void swop(ref int x, ref int y)
    {
        int t = x;
        x = y;
        t = x;
    }

}