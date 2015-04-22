package cs555_ged;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class HimabinduSprint4
{
	public static int birthBeforeDeath(IndividualStruct.individual indArr[],int Itotal)
	{
		int numErrors=0;
	try{
		String birthDate=null;
		String deathDate=null;;
	
		for(int i=0;i<Itotal+1;i++)
			{
				if(indArr[i].BDay != null && indArr[i].DDay != null)
				{
					birthDate = indArr[i].BDay;
					Date bdate = new SimpleDateFormat("dd MMM yyyy").parse(birthDate);
					deathDate = indArr[i].DDay;
					Date ddate = new SimpleDateFormat("dd MMM yyyy").parse(deathDate);
					
					if(bdate.getTime() > ddate.getTime())
					{
						numErrors++;
						Printing.print(1,"Error #" + numErrors + ": the individual below has a death-date prior to a birth date");
                                                Printing.PrintIndividualDetails(indArr, i, 2);					}		
					
				}
			 /*	else
				{
					System.out.println("Individual"+indArr[i].ID+" with out birth or death date");
				}*/
			}
		}
		catch(Exception ex)
			{
				System.out.println("Individual with out Birth or Death date");
			}

		System.out.println("Number of Errors :"+numErrors);
		return numErrors;
	}
	
	
	public static int ChildrensGap(FamilyStruct.family famArr[],IndividualStruct.individual indArr[],int Ftotal,int Itotal)
	{
            Printing.printHeader("Chceking to make sure the gap between births is less than 90 or more than 145");
		int numErrors = 0;
		try
		{
		String childBDate=null;
		for(int i=0;i<Ftotal+1;i++)
		{

			if(famArr[i].getNumChildren()==0)
			{
				//System.out.println("no Children for family "+ famArr[i].getID());
			}
			else
			{

				for(int j=0;j<famArr[i].getNumChildren()-1;j++){
                                        childBDate = indArr[famArr[i].getChild(j)].getBDay();
                                        Date c1bday = new SimpleDateFormat("dd MMM yyyy").parse(childBDate);
					for(int k=1;k<famArr[i].getNumChildren();k++)
					{
						
						String child2BDate = indArr[famArr[i].getChild(k)].getBDay();
						Date c2bday = new SimpleDateFormat("dd MMM yyyy").parse(child2BDate);
						long diff = c2bday.getTime()-c1bday.getTime();
						long diffdays = diff / (24 * 60 * 60 * 1000);
						if(diffdays < 0)
						{
							diffdays = -(diffdays);
						}
						
						if(diffdays > 90 && diffdays < 140)
						{
                                                    
							numErrors++;
                                                        Printing.print(1, "Error #" + numErrors + ": There is an error in the birth gap of the individuals below, the gap is only " +diffdays + " days.");
                                                        Printing.PrintFamilyDetails(famArr, i, 3, indArr, true, false);
                                                        Printing.PrintIndividualDetails(indArr, famArr[i].getChild(k),3);
                                                        Printing.PrintIndividualDetails(indArr, famArr[i].getChild(j),3);
						}
					}
			}}
		}
		}
		catch(Exception ex)
		{
			System.out.println("Individual with out Birth or Death date");
		}
		
		return numErrors;
	}

}
