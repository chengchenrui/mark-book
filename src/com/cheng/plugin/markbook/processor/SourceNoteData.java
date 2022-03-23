package com.cheng.plugin.markbook.processor;

import com.cheng.plugin.markbook.data.Note;

import java.util.List;

public interface SourceNoteData {

    String getFileName();

    String getTopic();

    List<Note> getNoteList();
}
