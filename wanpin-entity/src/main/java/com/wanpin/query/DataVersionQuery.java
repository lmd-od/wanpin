package com.wanpin.query;

import com.wanpin.common.query.BaseQuery;
import com.wanpin.entity.DataVersion;

public class DataVersionQuery extends BaseQuery<DataVersion> {

	private String dataCode;

    public String getDataCode() {
        return dataCode;
    }

    public void setDataCode(String dataCode) {
        this.dataCode = dataCode == null ? null : dataCode.trim();
    }
    
}
