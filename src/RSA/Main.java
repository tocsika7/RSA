package RSA;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        RSA rsa = new RSA();


        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        rsa.Key_gen();

        System.out.println("Enter the message you want to encrypt/decrypt");
        BigInteger message = scanner.nextBigInteger();

        System.out.println("Enter enc for encryption or dec for decryption.");
        String choice = scanner1.nextLine();

        if(choice.equals("dec")){
            BigInteger m = rsa.decrypt(message);
            if(message.equals(rsa.encrypt(m))){
                System.out.println("Decryption successful the decrypted message is: "+m+ " the message was: "+rsa.encrypt(m));
            }
        }
        else if(choice.equals("enc")) {
            BigInteger c = rsa.encrypt(message);
            if (message.equals(rsa.decrypt(c))) {
                System.out.println("Encryption successful the encrypted message is: " + c+" the message was: "+rsa.decrypt(c));
            }
        }

    }


    }

