package com.cheng.plugin.markbook.data;

public class DataConvert {
    public static String[] convert(Note note) {
        String[] raw = new String[4];
        raw[0] = note.getTitle();
        raw[1] = note.getMark();
        raw[2] = note.getFileName();
        raw[3] = note.getContent();
        return raw;
    }
}
