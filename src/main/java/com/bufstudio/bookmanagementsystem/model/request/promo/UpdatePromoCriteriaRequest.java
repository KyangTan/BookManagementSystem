package com.bufstudio.bookmanagementsystem.model.request.promo;

import java.io.Serializable;

public class UpdatePromoCriteriaRequest implements Serializable {
    private static final long serialVersionUID = -2069561109461215754L;

    private String description;
    private String conditionType;
    private String conditionValue;

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
