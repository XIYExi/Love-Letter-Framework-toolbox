package com.xion.wiki.service;

import com.xion.wiki.controller.req.EbookQueryReq;
import com.xion.wiki.controller.req.EbookSaveReq;
import com.xion.wiki.controller.resp.EbookQueryResp;
import com.xion.wiki.controller.resp.PageResp;

public interface EbookService {

    public abstract PageResp<EbookQueryResp> list(EbookQueryReq req);

    public abstract void save(EbookSaveReq req);

    public abstract void delete(Long id);

}
