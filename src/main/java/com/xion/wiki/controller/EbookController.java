package com.xion.wiki.controller;

import com.xion.wiki.controller.req.EbookQueryReq;
import com.xion.wiki.controller.req.EbookSaveReq;
import com.xion.wiki.controller.resp.EbookQueryResp;
import com.xion.wiki.controller.resp.PageResp;
import com.xion.wiki.service.impl.EbookServiceImpl;
import com.xion.wiki.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("ebook")
public class EbookController {

    @Autowired
    private EbookServiceImpl ebookService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public R list(EbookQueryReq req){
        System.err.println(req);
        PageResp<EbookQueryResp> list = ebookService.list(req);
        return R.ok().data("list", list);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public R save(@RequestBody EbookSaveReq req){
        ebookService.save(req);
        return R.ok();
    }


    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public R delete(@PathVariable Long id){
        ebookService.delete(id);
        return R.ok();
    }


}
