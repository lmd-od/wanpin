package com.wanpin.query;

import com.wanpin.common.query.BaseQuery;
import com.wanpin.entity.Dict;
import com.wanpin.entity.DictVal;

public class DictValQuery extends BaseQuery<DictVal> {

	private String dictCode;
	
	private Integer isValid;

    public String getDictCode() {
        return dictCode;
    }

    public void setDictCode(String dictCode) {
        this.dictCode = dictCode == null ? null : dictCode.trim();
    }
    
    public Integer getIsValid() {
        return isValid;
    }

    public void setIsValid(Integer isValid) {
        this.isValid = isValid;
    }

}
