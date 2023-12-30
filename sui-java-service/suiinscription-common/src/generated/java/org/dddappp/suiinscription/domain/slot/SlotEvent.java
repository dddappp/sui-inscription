// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

package org.dddappp.suiinscription.domain.slot;

import java.util.*;
import java.math.BigInteger;
import java.util.Date;
import org.dddappp.suiinscription.domain.*;
import org.dddappp.suiinscription.specialization.Event;

public interface SlotEvent extends Event, SuiEventEnvelope, SuiMoveEvent, HasStatus {

    interface SqlSlotEvent extends SlotEvent {
        SlotEventId getSlotEventId();

        boolean getEventReadOnly();

        void setEventReadOnly(boolean readOnly);
    }

    interface SlotCreated extends SlotEvent {
        BigInteger getGenesisTimestamp();

        void setGenesisTimestamp(BigInteger value);

        BigInteger getSlotMaxAmount();

        void setSlotMaxAmount(BigInteger value);

    }

    interface CandidateInscriptionPutUp extends SlotEvent {
        String getCandidateInscriptionId();

        void setCandidateInscriptionId(String value);

        BigInteger getRound();

        void setRound(BigInteger value);

        int[] getCandidateHash();

        void setCandidateHash(int[] value);

        String getCandidateInscriber();

        void setCandidateInscriber(String value);

        BigInteger getCandidateTimestamp();

        void setCandidateTimestamp(BigInteger value);

        BigInteger getCandidateAmount();

        void setCandidateAmount(BigInteger value);

        BigInteger getCandidateNonce();

        void setCandidateNonce(BigInteger value);

        BigInteger getCandidateDifference();

        void setCandidateDifference(BigInteger value);

        String getCandidateContent();

        void setCandidateContent(String value);

        Boolean getSuccessful();

        void setSuccessful(Boolean value);

    }

    interface SlotAdvanced extends SlotEvent {
        BigInteger getRound();

        void setRound(BigInteger value);

    }

    Integer getSlotNumber();

    //void setSlotNumber(Integer slotNumber);

    BigInteger getVersion();
    
    //void setVersion(BigInteger version);

    String getId_();
    
    //void setId_(String id);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    String getCommandId();

    void setCommandId(String commandId);


}

