package com.xion.wiki.controller.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotNull;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CategorySaveReq {
    private Long id;

    private Long parent;

    @NotNull(message = "【名称】不能为空")
    private String name;

    @NotNull(message = "【排序】不能为空")
    private Integer sort;

}
