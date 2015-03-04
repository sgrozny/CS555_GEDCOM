/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cs555_ged;

/**
 *
 * @author sgrozny
 */
public class FamilyStruct {
    public static class family{
        String ID;
        int husband;
        int wife;
        String MarriedDate;
        String DivDate;
        String WhichDate;
        int children[] = new int[15];
        public family(){

        }
        public void setID(String pID){
            ID=pID;
        }
        public String getID(){
            return ID;
        }
        public void setHusb(int H){
            husband= H;
        }
         public int getHusb(){
            return husband;
        }
         public void setWife(int W){
            wife= W;
        }
         public int getWife(){
            return wife;
        }
         public void setDate(String DateType){
            WhichDate=DateType;
        }
        public String getDate(){
            return WhichDate;
        }
        public void setMarriedDate(String DateofMarriage){
            MarriedDate= DateofMarriage;
        }
        public String getMarriedDate(){
            return MarriedDate;
        }
        public void setDivDate(String DivorceDate){
            DivDate = DivorceDate;
        }
        public String getDivDate(){
            return DivDate ;
        }
        public void addChild(int c, int index){
            children[index]=c;
        }
        public int getChild(int index){
            return children[index];
        }
    } 
}
