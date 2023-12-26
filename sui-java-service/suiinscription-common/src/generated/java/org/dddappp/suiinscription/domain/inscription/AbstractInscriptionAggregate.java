// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

package org.dddappp.suiinscription.domain.inscription;

import java.util.*;
import java.math.BigInteger;
import java.util.Date;
import org.dddappp.suiinscription.domain.*;
import org.dddappp.suiinscription.specialization.*;

public abstract class AbstractInscriptionAggregate extends AbstractAggregate implements InscriptionAggregate {
    private InscriptionState.MutableInscriptionState state;

    private List<Event> changes = new ArrayList<Event>();

    public AbstractInscriptionAggregate(InscriptionState state) {
        this.state = (InscriptionState.MutableInscriptionState)state;
    }

    public InscriptionState getState() {
        return this.state;
    }

    public List<Event> getChanges() {
        return this.changes;
    }

    public void throwOnInvalidStateTransition(Command c) {
        InscriptionCommand.throwOnInvalidStateTransition(this.state, c);
    }

    protected void apply(Event e) {
        onApplying(e);
        state.mutate(e);
        changes.add(e);
    }


    ////////////////////////

    public static class SimpleInscriptionAggregate extends AbstractInscriptionAggregate {
        public SimpleInscriptionAggregate(InscriptionState state) {
            super(state);
        }

        @Override
        public void mint(Integer slotNumber, BigInteger round, BigInteger amount, BigInteger nonce, String content, String clock, Long offChainVersion, String commandId, String requesterId, InscriptionCommands.Mint c) {
            java.util.function.Supplier<InscriptionEvent.InscriptionMinted> eventFactory = () -> newInscriptionMinted(slotNumber, round, amount, nonce, content, clock, offChainVersion, commandId, requesterId);
            InscriptionEvent.InscriptionMinted e;
            try {
                e = verifyMint(eventFactory, slotNumber, round, amount, nonce, content, c);
            } catch (Exception ex) {
                throw new DomainError("VerificationFailed", ex);
            }

            apply(e);
        }

        @Override
        public void mintV2(Integer slotNumber, BigInteger round, BigInteger amount, BigInteger nonce, String content, String clock, Long offChainVersion, String commandId, String requesterId, InscriptionCommands.MintV2 c) {
            java.util.function.Supplier<InscriptionEvent.InscriptionMinted> eventFactory = () -> newInscriptionMinted(slotNumber, round, amount, nonce, content, clock, offChainVersion, commandId, requesterId);
            InscriptionEvent.InscriptionMinted e;
            try {
                e = verifyMintV2(eventFactory, slotNumber, round, amount, nonce, content, c);
            } catch (Exception ex) {
                throw new DomainError("VerificationFailed", ex);
            }

            apply(e);
        }

        @Override
        public void delete(Long offChainVersion, String commandId, String requesterId, InscriptionCommands.Delete c) {
            java.util.function.Supplier<InscriptionEvent.InscriptionDeleted> eventFactory = () -> newInscriptionDeleted(offChainVersion, commandId, requesterId);
            InscriptionEvent.InscriptionDeleted e;
            try {
                e = verifyDelete(eventFactory, c);
            } catch (Exception ex) {
                throw new DomainError("VerificationFailed", ex);
            }

            apply(e);
        }

        protected InscriptionEvent.InscriptionMinted verifyMint(java.util.function.Supplier<InscriptionEvent.InscriptionMinted> eventFactory, Integer slotNumber, BigInteger round, BigInteger amount, BigInteger nonce, String content, InscriptionCommands.Mint c) {
            Integer SlotNumber = slotNumber;
            BigInteger Round = round;
            BigInteger Amount = amount;
            BigInteger Nonce = nonce;
            String Content = content;

            InscriptionEvent.InscriptionMinted e = (InscriptionEvent.InscriptionMinted) ReflectUtils.invokeStaticMethod(
                    "org.dddappp.suiinscription.domain.inscription.MintLogic",
                    "verify",
                    new Class[]{java.util.function.Supplier.class, InscriptionState.class, Integer.class, BigInteger.class, BigInteger.class, BigInteger.class, String.class, VerificationContext.class},
                    new Object[]{eventFactory, getState(), slotNumber, round, amount, nonce, content, VerificationContext.forCommand(c)}
            );

//package org.dddappp.suiinscription.domain.inscription;
//
//public class MintLogic {
//    public static InscriptionEvent.InscriptionMinted verify(java.util.function.Supplier<InscriptionEvent.InscriptionMinted> eventFactory, InscriptionState inscriptionState, Integer slotNumber, BigInteger round, BigInteger amount, BigInteger nonce, String content, VerificationContext verificationContext) {
//    }
//}

            return e;
        }
           

