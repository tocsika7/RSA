package RSA;

import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

public class RSA {

    private BigInteger n;
    private int e = 3;
    private BigInteger d;

    FME fme = new FME();
    MR mr = new MR();
    EA ea = new EA();

    public void Key_gen(){

        Random random = new Random();
        BigInteger q = BigInteger.probablePrime(128,random);
        BigInteger p = BigInteger.probablePrime(128,random);


        while (!mr.MR(p)){
            p = BigInteger.probablePrime(128,random);
        }

        while (!mr.MR(q)){
            q = BigInteger.probablePrime(128,random);
        }

        n = p.multiply(q);
        BigInteger fi_n = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));


        while(!(ea.EA(BigInteger.valueOf(e),fi_n).equals(BigInteger.ONE))){
            e+=2;
        }


        d = ea.EEA(BigInteger.valueOf(e),fi_n);

        if(d.compareTo(BigInteger.ZERO)<0){
            d = d.add(fi_n);
        }

        System.out.println("Keys generated.");
    }

    public BigInteger encrypt(BigInteger m){
        Scanner scanner = new Scanner(System.in);

        while (m.compareTo(n) > 0){
            System.out.println("Please enter a smaller number!");
            m = scanner.nextBigInteger();
        }

        return fme.FME(m,BigInteger.valueOf(e),n);
    }

    public BigInteger decrypt(BigInteger c){
        return fme.FME(c,d,n);
    }
}
