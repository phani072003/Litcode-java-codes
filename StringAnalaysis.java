import java.util.Scanner;
public class StringAnalaysis {
    public static void Stringperc(String email){
        int TotalCharCount = email.length();
        int upperCaseCount = 0;
        int lowerCaseCount = 0;
        int digitCount = 0;
        int otherCount = 0;
        for(int i = 0; i<TotalCharCount; i++){
            char ch = email.charAt(i);
            if(Character.isUpperCase(ch)){
                upperCaseCount++;
            }
            else if(Character.isLowerCase(ch)){
                lowerCaseCount++;
            }
            else if(Character.isDigit(ch)){
                digitCount++;
            }
            else{
                otherCount++;
            }
        }
        double upperCaseCountPerc = ((double)upperCaseCount/TotalCharCount) * 100;
        double lowerCaseCountPerc =  ((double)lowerCaseCount/TotalCharCount) * 100;
        double digitCountPerc =  ((double)digitCount/TotalCharCount) * 100;
        double otherCountPerc =  ((double)otherCount/TotalCharCount) * 100;
        
        System.out.printf("%.3f%% %.3f%% %.3f%% %.3f%%", upperCaseCountPerc, lowerCaseCountPerc, digitCountPerc, otherCountPerc);
        
    }
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        String email = input.nextLine();
        input.close();
        Stringperc(email);
    }
}