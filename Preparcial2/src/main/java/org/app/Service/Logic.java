package org.app.Service;

import org.app.Dto.CollectionDTO;
import org.app.Dto.DonationAssignmentDTO;
import org.app.Dto.TotalRaisedDTO;
import org.app.Models.Donation;
import org.app.Models.DonationAssignment;
import org.app.Models.DonationStatus;
import org.app.Models.DonorType;
import org.app.Utils.HibernateUtil;
import org.hibernate.Session;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Logic {
    private static Logic instance;

    private Logic() {
    }

    public static Logic getInstance() {
        if (instance == null) {
            instance = new Logic();
        }
        return instance;
    }

    public boolean RegisterDonation(String donorName, DonorType donorType, BigDecimal amount, LocalDate donationDate, String category){
        try(Session session = HibernateUtil.getSession()){
            Donation donation = new Donation(donorName, donorType, amount, donationDate, category, DonationStatus.RECEIVED);
            session.beginTransaction();
            session.persist(donation);
            session.getTransaction().commit();
        }
        return true;
    }

    public boolean AssignDonation(int donation_id, LocalDate assignedDate, String notes) {
        try(Session session = HibernateUtil.getSession()){
            Donation donation = session.get(Donation.class, donation_id);
            if(donation == null){
                System.out.println("La donación no existe");
                return false;
            }
            if (donation.getStatus() == DonationStatus.RECEIVED) {
                DonationAssignment donationAssignment = new DonationAssignment(donation, notes, assignedDate);
                donation.setStatus(DonationStatus.ASSIGNED);
                session.beginTransaction();
                session.persist(donationAssignment);
                session.merge(donation);
                session.getTransaction().commit();

                return true;
            } else{
                System.out.println("La donación ya fue asignada");
                return false;
            }
        }
    }

    public TotalRaisedDTO TotalRaised(DonorType donorType){
        try(Session session = HibernateUtil.getSession()){

        }

        TotalRaisedDTO totalRaisedDTO = null;
        return totalRaisedDTO;
    }

    public CollectionDTO Collection(String category){
        try(Session session = HibernateUtil.getSession()){

        }

        CollectionDTO collectionDTO = null;
        return collectionDTO;
    }
}
