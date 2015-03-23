/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cs555_ged;

/**
 *
 * @author sgroznys
 */
public class StasSprint1 {
    public static void MoreThan15Kids(FamilyStruct.family famArr[],int fTotal){
        for(int i=0;i<fTotal+1;i++){
           System.out.println("Family ID:" +famArr[i].getID());
           for(int j=0; j<15; j++){
               System.out.println("Child " + (j+1) + famArr[i].getChild(j));
           }
        }
    }
    public static void TwoIdenticalIndviduals(IndvidualStruct.individual indArr[], int Itotal){
        //Determines if two indivduals have same name and same birthday
        int errorcounter=0;
        System.out.println("Searching for 2 identical indviduals: ");
        for(int i=0;i<Itotal;i++){
            for(int j=i+1;j<Itotal+1;j++){
                if(indArr[i].name.equals(indArr[j].name)){
                   if(indArr[i].BDay.equals(indArr[j].BDay)){
                       errorcounter++;
                       System.out.println("==============================================");
                       System.out.println("Error number " + errorcounter + ":");
                       Printing.PrintIndividualDetails(indArr,i);
                       System.out.println("--------------------");
                       System.out.println("Is a match to: ");
                       Printing.PrintIndividualDetails(indArr,j);
                   }
                }
            }
        }
        System.out.println();
    System.out.println("Total errors found: " + errorcounter);
    }
 
}
