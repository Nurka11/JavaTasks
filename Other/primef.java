import java.util.Scanner;
public class primef{
	public static void main(String[] args) {
		System.out.print("Enter a positive integer: ");
        int num = new Scanner(System.in).nextInt();
		StackOfIntegers stack = new StackOfIntegers(20);
		int factor = 2;
        while (factor <= num) {
            if (num % factor == 0) {
                stack.push(factor);
                num /= factor;
            } else {
                factor++;
            }
        }
        while (!stack.empty()) {
            System.out.print(stack.pop() + " ");
        }


    }
}