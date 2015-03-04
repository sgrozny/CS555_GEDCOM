package cs555_ged;

public class HimabinduSprint1{
public static void missingBirthDate(IndvidualStruct.individual indArr[], int Itotal){
	boolean missing = true;
	System.out.println("User story : Looking for any Missing birth dates:");
	for(int i=0;i<Itotal;i++)
	{
		if (indArr[i].BDay == null)
			System.out.println("Birth date is misssing for Individual" + indArr[i].ID);
		else
			missing = false;
			//System.out.println("Each individual is with Birthdate");
		//System.out.println("Birth Date of individuals:"+indArr[i].BDay);    		
	}
	if (missing == false)
		System.out.println("Each and every individual has Birthdate");
}
}