// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

module sui_inscription::candidate_inscription_put_up {

    use sui::object::{Self, ID};
    use sui_inscription::slot::{Self, CandidateInscriptionPutUp};

    public fun id(candidate_inscription_put_up: &CandidateInscriptionPutUp): object::ID {
        slot::candidate_inscription_put_up_id(candidate_inscription_put_up)
    }

    public fun slot_number(candidate_inscription_put_up: &CandidateInscriptionPutUp): u8 {
        slot::candidate_inscription_put_up_slot_number(candidate_inscription_put_up)
    }

    public fun candidate_inscription_id(candidate_inscription_put_up: &CandidateInscriptionPutUp): ID {
        slot::candidate_inscription_put_up_candidate_inscription_id(candidate_inscription_put_up)
    }

    public fun round(candidate_inscription_put_up: &CandidateInscriptionPutUp): u64 {
        slot::candidate_inscription_put_up_round(candidate_inscription_put_up)
    }

    public fun candidate_hash(candidate_inscription_put_up: &CandidateInscriptionPutUp): vector<u8> {
        slot::candidate_inscription_put_up_candidate_hash(candidate_inscription_put_up)
    }

    public fun candidate_inscriber(candidate_inscription_put_up: &CandidateInscriptionPutUp): address {
        slot::candidate_inscription_put_up_candidate_inscriber(candidate_inscription_put_up)
    }

    public fun candidate_timestamp(candidate_inscription_put_up: &CandidateInscriptionPutUp): u64 {
        slot::candidate_inscription_put_up_candidate_timestamp(candidate_inscription_put_up)
    }

    public fun candidate_amount(candidate_inscription_put_up: &CandidateInscriptionPutUp): u64 {
        slot::candidate_inscription_put_up_candidate_amount(candidate_inscription_put_up)
    }

    public fun candidate_nonce(candidate_inscription_put_up: &CandidateInscriptionPutUp): u128 {
        slot::candidate_inscription_put_up_candidate_nonce(candidate_inscription_put_up)
    }

}
