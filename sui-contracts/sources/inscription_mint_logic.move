#[allow(unused_variable, unused_use, unused_assignment, unused_mut_parameter)]
module sui_inscription::inscription_mint_logic {
    use std::string::String;

    use sui::clock;
    use sui::clock::Clock;
    use sui::tx_context::{Self, TxContext};

    use sui_inscription::hash_util;
    use sui_inscription::inscription;
    use sui_inscription::inscription_minted;

    friend sui_inscription::inscription_aggregate;

    public(friend) fun verify(
        slot_number: u8,
        round: u64,
        amount: u64,
        nonce: u128,
        content: String,
        clock: &Clock,
        ctx: &mut TxContext,
    ): inscription::InscriptionMinted {
        let inscriber = tx_context::sender(ctx);
        let timestamp = clock::timestamp_ms(clock);
        let hash = hash_util::hash_inscription(
            slot_number,
            round,
            inscriber,
            timestamp,
            amount,
            nonce,
        );
        inscription::new_inscription_minted(
            slot_number,
            round,
            amount,
            nonce,
            content,
            inscriber,
            timestamp,
            hash,
        )
    }

    public(friend) fun mutate(
        inscription_minted: &inscription::InscriptionMinted,
        ctx: &mut TxContext,
    ): inscription::Inscription {
        let slot_number = inscription_minted::slot_number(inscription_minted);
        let round = inscription_minted::round(inscription_minted);
        let amount = inscription_minted::amount(inscription_minted);
        let nonce = inscription_minted::nonce(inscription_minted);
        let content = inscription_minted::content(inscription_minted);
        let inscriber = inscription_minted::inscriber(inscription_minted);
        let timestamp = inscription_minted::timestamp(inscription_minted);
        let hash = inscription_minted::hash(inscription_minted);
        inscription::new_inscription(
            hash,
            slot_number,
            round,
            inscriber,
            timestamp,
            amount,
            nonce,
            content,
            ctx,
        )
    }
}
