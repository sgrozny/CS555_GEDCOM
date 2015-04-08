/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cs555_ged;

/**
 *
 * @author sgrozny
 */
public class StasSprint3 {
    public static int indRecordsMatchFam(IndividualStruct.individual indArr[], Integer iTotal, FamilyStruct.family famArr[], int fTotal){
        int numerrors=0;
        int x,y;
        Printing.printHeader("Checking if all indvidual records match family records:");
            for(int i=0;i<iTotal+1;i++){
                y=DiffinRecordsforChild(indArr,i,famArr);
                if (y!=0){
                    numerrors++;
                    Printing.print(1,"Error #" + numerrors + " found on individual " + indArr[i].getID());
                    switch (y){
                        case 1:
                            Printing.print(2,"None of the children id's match the id of the individual\n");
                            break;
                        case 2:
                            Printing.print(2,"There are no children listed in the family\n");
                            break;
                        case 3:
                            Printing.print(2,"Family Doesn't exist\n");
                            break;
                        default:
                            break;
                    }
                    Printing.PrintIndividualDetails(indArr, i, 2);
                    if(y!=3){
                        Printing.PrintFamilyDetails(famArr, indArr[i].Spouse, 2, indArr,true,false); 
                    }
                    else{
                        Printing.ListAllFamilies(famArr, fTotal, 2);
                    }
                     System.out.println("---------------------------------------------------------------");
                }
                x= DiffinRecordsforSpouse(indArr,i,famArr);
                if (x!=0){
                    numerrors++;
                    Printing.print(1,"Error #" + numerrors + " found on individual " + indArr[i].getID());
                    switch (x){
                        case 1:
                            Printing.print(2,"Family's " + famArr[indArr[i].Spouse].ID + " record of the husband doesn't match the current indvidual\n" );
                            break; 
                        case 2:
                           
                            Printing.print(2,"Family " + famArr[indArr[i].Spouse].ID + " doesn't conatin a record of a husband that matches current individual\n");
                            break; 
                        case 3:
                            Printing.print(2,"Family's " + famArr[indArr[i].Spouse].ID + " record of the wife doesn't match the current indvidual\n" );
                            break; 
                        case 4:
                           // Printing.PrintFamilyDetails(famArr, i, 1);
                            Printing.print(2,"Family " + famArr[indArr[i].Spouse].ID + " doesn't conatin a record of a wife that matches current individual\n");
                            break; 
                        case 5:
                             Printing.print(2,"There is no family record that matches this spouse");
                            break; 
                        default: 
                            break;
                    }
                    Printing.PrintIndividualDetails(indArr, i, 2);
//                    if (x==2 || x==4 ){
//                         Printing.PrintFamilyDetails(famArr, indArr[i].Spouse, 2);
//                    }
                    if(x!=5){
                        Printing.PrintFamilyDetails(famArr, indArr[i].Spouse, 2, indArr,false,false);    
                    }
                    else{
                        Printing.ListAllFamilies(famArr, fTotal, 2);
                    }
                     System.out.println("---------------------------------------------------------------");
                }

            }
        return numerrors;
    }
    private static int DiffinRecordsforChild(IndividualStruct.individual indArr[], Integer i, FamilyStruct.family famArr[]){
        int diff=0;
        
        if(indArr[i].FAMC!=null){
            boolean kids=false;
            if(indArr[i].getChild()!=null){
                if(famArr[indArr[i].getChild()]!=null){
                     for(int j=0;j<famArr[indArr[i].getChild()].numChildren;j++){
                         kids=true;
                         if((indArr[i].ID).equals(indArr[famArr[indArr[i].getChild()].getChild(j)].ID)){
                             return diff;
                         }
                      }
                    if(kids){
                        diff=1;
                      }
                    else{
                        diff=2;
                    }
                }                    
            }
            else{
                diff=3;
            }
        }
        return diff;
    }
    private static int DiffinRecordsforSpouse(IndividualStruct.individual indArr[], Integer i, FamilyStruct.family famArr[]){
        int diff=0;
        if(indArr[i].FAMS!=null){
            //Printing.print(2, "Is a spouse");
            if(indArr[i].Spouse!=null){
                if(indArr[i].gender.equals("M")){
                      //Printing.print(2, "Is male");
                       if(famArr[indArr[i].Spouse].husband!=null){
                           //Printing.print(2, "Family's record of the husband isn't null");
                           if(indArr[famArr[indArr[i].Spouse].husband]!= null){
                              //Printing.print(2, "Family's husband points to a real individual");
                               if((indArr[i].ID).equals(indArr[famArr[indArr[i].Spouse].husband].ID)){
                                   return diff;
                               }
                           else{
                               diff=1;
                               //Printing.print(2,"Family's " + famArr[indArr[i].Spouse].ID + " record of the husband doesn't match the current indvidual" );
                                   }
                              }
                       }
                       else{
                           diff=2;
                           //Printing.print(2,"Family " + famArr[indArr[i].Spouse].ID + " doesn't conatin a record of a husband that matches current Individua;");
                       }

                   }
                   else if(indArr[i].gender.equals("F")){
                   //   Printing.print(2, "Is female");
                       if(famArr[indArr[i].Spouse].wife!=null){
                         //  Printing.print(2, "Family's record of the wife isn't null");
                           if(indArr[famArr[indArr[i].Spouse].wife]!= null){
                          //    Printing.print(2, "Family's wife points to a real individual");
                               if((indArr[i].ID).equals(indArr[famArr[indArr[i].Spouse].wife].ID)){
                                   return diff;
                               }
                           else{
                               diff=3;
                               //Printing.print(2,"Family's " + famArr[indArr[i].Spouse].ID + " record of the wife doesn't match the current indvidual" );
                                }
                          }
                       }
                       else{
                           diff=4;
                           //Printing.print(2,"Family " + famArr[indArr[i].Spouse].ID + " doesn't conatin a record of a wife that matches current Individua;");
                       }
                   }
               }
                else 
                {
                    diff=5;
                   // Printing.print(2,"There is no family record that matches this spouse");
                }
        }        
        return diff;
    }
    public static int famRecordsMatchInd(IndividualStruct.individual indArr[], int iTotal,FamilyStruct.family famArr[],int fTotal){
        int numerrors=0;
        int x,y;
        Printing.printHeader("Checking if all family records match indvidual records:");
        for(int i=0; i<fTotal+1;i++){
            int numkids=famArr[i].numcIds;
            if(numkids>0){
                for(int j=0;j<numkids;j++){
                    y=DiffinRecordsforChildFI(famArr[i],j,indArr);
                    if (y!=0){
                        numerrors++;
                        Printing.print(1,"Error #" + numerrors + " Found on family " + famArr[i].getID() + " on child " + famArr[i].childIds[j]);
                        switch (y){
                            case 1:
                                Printing.print(2,"The child points to an indvidual whose records don't match\n");
                                Printing.print(2,"Should be child of " + famArr[i].getID() + " but listed as child of " + indArr[famArr[i].getChild(j)].FAMC +"\n");
                                break;
                            case 2:
                                Printing.print(2,"The child points to an individual without a child tag\n");
                                Printing.print(2,"Should be child of " + famArr[i].getID() + " but child tag is Null\n");
                                break;
                            case 3:
                                Printing.print(2,"Indvidual doesn't exist\n");
                                break;
                            default:
                                break;
                        }
                        
                        if(y!=3){
                            Printing.PrintFamilyDetails(famArr, i, 2, indArr,true,false);
                             Printing.PrintIndividualDetails(indArr, famArr[i].getChild(j), 2);
                        }
                        else{
                            Printing.PrintFamilyDetails(famArr, i, 2, indArr,true,true);
                            Printing.ListAllIndividuals(indArr, iTotal, 2);
                           
                        }
                         System.out.println("---------------------------------------------------------------");
                    }
                }
            }
                
                x= DiffinWife(famArr,i,indArr);
                if (x!=0){
                    numerrors++;
                    Printing.print(1,"Error #" + numerrors + " found on family " + famArr[i].getID());
                    switch (x){
                        case 1:
                            Printing.print(2,"Family's " + famArr[i].getID() + " wife doesn't match individual's records\n" );
                            break; 
                        case 2:                           
                            Printing.print(2,"Family " + famArr[i].getID() + " points to a wife that doesn't exist\n");
                            break; 
                        case 3:
                            Printing.print(2, "The wife in family " + famArr[i].getID() + " points to an individual that isn't female");
                        default: 
                            break;
                    }
                    Printing.PrintFamilyDetails(famArr, i, 2, indArr,false,false);
                    if(x!=2){
                        Printing.PrintIndividualDetails(indArr, famArr[i].getWife(), 2);    
                    }
                    else{
                        Printing.ListAllIndividuals(indArr, iTotal, 2);
                    }
                     System.out.println("---------------------------------------------------------------");
                }
                x= DiffinHusb(famArr,i,indArr);
                if (x!=0){
                    numerrors++;
                    Printing.print(1,"Error #" + numerrors + " found on family " + famArr[i].getID());
                    
                    switch (x){
                        case 1:
                            Printing.print(2,"Family's " + famArr[i].getID() + " husband doesn't match individual's records\n" );
                            break; 
                        case 2:                           
                            Printing.print(2,"Family " + famArr[i].getID() + " points to a husband that doesn't exist\n");
                            break; 
                        case 3:
                            Printing.print(2, "The hisband in family " + famArr[i].getID() + " points to an individual that isn't male");
                        case 4:
                            Printing.print(2, "The husband in family " + famArr[i].getID()+ " points to an individual with a different ID");
                        default: 
                            break;
                    }
                    Printing.PrintFamilyDetails(famArr, i, 2, indArr,false,false);
                    if(x!=2){
                        Printing.PrintIndividualDetails(indArr, famArr[i].getHusb(), 2);    
                    }
                    else{
                        Printing.ListAllIndividuals(indArr, iTotal, 2);
                    }
                     System.out.println("---------------------------------------------------------------");
                }

            }
        return numerrors;
    }
        private static int DiffinRecordsforChildFI(FamilyStruct.family famArr,int i,IndividualStruct.individual indArr[]){
        int diff=0;
        if(famArr.getChild(i)!=-1){
            if(indArr[famArr.getChild(i)]!=null){
                if(indArr[famArr.getChild(i)].FAMC!=null){
                    if((indArr[famArr.getChild(i)].FAMC).equals(famArr.ID)){
                    }
                    else{
                        diff=1;
                    }
                }
                else{
                    diff=2;
                }
            }
        }
        else{
            diff=3;
        }
        return diff;       
    }
    
