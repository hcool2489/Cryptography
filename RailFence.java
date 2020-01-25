import java.util.*;
public class RailFence
{
    private static char[][] railFence;
    
    private static String encrypt(String msg, int key){
        railFence = new char[key][msg.length()];
        char[] arr = new char[msg.length()];
        for(int i=0;i<key;i++){
            Arrays.fill(railFence[i],'~');
        }
        boolean dir = true;
        for(int i=0,j=0;j<msg.length();j++){
            if(dir){
                railFence[i][j] = msg.charAt(j);
                i++;
                if(i==key-1)
                    dir = false;
            }else{
                railFence[i][j] = msg.charAt(j);
                i--;
                if(i==0)
                    dir = true;
            }
        }
        
        print(railFence,key,msg.length());
        for(int i=0,k=0;i<key;i++){
            for(int j=0;j<msg.length();j++){
                if(railFence[i][j]!='~')
                    arr[k++] = railFence[i][j];
            }
        }
        
        return new String(arr);
    }
    
    private static String decrypt(String msg, int key){
		railFence = new char[key][msg.length()];
        char[] arr = new char[msg.length()];
        for(int i=0;i<key;i++){
            Arrays.fill(railFence[i],'~');
        }
        boolean dir = true;
        for(int i=0,j=0;j<msg.length();j++){
            if(dir){
                railFence[i][j] = msg.charAt(j);
                i++;
                if(i==key-1)
                    dir = false;
            }else{
                railFence[i][j] = msg.charAt(j);
                i--;
                if(i==0)
                    dir = true;
            }
        }
		for(int i=0,k=0;i<key;i++){
			for(int j=0;j<msg.length();j++){
				if(railFence[i][j]!='~')
					railFence[i][j]=msg.charAt(k++);
			}
		}
		dir = true;
		for(int i=0,j=0;j<msg.length();j++){
            if(dir){
                arr[j] = railFence[i][j];
                i++;
                if(i==key-1)
                    dir = false;
            }else{
                arr[j] = railFence[i][j];
                i--;
                if(i==0)
                    dir = true;
            }
        }
		
        return new String(arr);
    }
    
    private static void print(char[][] arr,int il, int jl){
        for(int i=0;i<il;i++){
            for(int j=0;j<jl;j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		String msg;
		int key;
		int ch;
		while(run){
	    	System.out.print("\nEnter:\n\t0 - Exit\n\t1 - Encrypt\n\t2 - Decrypt\n> ");
	    	ch = sc.nextInt();
	    	sc.nextLine();
    		switch(ch){
    		    case 0:
    		        run = false;
    		        break;
    		    case 1:
    		        System.out.print("Message: ");
                	msg = sc.nextLine();
                	System.out.print("Key: ");
                	key = sc.nextInt();
    		        System.out.println("Cipher: " + encrypt(msg, key));
    		        break;
    		    case 2:
    		        System.out.print("Cipher: ");
                	msg = sc.nextLine();
                	System.out.print("Key: ");
                	key = sc.nextInt();
    		        System.out.println("Message: " + decrypt(msg,key));
    		        break;
    		    default:
    		        System.out.println("Invalid Input");
    		}
		}
	}
}
