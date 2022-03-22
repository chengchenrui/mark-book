package com.cheng.plugin.markbook.dialog;

import java.awt.*;

import javax.swing.*;

import org.jetbrains.annotations.Nullable;

import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.ui.EditorTextField;

public class AddNoteDialog extends DialogWrapper {

    private EditorTextField editorTextFieldTitle;

    private EditorTextField editorTextFieldMark;

    public AddNoteDialog() {
        super(true);
        init();
        setTitle("添加笔记注释");
    }

    @Override
    protected @Nullable JComponent createCenterPanel() {
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
            String content = editorTextFieldMark.getText();
            System.out.println(title + " : " + content);
        });
        panel.add(addButton);
        return panel;
    }

}
