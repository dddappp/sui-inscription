// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

package org.dddappp.suiinscription.domain.slot;

import java.util.*;
import java.math.BigInteger;
import java.util.Date;
import org.dddappp.suiinscription.domain.*;
import org.dddappp.suiinscription.specialization.*;
import org.dddappp.suiinscription.domain.AbstractEvent;

public abstract class AbstractSlotEvent extends AbstractEvent implements SlotEvent.SqlSlotEvent, SuiEventEnvelope.MutableSuiEventEnvelope, SuiMoveEvent.MutableSuiMoveEvent, HasStatus.MutableHasStatus {
    private SlotEventId slotEventId = new SlotEventId();

    public SlotEventId getSlotEventId() {
        return this.slotEventId;
    }

    public void setSlotEventId(SlotEventId eventId) {
        this.slotEventId = eventId;
    }
    
    public Integer getSlotNumber() {
        return getSlotEventId().getSlotNumber();
    }

    public void setSlotNumber(Integer slotNumber) {
        getSlotEventId().setSlotNumber(slotNumber);
    }

    private boolean eventReadOnly;

    public boolean getEventReadOnly() { return this.eventReadOnly; }

    public void setEventReadOnly(boolean readOnly) { this.eventReadOnly = readOnly; }

    public BigInteger getVersion() {
        return getSlotEventId().getVersion();
    }
    
    public void setVersion(BigInteger version) {
        getSlotEventId().setVersion(version);
    }

    private String id_;

    public String getId_() {
        return this.id_;
    }
    
    public void setId_(String id) {
        this.id_ = id;
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

    protected AbstractSlotEvent() {
    }

    protected AbstractSlotEvent(SlotEventId eventId) {
        this.slotEventId = eventId;
    }


    public abstract String getEventType();

    public static class SlotClobEvent extends AbstractSlotEvent {

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
            return "SlotClobEvent";
        }

    }

    public static class SlotCreated extends SlotClobEvent implements SlotEvent.SlotCreated {

        @Override
        public String getEventType() {
            return "SlotCreated";
        }

        public BigInteger getGenesisTimestamp() {
            Object val = getDynamicProperties().get("genesisTimestamp");
            if (val instanceof BigInteger) {
                return (BigInteger) val;
            }
            return ApplicationContext.current.getTypeConverter().convertValue(val, BigInteger.class);
        }

        public void setGenesisTimestamp(BigInteger value) {
            getDynamicProperties().put("genesisTimestamp", value);
        }

        public BigInteger getSlotMaxAmount() {
            Object val = getDynamicProperties().get("slotMaxAmount");
            if (val instanceof BigInteger) {
                return (BigInteger) val;
            }
            return ApplicationContext.current.getTypeConverter().convertValue(val, BigInteger.class);
        }

        public void setSlotMaxAmount(BigInteger value) {
            getDynamicProperties().put("slotMaxAmount", value);
        }

    }

    public static class CandidateInscriptionPutUpV2 extends SlotClobEvent implements SlotEvent.CandidateInscriptionPutUpV2 {

        @Override
        public String getEventType() {
            return "CandidateInscriptionPutUpV2";
        }

        public String getCandidateInscriptionId() {
            Object val = getDynamicProperties().get("candidateInscriptionId");
            if (val instanceof String) {
                return (String) val;
            }
            return ApplicationContext.current.getTypeConverter().convertValue(val, String.class);
        }

        public void setCandidateInscriptionId(String value) {
            getDynamicProperties().put("candidateInscriptionId", value);
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

        public int[] getCandidateHash() {
            Object val = getDynamicProperties().get("candidateHash");
            if (val instanceof int[]) {
                return (int[]) val;
            }
            return ApplicationContext.current.getTypeConverter().convertValue(val, int[].class);
        }

        public void setCandidateHash(int[] value) {
            getDynamicProperties().put("candidateHash", value);
        }

        public String getCandidateInscriber() {
            Object val = getDynamicProperties().get("candidateInscriber");
            if (val instanceof String) {
                return (String) val;
            }
            return ApplicationContext.current.getTypeConverter().convertValue(val, String.class);
        }

        public void setCandidateInscriber(String value) {
            getDynamicProperties().put("candidateInscriber", value);
        }

        public BigInteger getCandidateTimestamp() {
            Object val = getDynamicProperties().get("candidateTimestamp");
            if (val instanceof BigInteger) {
                return (BigInteger) val;
            }
            return ApplicationContext.current.getTypeConverter().convertValue(val, BigInteger.class);
        }

        public void setCandidateTimestamp(BigInteger value) {
            getDynamicProperties().put("candidateTimestamp", value);
        }

        public BigInteger getCandidateAmount() {
            Object val = getDynamicProperties().get("candidateAmount");
            if (val instanceof BigInteger) {
                return (BigInteger) val;
            }
            return ApplicationContext.current.getTypeConverter().convertValue(val, BigInteger.class);
        }

        public void setCandidateAmount(BigInteger value) {
            getDynamicProperties().put("candidateAmount", value);
        }

        public BigInteger getCandidateNonce() {
            Object val = getDynamicProperties().get("candidateNonce");
            if (val instanceof BigInteger) {
                return (BigInteger) val;
            }
            return ApplicationContext.current.getTypeConverter().convertValue(val, BigInteger.class);
        }

        public void setCandidateNonce(BigInteger value) {
            getDynamicProperties().put("candidateNonce", value);
        }

        public BigInteger getCandidateDifference() {
            Object val = getDynamicProperties().get("candidateDifference");
            if (val instanceof BigInteger) {
                return (BigInteger) val;
            }
            return ApplicationContext.current.getTypeConverter().convertValue(val, BigInteger.class);
        }

        public void setCandidateDifference(BigInteger value) {
            getDynamicProperties().put("candidateDifference", value);
        }

        public String getCandidateContent() {
            Object val = getDynamicProperties().get("candidateContent");
            if (val instanceof String) {
                return (String) val;
            }
            return ApplicationContext.current.getTypeConverter().convertValue(val, String.class);
        }

        public void setCandidateContent(String value) {
            getDynamicProperties().put("candidateContent", value);
        }

        public Boolean getSuccessful() {
            Object val = getDynamicProperties().get("successful");
            if (val instanceof Boolean) {
                return (Boolean) val;
            }
            return ApplicationContext.current.getTypeConverter().convertValue(val, Boolean.class);
        }

        public void setSuccessful(Boolean value) {
            getDynamicProperties().put("successful", value);
        }

    }

