package lesson3;

import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

public class MainClass3 {

    private static final String PING = "ping";
    private static final String PONG = "pong";

    private final Object mon = new Object();
    private volatile String currentPrint;

    public static void main(String[] args) {

        Count count = new Count();

        MainClass3 mainClass = new MainClass3();
        mainClass.currentPrint = PING;

        Thread ping = new Thread(()->mainClass.print(PING,PONG));
        Thread pong = new Thread(()->mainClass.print(PONG,PING));

        ping.start();
        pong.start();

        new Thread(()->mainClass.printCount(count)).start();
        new Thread(()->mainClass.printCount(count)).start();
        new Thread(()->mainClass.printCount(count)).start();


    }

    public void print(String printStr, String waitStr){
        synchronized (mon) {
            try{
                for (int i=0;i<5;i++){
                    while ( !currentPrint.equals(printStr) ){
                        mon.wait();
                    }
                    System.out.println(printStr);
                    currentPrint = waitStr;
                    mon.notify();
                }
            }catch (InterruptedException exception){
                exception.printStackTrace();
            }
        }
    }


    public void printCount( Count count ){
        for(int i=0; i<5; i++){
            try {
                count.increment();
                Thread.sleep(1000);
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        }
    }
}
