/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs555_ged;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author zhang_000
 */
public class lesprint5 {
    public static int Userstory30(IndividualStruct.individual indArr[], FamilyStruct.family famArr[], int Itotal, int Ftotal){
    Printing.printHeader("the age range between wife and husband must be less than 70! ");
        
        int numErrors=0;
        try{
        Integer w,h;     
        for(int i=0;i<Ftotal+1;i++){
              w=famArr[i].getWife();
              h=famArr[i].getHusb();
              if(w!=null&&h!=null){
                  
                      //Check if birthday is null
                     
               String husbanddate=indArr[h].getBDay();
              String wifebdate=indArr[w].getBDay();
               if(wifebdate!=null&&husbanddate!=null){
              Date wifebir=new SimpleDateFormat("dd MMM yyyy").parse(wifebdate);
              Date husbir=new SimpleDateFormat("dd MMM yyyy").parse(husbanddate);
              
              Calendar   mycalendar=Calendar.getInstance();
              String y=String.valueOf(mycalendar.get(Calendar.YEAR));
              int b=Integer.parseInt(y);
              int a=wifebir.getYear()+1900;
              int c=husbir.getYear()+1900;
              int wifeage=b-a;
              int husage=b-c;
              
              long range1=Math.abs(wifeage-husage);
              
               if(range1>70){
               System.out.println("in the family "+(i+1)+","+indArr[w].getName()+"'s age is "+wifeage+", but her husband "+indArr[h].getName()+"'s age is "+husage);
               System.out.println("So the age range between husband and wife is "+range1+" ,which is greater than 70!");
                Printing.PrintIndividualDetails(indArr,w,2);
                Printing.PrintIndividualDetails(indArr,h,2);
                
                 System.out.println("-------------------------------");
                 numErrors++;
              }
               }
                       
              
                  
             }
        }
}
        
     catch(Exception exc){
              System.out.print("there is no monther birthday date existing! ");
           }
        //System.out.println("total number of errors is:"+numErrors);
        return numErrors;
    }
    
    
    
}
