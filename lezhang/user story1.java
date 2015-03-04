
package cs555_ged;


public class Printing {
    public static void printIT(IndvidualStruct.individual indArr[], FamilyStruct.family famArr[],  int Ftotal){
           // System.out.println("Individuals:");
           int w,h;
       for(int i=0;i<Ftotal+1;i++){
            w=famArr[i].getWife();
            h=famArr[i].getHusb();
            if(indArr[h].getGender!='M'){
            System.out.println("The gender of"+indArr[h].getName()+" husband is wrong!");
}
              
           else if(indArr[w].getGender!='F'){
            System.out.println("The gender of"+indArr[w].getName()+" wife is wrong!");
}
           else {
             System.out.println("The genders of all are ture! ");
           }
       }
  }     