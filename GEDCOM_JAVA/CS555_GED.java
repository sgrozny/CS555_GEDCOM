/*
 * "I pledge my honor that I have abided by the Stevens Honor System"
 * Stas Grozny
 */
package cs555_ged;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CS555_GED {
    
    static int iCounter=-1, fCounter=-1, cCounter=0, cCounter2=0;
    static String TAGS[] = new String [16];
    static IndividualStruct.individual indArr[] = new IndividualStruct.individual[5000];
    static FamilyStruct.family famArr[] = new FamilyStruct.family[1000];
    static boolean hsbflg=false,wfflag=false,prntfmdt=false;
    public static void main(String[] args) {
        int initErrors=0;
        //Reads the lines of a ged file
        //Precondition: The GED file is in the specified location with the proper name
        //Postcondition: The oustput will print all original GED Lines with the addition of the level number and tag
        
        //String  Ged_Filename = "C:/Users/Class2016/Documents/GitHub/CS555_GEDCOM/GEDCOM_JAVA/TEST.ged";
        
        String  Ged_Filename ="C:/Users/Class2016/Documents/NetBeansProjects/CS555/src/cs555_ged/Sprint4Test.ged";
        initErrors=Read_GED_File(Ged_Filename);
        
        Testing.Test_Sprint1(indArr, famArr,iCounter,fCounter,initErrors);
        
        
        //StasSprint1.MoreThan15Kids(famArr,fCounter);
       
    }
    private static int Read_GED_File(String fileName){
                 initTagArray(); //Loads in valid tags   
                  int numErrors=0;
        try {
                //Read file
		File file = new File(fileName);
		FileReader fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		StringBuffer stringBuffer = new StringBuffer();
		String line;
                //While there are lines then call the print method.
                
        Printing.printHeader("Parsing .GED File and looking for intial errors...");
		while ((line = bufferedReader.readLine()) != null) {
                    
                        if(Parse_GED_File(line,numErrors)){
                            numErrors++;
                             
                        }
		}
                
		fileReader.close(); //close file reader
		} 
        //catches any errors
                catch (IOException e) {
			e.printStackTrace();
		}
      findFamID();
      setNumChildren();
      return numErrors;
    }
    private static boolean Parse_GED_File(String inputline, int errorCount){
        
        /*Private Method that will print 3 lines 
        * Precondition: Given a line from a Gedcom file
        * Postcondition: Print the orignal line, print level-number, tag
        */
        //System.out.println(inputline);//Print original line
        errorCount++;
        boolean iserror=false;
        if (!(inputline.equals(""))){
           
        int index;  //index of first " "
        int i;// used in for loop
        String lvl;
        String tag;//finds tag
        String  dateT; //
        String arguement=""; //holds the arguement of the tag
        boolean valid=false;    // checks if tag is valid (default is false)
       
        index= inputline.indexOf(" ");  // find index of first space
        lvl=inputline.substring(0,index);   //print the level number
        int index2; // index of second " "
        index2= inputline.indexOf(" ", index+1); 
        if (index2==-1) {//if there is no second space just a tag followed by nothing
            tag=inputline.substring(index+1);//then the end of tag is last character
            arguement= "GET DATE";
        }
        else{//else the tag is between the 2 spaces
           tag=inputline.substring(index+1,index2);
           arguement= inputline.substring(index2+1);
        } 
        //Compare obtained tag to list of predefined tags
        for (i=0;i<16;i++){      
            if (tag.equals(TAGS[i])){
                valid=true; //if its found then its a valid tag and no need to keep looking
                break;
            }
        }
        if (valid) {//if tag is valid 
            int id;
            if(lvl.equals("0")&& tag.equals("INDI")){
                iCounter=iCounter+1;
                indArr[iCounter]= new IndividualStruct.individual();
            }
            else if(lvl.equals("0")&& tag.equals("FAM")){
                if (prntfmdt){
                     
                    Printing.PrintFamilyDetails(famArr,fCounter,1,indArr,true,false); 
                    Printing.print(0,"----------------------------------");
                }
                cCounter=0;
                cCounter2=0;
                fCounter++;
                famArr[fCounter]=new FamilyStruct.family();
                hsbflg= false;
                wfflag=false;
                prntfmdt=false;
             //   famArr[fCounter].setKids();
            }
            switch (tag){
                case "INDI":
                    indArr[iCounter].setID(arguement);
                break;
                case "NAME":
                    indArr[iCounter].setName(formatName(arguement));
                    break;
                case "SEX":
                    indArr[iCounter].setGender(arguement);  
                    break;
                case "FAMS":
                    indArr[iCounter].FAMS = arguement;
//                   id=findFamID(arguement);
//                   if (id>=0){
//                       indArr[iCounter].setSpouse(id);
//                   }
                    break;
                case "FAMC":
                   indArr[iCounter].FAMC = arguement;
//                   id=findFamID(arguement);
//                   if (id>=0){
//                       indArr[iCounter].setChild(id);
//                   }
//                    break;
                case "BIRT":
                    indArr[iCounter].setDate(tag);
                    break;
                case "DEAT":
                    indArr[iCounter].setDate(tag);
                    break;  
                case "DATE":
                        if(indArr[iCounter].getDate().equals("BIRT")){
                            indArr[iCounter].setBDay(arguement);
                            indArr[iCounter].setDate("");
                        }
                        else if(indArr[iCounter].getDate().equals("DEAT")){
                            indArr[iCounter].setDDay(arguement);
                            indArr[iCounter].setDate("");
                        }
                        else if(famArr[fCounter].getDate().equals("DIV")){
                            famArr[fCounter].setDivDate(arguement);
                            famArr[fCounter].setDate("");
                        }
                         else if(famArr[fCounter].getDate().equals("MARR")){
                            famArr[fCounter].setMarriedDate(arguement);
                            famArr[fCounter].setDate("");
                        }
                    break;
                case "FAM":
                    famArr[fCounter].setID(arguement);
                    
                    break;
                case "HUSB":
                    if (hsbflg){
                        iserror=true; 
                       Printing.print(1, "Error #"+errorCount +":Trying to add a second husband to family " + famArr[fCounter].ID + " caused an error. Keeping original husband");
                       Printing.print(2, "Original husband's ID = " +famArr[fCounter].husbS + ". The new husband's ID =" + arguement);
                       prntfmdt=true;
                                      
                    }
                    else{
                        hsbflg=true; 
                        id= findIndiID(arguement);
                        if(id>=0){
                            famArr[fCounter].setHusb(id);
                        }
                        famArr[fCounter].husbS=arguement;

                    }
                     
                 break;
                case "WIFE":
                    if (wfflag){
                        iserror=true;  
                       Printing.print(1, "Error #"+errorCount +":Trying to add a second wife to family " + famArr[fCounter].ID + " caused an error. Keeping original wife");
                       Printing.print(2, "Original wife's ID = " +famArr[fCounter].wifeS + ". The new wife's ID =" + arguement);
                       prntfmdt=true;
                                      
                    }
                    else{
                        wfflag=true; 
                        id= findIndiID(arguement);
                        if(id>=0){
                            famArr[fCounter].setWife(id);
                        }
                        famArr[fCounter].wifeS=arguement;
                        }
                 break;
                case "DIV":
                    famArr[fCounter].setDate(tag);
                    break;
                case "MARR":
                    famArr[fCounter].setDate(tag);
                    break;
                case "CHIL":
                    id= findIndiID(arguement);
                    if(id>-1){
                        famArr[fCounter].addChild(id, cCounter);
                        cCounter++;
                    }
                    famArr[fCounter].addChildId(arguement,cCounter2);
                    cCounter2++;
                    break;
                case "TRLR":
                    if (prntfmdt){
                        
                    Printing.PrintFamilyDetails(famArr,fCounter,1,indArr,true,false);
                    Printing.print(0,"----------------------------------");
                     
                }
                    return iserror;
                default:
                    break;
            }
            }
        }
        return iserror;
    }
    private static String formatName(String name){
        //Removes the "/" from the lastnames
        return name.replace("/", "");
    }
    private static int findIndiID(String indiID){
        for(int i=0;i<iCounter+1;i++){
             if(indArr[i].getID().equals(indiID)){
                return i;
            }
        }
        return -1;
    }
        
    private static void findFamID(){
    
        for(int j=0;j<iCounter+1;j++){
            for(int i=0;i<fCounter+1;i++){
             if(famArr[i].getID().equals(indArr[j].FAMC)){
                 indArr[j].Child=i;
             }
             else if(famArr[i].getID().equals(indArr[j].FAMS)){
                 indArr[j].Spouse=i;
             }
            }
        }
    }
    private static void setNumChildren(){
        for(int i=0;i<fCounter+1;i++){
            famArr[i].getNumChildren();
        }
    }
     public static void initTagArray(){
         //intializes the array of tags
         //Preconditions: None
         //Postconditions; The TAGS array is populated with all the valid tags
         TAGS[0]="NOTE";
         TAGS[1]="INDI";
         TAGS[2]="NAME";
         TAGS[3]="SEX";
         TAGS[4]="BIRT";
         TAGS[5]="DEAT";
         TAGS[6]="FAMC";
         TAGS[7]="FAMS";
         TAGS[8]="FAM";
         TAGS[9]="MARR";
         TAGS[10]="HUSB";
         TAGS[11]="WIFE";
         TAGS[12]="CHIL";
         TAGS[13]="DIV";
         TAGS[14]="DATE";
         TAGS[15]="TRLR";
                 
     }       

}
