package cs555_ged;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HimabinduSprint3 {
public static int birthBeforeMomDeath(FamilyStruct.family famArr[],IndividualStruct.individual indArr[],int fTotal,int Itotal)
{ int numErrors =0;
	try{
			for(int i=0;i<fTotal+1;i++)
		{
			famArr[i].setWife(i);
			String deathDate;
			String childBDate;
			deathDate = indArr[famArr[i].getWife()].getDDay();
			Date d1 = new SimpleDateFormat("dd MMM yyyy").parse(deathDate);
			if(famArr[i].getNumChildren()==0)
			{
				System.out.println("no Children for family "+ famArr[i].getID());
			}
			else
			{
				for(int j=0;j<famArr[i].getNumChildren();j++)
				{
					childBDate = indArr[famArr[i].getChild(j)].getBDay();
					Date d2 = new SimpleDateFormat("dd MMM yyyy").parse(childBDate);
					if(d1.getTime() < d2.getTime())
					{
						System.out.println("Mom with death date before birth date of kid"+famArr[i].getID());
						numErrors++;
						System.out.println("Number of Errors"+numErrors);
					}
					
				}
			}
		}
		
	}
	
	catch(Exception exc)
	{
		System.out.println("Child without Birth Date");
	}
		return numErrors;
}

public static int birthBeforeMomBirth(FamilyStruct.family famArr[],IndividualStruct.individual indArr[],int fTotal,int Itotal)
{ int numErrors =0;
	try{
			for(int i=0;i<fTotal+1;i++)
		{
			famArr[i].setWife(i);
			String momBDate;
			String childBDate;
			momBDate = indArr[famArr[i].getWife()].getBDay();
			Date d1 = new SimpleDateFormat("dd MMM yyyy").parse(momBDate);
			if(famArr[i].getNumChildren()==0)
			{
				System.out.println("no Children for family "+ famArr[i].getID());
			}
			else
			{
				for(int j=0;j<famArr[i].getNumChildren();j++)
				{
					childBDate = indArr[famArr[i].getChild(j)].getBDay();
					Date d2 = new SimpleDateFormat("dd MMM yyyy").parse(childBDate);
					if(d1.getTime() > d2.getTime())
					{
						System.out.println("Mom with birth date later birth date of kid"+famArr[i].getID());
						numErrors++;
						System.out.println("Number of Errors"+numErrors);
					}
					
				}
			}
		}
		
	}
	
	catch(Exception exc)
	{
		System.out.println("Mom without Birth Date");
	}
		return numErrors;
}

}