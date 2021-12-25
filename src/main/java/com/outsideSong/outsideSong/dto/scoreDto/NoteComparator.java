package com.outsideSong.outsideSong.dto.scoreDto;


import java.util.Comparator;

public class NoteComparator implements Comparator<NoteDto> {
    @Override
    public int compare(NoteDto first, NoteDto second) {
        if(first.getIndex() > first.getIndex())
            return 1;
        else if (first.getIndex() < first.getIndex())
            return -1;
        else
            return 0;
    }

}
