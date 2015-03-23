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
        //Printing.printIT(indArr, famArr,iCounter,fCounter);  
        //Printing.PritnAllChildren(indArr, famArr, Itotal, Ftotal);
        StasSprint1.TwoIdenticalIndviduals(indArr,Itotal);
        StasSprint1.MoreThan15Kids(indArr, famArr, Ftotal);
             //ClassName.Methodname(parameters);
    }
}
