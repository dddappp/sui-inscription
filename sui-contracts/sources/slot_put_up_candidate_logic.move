#[allow(unused_variable, unused_use, unused_assignment, unused_mut_parameter)]
module sui_inscription::slot_put_up_candidate_logic {
    use sui::clock::Clock;
    use sui::tx_context::{Self, TxContext};
    use sui_inscription::inscription::{Self, Inscription};
    use sui_inscription::candidate_inscription_put_up;
    use sui_inscription::slot;

    friend sui_inscription::slot_aggregate;

    const EInvalidRound: u64 = 100;
    const EInvalidSlotNumber: u64 = 101;

    public(friend) fun verify(
        candidate_inscription: &Inscription,
        clock: &Clock,
        slot: &slot::Slot,
        ctx: &TxContext,
    ): slot::CandidateInscriptionPutUp {
        assert!(slot::round(slot) == inscription::round(candidate_inscription), EInvalidRound);
        assert!(slot::slot_number(slot) == inscription::slot_number(candidate_inscription), EInvalidSlotNumber);

        //todo calculate candidate_difference
        let candidate_difference = 0;
        let candidate_inscription_id = inscription::id(candidate_inscription);
        let round = slot::round(slot);
        slot::new_candidate_inscription_put_up(
            slot,
            candidate_inscription_id,
            round,
            inscription::hash(candidate_inscription),
            inscription::inscriber(candidate_inscription),
            inscription::timestamp(candidate_inscription),
            inscription::amount(candidate_inscription),
            inscription::nonce(candidate_inscription),
            candidate_difference,
        )
    }

    public(friend) fun mutate(
        candidate_inscription_put_up: &slot::CandidateInscriptionPutUp,
        slot: &mut slot::Slot,
        _ctx: &TxContext, // modify the reference to mutable if needed
    ) {
        let candidate_inscription_id = candidate_inscription_put_up::candidate_inscription_id(candidate_inscription_put_up);
        //let slot_number = slot::slot_number(slot);
        slot::set_candidate_inscription_id(slot, candidate_inscription_id);
        slot::set_candidate_hash(slot, candidate_inscription_put_up::candidate_hash(candidate_inscription_put_up));
        slot::set_candidate_inscriber(slot, candidate_inscription_put_up::candidate_inscriber(candidate_inscription_put_up));
        slot::set_candidate_timestamp(slot, candidate_inscription_put_up::candidate_timestamp(candidate_inscription_put_up));
        slot::set_candidate_amount(slot, candidate_inscription_put_up::candidate_amount(candidate_inscription_put_up));
        slot::set_candidate_nonce(slot, candidate_inscription_put_up::candidate_nonce(candidate_inscription_put_up));
        slot::set_candidate_difference(slot, candidate_inscription_put_up::candidate_difference(candidate_inscription_put_up));
    }

}
