
package cs555_ged;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LeSprint1 {
    public static int userstory1(IndvidualStruct.individual indArr[], FamilyStruct.family famArr[],  int Ftotal){
           // System.out.println("Individuals:");
           int numerrors=0;
           int w,h;
           System.out.println("||||||||||||||||||||||||||||||||||||||");
           System.out.println("Checking if gender is right on each husband and wife");
       for(int i=0;i<Ftotal+1;i++){
            w=famArr[i].getWife();
            h=famArr[i].getHusb();
            if(!(indArr[h].getGender().equals("M"))){
            System.out.println("The gender of husband "+indArr[h].getName()+ " in family " +famArr[i].ID + " is wrong!");
            numerrors++;
}
              
           if(!(indArr[w].getGender().equals("F"))){
            System.out.println("The gender of wife "+indArr[w].getName() + " in family " +famArr[i].ID +" is wrong!");
            numerrors++;
}
          
       }
       if(numerrors==0){
             System.out.println("The genders of all are correct! ");
           }
       return numerrors;
  }
    public static int MarryProblems(IndvidualStruct.individual indArr[], FamilyStruct.family famArr[],  int Ftotal){
           // System.out.println("Individuals:");
        //Inprogress
        int numerrors=0;   
        int w,h;
           String marry;
           String wifedate;
           String husbanddate;
       for(int i=0;i<Ftotal+1;i++){
            marry=famArr[i].getMarriedDate();
            w=famArr[i].getWife();
            h=famArr[i].getHusb();
            husbanddate=indArr[h].getDDay();
            wifedate=indArr[w].getDDay();
            Date date1=new SimpleDateFormat("dd MMM yyyy").parse(marry);
            Date date2=new SimpleDateFormat("dd MMM yyyy").parse(husbanddate);
            Date date3=new SimpleDateFormat("dd MMM yyyy").parse(wifedate);
            if(date1.getTime()>date2.getTime||date1.getTime()>date3.getTime())
           {
             System.out.println("the marrydate of persons is older than the deaddate of the person!");
              }
    }
return numerrors;    
    }
    
}
