// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

package org.dddappp.suiinscription.sui.contract.taskservice;

import org.dddappp.suiinscription.sui.contract.service.SlotEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class PullSlotEventsTaskService {

    @Autowired
    private SlotEventService slotEventService;

    @Scheduled(fixedDelayString = "${sui.contract.pull-slot-events.slot-created.fixed-delay:5000}")
    public void pullSlotCreatedEvents() {
        slotEventService.pullSlotCreatedEvents();
    }

    @Scheduled(fixedDelayString = "${sui.contract.pull-slot-events.candidate-inscription-put-up.fixed-delay:5000}")
    public void pullCandidateInscriptionPutUpEvents() {
        slotEventService.pullCandidateInscriptionPutUpEvents();
    }

    @Scheduled(fixedDelayString = "${sui.contract.pull-slot-events.slot-advanced.fixed-delay:5000}")
    public void pullSlotAdvancedEvents() {
        slotEventService.pullSlotAdvancedEvents();
    }

}
