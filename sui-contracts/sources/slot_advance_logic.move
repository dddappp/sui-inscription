#[allow(unused_variable, unused_use, unused_assignment, unused_mut_parameter)]
module sui_inscription::slot_advance_logic {
    use sui::clock::Clock;
    use sui::tx_context::{Self, TxContext};
    use sui_inscription::slot;
    use sui_inscription::slot_advanced;

    friend sui_inscription::slot_aggregate;

    public(friend) fun verify(
        clock: &Clock,
        slot: &slot::Slot,
        ctx: &TxContext,
    ): slot::SlotAdvanced {
        let round = slot::round(slot);
        slot::new_slot_advanced(
            slot,
            round,// todo to the next round?
        )
    }

    public(friend) fun mutate(
        slot_advanced: &slot::SlotAdvanced,
        slot: &mut slot::Slot,
        ctx: &TxContext, // modify the reference to mutable if needed
    ) {
        let round = slot_advanced::round(slot_advanced);
        let slot_number = slot::slot_number(slot);
        // ...
        //
    }

}
