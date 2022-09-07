package com.xion.wiki.controller.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class PageReq {

    @NotNull(message = "【查询页数】查询页数不能为空")
    private int page;

    @NotNull(message="【每页条数】不能为空")
    @Max(value=1000, message = "【最大查询】查询条数超过限制！")
    private int size;

}
