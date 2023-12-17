#[allow(unused_variable, unused_use, unused_mut_parameter, unused_assignment)]
module sui_inscription::slot_create_logic {
    use sui::object::ID;
    use sui::tx_context::TxContext;
    use sui_inscription::slot;
    use sui_inscription::slot_created;

    friend sui_inscription::slot_aggregate;

    public(friend) fun verify(
        slot_number: u8,
        genesis_timestamp: u64,
        minted_amount: u64,
        qualified_round: u64,
        qualified_inscription_id: ID,
        qualified_hash: vector<u8>,
        qualified_timestamp: u64,
        qualified_difference: u64,
        candidate_inscription_id: ID,
        candidate_hash: vector<u8>,
        candidate_timestamp: u64,
        candidate_difference: u64,
        slot_number_table: &slot::SlotNumberTable,
        ctx: &mut TxContext,
    ): slot::SlotCreated {
        let _ = ctx;
        slot::asset_slot_number_not_exists(slot_number, slot_number_table);
        slot::new_slot_created(
            slot_number,
            genesis_timestamp,
            minted_amount,
            qualified_round,
            qualified_inscription_id,
            qualified_hash,
            qualified_timestamp,
            qualified_difference,
            candidate_inscription_id,
            candidate_hash,
            candidate_timestamp,
            candidate_difference,
        )
    }

    public(friend) fun mutate(
        slot_created: &slot::SlotCreated,
        slot_number_table: &mut slot::SlotNumberTable,
        ctx: &mut TxContext,
    ): slot::Slot {
        let slot_number = slot_created::slot_number(slot_created);
        let genesis_timestamp = slot_created::genesis_timestamp(slot_created);
        let minted_amount = slot_created::minted_amount(slot_created);
        let qualified_round = slot_created::qualified_round(slot_created);
        let qualified_inscription_id = slot_created::qualified_inscription_id(slot_created);
        let qualified_hash = slot_created::qualified_hash(slot_created);
        let qualified_timestamp = slot_created::qualified_timestamp(slot_created);
        let qualified_difference = slot_created::qualified_difference(slot_created);
        let candidate_inscription_id = slot_created::candidate_inscription_id(slot_created);
        let candidate_hash = slot_created::candidate_hash(slot_created);
        let candidate_timestamp = slot_created::candidate_timestamp(slot_created);
        let candidate_difference = slot_created::candidate_difference(slot_created);
        slot::create_slot(
            slot_number,
            genesis_timestamp,
            minted_amount,
            qualified_round,
            qualified_inscription_id,
            qualified_hash,
            qualified_timestamp,
            qualified_difference,
            candidate_inscription_id,
            candidate_hash,
            candidate_timestamp,
            candidate_difference,
            slot_number_table,
            ctx,
        )
    }

}
