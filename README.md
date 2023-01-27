# COP4520-PA1
## Experimental Evaluation:

I used the Sieve of Eratosthenes to build my program as you might be able to tell from the file name. I used it since it was one of the first results that showed up when I searched fast prime search. The Sieve of Eratosthenes puts a mark on multiples of numbers starting from 2 and moving up. Only unmarked numbers are checked for their multiples so 4 would never be checked as it would be marked from the first cycle. The numbers that aren’t marked would be considered primes at the end of the algorithm. This gave me the idea that the best and simplest way to implement this algorithm using parallel processing is to hard code limits in which each thread runs through. Each of the eight threads is hard coded with limits that divide the 10^8 into eight different sections. This allows it so that primes can be marked off in different ranges at the same time when using concurrency. The rest is simple as it is just creating a txt file output and the formulas to get the output. Admittedly the text file part took longer than it should have since I forgot some of the basics of Java. I also used atomic int and long for the sum and primes. 



## Run the program:

“javac SieveOfEratosthenes” and then “java SieveOfEratosthenes” in terminal. It should generate a text file. My speed was anywhere between 836MS (current 11th gen 8 core laptop on terminal) to 1803MS (on IntelliJ with multiple extensions in my old 6th gen 4 core laptop). I added a prime txt file for proof of correctness. 
