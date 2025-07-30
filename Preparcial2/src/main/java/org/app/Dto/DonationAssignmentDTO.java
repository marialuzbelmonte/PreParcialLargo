package org.app.Dto;

import org.app.Models.Donation;
import org.app.Models.DonationAssignment;
import java.time.LocalDate;

public class DonationAssignmentDTO {
    private Long assignmentId;
    private Donation donation;
    private String notes;
    private LocalDate assignedDate;

    public Long getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(Long assignmentId) {
        this.assignmentId = assignmentId;
    }

    public Donation getDonation() {
        return donation;
    }

    public void setDonation(Donation donation) {
        this.donation = donation;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public LocalDate getAssignedDate() {
        return assignedDate;
    }

    public void setAssignedDate(LocalDate assignedDate) {
        this.assignedDate = assignedDate;
    }

    // Static factory method to convert Entity to DTO
    public static DonationAssignmentDTO fromEntity(DonationAssignment donationAssignment) {
        if (donationAssignment == null) {
            return null;
        }

        DonationAssignmentDTO dto = new DonationAssignmentDTO();
        dto.setAssignmentId(donationAssignment.getAssignmentId());
        dto.setDonation(donationAssignment.getDonation());
        dto.setNotes(donationAssignment.getNotes());
        dto.setAssignedDate(donationAssignment.getAssignedDate());

        return dto;
    }
}