// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

package org.dddappp.suiinscription.domain.certificate;

import java.util.*;
import java.math.*;
import java.math.BigInteger;
import java.util.Date;
import org.dddappp.suiinscription.domain.*;
import org.dddappp.suiinscription.specialization.*;
import org.dddappp.suiinscription.domain.certificate.CertificateEvent.*;

public abstract class AbstractCertificateState implements CertificateState.SqlCertificateState {

    private String id;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String inscriptionId;

    public String getInscriptionId() {
        return this.inscriptionId;
    }

    public void setInscriptionId(String inscriptionId) {
        this.inscriptionId = inscriptionId;
    }

    private int[] inscriptionHash;

    public int[] getInscriptionHash() {
        return this.inscriptionHash;
    }

    public void setInscriptionHash(int[] inscriptionHash) {
        this.inscriptionHash = inscriptionHash;
    }

    private Integer slotNumber;

    public Integer getSlotNumber() {
        return this.slotNumber;
    }

    public void setSlotNumber(Integer slotNumber) {
        this.slotNumber = slotNumber;
    }

    private BigInteger round;

    public BigInteger getRound() {
        return this.round;
    }

    public void setRound(BigInteger round) {
        this.round = round;
    }

    private String inscriber;

    public String getInscriber() {
        return this.inscriber;
    }

    public void setInscriber(String inscriber) {
        this.inscriber = inscriber;
    }

    private BigInteger inscriptionTimestamp;

    public BigInteger getInscriptionTimestamp() {
        return this.inscriptionTimestamp;
    }

    public void setInscriptionTimestamp(BigInteger inscriptionTimestamp) {
        this.inscriptionTimestamp = inscriptionTimestamp;
    }

    private BigInteger amount;

    public BigInteger getAmount() {
        return this.amount;
    }

    public void setAmount(BigInteger amount) {
        this.amount = amount;
    }

    private BigInteger inscriptionNonce;

    public BigInteger getInscriptionNonce() {
        return this.inscriptionNonce;
    }

    public void setInscriptionNonce(BigInteger inscriptionNonce) {
        this.inscriptionNonce = inscriptionNonce;
    }

    private String inscriptionContent;

    public String getInscriptionContent() {
        return this.inscriptionContent;
    }

    public void setInscriptionContent(String inscriptionContent) {
        this.inscriptionContent = inscriptionContent;
    }

    private BigInteger version;

    public BigInteger getVersion() {
        return this.version;
    }

    public void setVersion(BigInteger version) {
        this.version = version;
    }

    private Long offChainVersion;

    public Long getOffChainVersion() {
        return this.offChainVersion;
    }

    public void setOffChainVersion(Long offChainVersion) {
        this.offChainVersion = offChainVersion;
    }

    private String createdBy;

    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    private Date createdAt;

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    private String updatedBy;

