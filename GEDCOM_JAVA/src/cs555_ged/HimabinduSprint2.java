package cs555_ged;

public class HimabinduSprint2 {

	public static int missingMarriageDate(FamilyStruct.family famArr[], int Itotal)
	{
		int numErrors = 0;
		 System.out.println();
	     System.out.println("==============================================");
		System.out.println("User story : Looking for any Missing Marriage date for a family:");
		for(int i=0;i<Itotal+1;i++)
		{
			if(famArr[i].getMarriedDate() == null)
			{
				System.out.println("Marriage date is missing for Family"+ famArr[i].getID());
				numErrors++;
			}
		}
		if (numErrors == 0)
			System.out.println("Each and every Family has Marriage Date");
		return numErrors;
	}
	
	public static int childrenWithSameNameandDateofBirth(IndvidualStruct.individual indArr[],FamilyStruct.family famArr[],int Itotal, int ftotal )
	{
		int numErrors = 0, numberOfChildren=0;
		System.out.println();
	     System.out.println("==============================================");
		System.out.println("User story : Looking for children in the same family with same name and Date of Birth:");
		for(int i=0; i<=ftotal;i++)
		{
			//if(famArr[i].getChild(i)==0)
			//{
				System.out.println(famArr[i].getID());
				for(int j=0;j<Itotal;j++){
					System.out.println(famArr[i].getChild(j));
				}
			//}
			//else
			//{
				//numberOfChildren++;
			//}
		
		}
		//System.out.println("No of children "+numberOfChildren);
		return numberOfChildren;
	}
}
