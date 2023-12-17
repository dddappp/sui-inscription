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
    const EInappropriateVersion: u64 = 103;

    struct Certificate has key {
        id: UID,
        version: u64,
        inscription_object_id: ID,
        inscription_hash: vector<u8>,
        slot_number: u8,
        round: u64,
        inscriber: address,
        inscription_timestamp: u64,
        amount: u64,
        inscription_content: String,
        certificate_type: u8,
    }

    public fun id(certificate: &Certificate): object::ID {
        object::uid_to_inner(&certificate.id)
    }

    public fun version(certificate: &Certificate): u64 {
        certificate.version
    }

    public fun inscription_object_id(certificate: &Certificate): ID {
        certificate.inscription_object_id
    }

    public(friend) fun set_inscription_object_id(certificate: &mut Certificate, inscription_object_id: ID) {
        certificate.inscription_object_id = inscription_object_id;
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

    public fun inscription_content(certificate: &Certificate): String {
        certificate.inscription_content
    }

    public(friend) fun set_inscription_content(certificate: &mut Certificate, inscription_content: String) {
        assert!(std::string::length(&inscription_content) <= 1000, EDataTooLong);
        certificate.inscription_content = inscription_content;
    }

    public fun certificate_type(certificate: &Certificate): u8 {
        certificate.certificate_type
    }

    public(friend) fun set_certificate_type(certificate: &mut Certificate, certificate_type: u8) {
        certificate.certificate_type = certificate_type;
    }

    public(friend) fun new_certificate(
        inscription_object_id: ID,
        inscription_hash: vector<u8>,
        slot_number: u8,
        round: u64,
        inscriber: address,
        inscription_timestamp: u64,
        amount: u64,
        inscription_content: String,
        certificate_type: u8,
        ctx: &mut TxContext,
    ): Certificate {
        assert!(std::string::length(&inscription_content) <= 1000, EDataTooLong);
        Certificate {
            id: object::new(ctx),
            version: 0,
            inscription_object_id,
            inscription_hash,
            slot_number,
            round,
            inscriber,
            inscription_timestamp,
            amount,
            inscription_content,
            certificate_type,
        }
    }

    struct CertificateIssued has copy, drop {
        id: option::Option<object::ID>,
        inscription_object_id: ID,
        inscription_hash: vector<u8>,
        slot_number: u8,
        round: u64,
        inscriber: address,
        inscription_timestamp: u64,
        amount: u64,
        inscription_content: String,
        certificate_type: u8,
    }

    public fun certificate_issued_id(certificate_issued: &CertificateIssued): option::Option<object::ID> {
        certificate_issued.id
    }

    public(friend) fun set_certificate_issued_id(certificate_issued: &mut CertificateIssued, id: object::ID) {
        certificate_issued.id = option::some(id);
    }

    public fun certificate_issued_inscription_object_id(certificate_issued: &CertificateIssued): ID {
        certificate_issued.inscription_object_id
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

    public fun certificate_issued_inscription_content(certificate_issued: &CertificateIssued): String {
        certificate_issued.inscription_content
    }

    public fun certificate_issued_certificate_type(certificate_issued: &CertificateIssued): u8 {
        certificate_issued.certificate_type
    }

    public(friend) fun new_certificate_issued(
        inscription_object_id: ID,
        inscription_hash: vector<u8>,
        slot_number: u8,
        round: u64,
        inscriber: address,
        inscription_timestamp: u64,
        amount: u64,
        inscription_content: String,
        certificate_type: u8,
    ): CertificateIssued {
        CertificateIssued {
            id: option::none(),
            inscription_object_id,
            inscription_hash,
            slot_number,
            round,
            inscriber,
            inscription_timestamp,
            amount,
            inscription_content,
            certificate_type,
        }
    }


    public(friend) fun transfer_object(certificate: Certificate, recipient: address) {
        assert!(certificate.version == 0, EInappropriateVersion);
        transfer::transfer(certificate, recipient);
    }

    public(friend) fun update_version_and_transfer_object(certificate: Certificate, recipient: address) {
        update_object_version(&mut certificate);
        transfer::transfer(certificate, recipient);
    }

    #[lint_allow(share_owned)]
    public(friend) fun share_object(certificate: Certificate) {
        assert!(certificate.version == 0, EInappropriateVersion);
        transfer::share_object(certificate);
    }

    #[lint_allow(share_owned)]
    public(friend) fun update_version_and_share_object(certificate: Certificate) {
        update_object_version(&mut certificate);
        transfer::share_object(certificate);
    }

    public(friend) fun freeze_object(certificate: Certificate) {
        assert!(certificate.version == 0, EInappropriateVersion);
        transfer::freeze_object(certificate);
    }

    public(friend) fun update_version_and_freeze_object(certificate: Certificate) {
        update_object_version(&mut certificate);
        transfer::freeze_object(certificate);
    }

    fun update_object_version(certificate: &mut Certificate) {
        certificate.version = certificate.version + 1;
        //assert!(certificate.version != 0, EInappropriateVersion);
    }

    public(friend) fun drop_certificate(certificate: Certificate) {
        let Certificate {
            id,
            version: _version,
            inscription_object_id: _inscription_object_id,
            inscription_hash: _inscription_hash,
            slot_number: _slot_number,
            round: _round,
            inscriber: _inscriber,
            inscription_timestamp: _inscription_timestamp,
            amount: _amount,
            inscription_content: _inscription_content,
            certificate_type: _certificate_type,
        } = certificate;
        object::delete(id);
    }

    public(friend) fun emit_certificate_issued(certificate_issued: CertificateIssued) {
        event::emit(certificate_issued);
    }

}
