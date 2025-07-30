package org.app.Dto;

import org.app.Models.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class DonationDTO {
    private Integer donation_id;
    private String donorName;
    private DonorType donorType;
    private BigDecimal amount;
    private LocalDate donationDate;
    private String category;
    private DonationStatus status;

    public DonationStatus getStatus() {
        return status;
    }

    public void setStatus(DonationStatus status) {
        this.status = status;
    }

    public Integer getDonation_id() {
        return donation_id;
    }

    public void setDonation_id(Integer donation_id) {
        this.donation_id = donation_id;
    }

    public String getDonorName() {
        return donorName;
    }

    public void setDonorName(String donorName) {
        this.donorName = donorName;
    }

    public DonorType getDonorType() {
        return donorType;
    }

    public void setDonorType(DonorType donorType) {
        this.donorType = donorType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDate getDonationDate() {
        return donationDate;
    }

    public void setDonationDate(LocalDate donationDate) {
        this.donationDate = donationDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    // Static factory method to convert Entity to DTO
    public static DonationDTO fromEntity(Donation donation) {
        if (donation == null) {
            return null;
        }

        DonationDTO dto = new DonationDTO();
        dto.setDonation_id(donation.getDonation_id());
        dto.setDonorName(donation.getDonorName());
        dto.setDonorType(donation.getDonorType());
        dto.setDonationDate(donation.getDonationDate());
        dto.setCategory(donation.getCategory());
        dto.setAmount(donation.getAmount());
        dto.setStatus(donation.getStatus());
        return dto;
    }
}

