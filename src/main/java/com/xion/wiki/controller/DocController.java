package com.xion.wiki.controller;

import com.xion.wiki.controller.req.DocQueryReq;
import com.xion.wiki.controller.req.DocSaveReq;
import com.xion.wiki.controller.resp.DocQueryResp;
import com.xion.wiki.controller.resp.PageResp;
import com.xion.wiki.service.impl.DocServiceImpl;
import com.xion.wiki.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/doc")
public class DocController {

    @Autowired
    private DocServiceImpl docService;

    @GetMapping("/all/{ebookId}")
    public R all(@PathVariable Long ebookId) {
        List<DocQueryResp> list = docService.all(ebookId);
        return R.ok().data("list", list);
    }

    @GetMapping("/list")
    public R list(@Valid DocQueryReq req) {
        PageResp<DocQueryResp> list = docService.list(req);
        return R.ok().data("list", list);
    }

    @PostMapping("/save")
    public R save(@Valid @RequestBody DocSaveReq req) {
        docService.save(req);
        return R.ok();
    }

    @DeleteMapping("/delete/{idsStr}")
    public R delete(@PathVariable String idsStr) {
        List<String> list = Arrays.asList(idsStr.split(","));
        docService.delete(list);
        return R.ok();
    }

}
