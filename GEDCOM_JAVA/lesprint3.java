/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs555_ged;

/**
 *
 * @author zhang_000
 * 
 */
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
public class lesprint3 {
    public static void userstory18(IndividualStruct.individual indArr[], FamilyStruct.family famArr[], int Itotal, int Ftotal ){
       try{
        Integer w;     
        for(int i=0;i<Ftotal+1;i++){
              w=famArr[i].getWife();
              if(w!=null){
              String wifebdate=indArr[i].getBDay();
               
              Date wifebir=new SimpleDateFormat("dd MMM yyyy").parse(wifebdate);
             
              
              Calendar   mycalendar=Calendar.getInstance();
              String y=String.valueOf(mycalendar.get(Calendar.YEAR));
              int b=Integer.parseInt(y);
              int a=wifebir.getYear()+1900;
              int tmp=b-a;
              if(tmp<5){
               System.out.println("in the family "+(i+1)+", the age of the monther is less than 5");
               System.out.println("her name is:"+indArr[w].getName());
              }
              
              }
             }

}
     catch(Exception exc){
              System.out.print("there is no monther birthday date existing! ");
           }
    }
    public static void userstory22(IndividualStruct.individual indArr[], FamilyStruct.family famArr[], int Itotal, int Ftotal){
     try{
         for(int i=0;i<Itotal+1;i++){
            // System.out.println("BirthDay: " + indArr[i].BDay);
         Calendar   mycalendar=Calendar.getInstance();
              String y=String.valueOf(mycalendar.get(Calendar.YEAR));
              int b=Integer.parseInt(y);
             String datebir=indArr[i].getBDay();
             Date date=new SimpleDateFormat("dd MMM yyyy").parse(datebir);
              int a=date.getYear()+1900;
             // System.out.println("the year is:"+b);
              
              int tmp=b-a;
             // System.out.println("the year is:"+indArr[i].getName()+tmp);
              if(tmp>90){
                  System.out.println("the person "+indArr[i].getName()+" is older than 130 years old");
              }}
    
     }
     catch(Exception exc){
              System.out.print("there is no birthday date existing! ");
           } 
}

}