package com.xion.wiki.service;

import com.xion.wiki.controller.req.CategoryQueryReq;
import com.xion.wiki.controller.req.CategorySaveReq;
import com.xion.wiki.controller.resp.CategoryQueryResp;
import com.xion.wiki.controller.resp.PageResp;

import java.util.List;

public interface CategoryService {

    public abstract List<CategoryQueryResp> all();

    public abstract PageResp<CategoryQueryResp> list(CategoryQueryReq req);

    public abstract void save(CategorySaveReq req);

    public abstract void delete(Long id);

}
