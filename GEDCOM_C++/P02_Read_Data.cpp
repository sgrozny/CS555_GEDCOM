#include <cstdlib>
#include <string>
#include <iostream>
#include <fstream>
#include <stdio.h>
#include <string.h>
#include "GEDCOM_Header.h"
#include<vector>
using namespace std;

    struct individual* indArr = new individual[5000];
    struct family* famArr = new family[1000];
int i=0,k=0;
vector<string> split(const char *str, char c = ' ')
{
	vector<string> result;

	do
	{
		const char *begin = str;

		while (*str != c && *str)
			str++;

		result.push_back(string(begin, str));
	} while (0 != *str++);

	return result;
}
void Read_Ged_File(){

   ifstream myfile;
   string line;
    myfile.open("C:/Users/Class2016/Documents/NetBeansProjects/CS555_GED/src/cs555_ged/TEST.ged");

        while(getline(myfile,line)){
            
        
        //vector<string> result = split(line.c_str());
       // cout << result[1] << endl;
const char * c = line.c_str();
           Parse_Ged_Line(c);
        }
    myfile.close();
    for (int j=1;j<14;j++){
       cout<<indArr[j].ID<<endl;
       cout<< indArr[j].Name <<endl;
    }
    for (int j=1; j<20;j++){
        if(famArr[j]NULL){
        cout<<"husband"<<endl;
        cout<<famArr[j].husb.Name<<endl;
        }
        else{
            cout<<"NULL"<<endl;
        }
    }
    
}
void Parse_Ged_Line(const char* input){
    
    char lvl_Number= input[0];
    char* tag =subchars(input,2,4);
    char* tag2 = subchars(input,2,3);
    char* arguement = subchars(input,7,100);
    if(lvl_Number=='0' && strcmp(tag,"INDI")==0){
         i++;
    }
    if (lvl_Number=='0' && strcmp(tag2, "FAM")==0){
        k++;
        cout<<"increased"<<endl;
    }
    if (strcmp(tag,"INDI")==0){   
        indArr[i].ID=arguement;
    }
            
    if (strcmp(tag,"NAME")==0){
        indArr[i].Name=arguement;        
    }
    if (strcmp(tag, "HUSB")==0){
//        cout<< indArr[1].ID<<endl;
//        cout<< arguement<<endl;
//        cout<<strcmp(indArr[1].ID,arguement)<<endl;
        for(int j=1;j<15;j++){
            if(strcmp(indArr[j].ID,arguement)==0){
                famArr[k].husb=indArr[j];
                cout<<"added"<<endl;
                cout<<famArr[k].husb.Name<<endl;
            }
        }
    }   
    
}
 
char* subchars(const char* str, short x, short y){
    char* ret = new char[y+1];
    for(short i=x; i<x+y; i++)
        ret[i-x]=str[i];
    ret[y] = '\0';
    return ret;
}
