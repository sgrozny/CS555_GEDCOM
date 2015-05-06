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
    public static void Test_Sprint1(IndividualStruct.individual indArr[], FamilyStruct.family famArr[], int Itotal, int Ftotal, int initialErrorCount){
        int numErrors=initialErrorCount;
        //FORMAT
        //ClassName.Methodname(parameters);
        
//        Printing.printIT(indArr, famArr,Itotal,Ftotal);  
//        Printing.PritnAllChildren(indArr, famArr, Itotal, Ftotal);
//        Printing.printIT(indArr, famArr, Itotal, Ftotal);
//        numErrors+=StasSprint1.TwoIdenticalIndviduals(indArr,Itotal);
//        numErrors+=StasSprint1.MoreThan15Kids(indArr, famArr, Ftotal);
//        numErrors+=HimabinduSprint1.missingBirthDate(indArr, Itotal//
//        numErrors+=LeSprint1.userstory1(indArr, famArr, Ftotal);
//        numErrors+=LEZHANGsprint2.Userstory06(indArr, famArr, Ftotal);
//       numErrors+=lesprint4.Userstory20(indArr, famArr, Itotal, Ftotal);
//        numErrors+=lesprint4.Userstory24(indArr, famArr, Itotal, Ftotal);
//        numErrors+=lesprint3.userstory18(indArr, famArr, Itotal, Ftotal);
//        numErrors+=lesprint3.userstory22(indArr, famArr, Itotal, Ftotal);
////          numErrors+=StasSprint2.ChildisItsparent(indArr, Itotal, famArr, Ftotal);
////          numErrors+=StasSprint2_US2.ind_is_SpouseandChild(indArr, Itotal);
////          numErrors+=HimabinduSprint2.childrenWithSameNameandDateofBirth(indArr, Itotal, famArr, Ftotal);
////          numErrors+=HimabinduSprint2.missingMarriageDate(famArr, Ftotal);
// //         StasSprint3.test( indArr,famArr, Ftotal);
// //         numErrors+=StasSprint3.indRecordsMatchFam(indArr, Itotal, famArr, Ftotal);
// //         numErrors+=StasSprint3.famRecordsMatchInd(indArr,Itotal, famArr, Ftotal);
// //       numErrors+=lesprint4.Userstory24(indArr, famArr, Itotal, Ftotal);
//        numErrors+=StasSprint4.Polygamy(indArr, Itotal, famArr, Ftotal);
// //         numErrors+=HimabinduSprint3.birthBeforeMomBirth(famArr, indArr, Ftotal, Itotal);
// //         numErrors+=HimabinduSprint3.birthBeforeMomDeath(famArr, indArr, Ftotal, Itotal);
//            numErrors+=HimabinduSprint4.ChildrensGap(famArr, indArr, Ftotal, Itotal);
//            numErrors+=HimabinduSprint4.birthBeforeDeath(indArr, Itotal);
 //         numErrors+=lesprint3.userstory18(indArr, famArr, Itotal, Ftotal);
 //         lesprint3.userstory22(indArr, famArr, Itotal, Ftotal);
        numErrors+=StasSprint5.DualMarriage(indArr, Itotal, famArr, Ftotal);
          numErrors+=StasSprint5.Marriedat18(indArr, famArr, Itotal, Ftotal);
          numErrors+=lesprint5.Userstory30(indArr, famArr, Itotal, Ftotal);
          System.out.println();
        System.out.println("***********************************************");
        System.out.println("Total number of errors found was: " + numErrors);     
    }
    

}
