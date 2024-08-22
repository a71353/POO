import java.util.Scanner;

public class Craftsman {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = sc.nextInt();
        String message = sc.next();
        if (n == 0 && p == 0) {
            int[] codes = EncrypterSmith.findKey(message, "bug");
            System.out.println(EncrypterSmith.decrypt(codes[0], codes[1], message));
        }
        else{
            System.out.println(EncrypterSmith.encrypt(n,p,message));
        }
    }
}