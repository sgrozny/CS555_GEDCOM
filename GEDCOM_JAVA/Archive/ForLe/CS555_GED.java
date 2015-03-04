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
    
    static int iCounter=-1, fCounter=-1, cCounter =0;
    static String TAGS[] = new String [16];
    static IndvidualStruct.individual indArr[] = new IndvidualStruct.individual[5000];
    static FamilyStruct.family famArr[] = new FamilyStruct.family[1000];
    
    public static void main(String[] args) {
        //Reads the lines of a ged file
        //Precondition: The GED file is in the specified location with the proper name
        //Postcondition: The oustput will print all original GED Lines with the addition of the level number and tag
        
        String  Ged_Filename = "C:/Users/Class2016/Documents/GitHub/CS555_GEDCOM/GEDCOM_JAVA/TEST.ged";
        Read_GED_File(Ged_Filename);
        
        Testing.Test_Sprint1(indArr, famArr,iCounter,fCounter, cCounter);
        //Printing.printIT(indArr, famArr,iCounter,fCounter);
        
        //StasSprint1.MoreThan15Kids(famArr,fCounter);
        //ClassName.Methodname(parameters);
    }
    private static void Read_GED_File(String fileName){
                 initTagArray(); //Loads in valid tags      
        try {
                //Read file
		File file = new File(fileName);
		FileReader fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		StringBuffer stringBuffer = new StringBuffer();
		String line;
                //While there are lines then call the print method.
                
		while ((line = bufferedReader.readLine()) != null) {
                        Parse_GED_File(line);
		}
                
		fileReader.close(); //close file reader
		} 
        //catches any errors
                catch (IOException e) {
			e.printStackTrace();
		}
    }
    private static void Parse_GED_File(String inputline){
        /*Private Method that will print 3 lines 
        * Precondition: Given a line from a Gedcom file
        * Postcondition: Print the orignal line, print level-number, tag
        */
        //System.out.println(inputline);//Print original line
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
                indArr[iCounter]= new IndvidualStruct.individual();
            }
            else if(lvl.equals("0")&& tag.equals("FAM")){
                fCounter++;
                famArr[fCounter]=new FamilyStruct.family();
                famArr[fCounter].setKids();
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
                   id=findFamID(arguement);
                   if (id>=0){
                       indArr[iCounter].setSpouse(id);
                   }
                    break;
                case "FAMC":
                   id=findFamID(arguement);
                   if (id>=0){
                       indArr[iCounter].setChild(id);
                   }
                    break;
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
                     id= findIndiID(arguement);
                    if(id>=0){
                        famArr[fCounter].setHusb(id);
                    }
                 break;
                case "WIFE":
                    id= findIndiID(arguement);
                    if(id>=0){
                        famArr[fCounter].setWife(id);
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
                    if(id>=0){
                        famArr[fCounter].addChild(id, cCounter);
                        cCounter++;
                    }
                    break;
                case "TRLR":
                    //Shuold we cut down array here?
                default:
                    break;
            }
        }
    }
    private static String formatName(String name){
        //Removes the "/" from the lastnames
        return name.replace("/", "");
    }
    private static int findIndiID(String indiID){
        int found=-1;
        for(int i=0;i<iCounter+1;i++){
             if(indArr[i].getID().equals(indiID)){
                return i;
            }

        }
        return found;
    }
    private static int findFamID(String fID){
        int found=-1;
        for(int i=0;i<fCounter+1;i++){
             if(famArr[i].getID().equals(fID)){
                return i;
            }

        }
        return found;
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
