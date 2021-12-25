package com.outsideSong.outsideSong.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum FixNote {
    note1("G4", "16n", "#CE3A4A"),
    note2("A4", "16n", "#F2D230"),
    note3("B4", "16n", "#85A638"),
    note4("C4", "16n", "#468263"),
    note5("D4", "16n", "#5B89A6"),
    note6("E4", "16n", "#A68160"),
    note7("F4", "16n", "#C0C0B0"),
    note8("G4", "16n", "#F2E2CE");


    private String pitch;
    private String beat;
    private String color;

    public static FixNote getNote(int index){
        if(index >= 0 || index < 8)
            return note1;
        else if(index >= 8 || index < 16)
            return note2;
        else if(index >= 16 || index < 24)
            return note3;
        else if(index >= 24 || index < 32)
            return note4;
        else if(index >= 32 || index < 40)
            return note5;
        else if(index >= 40 || index < 48)
            return note6;
        else if(index >= 48 || index < 56)
            return note7;
        else if(index >= 56 || index < 64)
            return note8;
        else
            return null;
    }

}
