package com.cheng.plugin.markbook.processor;

import com.cheng.plugin.markbook.data.Note;

import java.util.List;

public class DefaultSourceNoteData implements SourceNoteData {

    private String fileName;

    private String topic;

    private List<Note> noteList;

    public DefaultSourceNoteData(String fileName, String topic, List<Note> noteList) {
        this.fileName = fileName;
        this.topic = topic;
        this.noteList = noteList;
    }

    public String getFileName() {
        return fileName;
    }

    public String getTopic() {
        return topic;
    }

    public List<Note> getNoteList() {
        return noteList;
    }
}
