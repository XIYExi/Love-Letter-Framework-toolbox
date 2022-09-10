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
public class DocQueryResp {

    @JsonSerialize(using= ToStringSerializer.class)
    private Long id;

    @JsonSerialize(using= ToStringSerializer.class)
    private Long ebookId;

    @JsonSerialize(using= ToStringSerializer.class)
    private Long parent;

    private String name;

    private Integer sort;

    private Integer viewCount;

    private Integer voteCount;
}
