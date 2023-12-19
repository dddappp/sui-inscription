// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

package org.dddappp.suiinscription.domain.certificate;

import java.util.*;
import java.math.BigInteger;
import java.util.Date;
import org.dddappp.suiinscription.domain.*;
import org.dddappp.suiinscription.domain.Command;
import org.dddappp.suiinscription.specialization.DomainError;

public interface CertificateCommand extends Command {

    String getId();

    void setId(String id);

    Long getOffChainVersion();

    void setOffChainVersion(Long offChainVersion);

    static void throwOnInvalidStateTransition(CertificateState state, Command c) {
        if (state.getOffChainVersion() == null) {
            if (isCommandCreate((CertificateCommand)c)) {
                return;
            }
            throw DomainError.named("premature", "Can't do anything to unexistent aggregate");
        }
        if (state.getDeleted() != null && state.getDeleted()) {
            throw DomainError.named("zombie", "Can't do anything to deleted aggregate.");
        }
        if (isCommandCreate((CertificateCommand)c))
            throw DomainError.named("rebirth", "Can't create aggregate that already exists");
    }

    static boolean isCommandCreate(CertificateCommand c) {
        if (c.getOffChainVersion().equals(CertificateState.VERSION_NULL))
            return true;
        return false;
    }

}
