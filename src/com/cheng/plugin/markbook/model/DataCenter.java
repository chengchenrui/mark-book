package com.cheng.plugin.markbook.model;

import java.util.LinkedList;
import java.util.List;

public class DataCenter {
    /**
     * 选择的文本
     */
    public static String     SELECTED_TEXT     = null;
    /**
     * 当前的文件名称
     */
    public static String     CURRENT_FILE_NAME = null;
    /**
     * 当前的文件类型
     */
    public static String     CURRENT_FILE_TYPE = null;
    /**
     * 笔记列表集合
     */
    public static List<Node> NOTE_LIST         = new LinkedList<>();
}
