// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

module sui_inscription::inscription {
    use std::option::{Self, Option};
    use std::string::String;
    use sui::event;
    use sui::object::{Self, ID, UID};
    use sui::transfer;
    use sui::tx_context::TxContext;
    friend sui_inscription::inscription_mint_logic;
    friend sui_inscription::inscription_mint_v2_logic;
    friend sui_inscription::inscription_delete_logic;
    friend sui_inscription::inscription_aggregate;

    friend sui_inscription::slot_service;

    #[allow(unused_const)]
    const EDataTooLong: u64 = 102;
    const EInappropriateVersion: u64 = 103;
    const EEmptyObjectID: u64 = 107;

    struct Inscription has key, store {
        id: UID,
        version: u64,
        hash: vector<u8>,
        slot_number: u8,
        round: u64,
        inscriber: address,
        timestamp: u64,
        amount: u64,
        nonce: u128,
        content: String,
    }

    public fun id(inscription: &Inscription): object::ID {
        object::uid_to_inner(&inscription.id)
    }

    public fun version(inscription: &Inscription): u64 {
        inscription.version
    }

    public fun hash(inscription: &Inscription): vector<u8> {
        inscription.hash
    }

    public(friend) fun set_hash(inscription: &mut Inscription, hash: vector<u8>) {
        inscription.hash = hash;
    }

    public fun slot_number(inscription: &Inscription): u8 {
        inscription.slot_number
    }

    public(friend) fun set_slot_number(inscription: &mut Inscription, slot_number: u8) {
        inscription.slot_number = slot_number;
    }

    public fun round(inscription: &Inscription): u64 {
        inscription.round
    }

    public(friend) fun set_round(inscription: &mut Inscription, round: u64) {
        inscription.round = round;
    }

    public fun inscriber(inscription: &Inscription): address {
        inscription.inscriber
    }

    public(friend) fun set_inscriber(inscription: &mut Inscription, inscriber: address) {
        inscription.inscriber = inscriber;
    }

    public fun timestamp(inscription: &Inscription): u64 {
        inscription.timestamp
    }

    public(friend) fun set_timestamp(inscription: &mut Inscription, timestamp: u64) {
        inscription.timestamp = timestamp;
    }

    public fun amount(inscription: &Inscription): u64 {
        inscription.amount
    }

    public(friend) fun set_amount(inscription: &mut Inscription, amount: u64) {
        inscription.amount = amount;
    }

    public fun nonce(inscription: &Inscription): u128 {
        inscription.nonce
    }

    public(friend) fun set_nonce(inscription: &mut Inscription, nonce: u128) {
        inscription.nonce = nonce;
    }

    public fun content(inscription: &Inscription): String {
        inscription.content
    }

    public(friend) fun set_content(inscription: &mut Inscription, content: String) {
        assert!(std::string::length(&content) <= 1000, EDataTooLong);
        inscription.content = content;
    }

    public(friend) fun new_inscription(
        hash: vector<u8>,
        slot_number: u8,
        round: u64,
        inscriber: address,
        timestamp: u64,
        amount: u64,
        nonce: u128,
        content: String,
        ctx: &mut TxContext,
    ): Inscription {
        assert!(std::string::length(&content) <= 1000, EDataTooLong);
        Inscription {
            id: object::new(ctx),
            version: 0,
            hash,
            slot_number,
            round,
            inscriber,
            timestamp,
            amount,
            nonce,
            content,
        }
    }

    struct InscriptionMinted has copy, drop {
        id: Option<ID>,
        slot_number: u8,
        round: u64,
        amount: u64,
        nonce: u128,
        content: String,
        inscriber: address,
        timestamp: u64,
        hash: vector<u8>,
    }

    public fun inscription_minted_id(inscription_minted: &InscriptionMinted): Option<ID> {
        inscription_minted.id
    }

    public(friend) fun set_inscription_minted_id(inscription_minted: &mut InscriptionMinted, id: ID) {
        inscription_minted.id = option::some(id);
    }

