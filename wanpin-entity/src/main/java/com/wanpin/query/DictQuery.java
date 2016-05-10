package com.wanpin.query;

import com.wanpin.common.query.BaseQuery;
import com.wanpin.entity.Dict;

public class DictQuery extends BaseQuery<Dict> {

	private String dictCode;

    private String dictName;
    
    public String getDictCode() {
        return dictCode;
    }

    public void setDictCode(String dictCode) {
        this.dictCode = dictCode == null ? null : dictCode.trim();
    }

    public String getDictName() {
        return dictName;
    }

    public void setDictName(String dictName) {
        this.dictName = dictName == null ? null : dictName.trim();
    }
}
