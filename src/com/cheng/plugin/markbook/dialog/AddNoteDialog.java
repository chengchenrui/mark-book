package com.cheng.plugin.markbook.dialog;

import com.cheng.plugin.markbook.data.DataCenter;
import com.cheng.plugin.markbook.data.DataConvert;
import com.cheng.plugin.markbook.data.Note;
import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.openapi.ui.MessageDialogBuilder;
import com.intellij.ui.EditorTextField;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;

public class AddNoteDialog extends DialogWrapper {

    private EditorTextField editorTextFieldTitle;

    private EditorTextField editorTextFieldMark;

    public AddNoteDialog() {
        super(true);
        init();
        setTitle("添加笔记注释");
    }

    @Override
    protected @Nullable
    JComponent createCenterPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        editorTextFieldTitle = new EditorTextField("笔记标题");
        editorTextFieldMark = new EditorTextField("笔记内容");
        editorTextFieldMark.setPreferredSize(new Dimension(200, 100));
        panel.add(editorTextFieldTitle, BorderLayout.NORTH);
        panel.add(editorTextFieldMark, BorderLayout.CENTER);
        return panel;
    }

    @Override
    protected JComponent createSouthPanel() {
        JPanel panel = new JPanel(new FlowLayout());
        JButton addButton = new JButton("添加笔记列表");
        // 按钮点击事件
        addButton.addActionListener(e -> {
            // 获取标题
            String title = editorTextFieldTitle.getText();
            // 获取内容
            String mark = editorTextFieldMark.getText();
            String fileType = DataCenter.CURRENT_FILE_TYPE;
            Note note = new Note();
            note.setTitle(title);
            note.setMark(mark);
            note.setContent(DataCenter.SELECTED_TEXT);
            note.setFileName(DataCenter.CURRENT_FILE_NAME);
            note.setFileType(fileType);
            DataCenter.NOTE_LIST.add(note);
            DataCenter.TABLE_MODEL.addRow(DataConvert.convert(note));
            MessageDialogBuilder.yesNo("操作结果", "添加成功").show();
            AddNoteDialog.this.dispose();
        });
        panel.add(addButton);
        return panel;
    }

}
