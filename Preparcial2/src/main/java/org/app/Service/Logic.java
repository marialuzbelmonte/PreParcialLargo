package org.app.Service;

import org.app.Dto.CollectionDTO;
import org.app.Dto.DonationAssignmentDTO;
import org.app.Dto.TotalRaisedDTO;
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

        }
        return true;
    }

    public boolean AssignDonation(int donation_id, LocalDate assignedDate, String notes) {
        try(Session session = HibernateUtil.getSession()){

        }
        return true;
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
