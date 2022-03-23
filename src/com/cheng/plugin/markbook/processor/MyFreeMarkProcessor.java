package com.cheng.plugin.markbook.processor;

import com.intellij.ide.fileTemplates.impl.UrlUtil;
import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MyFreeMarkProcessor extends AbstractFreeMarkProcess {
    @Override
    protected Template getTemplate() {
        Template template = null;
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_28);
        try {
            // 加载模板字符串
            String templateContent = UrlUtil.loadText(Objects.requireNonNull(MyFreeMarkProcessor.class.getResource("/template/md.ftl")));
            // 创建模板字符串的导入器
            StringTemplateLoader stringTemplateLoader = new StringTemplateLoader();
            // 导入字符串模板
            stringTemplateLoader.putTemplate("template", templateContent);
            configuration.setTemplateLoader(stringTemplateLoader);
            // 获取模板
            template = configuration.getTemplate("template");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return template;
    }

    @Override
    protected Object getModel(SourceNoteData sourceNoteData) {
        Map<String, Object> model = new HashMap<>();
        model.put("topic", sourceNoteData.getTopic());
        model.put("noteList", sourceNoteData.getNoteList());
        return model;
    }

    @Override
    protected Writer getWriter(SourceNoteData sourceNoteData) {
        String fileName = sourceNoteData.getFileName();
        File file = new File(fileName);
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return bufferedWriter;
    }
}
