// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

module sui_inscription::inscription_minted {

    use std::option;
    use std::string::String;
    use sui::object;
    use sui_inscription::inscription::{Self, InscriptionMinted};

    public fun id(inscription_minted: &InscriptionMinted): option::Option<object::ID> {
        inscription::inscription_minted_id(inscription_minted)
    }

    public fun slot_number(inscription_minted: &InscriptionMinted): u8 {
        inscription::inscription_minted_slot_number(inscription_minted)
    }

    public fun round(inscription_minted: &InscriptionMinted): u64 {
        inscription::inscription_minted_round(inscription_minted)
    }

    public fun amount(inscription_minted: &InscriptionMinted): u64 {
        inscription::inscription_minted_amount(inscription_minted)
    }

    public fun nonce(inscription_minted: &InscriptionMinted): u128 {
        inscription::inscription_minted_nonce(inscription_minted)
    }

    public fun content(inscription_minted: &InscriptionMinted): String {
        inscription::inscription_minted_content(inscription_minted)
    }

    public fun inscriber(inscription_minted: &InscriptionMinted): address {
        inscription::inscription_minted_inscriber(inscription_minted)
    }

    public fun timestamp(inscription_minted: &InscriptionMinted): u64 {
        inscription::inscription_minted_timestamp(inscription_minted)
    }

    public fun hash(inscription_minted: &InscriptionMinted): vector<u8> {
        inscription::inscription_minted_hash(inscription_minted)
    }

}
