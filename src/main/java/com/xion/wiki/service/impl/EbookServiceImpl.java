package com.xion.wiki.service.impl;

import com.xion.wiki.controller.req.EbookReq;
import com.xion.wiki.controller.resp.EbookResp;
import com.xion.wiki.domain.Ebook;
import com.xion.wiki.domain.EbookExample;
import com.xion.wiki.mapper.EbookMapper;
import com.xion.wiki.service.EbookService;
import com.xion.wiki.utils.CopyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class EbookServiceImpl implements EbookService {

    @Autowired
    private EbookMapper ebookMapper;

    @Override
    public List<EbookResp> list(EbookReq req) {

        EbookExample ebookExample = new EbookExample();
        EbookExample.Criteria criteria = ebookExample.createCriteria();

        if (!ObjectUtils.isEmpty(req.getName())){
            criteria.andNameLike("%" + req.getName() + "%");
        }
        List<Ebook> ebookList = ebookMapper.selectByExample(ebookExample);

        /**
        List<EbookResp> respList = new ArrayList<>();
        for (Ebook ebook : ebookList){
            EbookResp ebookResp = CopyUtil.copy(ebook, EbookResp.class);
            respList.add(ebookResp);
        }*/
        List<EbookResp> list = CopyUtil.copyList(ebookList, EbookResp.class);



        return list;
    }
}
