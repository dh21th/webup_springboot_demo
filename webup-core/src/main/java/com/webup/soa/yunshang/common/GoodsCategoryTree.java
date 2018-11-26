package com.webup.soa.yunshang.common;



import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * element树要求的结构
 *
 * @author Xiaobei
 * @create 2017-07-14 11:45
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class GoodsCategoryTree {
    private Integer id;

    private Integer pid;

    private String label;//级联选择器标签名称

    private Integer value;//级联选择器值

    private Boolean activeFlag; //激活状态 0 未激活 1 已激活

    private Boolean deleteFlag; //删除状态 0 未删除 1 已删除

    private List<GoodsCategoryTree> children;//子结点

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public List<GoodsCategoryTree> getChildren() {
        return children;
    }

    public void setChildren(List<GoodsCategoryTree> children) {
        this.children = children;
    }

    public Boolean getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(Boolean activeFlag) {
        this.activeFlag = activeFlag;
    }

    public Boolean getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
}