    private static int DiffinWife(FamilyStruct.family famArr[],int i,IndividualStruct.individual indArr[]){
        int diff=0;
        if (famArr[i].wifeS!=null){
            if(famArr[i].wife!=null){
               if(indArr[famArr[i].wife].ID!=null){
                   if((indArr[famArr[i].wife].ID).equals(famArr[i].wifeS)){
                       if ((indArr[famArr[i].wife].gender).equals("F")){
                           if ((indArr[famArr[i].wife].FAMS).equals(famArr[i].ID)){
                              return diff; 
                           }
                           else{
                            diff=1;
                            }
                       }
                       else{
                           diff=3;
                       }
                   }
                   else{
                       diff=4;
                   }
               } 
            }
            else{
                diff=2;
            }
        }
        return diff;
    }
 
private static int DiffinHusb(FamilyStruct.family famArr[],int i,IndividualStruct.individual indArr[]){
            int diff=0;
        if (famArr[i].husbS!=null){
            if(famArr[i].husbS!=null){
               if(indArr[famArr[i].husband].ID!=null){
                   if((indArr[famArr[i].husband].ID).equals(famArr[i].husbS)){
                       if ((indArr[famArr[i].husband].gender).equals("M")){
                           if ((indArr[famArr[i].husband].FAMS).equals(famArr[i].ID)){
                              return diff; 
                           }
                           else{
                            diff=1;
                            }
                       }
                       else{
                           diff=3;
                       }
                   }
                   else{
                       diff=4;
                   }
               } 
            }
            else{
                diff=2;
            }
        }
        return diff;
    }
}