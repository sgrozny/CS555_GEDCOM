
package cs555_ged;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LeSprint1 {
    public static int userstory1(IndividualStruct.individual indArr[], FamilyStruct.family famArr[],  int Ftotal){
           // System.out.println("Individuals:");
           int numerrors=0;
           Integer w,h;
            Printing.printHeader("Checking if gender is right on each husband and wife");
           
       for(int i=0;i<Ftotal+1;i++){
            w=famArr[i].getWife();
            h=famArr[i].getHusb();
            if(w!=null&&h!=null){
                String wg=indArr[w].getGender();
                String hg=indArr[h].getGender();
                if(hg==null){
                    if(wg==null){
                    System.out.println("The gender of wife "+indArr[w].getName()+ " in family " +famArr[i].ID + " is null! so we do not know what gender she is");
                    System.out.println(" Her ID is:"+indArr[w].getID());
                    }
                System.out.println("The gender of husband "+indArr[h].getName()+ " in family " +famArr[i].ID + " is null! so we do not know what gender he is");
                System.out.println(" His ID is:"+indArr[w].getID());
                Printing.PrintFamilyDetails(famArr,i,2,indArr,false,false);
                numerrors++;
                }
                else if(wg==null){
                System.out.println("The gender of wife "+indArr[h].getName()+ " in family " +famArr[i].ID + " is null! so we do not know what gender she is");
                System.out.println(" Her ID is:"+indArr[w].getID());
                Printing.PrintFamilyDetails(famArr,i,2,indArr,false,false);
                numerrors++;
                }
                else{
            if(!(indArr[h].getGender().equals("M"))){
            System.out.println("The gender of husband "+indArr[h].getName()+ " in family " +famArr[i].ID + " is wrong! He is a husband,but his gender is famale!");
             System.out.println(" Her ID is:"+indArr[w].getID());
             System.out.println(" Her gender is:"+indArr[w].gender);
            Printing.PrintFamilyDetails(famArr,i,2,indArr,false,false);
            numerrors++;
}
              
           if(!(indArr[w].getGender().equals("F"))){
            System.out.println("The gender of wife "+indArr[w].getName() + " in family " +famArr[i].ID +" is wrong! She is a wife,but her gender is male!");
            System.out.println(" His ID is:"+indArr[w].getID());
            System.out.println(" His gender is:"+indArr[w].gender);
            Printing.PrintFamilyDetails(famArr,i,2,indArr,false,false);
            numerrors++;
}
            }   
            }
       }
       if(numerrors==0){
             System.out.println("The genders of all are correct! ");
           }
       else{
           System.out.println("total number of errors is:"+numerrors);
       }
       return numerrors;
  }
    public static int MarryProblems(IndividualStruct.individual indArr[], FamilyStruct.family famArr[],  int Ftotal){
           // System.out.println("Individuals:");
        //Inprogress
        Printing.printHeader("Checking whether marriage date is before death");
        int numerrors=0;   
        try{
        Integer w,h;
           String marry;
           String wifedate;
           String husbanddate;
       for(int i=0;i<Ftotal+1;i++){
            marry=famArr[i].getMarriedDate();
            w=famArr[i].getWife();
            h=famArr[i].getHusb();
            
            wifedate=indArr[w].getDDay();
            husbanddate=indArr[h].getDDay();
            if(husbanddate!=null&&marry!=null){
            Date date1=new SimpleDateFormat("dd MMM yyyy").parse(marry);
            Date date2=new SimpleDateFormat("dd MMM yyyy").parse(husbanddate);
          //  Date date3=new SimpleDateFormat("dd MMM yyyy").parse(wifedate);
            if(date1.getTime()>date2.getTime())
           {
              
             System.out.println("the marrydate of the family"+(i+1)+" is older than the deaddate of the husband "+indArr[h].getName());
             System.out.println("the deaddate of the husband was:"+husbanddate+", but the marrydate is "+marry+". So it is not impossible!");
             numerrors++;
              }}
            else if(wifedate!=null&&marry!=null){
           Date date1=new SimpleDateFormat("dd MMM yyyy").parse(marry);
          //  Date date2=new SimpleDateFormat("dd MMM yyyy").parse(husbanddate);
            Date date3=new SimpleDateFormat("dd MMM yyyy").parse(wifedate);
             if(date1.getTime()>date3.getTime()){
             System.out.println("the marrydate of the family"+(i+1)+" is older than the deaddate of the wife "+indArr[w].getName());
             System.out.println("the deaddate of the husband was:"+wifedate+", but the marrydate is "+marry+". So it is not impossible!");
             numerrors++;
              }}
            
            
            }
    }
        
        catch(Exception exc){
              System.out.print("there is no monther birthday date existing! ");
           }
          System.out.println("total number of errors is:"+numerrors);
return numerrors;    
    }
    
}
