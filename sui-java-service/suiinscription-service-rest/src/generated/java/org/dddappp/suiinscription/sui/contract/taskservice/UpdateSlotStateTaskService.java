// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

package org.dddappp.suiinscription.sui.contract.taskservice;

import org.dddappp.suiinscription.sui.contract.repository.*;
import org.dddappp.suiinscription.sui.contract.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UpdateSlotStateTaskService {

    @Autowired
    private SuiSlotService suiSlotService;

    @Autowired
    private SlotEventRepository slotEventRepository;

    @Autowired
    private SlotEventService slotEventService;

    @Scheduled(fixedDelayString = "${sui.contract.update-slot-states.fixed-delay:5000}")
    @Transactional
    public void updateSlotStates() {
        slotEventRepository.findByStatusIsNull().forEach(e -> {
            String objectId = e.getId_();
            suiSlotService.updateSlotState(objectId);
            slotEventService.updateStatusToProcessed(e);
        });
    }
}
