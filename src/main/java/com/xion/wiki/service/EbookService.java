package com.xion.wiki.service;

import com.xion.wiki.controller.req.EbookReq;
import com.xion.wiki.controller.resp.EbookResp;
import com.xion.wiki.domain.Ebook;
import com.xion.wiki.mapper.EbookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EbookService {

    public List<EbookResp> list(EbookReq req);

}
