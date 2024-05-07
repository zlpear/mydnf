package org.zwj.mydnf.common.page;

import lombok.Data;

@Data
public class PageRequest {

    private long current = 1;
    private long size = 10;
    private String orderBy;
    private boolean asc = true;

}
