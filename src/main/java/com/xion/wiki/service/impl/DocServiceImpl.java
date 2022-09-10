package com.xion.wiki.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xion.wiki.controller.req.DocQueryReq;
import com.xion.wiki.controller.req.DocSaveReq;
import com.xion.wiki.controller.resp.DocQueryResp;
import com.xion.wiki.controller.resp.PageResp;
import com.xion.wiki.domain.Doc;
import com.xion.wiki.domain.DocExample;
import com.xion.wiki.mapper.DocMapper;
import com.xion.wiki.service.DocService;
import com.xion.wiki.utils.CopyUtil;
import com.xion.wiki.utils.SnowFlake;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class DocServiceImpl implements DocService {

    private static final Logger LOG = LoggerFactory.getLogger(DocService.class);

    @Autowired
    private DocMapper docMapper;

    @Autowired
    private SnowFlake snowFlake;

    public List<DocQueryResp> all(Long ebookId) {
        DocExample docExample = new DocExample();
        docExample.createCriteria().andEbookIdEqualTo(ebookId);
        docExample.setOrderByClause("sort asc");
        List<Doc> docList = docMapper.selectByExample(docExample);

        // 列表复制
        List<DocQueryResp> list = CopyUtil.copyList(docList, DocQueryResp.class);

        return list;
    }

    public PageResp<DocQueryResp> list(DocQueryReq req) {
        DocExample docExample = new DocExample();
        docExample.setOrderByClause("sort asc");
        DocExample.Criteria criteria = docExample.createCriteria();
        PageHelper.startPage(req.getPage(), req.getSize());
        List<Doc> docList = docMapper.selectByExample(docExample);

        PageInfo<Doc> pageInfo = new PageInfo<>(docList);
        LOG.info("总行数：{}", pageInfo.getTotal());
        LOG.info("总页数：{}", pageInfo.getPages());

        // List<DocResp> respList = new ArrayList<>();
        // for (Doc doc : docList) {
        //     // DocResp docResp = new DocResp();
        //     // BeanUtils.copyProperties(doc, docResp);
        //     // 对象复制
        //     DocResp docResp = CopyUtil.copy(doc, DocResp.class);
        //
        //     respList.add(docResp);
        // }

        // 列表复制
        List<DocQueryResp> list = CopyUtil.copyList(docList, DocQueryResp.class);

        PageResp<DocQueryResp> pageResp = new PageResp();
        pageResp.setTotal(pageInfo.getTotal());
        pageResp.setList(list);

        return pageResp;
    }

    @Override
    public void save(DocSaveReq req) {

    }


    public void delete(Long id) {
        docMapper.deleteByPrimaryKey(id);
    }

    public void delete(List<String> ids) {
        DocExample docExample = new DocExample();
        DocExample.Criteria criteria = docExample.createCriteria();

        List<Long> longStream = ids.stream()
                .map(Long::parseLong).collect(Collectors.toList());

        criteria.andIdIn(longStream);
        docMapper.deleteByExample(docExample);
    }

}