        protected InscriptionEvent.InscriptionMinted verifyMintV2(java.util.function.Supplier<InscriptionEvent.InscriptionMinted> eventFactory, Integer slotNumber, BigInteger round, BigInteger amount, BigInteger nonce, String content, InscriptionCommands.MintV2 c) {
            Integer SlotNumber = slotNumber;
            BigInteger Round = round;
            BigInteger Amount = amount;
            BigInteger Nonce = nonce;
            String Content = content;

            InscriptionEvent.InscriptionMinted e = (InscriptionEvent.InscriptionMinted) ReflectUtils.invokeStaticMethod(
                    "org.dddappp.suiinscription.domain.inscription.MintV2Logic",
                    "verify",
                    new Class[]{java.util.function.Supplier.class, InscriptionState.class, Integer.class, BigInteger.class, BigInteger.class, BigInteger.class, String.class, VerificationContext.class},
                    new Object[]{eventFactory, getState(), slotNumber, round, amount, nonce, content, VerificationContext.forCommand(c)}
            );

//package org.dddappp.suiinscription.domain.inscription;
//
//public class MintV2Logic {
//    public static InscriptionEvent.InscriptionMinted verify(java.util.function.Supplier<InscriptionEvent.InscriptionMinted> eventFactory, InscriptionState inscriptionState, Integer slotNumber, BigInteger round, BigInteger amount, BigInteger nonce, String content, VerificationContext verificationContext) {
//    }
//}

            return e;
        }
           

        protected InscriptionEvent.InscriptionDeleted verifyDelete(java.util.function.Supplier<InscriptionEvent.InscriptionDeleted> eventFactory, InscriptionCommands.Delete c) {

            InscriptionEvent.InscriptionDeleted e = (InscriptionEvent.InscriptionDeleted) ReflectUtils.invokeStaticMethod(
                    "org.dddappp.suiinscription.domain.inscription.DeleteLogic",
                    "verify",
                    new Class[]{java.util.function.Supplier.class, InscriptionState.class, VerificationContext.class},
                    new Object[]{eventFactory, getState(), VerificationContext.forCommand(c)}
            );

//package org.dddappp.suiinscription.domain.inscription;
//
//public class DeleteLogic {
//    public static InscriptionEvent.InscriptionDeleted verify(java.util.function.Supplier<InscriptionEvent.InscriptionDeleted> eventFactory, InscriptionState inscriptionState, VerificationContext verificationContext) {
//    }
//}

            return e;
        }
           

        protected AbstractInscriptionEvent.InscriptionMinted newInscriptionMinted(Integer slotNumber, BigInteger round, BigInteger amount, BigInteger nonce, String content, String clock, Long offChainVersion, String commandId, String requesterId) {
            InscriptionEventId eventId = new InscriptionEventId(getState().getId(), null);
            AbstractInscriptionEvent.InscriptionMinted e = new AbstractInscriptionEvent.InscriptionMinted();

            e.setSlotNumber(slotNumber);
            e.setRound(round);
            e.setAmount(amount);
            e.setNonce(nonce);
            e.setContent(content);
            e.setInscriber(null);
            e.setTimestamp(null);
            e.setHash(null);
            e.setSuiTimestamp(null);
            e.setSuiTxDigest(null);
            e.setSuiEventSeq(null);
            e.setSuiPackageId(null);
            e.setSuiTransactionModule(null);
            e.setSuiSender(null);
            e.setSuiType(null);
            e.setStatus(null);

            e.setCommandId(commandId);
            e.setCreatedBy(requesterId);
            e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));

            e.setInscriptionEventId(eventId);
            return e;
        }

        protected AbstractInscriptionEvent.InscriptionDeleted newInscriptionDeleted(Long offChainVersion, String commandId, String requesterId) {
            InscriptionEventId eventId = new InscriptionEventId(getState().getId(), null);
            AbstractInscriptionEvent.InscriptionDeleted e = new AbstractInscriptionEvent.InscriptionDeleted();

            e.setSuiTimestamp(null);
            e.setSuiTxDigest(null);
            e.setSuiEventSeq(null);
            e.setSuiPackageId(null);
            e.setSuiTransactionModule(null);
            e.setSuiSender(null);
            e.setSuiType(null);
            e.setStatus(null);

            e.setCommandId(commandId);
            e.setCreatedBy(requesterId);
            e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));

            e.setInscriptionEventId(eventId);
            return e;
        }

    }

}

