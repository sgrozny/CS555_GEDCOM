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
    public static int userstory18(IndividualStruct.individual indArr[], FamilyStruct.family famArr[], int Itotal, int Ftotal ){
        Printing.printHeader("Checking if mother's age is less than 5 years old");
        int numErrors=0;
        try{
        Integer w;     
        for(int i=0;i<Ftotal+1;i++){
              w=famArr[i].getWife();
              if(w!=null){
                  if(famArr[i].getNumChildren()!=0){
                      //Check if birthday is null
                       for(int j=0;j<famArr[i].getNumChildren();j++){
               String kidbdate=  indArr[famArr[i].getChild(j)].BDay;    
              String wifebdate=indArr[i].getBDay();
               if(wifebdate!=null&&kidbdate!=null){
              Date wifebir=new SimpleDateFormat("dd MMM yyyy").parse(wifebdate);
              Date kidbir=new SimpleDateFormat("dd MMM yyyy").parse(kidbdate);
              
              Calendar   mycalendar=Calendar.getInstance();
              String y=String.valueOf(mycalendar.get(Calendar.YEAR));
              int b=Integer.parseInt(y);
              int a=wifebir.getYear()+1900;
              int c=kidbir.getYear()+1900;
              int wifeage=b-a;
              int kidage=b-c;
              int range=wifeage-kidage;
              if(wifeage<5){
                 
               System.out.println("In the family "+(i+1)+","+indArr[w].getName()+"'s age is "+wifeage+", but she is a monther whose age is less than 5");
                Printing.PrintIndividualDetails(indArr,w,2);
                 System.out.println("-------------------------------");
                numErrors++;
              }
              else if(range<5){
               System.out.println("in the family "+(i+1)+","+indArr[w].getName()+"'s age is "+wifeage+", but her kid "+indArr[famArr[i].getChild(j)].name+"'s age is "+kidage);
               System.out.println("So when her kid was born, she was only "+range+" years old,which also less than 5 years old!");
                Printing.PrintIndividualDetails(indArr,w,2);
                Printing.PrintIndividualDetails(indArr, famArr[i].getChild(j), 2);
                 System.out.println("-------------------------------");
                 numErrors++;
              }
               }
                       }
              }
                  else if(famArr[i].getNumChildren()==0){
                  String wifebdate=indArr[i].getBDay();
                  Date wifebir=new SimpleDateFormat("dd MMM yyyy").parse(wifebdate);
                  Calendar   mycalendar=Calendar.getInstance();
              String y=String.valueOf(mycalendar.get(Calendar.YEAR));
              int b=Integer.parseInt(y);
              int a=wifebir.getYear()+1900;
              int tmp=b-a;
              if(tmp<5){
                 
               System.out.println("in the family "+(i+1)+","+indArr[w].getName()+"'s age is "+tmp+",less than 5,but she has no kids, so it does not matter!");
               Printing.PrintIndividualDetails(indArr,w,2);
                System.out.println("-------------------------------");
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
    public static int userstory22(IndividualStruct.individual indArr[], FamilyStruct.family famArr[], int Itotal, int Ftotal){
        Printing.printHeader("Checking if Indvidual's age is over 130 years old"); 
        int numErrors=0;
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
              if(tmp>130){
                  
                 
                  
                  numErrors++;
                  Printing.print(1,"Error number:" + numErrors+ " "+indArr[i].getName()+"'s age is "+tmp+",which is older than 130");
                   Printing.PrintIndividualDetails(indArr,i,2);
                   System.out.println("-------------------------------");
              }}
    
     }
     catch(Exception exc){
              System.out.print("there is no birthday date existing! ");
           } 
        System.out.println("total number of errors is:"+numErrors);
        return numErrors;
    }
    

}