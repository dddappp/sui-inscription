#[allow(unused_variable, unused_use, unused_assignment, unused_mut_parameter)]
module sui_inscription::slot_advance_logic {
    use sui::clock::{Self, Clock};
    use sui::tx_context::TxContext;

    use sui_inscription::certificate_aggregate;
    use sui_inscription::id_util;
    use sui_inscription::slot;
    use sui_inscription::time_util;

    const ECurrentRoundNotFinished: u64 = 100;
    const ENoCandidate: u64 = 101;

    friend sui_inscription::slot_aggregate;

    public(friend) fun verify(
        clock: &Clock,
        slot: &slot::Slot,
        _ctx: &TxContext,
    ): slot::SlotAdvanced {
        let round = slot::round(slot);
        let due_rounds = time_util::count_rounds(slot::genesis_timestamp(slot), clock::timestamp_ms(clock));
        assert!(due_rounds > round, ECurrentRoundNotFinished);
        assert!(id_util::id_placeholder() != slot::candidate_inscription_id(slot), ENoCandidate);
        slot::new_slot_advanced(
            slot,
            round, //or use the next-round?
        )
    }

    public(friend) fun mutate(
        _slot_advanced: &slot::SlotAdvanced,
        slot: &mut slot::Slot,
        _ctx: &mut TxContext, // modify the reference to mutable if needed
    ) {
        //let round = slot_advanced::round(slot_advanced);
        let qualified_round = slot::round(slot);
        let slot_number = slot::slot_number(slot);

        let inscription_id = slot::candidate_inscription_id(slot);
        let inscription_hash = slot::candidate_hash(slot);
        let inscriber = slot::candidate_inscriber(slot);
        let inscription_timestamp = slot::candidate_timestamp(slot);
        let amount = slot::candidate_amount(slot);
        let inscription_nonce = slot::candidate_nonce(slot);

        certificate_aggregate::issue(
            inscription_id,
            inscription_hash,
            slot_number,
            qualified_round,
            inscriber,
            inscription_timestamp,
            amount,
            inscription_nonce,
            _ctx,
        );
        // update amount
        let minted_amount = slot::minted_amount(slot);
        slot::set_minted_amount(slot, minted_amount + amount);

        slot::set_qualified_round(slot, qualified_round);
        slot::set_qualified_inscription_id(slot, inscription_id);
        slot::set_qualified_hash(slot, inscription_hash);
        slot::set_qualified_timestamp(slot, inscription_timestamp);
        let candidate_difference = slot::candidate_difference(slot);
        slot::set_qualified_difference(slot, candidate_difference);

        slot::set_candidate_inscription_id(slot, id_util::id_placeholder());
        slot::set_round(slot, qualified_round + 1);
    }
}
