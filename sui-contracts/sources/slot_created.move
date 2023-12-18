// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

module sui_inscription::slot_created {

    use std::option;
    use sui::object;
    use sui_inscription::slot::{Self, SlotCreated};

    public fun id(slot_created: &SlotCreated): option::Option<object::ID> {
        slot::slot_created_id(slot_created)
    }

    public fun slot_number(slot_created: &SlotCreated): u8 {
        slot::slot_created_slot_number(slot_created)
    }

    public fun genesis_timestamp(slot_created: &SlotCreated): u64 {
        slot::slot_created_genesis_timestamp(slot_created)
    }

    public fun slot_max_amount(slot_created: &SlotCreated): u64 {
        slot::slot_created_slot_max_amount(slot_created)
    }

}
