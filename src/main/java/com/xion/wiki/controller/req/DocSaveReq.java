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
public class DocSaveReq {
    private Long id;

    @NotNull(message = "【电子书】不能为空")
    private Long ebookId;

    @NotNull(message = "【父文档】不能为空")
    private Long parent;

    @NotNull(message = "【名称】不能为空")
    private String name;

    @NotNull(message = "【顺序】不能为空")
    private Integer sort;

    private Integer viewCount;

    private Integer voteCount;

    @NotNull(message = "【内容】不能为空")
    private String content;

}
