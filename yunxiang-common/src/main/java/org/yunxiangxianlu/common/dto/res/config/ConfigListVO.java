package org.yunxiangxianlu.common.dto.res.config;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConfigListVO {

    private Long id;

    private Integer configType;

    private Integer configKey;

    private String configValue;
}
