package com.turing.code.entity;

public class CodeXinyvdengji {
    private String cxyId;

    private String cxyName;

    public String getCxyId() {
        return cxyId;
    }

    public void setCxyId(String cxyId) {
        this.cxyId = cxyId == null ? null : cxyId.trim();
    }

    public String getCxyName() {
        return cxyName;
    }

    public void setCxyName(String cxyName) {
        this.cxyName = cxyName == null ? null : cxyName.trim();
    }
}