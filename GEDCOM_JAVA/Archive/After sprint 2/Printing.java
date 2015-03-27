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
    public static void printIT(IndividualStruct.individual indArr[], FamilyStruct.family famArr[], int Itotal, int Ftotal){
            System.out.println("Individuals:");
       for(int i=0;i<Itotal+1;i++){
            System.out.println("ID: " + indArr[i].getID() + " :  ");
            System.out.println("Name: " + indArr[i].getName());
            System.out.println("Gener: " + indArr[i].gender);
            System.out.println("BirthDay: " + indArr[i].BDay);
            System.out.println("Death Date: " + indArr[i].DDay);
            System.out.println("Spouse of Family: " + indArr[i].FAMS);
            System.out.println("Child of Family:" + indArr[i].FAMC);
//            if(indArr[i].getChild()!=null){
//            System.out.println("Child of Family: "  + famArr[indArr[i].getChild()].getID());
//            }
//            else {
//                System.out.println("Child of Family: null" );
//            }
            System.out.println("==============================================");
 
       }
       System.out.println("------------------------------");
       System.out.println("Families");
       Integer w,h;
       for(int i=0;i<Ftotal+1;i++){
           System.out.println("Family ID:" +famArr[i].getID());
           w=famArr[i].getWife();
           h=famArr[i].getHusb();
           if(h!=null){
           System.out.println("Husband: "+ indArr[h].getName());
           }
           else{
               System.out.println("Husband: null");
           }
           if(w!=null){
           System.out.println("Wife: " + indArr[w].getName());
           }
           else{
                System.out.println("Wife: null");
           }
           System.out.println("DivorceDate: " + famArr[i].getDivDate());
           System.out.println("Num of Children: " + famArr[i].getNumChildren());
           System.out.println("~~~~~~~~~~~~~~~~~");
       }
    }
    public static void PrintIndividualDetails(IndividualStruct.individual indArr[], int i, int tabs){
            print(tabs,"ID: " + indArr[i].getID());
            print(tabs,"Name: " + indArr[i].getName());
            print(tabs,"Gener: " + indArr[i].gender);
            print(tabs,"BirthDay: " + indArr[i].BDay);
            print(tabs,"Death Date: " + indArr[i].DDay);
            print(tabs,"Spouse to Family: " +indArr[i].FAMS);
            print(tabs,"Child to Family: " +indArr[i].FAMC);
    }
    public static void PritnAllChildren(IndividualStruct.individual indArr[], FamilyStruct.family famArr[], int Itotal, int Ftotal){
         for(int i=0;i<Ftotal+1;i++){
             System.out.println("Family ID:" +famArr[i].getID());
                   for(int j=0; j<30;j++){
                       if ((famArr[i].getChild(j))==-1){
                           break;
                       }
                       else{
                       System.out.println("Child " + (j+1) + ": " + indArr[famArr[i].getChild(j)].name);
                       }
                   }
           }
    }
     public static void print(int tab, String txt){
        String tabS="";
        for(int i=0;i<tab;i++){
            tabS= tabS.concat("     ");
        }
        System.out.println(tabS+txt);
    }
     public static void printHeader(String header){
         String x="-----------";
         System.out.println(x+header+x);
     }
}
