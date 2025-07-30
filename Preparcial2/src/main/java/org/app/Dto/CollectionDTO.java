package org.app.Dto;

import java.math.BigDecimal;

public class CollectionDTO {
    private String category;
    private int receivedCount;
    private int assignedCount;
    private BigDecimal totalAmount;

    public CollectionDTO(String category, int receivedCount, int assignedCount, BigDecimal totalAmount) {
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

    public int getReceivedCount() {
        return receivedCount;
    }

    public void setReceivedCount(int receivedCount) {
        this.receivedCount = receivedCount;
    }

    public int getAssignedCount() {
        return assignedCount;
    }

    public void setAssignedCount(int assignedCount) {
        this.assignedCount = assignedCount;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }
}
