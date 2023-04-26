import java.util.Scanner;

public class SharedPrinter extends Thread {

    int counter=1;
    Scanner scanner=new Scanner(System.in);
    int N = scanner.nextInt();
    public void printOddNumber() {
        synchronized (this) {
            while (counter < N) {
                while (counter % 2 == 0) {
                    try {
                        wait();
                    } catch (
                            InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print(counter + " ");
                counter++;
                notify();
            }
        }
    }

    public void printEvenNumber() {
        synchronized (this) {
            while (counter < N) {
                while (counter % 2 == 1) {

                    try {
                        wait();
                    } catch (
                            InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.print(counter + " ");
                counter++;
                notify();
            }
        }
    }
}