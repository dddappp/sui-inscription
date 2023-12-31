module sui_inscription::certificate_issue_logic {
    use std::string::String;
    use sui::object::ID;
    use sui::tx_context::TxContext;
    use sui_inscription::certificate;
    use sui_inscription::certificate_issued;

    friend sui_inscription::certificate_aggregate;

    public(friend) fun verify(
        inscription_id: ID,
        inscription_hash: vector<u8>,
        slot_number: u8,
        round: u64,
        inscriber: address,
        inscription_timestamp: u64,
        amount: u64,
        inscription_nonce: u128,
        inscription_content: String,
        ctx: &TxContext,//&mut TxContext,
    ): certificate::CertificateIssued {
        let _ = ctx;
        certificate::new_certificate_issued(
            inscription_id,
            inscription_hash,
            slot_number,
            round,
            inscriber,
            inscription_timestamp,
            amount,
            inscription_nonce,
            inscription_content,
        )
    }

    public(friend) fun mutate(
        certificate_issued: &certificate::CertificateIssued,
        ctx: &mut TxContext,
    ): certificate::Certificate {
        let inscription_id = certificate_issued::inscription_id(certificate_issued);
        let inscription_hash = certificate_issued::inscription_hash(certificate_issued);
        let slot_number = certificate_issued::slot_number(certificate_issued);
        let round = certificate_issued::round(certificate_issued);
        let inscriber = certificate_issued::inscriber(certificate_issued);
        let inscription_timestamp = certificate_issued::inscription_timestamp(certificate_issued);
        let amount = certificate_issued::amount(certificate_issued);
        let inscription_nonce = certificate_issued::inscription_nonce(certificate_issued);
        let inscription_content = certificate_issued::inscription_content(certificate_issued);
        certificate::new_certificate(
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
        )
    }

}
