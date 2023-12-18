module sui_inscription::hash_util {
    use std::bcs;
    use std::hash::sha3_256;

    use sui_inscription::byte_util;

    public fun hash_inscription(
        slot_number: u8,
        round: u64,
        inscriber: address,
        timestamp: u64,
        amount: u64,
        nonce: u128,
    ): vector<u8> {
        let bs = bcs::to_bytes(&slot_number);
        bs = byte_util::concat(&bs, bcs::to_bytes(&round));
        bs = byte_util::concat(&bs, bcs::to_bytes(&inscriber));
        bs = byte_util::concat(&bs, bcs::to_bytes(&timestamp));
        bs = byte_util::concat(&bs, bcs::to_bytes(&amount));
        bs = byte_util::concat(&bs, bcs::to_bytes(&nonce));
        sha3_256(bs)
    }
}
