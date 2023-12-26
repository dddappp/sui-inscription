// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

module sui_inscription::certificate_aggregate {
    use std::string::String;
    use sui::object::ID;
    use sui::tx_context;
    use sui_inscription::certificate;
    use sui_inscription::certificate_issue_logic;

    friend sui_inscription::slot_advance_logic;

    public(friend) fun issue(
        inscription_id: ID,
        inscription_hash: vector<u8>,
        slot_number: u8,
        round: u64,
        inscriber: address,
        inscription_timestamp: u64,
        amount: u64,
        inscription_nonce: u128,
        inscription_content: String,
        ctx: &mut tx_context::TxContext,
    ) {
        let certificate_issued = certificate_issue_logic::verify(
            inscription_id,
            inscription_hash,
            slot_number,
            round,
            inscriber,
            inscription_timestamp,
            amount,
            inscription_nonce,
            inscription_content,
            ctx,
        );
        let certificate = certificate_issue_logic::mutate(
            &certificate_issued,
            ctx,
        );
        certificate::set_certificate_issued_id(&mut certificate_issued, certificate::id(&certificate));
        certificate::transfer_object(certificate, certificate::certificate_issued_inscriber(&certificate_issued));
        certificate::emit_certificate_issued(certificate_issued);
    }

}
