package com.treasy.treasy.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
public class NodePai {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String code;

    private String description;

    private Integer parentId;

    private String detail;

    @OneToMany(mappedBy = "nodePai", cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private List<NodeFilho> children;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public List<NodeFilho> getChildren() {
        return children;
    }

    public void setChildren(List<NodeFilho> children) {
        this.children = children;
    }
}
