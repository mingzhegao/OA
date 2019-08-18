package com.turing.code.entity;

public class SHANGPINLEIXING {
    private String cslId;

    private String cslName;

    public String getCslId() {
        return cslId;
    }

    public void setCslId(String cslId) {
        this.cslId = cslId == null ? null : cslId.trim();
    }

    public String getCslName() {
        return cslName;
    }

    public void setCslName(String cslName) {
        this.cslName = cslName == null ? null : cslName.trim();
    }
}