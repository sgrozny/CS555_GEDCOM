/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cs555_ged;

/**
 *
 * @author sgrozny
 */
public class StasSprint2_US2 {
    public static int ind_is_SpouseandChild(IndividualStruct.individual indArr[], Integer iTotal){
       Printing.printHeader("Checking if Indvidual is both a spouse and child to same family:");
        int numerrors=0;
        for(int i=0;i<iTotal+1;i++){
            if((indArr[i].FAMC!=null)&&(indArr[i].FAMS)!=null){
                if((indArr[i].FAMC).equals(indArr[i].FAMS)){
                    numerrors++;
                    Printing.print(1,"Error #" + numerrors + " found");
                    Printing.PrintIndividualDetails(indArr, i, 2);
                }
            }
        }
        return numerrors;
    }
    public static int indRecordsMatch(IndividualStruct.individual indArr[], Integer iTotal, FamilyStruct.family famArr[]){
        int numerrors=0;
        System.out.println("Checking if all indvidual records match family records:");
            for(int i=0;i<iTotal+1;i++){
                if (DiffinRecordsforChild(indArr,i,famArr)){
                    numerrors++;
                }
                if(DiffinRecordsforSpouse(indArr,i,famArr)){
                    numerrors++;
                }
            }
        return numerrors;
    }
    private static boolean DiffinRecordsforChild(IndividualStruct.individual indArr[], Integer i, FamilyStruct.family famArr[]){
        boolean diff=false;
        
        if(indArr[i].FAMC!=null){
            boolean kids=false;
            if(indArr[i].getChild()!=null){
                if(famArr[indArr[i].getChild()].getID()!=null){
                     for(int j=0;j<famArr[indArr[i].getChild()].numChildren;j++){
                         kids=true;
                         if((indArr[i].ID).equals(indArr[famArr[indArr[i].getChild()].getChild(j)].ID)){
                             return diff;
                         }
                      }
              
                        diff=true;
                        System.out.println();
                        System.out.println("      Child of individual " + indArr[i].getName() + " doesn't have a matching family record");
                        System.out.println("      In indvidual record, child to family: " + indArr[i].FAMC);
                        if(kids){
                            System.out.println("      In Family record, child doesn't exist");
                        }
                        else{
                            System.out.println("      No record of kids in family"); 
                        }
                return diff;
                }
                    
            }
            diff=true;
            System.out.println();
            System.out.println("      For individual: " + indArr[i].name);
            System.out.println("      " + indArr[i].FAMC + " Family doesn't exist");
        }
        return diff;
    }
    private static boolean DiffinRecordsforSpouse(IndividualStruct.individual indArr[], Integer i, FamilyStruct.family famArr[]){
        boolean diff=false;
        if(indArr[i].FAMS!=null){
            if(indArr[i].Spouse!=null){
                if(famArr[indArr[i].Spouse].getID()!=null){
                    System.out.println(indArr[i].name + "Checking Gender");
                    if(indArr[i].gender.equals("M")){
                         if((indArr[i].ID).equals(indArr[famArr[indArr[i].Spouse].husband].ID)){
                             return diff;
                         }
                    }
                    else if(indArr[i].gender.equals("F")){
                        System.out.println("Is female");
                        if(famArr[indArr[i].Spouse].getWife()!=null){
                            System.out.println("Check ID");
                            if((indArr[i].ID).equals(indArr[famArr[indArr[i].Spouse].wife].ID)){
                                return diff;
                            }
                            System.out.println("for indi " + indArr[i].name + " " + famArr[indArr[i].Spouse].getWife());
                        } 
                    }
                        diff=true;
                        System.out.println();
                        System.out.println("      Spouse of individual " + indArr[i].getName() + " doesn't have a matching family record");
                        System.out.println("      In indvidual record, Spouse to family: " + indArr[i].FAMS);
                            System.out.println("      In Family record, spouse doesn't exist");

                return diff;
                }
                    
            }
            diff=true;
            System.out.println();
            System.out.println("      For individual: " + indArr[i].name);
            System.out.println("      " + indArr[i].FAMS + " Family doesn't exist");
        }
        
        return diff;
    }
}
