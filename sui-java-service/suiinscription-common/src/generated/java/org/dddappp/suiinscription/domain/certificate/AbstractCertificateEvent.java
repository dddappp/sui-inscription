// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

package org.dddappp.suiinscription.domain.certificate;

import java.util.*;
import java.math.BigInteger;
import java.util.Date;
import org.dddappp.suiinscription.domain.*;
import org.dddappp.suiinscription.specialization.*;
import org.dddappp.suiinscription.domain.AbstractEvent;

public abstract class AbstractCertificateEvent extends AbstractEvent implements CertificateEvent.SqlCertificateEvent, SuiEventEnvelope.MutableSuiEventEnvelope, SuiMoveEvent.MutableSuiMoveEvent, HasStatus.MutableHasStatus {
    private CertificateEventId certificateEventId = new CertificateEventId();

    public CertificateEventId getCertificateEventId() {
        return this.certificateEventId;
    }

    public void setCertificateEventId(CertificateEventId eventId) {
        this.certificateEventId = eventId;
    }
    
    public String getId() {
        return getCertificateEventId().getId();
    }

    public void setId(String id) {
        getCertificateEventId().setId(id);
    }

    private boolean eventReadOnly;

    public boolean getEventReadOnly() { return this.eventReadOnly; }

    public void setEventReadOnly(boolean readOnly) { this.eventReadOnly = readOnly; }

    public BigInteger getVersion() {
        return getCertificateEventId().getVersion();
    }
    
    public void setVersion(BigInteger version) {
        getCertificateEventId().setVersion(version);
    }

    private Long suiTimestamp;

    public Long getSuiTimestamp() {
        return this.suiTimestamp;
    }
    
    public void setSuiTimestamp(Long suiTimestamp) {
        this.suiTimestamp = suiTimestamp;
    }

    private String suiTxDigest;

    public String getSuiTxDigest() {
        return this.suiTxDigest;
    }
    
    public void setSuiTxDigest(String suiTxDigest) {
        this.suiTxDigest = suiTxDigest;
    }

    private BigInteger suiEventSeq;

    public BigInteger getSuiEventSeq() {
        return this.suiEventSeq;
    }
    
    public void setSuiEventSeq(BigInteger suiEventSeq) {
        this.suiEventSeq = suiEventSeq;
    }

    private String suiPackageId;

    public String getSuiPackageId() {
        return this.suiPackageId;
    }
    
    public void setSuiPackageId(String suiPackageId) {
        this.suiPackageId = suiPackageId;
    }

    private String suiTransactionModule;

    public String getSuiTransactionModule() {
        return this.suiTransactionModule;
    }
    
    public void setSuiTransactionModule(String suiTransactionModule) {
        this.suiTransactionModule = suiTransactionModule;
    }

    private String suiSender;

    public String getSuiSender() {
        return this.suiSender;
    }
    
    public void setSuiSender(String suiSender) {
        this.suiSender = suiSender;
    }

    private String suiType;

    public String getSuiType() {
        return this.suiType;
    }
    
    public void setSuiType(String suiType) {
        this.suiType = suiType;
    }

