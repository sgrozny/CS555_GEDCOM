package cs555_ged;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Printing {
    public static void printIT(IndvidualStruct.individual indArr[], FamilyStruct.family famArr[],  int Ftotal){
           // System.out.println("Individuals:");
           int w,h;
           string marry;
           string wifedate;
           string husbanddate;
       for(int i=0;i<Ftotal+1;i++){
            marry=famArr[i].getMarriedDate();
            w=famArr[i].getWife();
            h=famArr[i].getHusb();
            husbanddate=indArr[h].getDDay;
            wifedate=inArr[w].getDDay;
            Date date1=new SimpleDateFormat("dd MMM yyyy").parse(marry);
            Date date2=new SimpleDateFormat("dd MMM yyyy").parse(husbanddate);
            Date date3=new SimpleDateFormat("dd MMM yyyy").parse(wifedate);
            if(date1.getTime()>date2.getTime||date1.getTime()>date3.getTime())
           {
             System.out.println("the marrydate of persons is older than the deaddate of the person!")
              }
       }
  }     