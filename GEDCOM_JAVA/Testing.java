/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cs555_ged;

/**
 *
 * @author sgrozny
 */
public class Testing {
    public static void Test_Sprint1(IndvidualStruct.individual indArr[], FamilyStruct.family famArr[], int Itotal, int Ftotal){
        int numErrors=0;
        //FORMAT
        //ClassName.Methodname(parameters);
        
        //Printing.printIT(indArr, famArr,Itotal,Ftotal);  
        //Printing.PritnAllChildren(indArr, famArr, Itotal, Ftotal);
        numErrors+=StasSprint1.TwoIdenticalIndviduals(indArr,Itotal);
        numErrors+=StasSprint1.MoreThan15Kids(indArr, famArr, Ftotal);
        numErrors+=HimabinduSprint1.missingBirthDate(indArr, Itotal);
        System.out.println();
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        System.out.println("Total Errors found was: " + numErrors);     
    }
}
