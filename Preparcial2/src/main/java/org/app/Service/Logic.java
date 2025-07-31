package org.app.Service;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Root;
import org.app.Dto.CollectionDTO;
import org.app.Dto.TotalRaisedDTO;
import org.app.Models.Donation;
import org.app.Models.DonationAssignment;
import org.app.Models.DonationStatus;
import org.app.Models.DonorType;
import org.app.Utils.HibernateUtil;
import org.hibernate.Session;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

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

    public List<TotalRaisedDTO> TotalRaised(){
        try(Session session = HibernateUtil.getSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<TotalRaisedDTO> cq = cb.createQuery(TotalRaisedDTO.class);
            Root<Donation> root = cq.from(Donation.class);

            cq.groupBy(root.get("donorType"));
            cq.orderBy(cb.desc(root.get("amount")));

            cq.select(cb.construct(
                    TotalRaisedDTO.class,
                    root.get("donorType"),
                    cb.count(root).alias("donation_count"),
                    cb.sum(root.get("amount")).alias("total_amount")
            ));

            return session.createQuery(cq).getResultList();
        }
    }

    public List<CollectionDTO> Collection(){
        try(Session session = HibernateUtil.getSession()){
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<CollectionDTO> cq = cb.createQuery(CollectionDTO.class);
            Root<Donation> root = cq.from(Donation.class);

            cq.groupBy(root.get("category"));
            cq.orderBy(cb.desc(root.get("amount")));

            Expression<Long> receivedCount = cb.sum(
                    cb.<Long>selectCase()
                            .when(cb.equal(root.get("stauts"), "RECIVED"), 1L)
                            .otherwise(0L)
            );

            Expression<Long> assignedCount = cb.sum(
                    cb.<Long>selectCase()
                            .when(cb.equal(root.get("status"),"ASSIGNED"), 1L)
                            .otherwise(0L)
            );

            Expression<BigDecimal> totalAmount = cb.sum(root.get("amount"));

            cq.select(cb.construct(
                    CollectionDTO.class,
                    root.get("category"),
                    receivedCount,
                    assignedCount,
                    totalAmount
            ));

            return session.createQuery(cq).getResultList();
        }
    }
}
