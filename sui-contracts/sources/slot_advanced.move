// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

module sui_inscription::slot_advanced {

    use sui::object::{Self, ID};
    use sui_inscription::slot::{Self, SlotAdvanced};

    public fun id(slot_advanced: &SlotAdvanced): object::ID {
        slot::slot_advanced_id(slot_advanced)
    }

    public fun slot_number(slot_advanced: &SlotAdvanced): u8 {
        slot::slot_advanced_slot_number(slot_advanced)
    }

    public fun cadidate_inscription_id(slot_advanced: &SlotAdvanced): ID {
        slot::slot_advanced_cadidate_inscription_id(slot_advanced)
    }

    public fun witness_inscription_id(slot_advanced: &SlotAdvanced): ID {
        slot::slot_advanced_witness_inscription_id(slot_advanced)
    }

}
