package org.app.Dto;

import org.app.Models.DonorType;

import java.math.BigDecimal;

public class TotalRaisedDTO {
    private DonorType donorType;
    private int donationCount;
    private BigDecimal totalAmount;

    public TotalRaisedDTO(DonorType donorType, int donationCount, BigDecimal totalAmount) {
        this.donorType = donorType;
        this.donationCount = donationCount;
        this.totalAmount = totalAmount;
    }

    public DonorType getDonorType() {
        return donorType;
    }

    public void setDonorType(DonorType donorType) {
        this.donorType = donorType;
    }

    public int getDonationCount() {
        return donationCount;
    }

    public void setDonationCount(int donationCount) {
        this.donationCount = donationCount;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }
}
