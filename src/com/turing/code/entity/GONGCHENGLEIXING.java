package com.turing.code.entity;

public class GONGCHENGLEIXING {
    private String cglId;

    private String cglName;

    public String getCglId() {
        return cglId;
    }

    public void setCglId(String cglId) {
        this.cglId = cglId == null ? null : cglId.trim();
    }

    public String getCglName() {
        return cglName;
    }

    public void setCglName(String cglName) {
        this.cglName = cglName == null ? null : cglName.trim();
    }
}