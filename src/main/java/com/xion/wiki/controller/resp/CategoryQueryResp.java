package com.xion.wiki.controller.resp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CategoryQueryResp {
    private Long id;

    private Long parent;

    private String name;

    private Integer sort;

}
