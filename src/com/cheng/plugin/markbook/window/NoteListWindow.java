package com.cheng.plugin.markbook.window;

import com.cheng.plugin.markbook.data.DataCenter;
import com.cheng.plugin.markbook.processor.DefaultSourceNoteData;
import com.cheng.plugin.markbook.processor.MyFreeMarkProcessor;
import com.cheng.plugin.markbook.processor.Processor;
import com.intellij.notification.Notification;
import com.intellij.notification.NotificationDisplayType;
import com.intellij.notification.NotificationGroup;
import com.intellij.notification.Notifications;
import com.intellij.openapi.fileChooser.FileChooser;
import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.MessageDialogBuilder;
import com.intellij.openapi.ui.MessageType;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.wm.ToolWindow;
import org.apache.commons.lang3.StringUtils;

import javax.swing.*;

public class NoteListWindow {
    private JPanel     contentPanel;
    private JTextField tfTopic;
    private JTable     tableContent;
    private JButton    buttonCreate;
    private JButton    buttonClear;
    private JButton    buttonClose;

    public void init() {
        tableContent.setModel(DataCenter.TABLE_MODEL);
        tableContent.setEnabled(true);
    }

    public NoteListWindow(Project project, ToolWindow toolWindow) {
        init();
        buttonCreate.addActionListener(actionEvent -> {
            String topic = tfTopic.getText();
            if (StringUtils.isBlank(topic)) {
                MessageDialogBuilder.yesNo("操作结果", "文档标题没有输入").show();
                return;
            }
            VirtualFile virtualFile = FileChooser.chooseFile(FileChooserDescriptorFactory.createSingleFolderDescriptor(), project, project.getBaseDir());
            if (virtualFile != null) {
                String path = virtualFile.getPath();
                String filePath = path + "/" + topic + ".md";
                Processor processor = new MyFreeMarkProcessor();
                processor.process(new DefaultSourceNoteData(filePath, topic, DataCenter.NOTE_LIST));
                MessageDialogBuilder.yesNo("操作结果", "添加成功!").show();
                // NotificationGroup notificationGroup = NotificationGroupManager.getInstance().getNotificationGroup("addSuccess");
                NotificationGroup notificationGroup = new NotificationGroup("addSuccess", NotificationDisplayType.BALLOON, true);
                Notification notification = notificationGroup.createNotification("生成文档成功：" + filePath, MessageType.INFO);
                Notifications.Bus.notify(notification);
            }

        });

        buttonClear.addActionListener(actionEvent -> DataCenter.reset());
        buttonClose.addActionListener(actionEvent -> toolWindow.hide(null));
    }

    public JPanel getJContent() {
        return contentPanel;
    }
}
