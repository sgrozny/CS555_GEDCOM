package cs555_ged;

public class HimabinduSprint2 {

	public static int missingMarriageDate(FamilyStruct.family famArr[], int Itotal)
	{
		int numErrors = 0;
		//boolean Mdate;
		 System.out.println();
	     System.out.println("==============================================");
		System.out.println("User story : Looking for any Missing Marriage date for a family:");
		for(int i=0;i<Itotal+1;i++)
		{
		//	Mdate = famArr[i].getDate().equals("MARR");
			if(famArr[i].getMarriedDate()==null)
			{
				System.out.println("Marriage date is missing for Family"+ famArr[i].getID());
				numErrors++;
			}
		}
		if (numErrors == 0)
			System.out.println("Each and every Family has Marriage Date");
		return numErrors;
	}
	
	
	public static int childrenWithSameNameandDateofBirth(IndvidualStruct.individual indArr[], int Itotal,FamilyStruct.family famArr[],int Ftotal){
        //Determines if two indivduals have same name and same birthday
        int errorcounter=0;
        System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("Searching for identical children in a family: ");
       // int numOfChildern = famArr
       for(int m=0;m<Ftotal+1;m++){
        for(int i=0;i<famArr[m].getNumChildren()-1;i++){
            for(int j=i+1;j<famArr[m].getNumChildren();j++){  
        
               if(indArr[famArr[m].getChild(i)].name.equals(indArr[famArr[m].getChild(j)].name)){
                   if(indArr[famArr[m].getChild(i)].BDay.equals(indArr[famArr[m].getChild(j)].BDay)){
                       errorcounter++;
                       System.out.println("==============================================");
                       System.out.println("Error number " + errorcounter + ":");
                       Printing.PrintIndividualDetails(indArr,i);
                       System.out.println("--------------------");
                       System.out.println("Is a match to: ");
                       Printing.PrintIndividualDetails(indArr,j);
                   }
                }
            }
        }
        }
        System.out.println();
    System.out.println("Total errors found: " + errorcounter);
    return errorcounter;
    }
	 
	
}
