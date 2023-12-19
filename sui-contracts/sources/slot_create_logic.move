#[allow(unused_variable, unused_use, unused_assignment, unused_mut_parameter)]
module sui_inscription::slot_create_logic {
    use sui::clock::Clock;
    use sui::object::{Self, UID};
    use sui::tx_context::{Self, TxContext};
    use sui_inscription::slot;
    use sui_inscription::slot_created;

    friend sui_inscription::slot_aggregate;

    public(friend) fun verify(
        slot_number: u8,
        clock: &Clock,
        slot_number_table: &slot::SlotNumberTable,
        ctx: &mut TxContext,
    ): slot::SlotCreated {
        //slot::asset_slot_number_not_exists(slot_number, slot_number_table);
        //slot::new_slot_created(
        //    // ...
        //)
    }

    public(friend) fun mutate(
        slot_created: &slot::SlotCreated,
        slot_number_table: &mut slot::SlotNumberTable,
        ctx: &mut TxContext,
    ): slot::Slot {
        let slot_number = slot_created::slot_number(slot_created);
        let genesis_timestamp = slot_created::genesis_timestamp(slot_created);
        let slot_max_amount = slot_created::slot_max_amount(slot_created);
        //let slot = slot::create_slot(
        //    //...
        //    slot_number_table,
        //);
        //slot
    }

}
