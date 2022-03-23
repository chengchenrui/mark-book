package com.cheng.plugin.markbook.processor;

import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.Writer;

public abstract class AbstractFreeMarkProcess implements Processor {

    protected abstract Template getTemplate();

    protected abstract Object getModel(SourceNoteData sourceNoteData);

    protected abstract Writer getWriter(SourceNoteData sourceNoteData);

    @Override
    public void process(SourceNoteData sourceNoteData) {
        Template template = getTemplate();
        Object model = getModel(sourceNoteData);
        Writer writer = getWriter(sourceNoteData);
        try {
            template.process(model, writer);
        } catch (TemplateException | IOException e) {
            e.printStackTrace();
        }
    }
}
