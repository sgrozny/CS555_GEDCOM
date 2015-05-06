package cs555_ged;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sgrozny
 */
public class StasSprint5 {
    public static int DualMarriage(IndividualStruct.individual indArr[], int iTotal, FamilyStruct.family famArr[],  int Ftotal){
        int numErrors=0;
        Printing.printHeader("Checking to make sure there are no extra marriage events in family");
        int i;
        for(i=0;i<Ftotal+1;i++){
             if (famArr[i].secondMarr!=null) {
                 if (famArr[i].DivDate==null){
                     numErrors++;
                     Printing.print(1, "Error #"+numErrors+ " family " + famArr[i].ID + " has 2 marriage events but no divorce date");
                     Printing.PrintFamilyDetails(famArr, i, 2, indArr, true, false);
                     Printing.print(2, "Second Married date =" + famArr[i].secondMarr);
                 }
             }
        }
        return numErrors;
    
    }
    public static int Marriedat18(IndividualStruct.individual indArr[], FamilyStruct.family famArr[], int Itotal, int Ftotal){
     Printing.printHeader("Checking whether the age of husbands and wives are older than 18 ");
    int numErrors=0;
     try{
        Integer w;     
        Integer h;
        for(int i=0;i<Ftotal+1;i++){
              w=famArr[i].getWife();
              h=famArr[i].getHusb();
              
              if(w!=null&&h!=null){
              String husbdate=indArr[h].getBDay();       
              String wifebdate=indArr[w].getBDay();
              
                if(wifebdate!=null&&husbdate!=null){
                    Date wifebir=new SimpleDateFormat("dd MMM yyyy").parse(wifebdate);
                    Date husbir=new SimpleDateFormat("dd MMM yyyy").parse(husbdate);
                        if(famArr[i].MarriedDate!=null){
                            Date mardate=new SimpleDateFormat("dd MMM yyyy").parse(famArr[i].MarriedDate);

                            Calendar mycalendar=Calendar.getInstance();
                            String y=String.valueOf(mycalendar.get(Calendar.YEAR));
                            int b=mardate.getYear()+1900;;
                            int a=wifebir.getYear()+1900;
                            int c=husbir.getYear()+1900;
                            int wifeage=b-a;
                            int husage=b-c;

                            if(wifeage<18){
                               if(husage<18){
                               Printing.print(1, "In family "+famArr[i].ID+","+indArr[h].getName()+"'s age at point of marriage was "+husage+", which is less than 18");
                               Printing.PrintIndividualDetails(indArr,h,2);
                               Printing.PrintFamilyDetails(famArr, i, 2, indArr, true, false);
                               System.out.println("-------------------------------");
                               numErrors++;
                               }
                            Printing.print(1,"In family "+famArr[i].ID+","+indArr[w].getName()+"'s age at point of marriage was "+wifeage+", which is less than 18");;
                              Printing.PrintIndividualDetails(indArr,w,2);
                              Printing.PrintFamilyDetails(famArr, i, 2, indArr, true, false);
                               System.out.println("-------------------------------");
                              numErrors++;
                            }
                            else if(husage<18){
                             Printing.print(1,"In family "+famArr[i].ID+","+indArr[h].getName()+"'s age at point of marriage was "+husage+", which is less than 18");
                              Printing.PrintIndividualDetails(indArr, h, 2);
                              Printing.PrintFamilyDetails(famArr, i, 2, indArr, true, false);
                               System.out.println("-------------------------------");
                               numErrors++;
                            }
                    }  
                } 
            }
}
     }
     catch(Exception exc){
              System.out.print("there is no husbands and wives' birthday date existing! ");
           }
        //System.out.println("total number of errors is:"+numErrors);
       
    
           

    System.out.println("the total number of errors is:"+numErrors);
    return numErrors;
           }
}
