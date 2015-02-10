/* 
 * File:   GEDCOM_Header.h
 * Author: sgrozny
 *
 * Created on February 10, 2015, 2:22 PM
 */

#ifndef GEDCOM_HEADER_H
#define	GEDCOM_HEADER_H

#include <iostream>
#include <cstring>
using namespace std;

struct individual{
    char* ID;
    char* Name;
    char gender;
    char* famID;
    //family famID;
    char* birthdate;
    char* deathdate;
};
struct family{
    char* famID;
} ;

     void Read_Ged_File();
     void Parse_Ged_Line(const char*);
     char* subchars(const char* str, short x, short y);

#endif	/* GEDCOM_HEADER_H */

