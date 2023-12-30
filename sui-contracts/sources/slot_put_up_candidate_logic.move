#[allow(unused_variable, unused_use, unused_assignment, unused_mut_parameter)]
module sui_inscription::slot_put_up_candidate_logic {
    use std::hash::sha3_256;
    use std::vector;

    use sui::bcs;
    use sui::clock;
    use sui::clock::Clock;
    use sui::tx_context::TxContext;

    use sui_inscription::byte_util;
    use sui_inscription::candidate_inscription_put_up;
    use sui_inscription::diff;
    use sui_inscription::id_util;
    use sui_inscription::inscription::{Self, Inscription};
    use sui_inscription::slot;
    use sui_inscription::time_util;

    friend sui_inscription::slot_aggregate;

    const EInvalidRound: u64 = 100;
    const EInvalidSlotNumber: u64 = 101;
    //const EInvalidCandidateDifference: u64 = 102;
    const EInvalidAmount: u64 = 103;
    const ENeedToAdvanceRound: u64 = 104;
    const EJumpedTheGun: u64 = 105;

    const MAJOR_DIFFERENCE_SCALE_FACTOR: u64 = 1_000_000;
    const MINT_AMOUNT_LIMIT: u64 = 385802469;

    public(friend) fun verify(
        candidate_inscription: &Inscription,
        clock: &Clock,
        slot: &slot::Slot,
        _ctx: &TxContext,
    ): slot::CandidateInscriptionPutUp {
        assert!(slot::round(slot) == inscription::round(candidate_inscription), EInvalidRound);
        assert!(slot::slot_number(slot) == inscription::slot_number(candidate_inscription), EInvalidSlotNumber);
        assert!(inscription::amount(candidate_inscription) <= MINT_AMOUNT_LIMIT, EInvalidAmount);
        assert!(
            slot::slot_max_amount(slot) >= slot::minted_amount(slot) + inscription::amount(candidate_inscription),
            EInvalidAmount
        );
        let round = slot::round(slot);
        let genesis_timestamp = slot::genesis_timestamp(slot);
        //let current_timestamp = clock::timestamp_ms(clock);
        assert!(
            inscription::timestamp(candidate_inscription) >= time_util::round_started_at(genesis_timestamp, round),
            EJumpedTheGun
        );

        let due_rounds = time_util::count_rounds(slot::genesis_timestamp(slot), clock::timestamp_ms(clock));
        assert!(
            due_rounds <= round || slot::candidate_inscription_id(slot) == id_util::id_placeholder(),
            ENeedToAdvanceRound
        );

        let qualified_difference = slot::qualified_difference(slot);
        let qualified_hash = slot::qualified_hash(slot);
        let qualified_timestamp = slot::qualified_timestamp(slot);
        if (round == 0
            || slot::qualified_inscription_id(slot) == id_util::id_placeholder()
            || slot::qualified_hash(slot) == vector::empty()
            || slot::qualified_timestamp(slot) == 0
        ) {
            //fix for the first round
            qualified_difference = 256 * MAJOR_DIFFERENCE_SCALE_FACTOR;
            qualified_hash = id_util::hash_placeholder();
            qualified_timestamp = genesis_timestamp + time_util::round_duration_ms() / 2;
        };
        let qualified_elapsed_time = time_util::elapsed_time_after_round(
            genesis_timestamp,
            qualified_timestamp,
            slot::qualified_round(slot)
        );

        let candidate_hash = inscription::hash(candidate_inscription);
        let candidte_timestamp = inscription::timestamp(candidate_inscription);
        let candidate_elapsed_time = time_util::elapsed_time_after_round(
            genesis_timestamp,
            candidte_timestamp,
            round
        );
        let elapsed_time_diff = if (candidate_elapsed_time > qualified_elapsed_time) { candidate_elapsed_time - qualified_elapsed_time } else { qualified_elapsed_time - candidate_elapsed_time };
        if (elapsed_time_diff > time_util::round_duration_ms()) {
            candidate_elapsed_time = candidate_elapsed_time + time_util::round_duration_ms();
        };

        let candidate_difference = diff::calculate_difference(
            sha3_256(byte_util::concat(&qualified_hash, bcs::to_bytes(&slot::qualified_inscription_id(slot)))),
            sha3_256(byte_util::concat(&candidate_hash, bcs::to_bytes(&inscription::id(candidate_inscription)))),
            qualified_elapsed_time,
            candidate_elapsed_time
        );

        let idle_rounds = if (due_rounds > round) { due_rounds - round } else { 0 };
        let is_successful: bool;
        if (slot::candidate_inscription_id(slot) == id_util::id_placeholder()) {
            //compare with the qualified inscription
            //assert!(
            is_successful = diff::major_difference_equals_or_less_than(candidate_difference,
                qualified_difference + idle_rounds * MAJOR_DIFFERENCE_SCALE_FACTOR);//, EInvalidCandidateDifference);
        } else {
            //compare with existing candidate inscription
            //assert!(
            is_successful = candidate_difference < slot::candidate_difference(
                slot
            ) + idle_rounds * MAJOR_DIFFERENCE_SCALE_FACTOR;//, EInvalidCandidateDifference);
        };

        if (is_successful) {
            let candidate_inscription_id = inscription::id(candidate_inscription);
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
                inscription::content(candidate_inscription),
                is_successful,
            )
        } else {
            slot::new_candidate_inscription_put_up(
                slot,
                slot::candidate_inscription_id(slot),
                slot::round(slot),
                slot::candidate_hash(slot),
                slot::candidate_inscriber(slot),
                slot::candidate_timestamp(slot),
                slot::candidate_amount(slot),
                slot::candidate_nonce(slot),
                slot::candidate_difference(slot),
                slot::candidate_content(slot),
                is_successful,
            )
        }
    }

    public(friend) fun mutate(
        candidate_inscription_put_up: &slot::CandidateInscriptionPutUp,
        slot: &mut slot::Slot,
        _ctx: &TxContext, // modify the reference to mutable if needed
    ) {
        if (candidate_inscription_put_up::successful(candidate_inscription_put_up) == false) {
            return
        };
        let candidate_inscription_id = candidate_inscription_put_up::candidate_inscription_id(
            candidate_inscription_put_up
        );
        //let slot_number = slot::slot_number(slot);
        slot::set_candidate_inscription_id(slot, candidate_inscription_id);
        slot::set_candidate_hash(slot, candidate_inscription_put_up::candidate_hash(candidate_inscription_put_up));
        slot::set_candidate_inscriber(
            slot,
            candidate_inscription_put_up::candidate_inscriber(candidate_inscription_put_up)
        );
        slot::set_candidate_timestamp(
            slot,
            candidate_inscription_put_up::candidate_timestamp(candidate_inscription_put_up)
        );
        slot::set_candidate_amount(slot, candidate_inscription_put_up::candidate_amount(candidate_inscription_put_up));
        slot::set_candidate_nonce(slot, candidate_inscription_put_up::candidate_nonce(candidate_inscription_put_up));
        slot::set_candidate_difference(
            slot,
            candidate_inscription_put_up::candidate_difference(candidate_inscription_put_up)
        );
        slot::set_candidate_content(
            slot,
            candidate_inscription_put_up::candidate_content(candidate_inscription_put_up)
        );
    }
}