    private String status;

    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(String status) {
        this.status = status;
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


    private String commandId;

    public String getCommandId() {
        return commandId;
    }

    public void setCommandId(String commandId) {
        this.commandId = commandId;
    }

    private String commandType;

    public String getCommandType() {
        return commandType;
    }

    public void setCommandType(String commandType) {
        this.commandType = commandType;
    }

    protected AbstractCertificateEvent() {
    }

    protected AbstractCertificateEvent(CertificateEventId eventId) {
        this.certificateEventId = eventId;
    }


    public abstract String getEventType();

    public static class CertificateClobEvent extends AbstractCertificateEvent {

        protected Map<String, Object> getDynamicProperties() {
            return dynamicProperties;
        }

        protected void setDynamicProperties(Map<String, Object> dynamicProperties) {
            if (dynamicProperties == null) {
                throw new IllegalArgumentException("dynamicProperties is null.");
            }
            this.dynamicProperties = dynamicProperties;
        }

        private Map<String, Object> dynamicProperties = new HashMap<>();

        protected String getDynamicPropertiesLob() {
            return ApplicationContext.current.getClobConverter().toString(getDynamicProperties());
        }

        protected void setDynamicPropertiesLob(String text) {
            getDynamicProperties().clear();
            Map<String, Object> ps = ApplicationContext.current.getClobConverter().parseLobProperties(text);
            if (ps != null) {
                for (Map.Entry<String, Object> kv : ps.entrySet()) {
                    getDynamicProperties().put(kv.getKey(), kv.getValue());
                }
            }
        }

        @Override
        public String getEventType() {
            return "CertificateClobEvent";
        }

    }

    public static class CertificateIssued extends CertificateClobEvent implements CertificateEvent.CertificateIssued {

        @Override
        public String getEventType() {
            return "CertificateIssued";
        }

        public String getInscriptionId() {
            Object val = getDynamicProperties().get("inscriptionId");
            if (val instanceof String) {
                return (String) val;
            }
            return ApplicationContext.current.getTypeConverter().convertValue(val, String.class);
        }

        public void setInscriptionId(String value) {
            getDynamicProperties().put("inscriptionId", value);
        }

        public int[] getInscriptionHash() {
            Object val = getDynamicProperties().get("inscriptionHash");
            if (val instanceof int[]) {
                return (int[]) val;
            }
            return ApplicationContext.current.getTypeConverter().convertValue(val, int[].class);
        }

        public void setInscriptionHash(int[] value) {
            getDynamicProperties().put("inscriptionHash", value);
        }

        public Integer getSlotNumber() {
            Object val = getDynamicProperties().get("slotNumber");
            if (val instanceof Integer) {
                return (Integer) val;
            }
            return ApplicationContext.current.getTypeConverter().convertValue(val, Integer.class);
        }

        public void setSlotNumber(Integer value) {
            getDynamicProperties().put("slotNumber", value);
        }

        public BigInteger getRound() {
            Object val = getDynamicProperties().get("round");
            if (val instanceof BigInteger) {
                return (BigInteger) val;
            }
            return ApplicationContext.current.getTypeConverter().convertValue(val, BigInteger.class);
        }

        public void setRound(BigInteger value) {
            getDynamicProperties().put("round", value);
        }

        public String getInscriber() {
            Object val = getDynamicProperties().get("inscriber");
            if (val instanceof String) {
                return (String) val;
            }
            return ApplicationContext.current.getTypeConverter().convertValue(val, String.class);
        }

        public void setInscriber(String value) {
            getDynamicProperties().put("inscriber", value);
        }

        public BigInteger getInscriptionTimestamp() {
            Object val = getDynamicProperties().get("inscriptionTimestamp");
            if (val instanceof BigInteger) {
                return (BigInteger) val;
            }
            return ApplicationContext.current.getTypeConverter().convertValue(val, BigInteger.class);
        }

        public void setInscriptionTimestamp(BigInteger value) {
            getDynamicProperties().put("inscriptionTimestamp", value);
        }

        public BigInteger getAmount() {
            Object val = getDynamicProperties().get("amount");
            if (val instanceof BigInteger) {
                return (BigInteger) val;
            }
            return ApplicationContext.current.getTypeConverter().convertValue(val, BigInteger.class);
        }

        public void setAmount(BigInteger value) {
            getDynamicProperties().put("amount", value);
        }

        public BigInteger getInscriptionNonce() {
            Object val = getDynamicProperties().get("inscriptionNonce");
            if (val instanceof BigInteger) {
                return (BigInteger) val;
            }
            return ApplicationContext.current.getTypeConverter().convertValue(val, BigInteger.class);
        }

        public void setInscriptionNonce(BigInteger value) {
            getDynamicProperties().put("inscriptionNonce", value);
        }

        public String getInscriptionContent() {
            Object val = getDynamicProperties().get("inscriptionContent");
            if (val instanceof String) {
                return (String) val;
            }
            return ApplicationContext.current.getTypeConverter().convertValue(val, String.class);
        }

        public void setInscriptionContent(String value) {
            getDynamicProperties().put("inscriptionContent", value);
        }

    }


}