    public String getUpdatedBy() {
        return this.updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    private Date updatedAt;

    public Date getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    private Boolean active;

    public Boolean getActive() {
        return this.active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    private Boolean deleted;

    public Boolean getDeleted() {
        return this.deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public boolean isStateUnsaved() {
        return this.getOffChainVersion() == null;
    }

    private Boolean stateReadOnly;

    public Boolean getStateReadOnly() { return this.stateReadOnly; }

    public void setStateReadOnly(Boolean readOnly) { this.stateReadOnly = readOnly; }

    private boolean forReapplying;

    public boolean getForReapplying() {
        return forReapplying;
    }

    public void setForReapplying(boolean forReapplying) {
        this.forReapplying = forReapplying;
    }

    public AbstractCertificateState(List<Event> events) {
        initializeForReapplying();
        if (events != null && events.size() > 0) {
            this.setId(((CertificateEvent.SqlCertificateEvent) events.get(0)).getCertificateEventId().getId());
            for (Event e : events) {
                mutate(e);
                this.setOffChainVersion((this.getOffChainVersion() == null ? CertificateState.VERSION_NULL : this.getOffChainVersion()) + 1);
            }
        }
    }


    public AbstractCertificateState() {
        initializeProperties();
    }

    protected void initializeForReapplying() {
        this.forReapplying = true;

        initializeProperties();
    }
    
    protected void initializeProperties() {
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) { return true; }
        if (obj instanceof CertificateState) {
            return Objects.equals(this.getId(), ((CertificateState)obj).getId());
        }
        return false;
    }


    public void mutate(Event e) {
        setStateReadOnly(false);
        if (false) { 
            ;
        } else if (e instanceof AbstractCertificateEvent.CertificateIssued) {
            when((AbstractCertificateEvent.CertificateIssued)e);
        } else {
            throw new UnsupportedOperationException(String.format("Unsupported event type: %1$s", e.getClass().getName()));
        }
    }

    public void merge(CertificateState s) {
        if (s == this) {
            return;
        }
        this.setInscriptionId(s.getInscriptionId());
        this.setInscriptionHash(s.getInscriptionHash());
        this.setSlotNumber(s.getSlotNumber());
        this.setRound(s.getRound());
        this.setInscriber(s.getInscriber());
        this.setInscriptionTimestamp(s.getInscriptionTimestamp());
        this.setAmount(s.getAmount());
        this.setInscriptionNonce(s.getInscriptionNonce());
        this.setInscriptionContent(s.getInscriptionContent());
        this.setVersion(s.getVersion());
        this.setActive(s.getActive());
    }

    public void when(AbstractCertificateEvent.CertificateIssued e) {
        throwOnWrongEvent(e);

        String inscriptionId = e.getInscriptionId();
        String InscriptionId = inscriptionId;
        int[] inscriptionHash = e.getInscriptionHash();
        int[] InscriptionHash = inscriptionHash;
        Integer slotNumber = e.getSlotNumber();
        Integer SlotNumber = slotNumber;
        BigInteger round = e.getRound();
        BigInteger Round = round;
        String inscriber = e.getInscriber();
        String Inscriber = inscriber;
        BigInteger inscriptionTimestamp = e.getInscriptionTimestamp();
        BigInteger InscriptionTimestamp = inscriptionTimestamp;
        BigInteger amount = e.getAmount();
        BigInteger Amount = amount;
        BigInteger inscriptionNonce = e.getInscriptionNonce();
        BigInteger InscriptionNonce = inscriptionNonce;
        String inscriptionContent = e.getInscriptionContent();
        String InscriptionContent = inscriptionContent;
        Long suiTimestamp = e.getSuiTimestamp();
        Long SuiTimestamp = suiTimestamp;
        String suiTxDigest = e.getSuiTxDigest();
        String SuiTxDigest = suiTxDigest;
        BigInteger suiEventSeq = e.getSuiEventSeq();
        BigInteger SuiEventSeq = suiEventSeq;
        String suiPackageId = e.getSuiPackageId();
        String SuiPackageId = suiPackageId;
        String suiTransactionModule = e.getSuiTransactionModule();
        String SuiTransactionModule = suiTransactionModule;
        String suiSender = e.getSuiSender();
        String SuiSender = suiSender;
        String suiType = e.getSuiType();
        String SuiType = suiType;
        String status = e.getStatus();
        String Status = status;

        if (this.getCreatedBy() == null){
            this.setCreatedBy(e.getCreatedBy());
        }
        if (this.getCreatedAt() == null){
            this.setCreatedAt(e.getCreatedAt());
        }
        this.setUpdatedBy(e.getCreatedBy());
        this.setUpdatedAt(e.getCreatedAt());

        CertificateState updatedCertificateState = (CertificateState) ReflectUtils.invokeStaticMethod(
                    "org.dddappp.suiinscription.domain.certificate.IssueLogic",
                    "mutate",
                    new Class[]{CertificateState.class, String.class, int[].class, Integer.class, BigInteger.class, String.class, BigInteger.class, BigInteger.class, BigInteger.class, String.class, Long.class, String.class, BigInteger.class, String.class, String.class, String.class, String.class, String.class, MutationContext.class},
                    new Object[]{this, inscriptionId, inscriptionHash, slotNumber, round, inscriber, inscriptionTimestamp, amount, inscriptionNonce, inscriptionContent, suiTimestamp, suiTxDigest, suiEventSeq, suiPackageId, suiTransactionModule, suiSender, suiType, status, MutationContext.forEvent(e, s -> {if (s == this) {return this;} else {throw new UnsupportedOperationException();}})}
            );

//package org.dddappp.suiinscription.domain.certificate;
//
//public class IssueLogic {
//    public static CertificateState mutate(CertificateState certificateState, String inscriptionId, int[] inscriptionHash, Integer slotNumber, BigInteger round, String inscriber, BigInteger inscriptionTimestamp, BigInteger amount, BigInteger inscriptionNonce, String inscriptionContent, Long suiTimestamp, String suiTxDigest, BigInteger suiEventSeq, String suiPackageId, String suiTransactionModule, String suiSender, String suiType, String status, MutationContext<CertificateState, CertificateState.MutableCertificateState> mutationContext) {
//    }
//}

        if (this != updatedCertificateState) { merge(updatedCertificateState); } //else do nothing

    }

    public void save() {
    }

    protected void throwOnWrongEvent(CertificateEvent event) {
        String stateEntityId = this.getId(); // Aggregate Id
        String eventEntityId = ((CertificateEvent.SqlCertificateEvent)event).getCertificateEventId().getId(); // EntityBase.Aggregate.GetEventIdPropertyIdName();
        if (!stateEntityId.equals(eventEntityId)) {
            throw DomainError.named("mutateWrongEntity", "Entity Id %1$s in state but entity id %2$s in event", stateEntityId, eventEntityId);
        }


        Long stateVersion = this.getOffChainVersion();

    }


    public static class SimpleCertificateState extends AbstractCertificateState {

        public SimpleCertificateState() {
        }

        public SimpleCertificateState(List<Event> events) {
            super(events);
        }

        public static SimpleCertificateState newForReapplying() {
            SimpleCertificateState s = new SimpleCertificateState();
            s.initializeForReapplying();
            return s;
        }

    }



}

