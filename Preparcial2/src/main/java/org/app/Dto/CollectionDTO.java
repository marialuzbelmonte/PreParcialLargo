package org.app.Dto;

import java.math.BigDecimal;

public class CollectionDTO {
    private String category;
    private Long receivedCount;
    private Long assignedCount;
    private BigDecimal totalAmount;

    public CollectionDTO(String category, Long receivedCount, Long assignedCount, BigDecimal totalAmount) {
        this.category = category;
        this.receivedCount = receivedCount;
        this.assignedCount = assignedCount;
        this.totalAmount = totalAmount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Long getReceivedCount() {
        return receivedCount;
    }

    public void setReceivedCount(Long receivedCount) {
        this.receivedCount = receivedCount;
    }

    public Long getAssignedCount() {
        return assignedCount;
    }

    public void setAssignedCount(Long assignedCount) {
        this.assignedCount = assignedCount;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }
}
