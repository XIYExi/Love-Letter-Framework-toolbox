package com.xion.wiki.service;

import com.xion.wiki.controller.req.DocQueryReq;
import com.xion.wiki.controller.req.DocSaveReq;
import com.xion.wiki.controller.resp.DocQueryResp;
import com.xion.wiki.controller.resp.PageResp;

import java.util.List;

public interface DocService {

    public abstract List<DocQueryResp> all(Long ebookId);

    public abstract PageResp<DocQueryResp> list(DocQueryReq req);

    public abstract void save(DocSaveReq req);

    public abstract void delete(Long id);

    public abstract void delete(List<String> ids);

    public abstract String findContent(Long id);

    public abstract void vote(Long id);

    public void updateEbookInfo();
}
