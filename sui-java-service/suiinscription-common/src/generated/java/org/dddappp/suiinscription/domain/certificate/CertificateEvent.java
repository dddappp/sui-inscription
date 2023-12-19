// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

package org.dddappp.suiinscription.domain.certificate;

import java.util.*;
import java.math.BigInteger;
import java.util.Date;
import org.dddappp.suiinscription.domain.*;
import org.dddappp.suiinscription.specialization.Event;

public interface CertificateEvent extends Event, SuiEventEnvelope, SuiMoveEvent, HasStatus {

    interface SqlCertificateEvent extends CertificateEvent {
        CertificateEventId getCertificateEventId();

        boolean getEventReadOnly();

        void setEventReadOnly(boolean readOnly);
    }

    interface CertificateIssued extends CertificateEvent {
        String getInscriptionId();

        void setInscriptionId(String value);

        int[] getInscriptionHash();

        void setInscriptionHash(int[] value);

        Integer getSlotNumber();

        void setSlotNumber(Integer value);

        BigInteger getRound();

        void setRound(BigInteger value);

        String getInscriber();

        void setInscriber(String value);

        BigInteger getInscriptionTimestamp();

        void setInscriptionTimestamp(BigInteger value);

        BigInteger getAmount();

        void setAmount(BigInteger value);

        BigInteger getInscriptionNonce();

        void setInscriptionNonce(BigInteger value);

        String getInscriptionContent();

        void setInscriptionContent(String value);

    }

    String getId();

    //void setId(String id);

    BigInteger getVersion();
    
    //void setVersion(BigInteger version);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    String getCommandId();

    void setCommandId(String commandId);


}

