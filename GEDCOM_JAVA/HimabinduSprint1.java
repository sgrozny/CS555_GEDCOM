package cs555_ged;

public class HimabinduSprint1{
public static int missingBirthDate(IndvidualStruct.individual indArr[], int Itotal){
    int numErrors=0;
        System.out.println();
        System.out.println("==============================================");
	System.out.println("User story : Looking for any Missing birth dates:");
	for(int i=0;i<Itotal+1;i++)
	{
		if (indArr[i].BDay == null || indArr[i].BDay.equals("GET DATE")){
			System.out.println("Birth date is misssing for Individual " + indArr[i].ID);
                numErrors++;
                }

			//System.out.println("Each individual is with Birthdate");
		//System.out.println("Birth Date of individuals:"+indArr[i].BDay);    		
	}
	if (numErrors == 0)
		System.out.println("Each and every individual has Birthdate");
return numErrors;
}

}