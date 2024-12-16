package com.bufstudio.bookmanagementsystem.model.dto.promo;

import com.bufstudio.bookmanagementsystem.model.entity.Promo;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;

public class PromoCriteriaDto implements Serializable {
    private static final long serialVersionUID = -7684197682803522063L;

    private Long id;

    private String description;
    private String conditionType;
    private String conditionValue;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getConditionType() {
        return conditionType;
    }

    public void setConditionType(String conditionType) {
        this.conditionType = conditionType;
    }

    public String getConditionValue() {
        return conditionValue;
    }

    public void setConditionValue(String conditionValue) {
        this.conditionValue = conditionValue;
    }
}
