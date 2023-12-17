#[allow(unused_variable, unused_use, unused_assignment, unused_mut_parameter)]
module sui_inscription::slot_put_up_candidate_logic {
    use sui::clock::Clock;
    use sui::tx_context::{Self, TxContext};
    use sui_inscription::inscription::{Self, Inscription};
    use sui_inscription::candidate_inscription_put_up;
    use sui_inscription::slot;

    friend sui_inscription::slot_aggregate;

    public(friend) fun verify(
        cadidate_inscription: &Inscription,
        clock: &Clock,
        slot: &slot::Slot,
        ctx: &TxContext,
    ): slot::CandidateInscriptionPutUp {
        let cadidate_inscription_id = inscription::id(cadidate_inscription);
        slot::new_candidate_inscription_put_up(
            slot,
            cadidate_inscription_id,
        )
    }

    public(friend) fun mutate(
        candidate_inscription_put_up: &slot::CandidateInscriptionPutUp,
        slot: &mut slot::Slot,
        ctx: &TxContext, // modify the reference to mutable if needed
    ) {
        let cadidate_inscription_id = candidate_inscription_put_up::cadidate_inscription_id(candidate_inscription_put_up);
        let slot_number = slot::slot_number(slot);
        // ...
        //
    }

}
