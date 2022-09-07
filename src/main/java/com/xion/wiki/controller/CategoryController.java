package com.xion.wiki.controller;

import com.xion.wiki.controller.req.CategoryQueryReq;
import com.xion.wiki.controller.req.CategorySaveReq;
import com.xion.wiki.controller.resp.CategoryQueryResp;
import com.xion.wiki.controller.resp.PageResp;
import com.xion.wiki.service.impl.CategoryServiceImpl;
import com.xion.wiki.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryServiceImpl categoryService;

    @GetMapping("/all")
    public R all() {
        List<CategoryQueryResp> all = categoryService.all();
        // System.err.println(all);
        return R.ok().data("list", all);
    }

    @GetMapping("/list")
    public R list(@Valid CategoryQueryReq req) {
        PageResp<CategoryQueryResp> list = categoryService.list(req);
        return R.ok().data("list", list);
    }

    @PostMapping("/save")
    public R save(@Valid @RequestBody CategorySaveReq req) {
        categoryService.save(req);
        return R.ok();
    }

    @DeleteMapping("/delete/{id}")
    public R delete(@PathVariable String id) {
        System.err.println("delete category id: "+id);
        categoryService.delete(Long.parseLong(id));
        return R.ok();
    }
}
