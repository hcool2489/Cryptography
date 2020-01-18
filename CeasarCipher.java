import java.util.*;
public class CeasarCipher
{
    private static String encrypt(String text, int key){
        char[] ch = text.toCharArray();
        for(int i=0;i<ch.length;i++){
            if(ch[i]>=65&&ch[i]<=90){
                ch[i]+=key;
                if(ch[i]>90)
                    ch[i]-=26;
				else if(ch[i]<65)
					ch[i]+=26;
            }
            else if(ch[i]>=97&&ch[i]<=122){
                ch[i]+=key;
                if(ch[i]>122)
                    ch[i]-=26;
				else if(ch[i]<97)
					ch[i]+=26;
            }
        }
        return String.valueOf(ch);
    }
    
    private static String decrypt(String text, int key){
        return encrypt(text, -key);
    }
    
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int key;
	String msg;
	boolean run = true;
	while(run){
		System.out.print("Enter:\n\t1. Encrypt\n\t2. Decrypt\n\t3. Bruteforce\n\t0. Exit\n> ");
		int choice = sc.nextInt();
		sc.nextLine();
		switch(choice){
			case 0:
				run = false;
				break;
			case 1:
				System.out.print("Enter Message: ");
				msg = sc.nextLine();
				System.out.print("Enter encryption key: ");
				key = sc.nextInt();
				System.out.println("Cipher Text: " + encrypt(msg, key%26));
				break;
			case 2:
				System.out.print("Enter Ciphered Message: ");
				msg = sc.nextLine();
				System.out.print("Enter decryption key: ");
				key = sc.nextInt();
				System.out.println("Original Message: " + decrypt(msg, key%26));
				break;
			case 3:
				System.out.print("Enter Ciphered Message: ");
				msg = sc.nextLine();
				for(key = 1;key<27;key++)
					System.out.println("Key: " + key + " | Message: " + decrypt(msg, key));
				break;
			default:
				System.out.println("Invalid Input !");
			}
		}
	}
}