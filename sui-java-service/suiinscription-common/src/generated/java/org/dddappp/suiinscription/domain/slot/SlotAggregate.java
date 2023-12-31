// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

package org.dddappp.suiinscription.domain.slot;

import java.util.List;
import java.math.BigInteger;
import java.util.Date;
import org.dddappp.suiinscription.domain.*;
import org.dddappp.suiinscription.specialization.Event;
import org.dddappp.suiinscription.domain.Command;

public interface SlotAggregate {
    SlotState getState();

    List<Event> getChanges();

    void create(String clock, Long offChainVersion, String commandId, String requesterId, SlotCommands.Create c);

    void putUpCandidate(String candidateInscription, String clock, Long offChainVersion, String commandId, String requesterId, SlotCommands.PutUpCandidate c);

    void advance(String clock, Long offChainVersion, String commandId, String requesterId, SlotCommands.Advance c);

    void throwOnInvalidStateTransition(Command c);
}

