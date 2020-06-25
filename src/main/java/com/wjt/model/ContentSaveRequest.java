package com.wjt.model;

import java.util.List;

/**
 * @Time 2020/4/6/20:15
 * @Author jintao.wang
 * @Description
 */

public class ContentSaveRequest {
    public List<String> contentList;

    public ContentSaveRequest(List<String> contentList) {
        this.contentList = contentList;
    }

    @Override
    public String toString() {
        return "ContentSaveRequest{" +
                "contentList=" + contentList +
                '}';
    }
}
