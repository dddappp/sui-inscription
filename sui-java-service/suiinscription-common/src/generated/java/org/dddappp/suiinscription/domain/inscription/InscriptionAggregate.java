// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

package org.dddappp.suiinscription.domain.inscription;

import java.util.List;
import java.math.BigInteger;
import java.util.Date;
import org.dddappp.suiinscription.domain.*;
import org.dddappp.suiinscription.specialization.Event;
import org.dddappp.suiinscription.domain.Command;

public interface InscriptionAggregate {
    InscriptionState getState();

    List<Event> getChanges();

    void mint(Integer slotNumber, BigInteger round, BigInteger amount, BigInteger nonce, String content, String clock, Long offChainVersion, String commandId, String requesterId, InscriptionCommands.Mint c);

    void mintV2(Integer slotNumber, BigInteger round, BigInteger amount, BigInteger nonce, String content, String clock, Long offChainVersion, String commandId, String requesterId, InscriptionCommands.MintV2 c);

    void delete(Long offChainVersion, String commandId, String requesterId, InscriptionCommands.Delete c);

    void throwOnInvalidStateTransition(Command c);
}

