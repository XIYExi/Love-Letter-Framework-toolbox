package com.xion.wiki.controller;

import com.xion.wiki.controller.req.EbookReq;
import com.xion.wiki.controller.resp.EbookResp;
import com.xion.wiki.service.impl.EbookServiceImpl;
import com.xion.wiki.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("ebook")
public class EbookController {

    @Autowired
    private EbookServiceImpl ebookService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public R list(EbookReq req){
        List<EbookResp> list = ebookService.list(req);
        return R.ok().data("list", list);
    }

}
