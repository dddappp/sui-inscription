// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

package org.dddappp.suiinscription.domain.slot;

import java.util.*;
import java.math.*;
import java.math.BigInteger;
import java.util.Date;
import org.dddappp.suiinscription.domain.*;
import org.dddappp.suiinscription.specialization.Event;

public interface SlotState extends VersionedSuiMoveObject
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    Integer getSlotNumber();

    String getId_();

    BigInteger getGenesisTimestamp();

    BigInteger getSlotMaxAmount();

    BigInteger getMintedAmount();

    BigInteger getRound();

    BigInteger getQualifiedRound();

    String getQualifiedInscriptionId();

    int[] getQualifiedHash();

    BigInteger getQualifiedTimestamp();

    BigInteger getQualifiedDifference();

    String getCandidateInscriptionId();

    int[] getCandidateHash();

    String getCandidateInscriber();

    BigInteger getCandidateTimestamp();

    BigInteger getCandidateAmount();

    BigInteger getCandidateNonce();

    BigInteger getCandidateDifference();

    String getCandidateContent();

    Long getOffChainVersion();

    String getCreatedBy();

    Date getCreatedAt();

    String getUpdatedBy();

    Date getUpdatedAt();

    Boolean getActive();

    Boolean getDeleted();

    interface MutableSlotState extends SlotState, VersionedSuiMoveObject.MutableVersionedSuiMoveObject {
        void setSlotNumber(Integer slotNumber);

        void setId_(String id);

        void setGenesisTimestamp(BigInteger genesisTimestamp);

        void setSlotMaxAmount(BigInteger slotMaxAmount);

        void setMintedAmount(BigInteger mintedAmount);

        void setRound(BigInteger round);

        void setQualifiedRound(BigInteger qualifiedRound);

        void setQualifiedInscriptionId(String qualifiedInscriptionId);

        void setQualifiedHash(int[] qualifiedHash);

        void setQualifiedTimestamp(BigInteger qualifiedTimestamp);

        void setQualifiedDifference(BigInteger qualifiedDifference);

        void setCandidateInscriptionId(String candidateInscriptionId);

        void setCandidateHash(int[] candidateHash);

        void setCandidateInscriber(String candidateInscriber);

        void setCandidateTimestamp(BigInteger candidateTimestamp);

        void setCandidateAmount(BigInteger candidateAmount);

        void setCandidateNonce(BigInteger candidateNonce);

        void setCandidateDifference(BigInteger candidateDifference);

        void setCandidateContent(String candidateContent);

        void setOffChainVersion(Long offChainVersion);

        void setCreatedBy(String createdBy);

        void setCreatedAt(Date createdAt);

        void setUpdatedBy(String updatedBy);

        void setUpdatedAt(Date updatedAt);

        void setActive(Boolean active);

        void setDeleted(Boolean deleted);


        void mutate(Event e);

        //void when(SlotEvent.SlotStateCreated e);

        //void when(SlotEvent.SlotStateMergePatched e);

        //void when(SlotEvent.SlotStateDeleted e);
    }

    interface SqlSlotState extends MutableSlotState {

        boolean isStateUnsaved();

        boolean getForReapplying();
    }
}

