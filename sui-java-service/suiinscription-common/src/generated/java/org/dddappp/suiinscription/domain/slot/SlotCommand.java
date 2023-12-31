// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

package org.dddappp.suiinscription.domain.slot;

import java.util.*;
import java.math.BigInteger;
import java.util.Date;
import org.dddappp.suiinscription.domain.*;
import org.dddappp.suiinscription.domain.Command;
import org.dddappp.suiinscription.specialization.DomainError;

public interface SlotCommand extends Command {

    Integer getSlotNumber();

    void setSlotNumber(Integer slotNumber);

    String getId_();

    void setId_(String id);

    Long getOffChainVersion();

    void setOffChainVersion(Long offChainVersion);

    static void throwOnInvalidStateTransition(SlotState state, Command c) {
        if (state.getOffChainVersion() == null) {
            if (isCommandCreate((SlotCommand)c)) {
                return;
            }
            throw DomainError.named("premature", "Can't do anything to unexistent aggregate");
        }
        if (state.getDeleted() != null && state.getDeleted()) {
            throw DomainError.named("zombie", "Can't do anything to deleted aggregate.");
        }
        if (isCommandCreate((SlotCommand)c))
            throw DomainError.named("rebirth", "Can't create aggregate that already exists");
    }

    static boolean isCommandCreate(SlotCommand c) {
        if (c.getOffChainVersion().equals(SlotState.VERSION_NULL))
            return true;
        return false;
    }

}

