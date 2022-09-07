package com.xion.wiki.controller.resp;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CategoryQueryResp {

    @JsonSerialize(using= ToStringSerializer.class)
    private Long id;

    private Long parent;

    private String name;

    private Integer sort;

}
