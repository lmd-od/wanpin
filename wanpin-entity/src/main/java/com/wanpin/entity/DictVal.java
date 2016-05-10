package com.wanpin.entity;

public class DictVal {
    private Long dictValId;

    private String dictCode;

    private String valCode;

    private String valName;

    private Integer sortNo;

    private Integer isValid;

    public Long getDictValId() {
        return dictValId;
    }

    public void setDictValId(Long dictValId) {
        this.dictValId = dictValId;
    }

    public String getDictCode() {
        return dictCode;
    }

    public void setDictCode(String dictCode) {
        this.dictCode = dictCode == null ? null : dictCode.trim();
    }

    public String getValCode() {
        return valCode;
    }

    public void setValCode(String valCode) {
        this.valCode = valCode == null ? null : valCode.trim();
    }

    public String getValName() {
        return valName;
    }

    public void setValName(String valName) {
        this.valName = valName == null ? null : valName.trim();
    }

    public Integer getSortNo() {
        return sortNo;
    }

    public void setSortNo(Integer sortNo) {
        this.sortNo = sortNo;
    }

    public Integer getIsValid() {
        return isValid;
    }

    public void setIsValid(Integer isValid) {
        this.isValid = isValid;
    }
}