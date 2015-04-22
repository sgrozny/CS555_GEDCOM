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
 * @author zhang_le
 */
public class lesprint4 {
    public static int Userstory20(IndividualStruct.individual indArr[], FamilyStruct.family famArr[], int Itotal, int Ftotal){
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
              
              Calendar   mycalendar=Calendar.getInstance();
              String y=String.valueOf(mycalendar.get(Calendar.YEAR));
              int b=Integer.parseInt(y);
              int a=wifebir.getYear()+1900;
              int c=husbir.getYear()+1900;
              int wifeage=b-a;
              int husage=b-c;
              
              if(wifeage<18){
                 if(husage<18){
                 System.out.println("In family "+famArr[i].ID+","+indArr[h].getName()+"'s age is "+husage+", less than 18,but he is a husband");
                 Printing.PrintIndividualDetails(indArr,h,2);
                 System.out.println("-------------------------------");
                 numErrors++;
                 }
               System.out.println("In family "+famArr[i].ID+","+indArr[w].getName()+"'s age is "+wifeage+", less than 18,but she is a wife");
                Printing.PrintIndividualDetails(indArr,w,2);
                 System.out.println("-------------------------------");
                numErrors++;
              }
              else if(husage<18){
               System.out.println("In family "+famArr[i].ID+","+indArr[h].getName()+"'s age is "+husage+", less than 18,but he is a husband");
             
                Printing.PrintIndividualDetails(indArr, h, 2);
                 System.out.println("-------------------------------");
                 numErrors++;
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
    
    public static int Userstory24(IndividualStruct.individual indArr[], FamilyStruct.family famArr[], int Itotal, int Ftotal){
        Printing.printHeader( "Check whether in one family, there is only one husband but no wife " );     
        int numErrors=0;
               Integer w,h;
    
    for(int i=0;i<Ftotal+1;i++){
           w=famArr[i].getWife();
           h=famArr[i].getHusb();
           if(w==null){
           if(h==null){
               if (famArr[i].getNumChildren()>0){
               System.out.println("In the family "+famArr[i].getID()+", there are is wife and husband existing !");
               Printing.PrintFamilyDetails(famArr,i,2,indArr,true,false);
            numErrors++;
               }
           }
          
           else{
               if (famArr[i].getNumChildren()>0){
            System.out.println("In the family "+famArr[i].getID()+", there are is wife existing !");
               Printing.PrintFamilyDetails(famArr,i,2,indArr,true,false);
            numErrors++;
               }
           }
           }
    }
           

    System.out.println("the total number of errors is:"+numErrors);
    return numErrors;
           }
    
    
    }
   
   

