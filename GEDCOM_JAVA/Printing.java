/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cs555_ged;

/**
 *
 * @author sgrozny
 */
public class Printing {
    public static void printIT(IndvidualStruct.individual indArr[], FamilyStruct.family famArr[], int Itotal, int Ftotal){
            System.out.println("Individuals:");
       for(int i=0;i<Itotal+1;i++){
            System.out.print(indArr[i].getID() + " :  ");
            System.out.println(indArr[i].getName());
       }
       System.out.println("------------------------------");
       System.out.println("Families");
       int w,h;
       for(int i=0;i<Ftotal+1;i++){
           System.out.println("Family ID:" +famArr[i].getID());
           w=famArr[i].getWife();
           h=famArr[i].getHusb();
           System.out.println("Husband: "+ indArr[h].getName());
           System.out.println("Wife: " + indArr[w].getName());
           System.out.println("~~~~~~~~~~~~~~~~~");
       }
}
}
