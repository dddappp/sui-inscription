// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

module sui_inscription::certificate {
    use std::option;
    use std::string::String;
    use sui::event;
    use sui::object::{Self, ID, UID};
    use sui::transfer;
    use sui::tx_context::TxContext;
    friend sui_inscription::certificate_issue_logic;
    friend sui_inscription::certificate_aggregate;

    #[allow(unused_const)]
    const EDataTooLong: u64 = 102;

    struct Certificate has key, store {
        id: UID,
        inscription_id: ID,
        inscription_hash: vector<u8>,
        slot_number: u8,
        round: u64,
        inscriber: address,
        inscription_timestamp: u64,
        amount: u64,
        inscription_nonce: u128,
        inscription_content: String,
    }

    public fun id(certificate: &Certificate): object::ID {
        object::uid_to_inner(&certificate.id)
    }

    public fun inscription_id(certificate: &Certificate): ID {
        certificate.inscription_id
    }

    public(friend) fun set_inscription_id(certificate: &mut Certificate, inscription_id: ID) {
        certificate.inscription_id = inscription_id;
    }

    public fun inscription_hash(certificate: &Certificate): vector<u8> {
        certificate.inscription_hash
    }

    public(friend) fun set_inscription_hash(certificate: &mut Certificate, inscription_hash: vector<u8>) {
        certificate.inscription_hash = inscription_hash;
    }

    public fun slot_number(certificate: &Certificate): u8 {
        certificate.slot_number
    }

    public(friend) fun set_slot_number(certificate: &mut Certificate, slot_number: u8) {
        certificate.slot_number = slot_number;
    }

    public fun round(certificate: &Certificate): u64 {
        certificate.round
    }

    public(friend) fun set_round(certificate: &mut Certificate, round: u64) {
        certificate.round = round;
    }

    public fun inscriber(certificate: &Certificate): address {
        certificate.inscriber
    }

    public(friend) fun set_inscriber(certificate: &mut Certificate, inscriber: address) {
        certificate.inscriber = inscriber;
    }

    public fun inscription_timestamp(certificate: &Certificate): u64 {
        certificate.inscription_timestamp
    }

    public(friend) fun set_inscription_timestamp(certificate: &mut Certificate, inscription_timestamp: u64) {
        certificate.inscription_timestamp = inscription_timestamp;
    }

    public fun amount(certificate: &Certificate): u64 {
        certificate.amount
    }

    public(friend) fun set_amount(certificate: &mut Certificate, amount: u64) {
        certificate.amount = amount;
    }

    public fun inscription_nonce(certificate: &Certificate): u128 {
        certificate.inscription_nonce
    }

    public(friend) fun set_inscription_nonce(certificate: &mut Certificate, inscription_nonce: u128) {
        certificate.inscription_nonce = inscription_nonce;
    }

    public fun inscription_content(certificate: &Certificate): String {
        certificate.inscription_content
    }

    public(friend) fun set_inscription_content(certificate: &mut Certificate, inscription_content: String) {
        assert!(std::string::length(&inscription_content) <= 1000, EDataTooLong);
        certificate.inscription_content = inscription_content;
    }

    public(friend) fun new_certificate(
        inscription_id: ID,
        inscription_hash: vector<u8>,
        slot_number: u8,
        round: u64,
        inscriber: address,
        inscription_timestamp: u64,
        amount: u64,
        inscription_nonce: u128,
        inscription_content: String,
        ctx: &mut TxContext,
    ): Certificate {
        assert!(std::string::length(&inscription_content) <= 1000, EDataTooLong);
        Certificate {
            id: object::new(ctx),
            inscription_id,
            inscription_hash,
            slot_number,
            round,
            inscriber,
            inscription_timestamp,
            amount,
            inscription_nonce,
            inscription_content,
        }
    }

    struct CertificateIssued has copy, drop {
        id: option::Option<object::ID>,
        inscription_id: ID,
        inscription_hash: vector<u8>,
        slot_number: u8,
        round: u64,
        inscriber: address,
        inscription_timestamp: u64,
        amount: u64,
        inscription_nonce: u128,
        inscription_content: String,
    }

    public fun certificate_issued_id(certificate_issued: &CertificateIssued): option::Option<object::ID> {
        certificate_issued.id
    }

    public(friend) fun set_certificate_issued_id(certificate_issued: &mut CertificateIssued, id: object::ID) {
        certificate_issued.id = option::some(id);
    }

    public fun certificate_issued_inscription_id(certificate_issued: &CertificateIssued): ID {
        certificate_issued.inscription_id
    }

    public fun certificate_issued_inscription_hash(certificate_issued: &CertificateIssued): vector<u8> {
        certificate_issued.inscription_hash
    }

    public fun certificate_issued_slot_number(certificate_issued: &CertificateIssued): u8 {
        certificate_issued.slot_number
    }

    public fun certificate_issued_round(certificate_issued: &CertificateIssued): u64 {
        certificate_issued.round
    }

    public fun certificate_issued_inscriber(certificate_issued: &CertificateIssued): address {
        certificate_issued.inscriber
    }

    public fun certificate_issued_inscription_timestamp(certificate_issued: &CertificateIssued): u64 {
        certificate_issued.inscription_timestamp
    }

    public fun certificate_issued_amount(certificate_issued: &CertificateIssued): u64 {
        certificate_issued.amount
    }

    public fun certificate_issued_inscription_nonce(certificate_issued: &CertificateIssued): u128 {
        certificate_issued.inscription_nonce
    }

    public fun certificate_issued_inscription_content(certificate_issued: &CertificateIssued): String {
        certificate_issued.inscription_content
    }

    public(friend) fun new_certificate_issued(
        inscription_id: ID,
        inscription_hash: vector<u8>,
        slot_number: u8,
        round: u64,
        inscriber: address,
        inscription_timestamp: u64,
        amount: u64,
        inscription_nonce: u128,
        inscription_content: String,
    ): CertificateIssued {
        CertificateIssued {
            id: option::none(),
            inscription_id,
            inscription_hash,
            slot_number,
            round,
            inscriber,
            inscription_timestamp,
            amount,
            inscription_nonce,
            inscription_content,
        }
    }


    #[lint_allow(custom_state_change)]
    public(friend) fun transfer_object(certificate: Certificate, recipient: address) {
        transfer::transfer(certificate, recipient);
    }

    #[lint_allow(share_owned, custom_state_change)]
    public(friend) fun share_object(certificate: Certificate) {
        transfer::share_object(certificate);
    }

    #[lint_allow(custom_state_change)]
    public(friend) fun freeze_object(certificate: Certificate) {
        transfer::freeze_object(certificate);
    }

    public(friend) fun drop_certificate(certificate: Certificate) {
        let Certificate {
            id,
            inscription_id: _inscription_id,
            inscription_hash: _inscription_hash,
            slot_number: _slot_number,
            round: _round,
            inscriber: _inscriber,
            inscription_timestamp: _inscription_timestamp,
            amount: _amount,
            inscription_nonce: _inscription_nonce,
            inscription_content: _inscription_content,
        } = certificate;
        object::delete(id);
    }

    public(friend) fun emit_certificate_issued(certificate_issued: CertificateIssued) {
        event::emit(certificate_issued);
    }

}
