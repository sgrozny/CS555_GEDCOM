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
            System.out.println("ID: " + indArr[i].getID() + " :  ");
            System.out.println("Name: " + indArr[i].getName());
            System.out.println("Gener: " + indArr[i].gender);
            System.out.println("BirthDay: " + indArr[i].BDay);
            System.out.println("Death Date: " + indArr[i].DDay);
            System.out.println("Child of Family " + famArr[indArr[i].Child].getID());
            System.out.println("Spouse of Family " + famArr[indArr[i].Spouse].getID());
            System.out.println("==============================================");
 
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
           System.out.println("DivorceDate: " + famArr[i].getDivDate());
           System.out.println("~~~~~~~~~~~~~~~~~");
       }
    }
    public static void PrintIndividualDetails(IndvidualStruct.individual indArr[], int i){
            System.out.println("ID: " + indArr[i].getID() + " :  ");
            System.out.println("Name: " + indArr[i].getName());
            System.out.println("Gener: " + indArr[i].gender);
            System.out.println("BirthDay: " + indArr[i].BDay);
            System.out.println("Death Date: " + indArr[i].DDay);
    }
}
