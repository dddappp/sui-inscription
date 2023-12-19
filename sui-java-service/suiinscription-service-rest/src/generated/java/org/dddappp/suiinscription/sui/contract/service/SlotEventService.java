// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

package org.dddappp.suiinscription.sui.contract.service;

import com.github.wubuku.sui.bean.EventId;
import com.github.wubuku.sui.bean.Page;
import com.github.wubuku.sui.bean.PaginatedMoveEvents;
import com.github.wubuku.sui.bean.SuiMoveEventEnvelope;
import com.github.wubuku.sui.utils.SuiJsonRpcClient;
import org.dddappp.suiinscription.domain.slot.AbstractSlotEvent;
import org.dddappp.suiinscription.sui.contract.ContractConstants;
import org.dddappp.suiinscription.sui.contract.DomainBeanUtils;
import org.dddappp.suiinscription.sui.contract.SuiPackage;
import org.dddappp.suiinscription.sui.contract.slot.SlotCreated;
import org.dddappp.suiinscription.sui.contract.slot.CandidateInscriptionPutUp;
import org.dddappp.suiinscription.sui.contract.slot.SlotAdvanced;
import org.dddappp.suiinscription.sui.contract.repository.SlotEventRepository;
import org.dddappp.suiinscription.sui.contract.repository.SuiPackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SlotEventService {

    @Autowired
    private SuiPackageRepository suiPackageRepository;

    @Autowired
    private SuiJsonRpcClient suiJsonRpcClient;

    @Autowired
    private SlotEventRepository slotEventRepository;

    @Transactional
    public void updateStatusToProcessed(AbstractSlotEvent event) {
        event.setStatus("D");
        slotEventRepository.save(event);
    }

    @Transactional
    public void pullSlotCreatedEvents() {
        String packageId = getDefaultSuiPackageId();
        if (packageId == null) {
            return;
        }
        int limit = 1;
        EventId cursor = getSlotCreatedEventNextCursor();
        while (true) {
            PaginatedMoveEvents<SlotCreated> eventPage = suiJsonRpcClient.queryMoveEvents(
                    packageId + "::" + ContractConstants.SLOT_MODULE_SLOT_CREATED,
                    cursor, limit, false, SlotCreated.class);

            if (eventPage.getData() != null && !eventPage.getData().isEmpty()) {
                cursor = eventPage.getNextCursor();
                for (SuiMoveEventEnvelope<SlotCreated> eventEnvelope : eventPage.getData()) {
                    saveSlotCreated(eventEnvelope);
                }
            } else {
                break;
            }
            if (!Page.hasNextPage(eventPage)) {
                break;
            }
        }
    }

    private EventId getSlotCreatedEventNextCursor() {
        AbstractSlotEvent lastEvent = slotEventRepository.findFirstSlotCreatedByOrderBySuiTimestampDesc();
        return lastEvent != null ? new EventId(lastEvent.getSuiTxDigest(), lastEvent.getSuiEventSeq() + "") : null;
    }

    private void saveSlotCreated(SuiMoveEventEnvelope<SlotCreated> eventEnvelope) {
        AbstractSlotEvent.SlotCreated slotCreated = DomainBeanUtils.toSlotCreated(eventEnvelope);
        if (slotEventRepository.findById(slotCreated.getSlotEventId()).isPresent()) {
            return;
        }
        slotEventRepository.save(slotCreated);
    }

    @Transactional
    public void pullCandidateInscriptionPutUpEvents() {
        String packageId = getDefaultSuiPackageId();
        if (packageId == null) {
            return;
        }
        int limit = 1;
        EventId cursor = getCandidateInscriptionPutUpEventNextCursor();
        while (true) {
            PaginatedMoveEvents<CandidateInscriptionPutUp> eventPage = suiJsonRpcClient.queryMoveEvents(
                    packageId + "::" + ContractConstants.SLOT_MODULE_CANDIDATE_INSCRIPTION_PUT_UP,
                    cursor, limit, false, CandidateInscriptionPutUp.class);

            if (eventPage.getData() != null && !eventPage.getData().isEmpty()) {
                cursor = eventPage.getNextCursor();
                for (SuiMoveEventEnvelope<CandidateInscriptionPutUp> eventEnvelope : eventPage.getData()) {
                    saveCandidateInscriptionPutUp(eventEnvelope);
                }
            } else {
                break;
            }
            if (!Page.hasNextPage(eventPage)) {
                break;
            }
        }
    }

    private EventId getCandidateInscriptionPutUpEventNextCursor() {
        AbstractSlotEvent lastEvent = slotEventRepository.findFirstCandidateInscriptionPutUpByOrderBySuiTimestampDesc();
        return lastEvent != null ? new EventId(lastEvent.getSuiTxDigest(), lastEvent.getSuiEventSeq() + "") : null;
    }

    private void saveCandidateInscriptionPutUp(SuiMoveEventEnvelope<CandidateInscriptionPutUp> eventEnvelope) {
        AbstractSlotEvent.CandidateInscriptionPutUp candidateInscriptionPutUp = DomainBeanUtils.toCandidateInscriptionPutUp(eventEnvelope);
        if (slotEventRepository.findById(candidateInscriptionPutUp.getSlotEventId()).isPresent()) {
            return;
        }
        slotEventRepository.save(candidateInscriptionPutUp);
    }

    @Transactional
    public void pullSlotAdvancedEvents() {
        String packageId = getDefaultSuiPackageId();
        if (packageId == null) {
            return;
        }
        int limit = 1;
        EventId cursor = getSlotAdvancedEventNextCursor();
        while (true) {
            PaginatedMoveEvents<SlotAdvanced> eventPage = suiJsonRpcClient.queryMoveEvents(
                    packageId + "::" + ContractConstants.SLOT_MODULE_SLOT_ADVANCED,
                    cursor, limit, false, SlotAdvanced.class);

            if (eventPage.getData() != null && !eventPage.getData().isEmpty()) {
                cursor = eventPage.getNextCursor();
                for (SuiMoveEventEnvelope<SlotAdvanced> eventEnvelope : eventPage.getData()) {
                    saveSlotAdvanced(eventEnvelope);
                }
            } else {
                break;
            }
            if (!Page.hasNextPage(eventPage)) {
                break;
            }
        }
    }

    private EventId getSlotAdvancedEventNextCursor() {
        AbstractSlotEvent lastEvent = slotEventRepository.findFirstSlotAdvancedByOrderBySuiTimestampDesc();
        return lastEvent != null ? new EventId(lastEvent.getSuiTxDigest(), lastEvent.getSuiEventSeq() + "") : null;
    }

    private void saveSlotAdvanced(SuiMoveEventEnvelope<SlotAdvanced> eventEnvelope) {
        AbstractSlotEvent.SlotAdvanced slotAdvanced = DomainBeanUtils.toSlotAdvanced(eventEnvelope);
        if (slotEventRepository.findById(slotAdvanced.getSlotEventId()).isPresent()) {
            return;
        }
        slotEventRepository.save(slotAdvanced);
    }


    private String getDefaultSuiPackageId() {
        return suiPackageRepository.findById(ContractConstants.DEFAULT_SUI_PACKAGE_NAME)
                .map(SuiPackage::getObjectId).orElse(null);
    }
}