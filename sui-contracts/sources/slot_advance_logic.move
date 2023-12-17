#[allow(unused_variable, unused_use, unused_mut_parameter, unused_assignment)]
module sui_inscription::slot_advance_logic {
    use sui::clock::Clock;
    use sui::tx_context::{Self, TxContext};
    use sui_inscription::candidate_inscription_put_up::candidate_inscription_id;
    use sui_inscription::inscription::{Self, Inscription};
    use sui_inscription::slot;
    use sui_inscription::slot_advanced;

    friend sui_inscription::slot_aggregate;

    public(friend) fun verify(
        candidate_inscription: &Inscription,
        witness_inscription: &Inscription,
        clock: &Clock,
        slot: &slot::Slot,
        ctx: &TxContext,
    ): slot::SlotAdvanced {
        let candidate_inscription_id = inscription::id(candidate_inscription);
        let witness_inscription_id = inscription::id(witness_inscription);
        slot::new_slot_advanced(
            slot,
            candidate_inscription_id,
            witness_inscription_id,
        )
    }

    public(friend) fun mutate(
        slot_advanced: &slot::SlotAdvanced,
        slot: &mut slot::Slot,
        ctx: &TxContext, // modify the reference to mutable if needed
    ) {
        let candidate_inscription_id = slot_advanced::candidate_inscription_id(slot_advanced);
        let witness_inscription_id = slot_advanced::witness_inscription_id(slot_advanced);
        let slot_number = slot::slot_number(slot);
        // ...
        //
    }

}
