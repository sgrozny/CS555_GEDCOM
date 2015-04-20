package cs555_ged;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LEZHANGsprint2 {
   public static int Userstory06(IndividualStruct.individual indArr[], FamilyStruct.family famArr[],  int Ftotal){
       int numErrors=0;    
       try{   
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
                wifeddate=indArr[w].getDDay();
                   for(int j=0; j<30;j++){
                       if ((famArr[i].getChild(j))==-1){
                           break;
                       }
                       else{
                      String childbday= indArr[famArr[i].getChild(j)].BDay;
                      Date date1=new SimpleDateFormat("dd MMM yyyy").parse(marry);
                      Date date2=new SimpleDateFormat("dd MMM yyyy").parse(husbanddate);
                      Date date3=new SimpleDateFormat("dd MMM yyyy").parse(wifeddate);
                      Date date4=new SimpleDateFormat("dd MMM yyyy").parse(childbday);
                      
                      if(date1.getTime()>date2.getTime()){
                          numErrors++;
                         System.out.println("==============================");
                         System.out.println("In the family"+(i+1)+", ");
                         System.out.println("the deaddate of the husband is: "+husbanddate);
                         System.out.println("the marrydate is: "+marry);
                         
                         System.out.println("the marrydate can not happen after husband being dead,so it is wrong!");
                      }
                      else if(date1.getTime()>date3.getTime()){
                           numErrors++;
                       System.out.println("==============================");
                         System.out.println("In the family"+(i+1)+", ");
                         System.out.println("the deaddate of the wife is: "+wifeddate);
                         System.out.println("the marrydate is: "+marry);
                         
                         System.out.println("the marrydate can not happen after wife being dead,so it is wrong!");
                      }
                      else if(date4.getTime()>date2.getTime()){
                           numErrors++;
                        System.out.println("==============================");
                         System.out.println("In the family"+(i+1)+", ");
                         System.out.println("the deaddate of the husband is: "+husbanddate);
                         System.out.println("the birthday of the child "+indArr[famArr[i].getChild(j)].name+" is: "+childbday);
                         
                         System.out.println("the birthday of the child "+ indArr[famArr[i].getChild(j)].name+" can not happen after husband being dead,so it is wrong!");
                      }
                      else if(date4.getTime()>date3.getTime()){
                           numErrors++;
                        System.out.println("==============================");
                         System.out.println("In the family"+(i+1)+", ");
                         System.out.println("the deaddate of the wife is: "+wifeddate);
                         System.out.println("the birthday of the child "+indArr[famArr[i].getChild(j)].name+" is: "+childbday);
                         
                         System.out.println("the birthday of the child "+ indArr[famArr[i].getChild(j)].name+" can not happen after wife being dead,so it is wrong!");
                      }
                       }
                       }
                       
                   }
            
                
               } 
           
           catch(Exception exc){
              System.out.print("there is no child date existing! ");
           }
       System.out.println("the total number of errors is:"+numErrors);
        return numErrors;   
    }
    public static int Userstory07( FamilyStruct.family famArr[],  int Ftotal){
           // System.out.println("Individuals:");
        //Inprogress
        int numErrors=0;   
        try{
           String marry;
           String divorce;
           
       for(int i=0;i<Ftotal+1;i++){
            marry=famArr[i].getMarriedDate();
            divorce=famArr[i].getDivDate();
            if(marry!=null&&divorce!=null){
            Date date1=new SimpleDateFormat("dd MMM yyyy").parse(marry);
            Date date2=new SimpleDateFormat("dd MMM yyyy").parse(divorce);
            if(date1.getTime()>date2.getTime())
           {System.out.println("==============================");
             System.out.println("In the family"+(i+1)+",");
             System.out.println("the marry date is: "+marry);
             System.out.println("the divorce date is: "+divorce);
             System.out.println("the marrydate  is older than the divorcedate!");
             numErrors++;
              }
            }
        }
     }
    catch(Exception exc){
           System.out.print("there is no divorce date existing! ");
    }
        

     System.out.println("the total number of errors is:"+numErrors);          
return numErrors;    
    }
    
}
    

