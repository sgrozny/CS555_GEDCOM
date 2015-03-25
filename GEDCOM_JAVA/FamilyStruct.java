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
        Integer husband;
        Integer wife;
        String MarriedDate;
        String DivDate;
        String WhichDate;
        Integer children[] = new Integer[30];
        int numChildren;
        boolean visited;
        public family(){
            numChildren=0;
        }
        public void setKids(){
           for(int i=0;i<30;i++){
               children[i]=-1;
           }
        }
        private void setNumChildren(){
            int i=0;
            numChildren=0;
            while(children[i]!=null){
                numChildren++;
                i++;
            }
        }
        public int getNumChildren(){
            setNumChildren();
            return numChildren;
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
         public Integer getWife(){
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
            if(children[index]!=null){
            return children[index];
            }
            else return -1;
                    
        }
    } 
}