    public fun inscription_minted_slot_number(inscription_minted: &InscriptionMinted): u8 {
        inscription_minted.slot_number
    }

    public fun inscription_minted_round(inscription_minted: &InscriptionMinted): u64 {
        inscription_minted.round
    }

    public fun inscription_minted_amount(inscription_minted: &InscriptionMinted): u64 {
        inscription_minted.amount
    }

    public fun inscription_minted_nonce(inscription_minted: &InscriptionMinted): u128 {
        inscription_minted.nonce
    }

    public fun inscription_minted_content(inscription_minted: &InscriptionMinted): String {
        inscription_minted.content
    }

    public fun inscription_minted_inscriber(inscription_minted: &InscriptionMinted): address {
        inscription_minted.inscriber
    }

    public fun inscription_minted_timestamp(inscription_minted: &InscriptionMinted): u64 {
        inscription_minted.timestamp
    }

    public fun inscription_minted_hash(inscription_minted: &InscriptionMinted): vector<u8> {
        inscription_minted.hash
    }

    public(friend) fun new_inscription_minted(
        slot_number: u8,
        round: u64,
        amount: u64,
        nonce: u128,
        content: String,
        inscriber: address,
        timestamp: u64,
        hash: vector<u8>,
    ): InscriptionMinted {
        InscriptionMinted {
            id: option::none(),
            slot_number,
            round,
            amount,
            nonce,
            content,
            inscriber,
            timestamp,
            hash,
        }
    }

    struct InscriptionDeleted has copy, drop {
        id: object::ID,
        version: u64,
    }

    public fun inscription_deleted_id(inscription_deleted: &InscriptionDeleted): object::ID {
        inscription_deleted.id
    }

    public(friend) fun new_inscription_deleted(
        inscription: &Inscription,
    ): InscriptionDeleted {
        InscriptionDeleted {
            id: id(inscription),
            version: version(inscription),
        }
    }


    #[lint_allow(custom_state_change)]
    public(friend) fun transfer_object(inscription: Inscription, recipient: address) {
        assert!(inscription.version == 0, EInappropriateVersion);
        transfer::transfer(inscription, recipient);
    }

    #[lint_allow(custom_state_change)]
    public(friend) fun update_version_and_transfer_object(inscription: Inscription, recipient: address) {
        update_object_version(&mut inscription);
        transfer::transfer(inscription, recipient);
    }

    #[lint_allow(share_owned, custom_state_change)]
    public(friend) fun share_object(inscription: Inscription) {
        assert!(inscription.version == 0, EInappropriateVersion);
        transfer::share_object(inscription);
    }

    #[lint_allow(custom_state_change)]
    public(friend) fun freeze_object(inscription: Inscription) {
        assert!(inscription.version == 0, EInappropriateVersion);
        transfer::freeze_object(inscription);
    }

    #[lint_allow(custom_state_change)]
    public(friend) fun update_version_and_freeze_object(inscription: Inscription) {
        update_object_version(&mut inscription);
        transfer::freeze_object(inscription);
    }

    fun update_object_version(inscription: &mut Inscription) {
        inscription.version = inscription.version + 1;
        //assert!(inscription.version != 0, EInappropriateVersion);
    }

    public(friend) fun drop_inscription(inscription: Inscription) {
        let Inscription {
            id,
            version: _version,
            hash: _hash,
            slot_number: _slot_number,
            round: _round,
            inscriber: _inscriber,
            timestamp: _timestamp,
            amount: _amount,
            nonce: _nonce,
            content: _content,
        } = inscription;
        object::delete(id);
    }

    public(friend) fun emit_inscription_minted(inscription_minted: InscriptionMinted) {
        assert!(std::option::is_some(&inscription_minted.id), EEmptyObjectID);
        event::emit(inscription_minted);
    }

    public(friend) fun emit_inscription_deleted(inscription_deleted: InscriptionDeleted) {
        event::emit(inscription_deleted);
    }

}
