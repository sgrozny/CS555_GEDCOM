package cs555_ged;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LeSprint2 {
   public static int MarryProblems(IndvidualStruct.individual indArr[], FamilyStruct.family famArr[],  int Ftotal){
           try{ int numerrors=0;   
            int w,h;
             String marry;
           String childdate;
           String wifeddate;
           String husbanddate;
                   for(int i=0;i<Ftotal+1;i++){
                  marry=famArr[i].getMarriedDate();
                w=famArr[i].getWife();
                h=famArr[i].getHusb();
                husbanddate=indArr[h].getDDay();
                wifedate=indArr[w].getDDay();
                   for(int j=0; j<30;j++){
                       if ((famArr[i].getChild(j))==-1){
                           continue;
                       }
                       else{
                      String childbday= indArr[famArr[i].getChild(j)].getbday();
                       }
                   }
            Date date1=new SimpleDateFormat("dd MMM yyyy").parse(marry);
            Date date2=new SimpleDateFormat("dd MMM yyyy").parse(husbanddate);
            Date date3=new SimpleDateFormat("dd MMM yyyy").parse(wifedate);
            Date date4=new SimpleDateFormat("dd MMM yyyy").parse(childbday);
                 if(date1.getTime()>date2.getTime()||date1.getTime()>date3.getTime()||date4.getTime()>date2.getTime()||date4.getTime()>date3.getTime())
           {
             System.out.println("the marrydate of persons or the birthday of childs is older than the deaddate of the person!");
              }
               } 
           }
           catch(Exception exc){
              System.out.print("there is no child date existing! ")
           }
        return numerrors;   
    }
    public static int MarryProblems( FamilyStruct.family famArr[],  int Ftotal){
           // System.out.println("Individuals:");
        //Inprogress
        int numerrors=0;   
        try{
           String marry;
           String divorce;
           
       for(int i=0;i<Ftotal+1;i++){
            marry=famArr[i].getMarriedDate();
            divorce=famArr[i].getDivDate();
            Date date1=new SimpleDateFormat("dd MMM yyyy").parse(marry);
            Date date2=new SimpleDateFormat("dd MMM yyyy").parse(divorce);
            if(date1.getTime()<date2.getTime())
           {
             System.out.println("the marrydate of persons is older than the divorcedate of the person!");
              }
        }
     }
    catch(Exception exc){
           System.out.print("there is no divorce date existing! ")
    }
}
               
return numerrors;    
    }
    
}
    }
}
