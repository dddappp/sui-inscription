#[allow(unused_variable, unused_use, unused_assignment, unused_mut_parameter)]
module sui_inscription::slot_create_logic {
    use std::vector;
    use std::string;

    use sui::clock::{Self, Clock};
    use sui::tx_context::TxContext;

    use sui_inscription::id_util;
    use sui_inscription::slot;
    use sui_inscription::slot_created;

    friend sui_inscription::slot_aggregate;

    const EWrongSlotNumber: u64 = 100;

    const MAX_SLOT_NUMBER: u8 = 209;
    const SLOT_MAX_AMOUNT: u64 = 9_999_999_996_480;
    const LAST_SLOT_SUPPLEMENT: u64 = 739_200;
    const MAJOR_DIFFERENCE_SCALE_FACTOR: u64 = 1_000_000;

    public(friend) fun verify(
        slot_number: u8,
        clock: &Clock,
        slot_number_table: &slot::SlotNumberTable,
        _ctx: &mut TxContext,
    ): slot::SlotCreated {
        assert!(slot_number <= MAX_SLOT_NUMBER, EWrongSlotNumber);
        slot::asset_slot_number_not_exists(slot_number, slot_number_table);
        let genesis_timestamp = clock::timestamp_ms(clock);
        let slot_max_amount = if (slot_number == MAX_SLOT_NUMBER) { SLOT_MAX_AMOUNT + LAST_SLOT_SUPPLEMENT } else { SLOT_MAX_AMOUNT };
        slot::new_slot_created(
            slot_number,
            genesis_timestamp,
            slot_max_amount,
        )
    }

    public(friend) fun mutate(
        slot_created: &slot::SlotCreated,
        slot_number_table: &mut slot::SlotNumberTable,
        ctx: &mut TxContext,
    ): slot::Slot {
        let slot_number = slot_created::slot_number(slot_created);
        let genesis_timestamp = slot_created::genesis_timestamp(slot_created);
        let slot_max_amount = slot_created::slot_max_amount(slot_created);
        slot::create_slot(
            slot_number,
            genesis_timestamp,
            slot_max_amount,
            id_util::id_placeholder(),
            vector::empty(),
            0,
            256 * MAJOR_DIFFERENCE_SCALE_FACTOR,
            id_util::id_placeholder(),
            vector::empty(),
            id_util::address_placeholder(),
            0,
            0,
            0,
            256 * MAJOR_DIFFERENCE_SCALE_FACTOR,
            string::utf8(b""),
            slot_number_table,
            ctx,
        )
    }
}
