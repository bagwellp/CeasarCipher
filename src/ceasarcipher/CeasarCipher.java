//Patty Bagwell
//Data Structures Class 
package ceasarcipher;
import java.util.Scanner;

public class CeasarCipher 
{
public static void main(String [] args)
{
    Scanner data = new Scanner(System.in); //create scanner for input from user
    System.out.println("Please enter text you want encrypted: ");
                    //request data from user
    String str = data.nextLine();//assign user data to string str
    String lc = str.toLowerCase(); //put string into lowercase text
    System.out.println("Enter numerical key for encryption: "); 
                    //request key from user
    int key = data.nextInt();//assign input to variable key
    char c;//create char c to hold current character
    StringBuffer sb = new StringBuffer(lc);//create new string buffer to use to
                           //substitute new values of the string
    for(int i=0; i<sb.length(); i++) //iterate through the string
    
    if(!(sb.charAt(i)==32))//if the character is not a space (32 in ASCii then
                           //proceed - could make this to include various other
                           //puncuations
    {
        int z = (int)(((sb.charAt(i)-97) + key) % 26) + 97;
        //take the char at i, subtract 97 because that is the ASCii value of 
        //lowercase a, add the key, mod by 26, add back in the 97 to get the
        //correct character in the ASCii table
        c= (char) z; //assign the vaule received for z to c with a type of char
        sb.setCharAt(i, c);//set the character in the substring to new value
    }
    System.out.println("The encrypeted text is: " + sb); //print encryption
   
    for(int i=0; i<sb.length(); i++)//same as above but in reverse to decrypt
    if(!(sb.charAt(i) == 32))//if the character is not a space (32 in ASCii then
                            //proceed - could chge this to include various other
                            //puncuation marks
    {
        int t = sb.charAt(i)-97 - key;//did partial calculation to test for neg
        //number,  This has to do with the way java handles the modulus operator
        //when there is a negative number involved.
        if (t<0)//if negative number, need to add 26
        {
            t+=26;
        }
        int z = (int)(t % 26) + 97;//finish calculation to decrypt the letter
        c= (char) z; //assign the vaule received for z to c with a type of char
        sb.setCharAt(i, c);//update sb string at i with c
    }
    System.out.println("The decrypeted text is: " + sb);//print decrypted string
    }
}
