module sui_inscription::id_util {
    use sui::address;
    use sui::object::{Self, ID};

    const ID_PLACEHOLDER: vector<u8> = b"dddaPPP-------------------------";
    const ADDRESS_PLACEHOLDER: vector<u8> = b"DDDAppp+++++++++++++++++++++++++";
    const HASH_PLACEHOLDER: vector<u8> = b"dddappp*************************";

    public fun id_placeholder(): ID {
        object::id_from_bytes(ID_PLACEHOLDER)
    }

    public fun address_placeholder(): address {
        address::from_bytes(ADDRESS_PLACEHOLDER)
    }

    public fun hash_placeholder(): vector<u8> {
        HASH_PLACEHOLDER
    }
}
