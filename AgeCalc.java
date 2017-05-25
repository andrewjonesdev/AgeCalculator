
import java.util.Scanner;
import java.time.LocalDate;
import java.time.Month;

public class AgeCalc{

public static void main (String[] args){

	int currentMonth = 0;
	int birthDay = 0;
	int birthMonth = 0;
	int birthYear = 0;
	int age = 0;
	String yesOrNo = "";
	boolean again = false;
	LocalDate date = LocalDate.now();
	Month stringMonth = date.getMonth();
	currentMonth = stringMonth.getValue();
	Scanner numScan = new Scanner(System.in);
	Scanner strScan = new Scanner(System.in);
	//System.out.println(currentMonth==5);
	
	//do{
		
		do{
			//set to negatives so the default will kick the Birthday inputs back to the start if non integers are entered
			birthDay = -10;
			birthMonth = -10;
			birthYear = -10;
			
			//Day Input
			do{
				System.out.println("Enter the day of the month you were born (ex. January 2, 2017 = 2): ");
				//checks if letters are input
				if (numScan.hasNextInt()){
					birthDay = numScan.nextInt();
					//checks if the day is valid
					if(birthDay < 0 || birthDay > 31){
						System.out.println("The day you entered wasn't valid. Please try again.");					
					}
				}else{
					System.out.println("You didn't submit a whole number. Please try again.");
					numScan.next();
					continue;
				}
			}while(birthDay < 1 || birthDay > 31);
			//Month Input
			do{
				System.out.println("Enter the month you were born (ex. January 2, 2017 = 1): ");
				//checks if letters are input
				if (numScan.hasNextInt()){
					birthMonth = numScan.nextInt();
					//checks if the day is valid
					if(birthMonth < 1 || birthMonth > 13){
						System.out.println("The month you entered wasn't valid. Please try again.");					
					}
					//checks if the day exists in this month
					else if(((birthDay>30)&&birthMonth == 4)||((birthDay>30)&&birthMonth == 6)||((birthDay>30)&&birthMonth == 9)||((birthDay>30)&&birthMonth == 11)||((birthDay>29)&&birthMonth == 2)){
						System.out.println("Day " + birthDay + " doesn't exist in month " + birthMonth +". Please try again.");
					}
				}else{
					System.out.println("You didn't submit a whole number. Please try again.");
					numScan.next();
					continue;
				}
			}while((birthMonth < 1 || birthMonth > 13)||((birthDay>30)&&birthMonth == 4)||((birthDay>30)&&birthMonth == 6)||((birthDay>30)&&birthMonth == 9)||((birthDay>30)&&birthMonth == 11)||((birthDay>29)&&birthMonth == 2));
			//Year Input
			do{
				System.out.println("Enter the year you were born (ex. January 2, 2017 = 2017): ");
				//checks if letters are input
				if (numScan.hasNextInt()){
					birthYear = numScan.nextInt();
					//checks if the user has given a date that hasn't occured yet
					if((birthYear > date.getYear())||((birthYear == date.getYear())&&(birthMonth > currentMonth))||(((birthYear == date.getYear())&&(birthMonth > currentMonth))&&(birthDay > date.getDayOfMonth()))){
						System.out.println("You haven't been born yet. Please try again.");					
					}
					//checks if date is real or not. B.C. is not accepted
					else if(birthYear<0){
						System.out.println("The year you entered wasn't valid. Please try again.");	
					}
					else if(((birthYear%4) != 0) && (birthDay > 28) && birthMonth == 2){
						System.out.println("There are only 28 days of February in " + birthYear + ". Please try again.");
					}
				}else{
					System.out.println("You didn't submit a whole number. Please try again.");
					numScan.next();
					continue;
				}
			}while((birthYear<0) || ((birthYear > date.getYear())||((birthYear == date.getYear())&&(birthMonth > currentMonth))||(((birthYear == date.getYear())&&(birthMonth > currentMonth))&&(birthDay > date.getDayOfMonth()))) || (((birthYear%4) != 0) && (birthDay > 28) && birthMonth == 2));
			//Verifies if your birthday has occured this year and assigns a value. SEE NEXT COMMENT
			if((birthMonth > currentMonth) ||((birthMonth == currentMonth)&&(birthDay > date.getDayOfMonth()))){
				age = -1;
			}
			else{
				age = 0;
			}
			//Calculates Age. Takes the value to determine how old you would be this year by subtracting it from the present. The aforementioned value is there to account for if your birthday has occured this year or not.
			age = age + date.getYear() - birthYear;
			System.out.println("You are " + age + " years old.");
			//Asks the user if they want to restart the application
			do{
				System.out.println("Do you want to continue? Y or N");
				yesOrNo = strScan.next();
				//in case the user types "y" or "n" it will still go through
				yesOrNo = yesOrNo.toUpperCase();
				if(yesOrNo.equals("Y")){
					again = true;
				}
				else if(yesOrNo.equals("N")){
					again = false;
				}
				else{
					System.out.println("You didn't type \"Y\" or \"N\". please try again");
				}
				
			}while((!(yesOrNo.equals("Y"))) && (!(yesOrNo.equals("N"))));
		}while(again);
	//}while(false);
	
	
	}

}