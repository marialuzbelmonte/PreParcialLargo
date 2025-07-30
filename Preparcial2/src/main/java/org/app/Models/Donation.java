package org.app.Models;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Donaciones")
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer donation_id;

    @Column(nullable = false)
    private String donorName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DonorType donorType;

    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal amount;

    @Column(nullable = false)
    private LocalDate donationDate;

    @Column(nullable = false)
    private String category;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DonationStatus status = DonationStatus.RECEIVED;

    public Donation() { }

    public Donation(String donorName, DonorType donorType, BigDecimal amount, LocalDate donationDate, String category, DonationStatus status) {
        this.donorName = donorName;
        this.donorType = donorType;
        this.amount = amount;
        this.donationDate = donationDate;
        this.category = category;
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

    public DonationStatus getStatus() {
        return status;
    }

    public void setStatus(DonationStatus status) {
        this.status = status;
    }

}


