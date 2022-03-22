package com.cheng.plugin.markbook.action;

import com.cheng.plugin.markbook.dialog.AddNoteDialog;
import com.cheng.plugin.markbook.model.DataCenter;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.SelectionModel;

public class EditorPopupAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        // TODO: insert action logic here
        // 获取当前编辑器对象
        Editor editor = e.getRequiredData(CommonDataKeys.EDITOR);
        // 获取选择的数据模型
        SelectionModel selectionModel = editor.getSelectionModel();
        // 获取当前选择的文本
        String selectedText = selectionModel.getSelectedText();
        DataCenter.SELECTED_TEXT = selectedText;
        // 文件名称
        String filename = e.getRequiredData(CommonDataKeys.PSI_FILE).getViewProvider().getVirtualFile().getName();
        DataCenter.CURRENT_FILE_NAME = filename;

        DataCenter.CURRENT_FILE_TYPE = filename.substring(filename.lastIndexOf(".") + 1);

        AddNoteDialog addNoteDialog = new AddNoteDialog();
        addNoteDialog.show();
    }
}
