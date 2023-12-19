module sui_inscription::inscription_delete_logic {
    use sui::tx_context::TxContext;
    use sui_inscription::inscription;

    friend sui_inscription::inscription_aggregate;

    public(friend) fun verify(
        inscription: &inscription::Inscription,
        ctx: &TxContext,
    ): inscription::InscriptionDeleted {
        let _ = ctx;
        inscription::new_inscription_deleted(
            inscription,
        )
    }

    public(friend) fun mutate(
        inscription_deleted: &inscription::InscriptionDeleted,
        inscription: inscription::Inscription,
        ctx: &TxContext, // modify the reference to mutable if needed
    ): inscription::Inscription {
        let id = inscription::id(&inscription);
        let _ = ctx;
        let _ = id;
        let _ = inscription_deleted;
        inscription
    }

}
