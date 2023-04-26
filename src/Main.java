import java.util.Scanner;

public class Main {
public static void main(String[] args) throws InterruptedException {

        Scanner scanner=new Scanner(System.in);
        int N = scanner.nextInt();

        SharedPrinter sharedPrinter = new SharedPrinter();

        Thread t1 = new Thread(new Runnable() {
public void run()
        {
        sharedPrinter.printEvenNumber();
        }
        });
        Thread t2 = new Thread(new Runnable() {
                public void run()
                {
                        sharedPrinter.printOddNumber();
                }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        }
        }
