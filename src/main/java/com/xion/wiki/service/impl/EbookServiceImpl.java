package com.xion.wiki.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xion.wiki.controller.req.EbookQueryReq;
import com.xion.wiki.controller.req.EbookSaveReq;
import com.xion.wiki.controller.resp.EbookQueryResp;
import com.xion.wiki.controller.resp.PageResp;
import com.xion.wiki.domain.Ebook;
import com.xion.wiki.domain.EbookExample;
import com.xion.wiki.mapper.EbookMapper;
import com.xion.wiki.service.EbookService;
import com.xion.wiki.utils.CopyUtil;
import com.xion.wiki.utils.SnowFlake;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
public class EbookServiceImpl implements EbookService {

    private static final Logger LOG = LoggerFactory.getLogger(EbookService.class);

    @Autowired
    private EbookMapper ebookMapper;

    @Autowired
    private SnowFlake snowFlake;

    @Override
    public PageResp<EbookQueryResp> list(EbookQueryReq req) {
        EbookExample ebookExample = new EbookExample();
        EbookExample.Criteria criteria = ebookExample.createCriteria();

        if (!ObjectUtils.isEmpty(req.getName())){
            criteria.andNameLike("%" + req.getName() + "%");
        }

        PageHelper.startPage(req.getPage(), req.getSize());
        List<Ebook> ebookList = ebookMapper.selectByExample(ebookExample);

        PageInfo<Ebook> pageInfo = new PageInfo<>(ebookList);
        LOG.info("总行数：{}", pageInfo.getTotal());

        /**
        List<EbookResp> respList = new ArrayList<>();
        for (Ebook ebook : ebookList){
            EbookResp ebookResp = CopyUtil.copy(ebook, EbookResp.class);
            respList.add(ebookResp);
        }*/

        PageResp<EbookQueryResp> pageResp = new PageResp<>();
        List<EbookQueryResp> list = CopyUtil.copyList(ebookList, EbookQueryResp.class);
        pageResp.setTotal(pageInfo.getTotal());
        pageResp.setList(list);

        return pageResp;
    }

    @Override
    public void save(EbookSaveReq req) {
        Ebook ebook = CopyUtil.copy(req, Ebook.class);

        if (ObjectUtils.isEmpty(ebook.getId())){
            ebook.setId(snowFlake.nextId());
            ebookMapper.insert(ebook);
        }
        else {
            ebookMapper.updateByPrimaryKey(ebook);
        }
    }

    @Override
    public void delete(Long id) {
        ebookMapper.deleteByPrimaryKey(id);
    }


}
