package com.cheng.plugin.markbook.window;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import org.jetbrains.annotations.NotNull;

public class NoteListWindowFactory implements ToolWindowFactory {

    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
        // 创建出NoteListWindow 对象
        NoteListWindow noteListWindow = new NoteListWindow(project, toolWindow);
        // 获取内容工厂的实例
        ContentFactory contentFactory = ContentFactory.SERVICE.getInstance();
        //获取用户ToolWindow显示的内容
        Content content = contentFactory.createContent(noteListWindow.getJContent(), "", false);
        // 给ToolWindow设置内容
        toolWindow.getContentManager().addContent(content);
    }
}
