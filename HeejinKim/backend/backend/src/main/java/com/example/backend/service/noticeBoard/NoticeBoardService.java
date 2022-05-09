package com.example.backend.service.noticeBoard;

import com.example.backend.entity.NoticeBoard;

import java.util.List;

public interface NoticeBoardService {

    public void register(NoticeBoard noticeBoard);
    public List<NoticeBoard> list();
    public NoticeBoard read(Long boardNo);
    public void modify(NoticeBoard noticeBoard);
    public void remove(Long boardNo);
    public void updateViewCount(Long boardNo);
}
