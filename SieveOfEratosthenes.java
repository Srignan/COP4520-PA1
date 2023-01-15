/*
Srignan Paruchuru
COP 4520
1/13/2022
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

//Intellij is Intelligent

class Prime extends Thread {
    static int num = 100000000;
    boolean []primeNums;
    int start;
    int end;
    ArrayList<Integer> list;
    //AtomicInteger fast af boi
    AtomicInteger primes = new AtomicInteger();
    AtomicLong sum = new AtomicLong();

    public Prime(int start, int end, boolean []primeNums){
        this.start = start;
        this.end = end;
        this.primeNums = primeNums;
    }

    public void run(){
        for (int i = start; i < end; i++){
            if (primeNums[i]){
                primes.getAndIncrement();
                sum.getAndAdd(i);
            }
        }
    }
}
public class SieveOfEratosthenes {
    static int num = 100000000;
    public static void main (String[] args) throws InterruptedException {
        long startTime = System.nanoTime();

        boolean[] primeNums = new boolean[num + 1];
        Arrays.fill(primeNums, true);
        //Sieve of Eratosthenes
        for (int i = 2; i * i < num; i++){
            if (primeNums[i]){
                for (int j = i * i; j <= num; j += i)
                    primeNums[j] = false;
            }
        }

        Prime prime1 = new Prime(1, 12500000, primeNums);
        Prime prime2 = new Prime(12500000, 25000000, primeNums);
        Prime prime3 = new Prime(25000000, 37500000, primeNums);
        Prime prime4 = new Prime(37500000, 50000000, primeNums);
        Prime prime5 = new Prime(50000000, 62500000, primeNums);
        Prime prime6 = new Prime(62500000, 75000000, primeNums);
        Prime prime7 = new Prime(75000000, 87500000, primeNums);
        Prime prime8 = new Prime(87500000, 100000000, primeNums);

        Thread thread1 = new Thread(prime1);
        Thread thread2 = new Thread(prime2);
        Thread thread3 = new Thread(prime3);
        Thread thread4 = new Thread(prime4);
        Thread thread5 = new Thread(prime5);
        Thread thread6 = new Thread(prime6);
        Thread thread7 = new Thread(prime7);
        Thread thread8 = new Thread(prime8);

        thread1.start();
        thread1.join();
        thread2.start();
        thread2.join();
        thread3.start();
        thread3.join();
        thread4.start();
        thread4.join();
        thread5.start();
        thread5.join();
        thread6.start();
        thread6.join();
        thread7.start();
        thread7.join();
        thread8.start();
        thread8.join();

        int primes = (prime1.primes).intValue() + (prime2.primes).intValue() + (prime3.primes).intValue()
                + (prime4.primes).intValue() + (prime5.primes).intValue() + (prime6.primes).intValue()
                + (prime7.primes).intValue() + (prime8.primes).intValue();

        long sum =  (prime1.sum).longValue() + (prime2.sum).longValue() + (prime3.sum).longValue()
                + (prime4.sum).longValue() + (prime5.sum).longValue() + (prime6.sum).longValue()
                + (prime7.sum).longValue() + (prime8.sum).longValue();

        long endTime = System.nanoTime();
        long milliseconds = TimeUnit.MILLISECONDS.convert(endTime - startTime, TimeUnit.NANOSECONDS);

        //Top ten Primes
        List<Integer> max = new ArrayList<>();
        int count = 0;
        int i = num - 1;
        while (count != 10){
            if (primeNums[i]){
                max.add(i);
                count++;
            }
            i--;
        }
        //Txt file
        try{
            File output = new File("primes.txt");
            FileWriter myOutput = new FileWriter("primes.txt");
            myOutput.write("Execution Time: " + milliseconds + " MS\n");
            myOutput.write("Number of Primes: " + (primes - 1) + "\n");
            myOutput.write("Sum of Primes: " + (sum - 1) + "\n");
            myOutput.write("Top Ten Max Primes from Low to High: \n");
            for (int j = max.size() - 1; j >= 0; j--){
                myOutput.write(max.get(j) + "\n");
            }
            myOutput.close();
        } catch (IOException ignored){
        }
    }
}