    public static class SlotAdvanced extends SlotClobEvent implements SlotEvent.SlotAdvanced {

        @Override
        public String getEventType() {
            return "SlotAdvanced";
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

    }

    public static class CandidateInscriptionPutUp extends SlotClobEvent implements SlotEvent.CandidateInscriptionPutUp {

        @Override
        public String getEventType() {
            return "CandidateInscriptionPutUp";
        }

        public String getCandidateInscriptionId() {
            Object val = getDynamicProperties().get("candidateInscriptionId");
            if (val instanceof String) {
                return (String) val;
            }
            return ApplicationContext.current.getTypeConverter().convertValue(val, String.class);
        }

        public void setCandidateInscriptionId(String value) {
            getDynamicProperties().put("candidateInscriptionId", value);
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

        public int[] getCandidateHash() {
            Object val = getDynamicProperties().get("candidateHash");
            if (val instanceof int[]) {
                return (int[]) val;
            }
            return ApplicationContext.current.getTypeConverter().convertValue(val, int[].class);
        }

        public void setCandidateHash(int[] value) {
            getDynamicProperties().put("candidateHash", value);
        }

        public String getCandidateInscriber() {
            Object val = getDynamicProperties().get("candidateInscriber");
            if (val instanceof String) {
                return (String) val;
            }
            return ApplicationContext.current.getTypeConverter().convertValue(val, String.class);
        }

        public void setCandidateInscriber(String value) {
            getDynamicProperties().put("candidateInscriber", value);
        }

        public BigInteger getCandidateTimestamp() {
            Object val = getDynamicProperties().get("candidateTimestamp");
            if (val instanceof BigInteger) {
                return (BigInteger) val;
            }
            return ApplicationContext.current.getTypeConverter().convertValue(val, BigInteger.class);
        }

        public void setCandidateTimestamp(BigInteger value) {
            getDynamicProperties().put("candidateTimestamp", value);
        }

        public BigInteger getCandidateAmount() {
            Object val = getDynamicProperties().get("candidateAmount");
            if (val instanceof BigInteger) {
                return (BigInteger) val;
            }
            return ApplicationContext.current.getTypeConverter().convertValue(val, BigInteger.class);
        }

        public void setCandidateAmount(BigInteger value) {
            getDynamicProperties().put("candidateAmount", value);
        }

        public BigInteger getCandidateNonce() {
            Object val = getDynamicProperties().get("candidateNonce");
            if (val instanceof BigInteger) {
                return (BigInteger) val;
            }
            return ApplicationContext.current.getTypeConverter().convertValue(val, BigInteger.class);
        }

        public void setCandidateNonce(BigInteger value) {
            getDynamicProperties().put("candidateNonce", value);
        }

        public BigInteger getCandidateDifference() {
            Object val = getDynamicProperties().get("candidateDifference");
            if (val instanceof BigInteger) {
                return (BigInteger) val;
            }
            return ApplicationContext.current.getTypeConverter().convertValue(val, BigInteger.class);
        }

        public void setCandidateDifference(BigInteger value) {
            getDynamicProperties().put("candidateDifference", value);
        }

        public String getCandidateContent() {
            Object val = getDynamicProperties().get("candidateContent");
            if (val instanceof String) {
                return (String) val;
            }
            return ApplicationContext.current.getTypeConverter().convertValue(val, String.class);
        }

        public void setCandidateContent(String value) {
            getDynamicProperties().put("candidateContent", value);
        }

    }


}

