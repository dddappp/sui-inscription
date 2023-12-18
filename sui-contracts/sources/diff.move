module sui_inscription::diff {

    use std::vector;

    use sui_inscription::byte_util;

    const MAJOR_DIFFERENCE_SCALE_FACTOR: u64 = 1_000_000;
    const BYTE_DIFFERENCE_SCALE_FACTOR: u64 = 3000;
    const TIMESTAMP_DIFFERENCE_SCALE_FACTOR: u64 = 3;

    public fun calculate_difference(hash_1: vector<u8>, hash_2: vector<u8>, timestamp_1: u64, timestamp_2: u64): u64 {
        assert!(vector::length(&hash_1) == 32, 1);
        assert!(vector::length(&hash_2) == 32, 1);
        let d = major_defference_between_hashes(hash_1, hash_2) * MAJOR_DIFFERENCE_SCALE_FACTOR;
        //debug::print(&d);
        let d_0 = difference_between_bytes(*vector::borrow(&hash_1, 0), *vector::borrow(&hash_2, 0));
        let d_1 = difference_between_bytes(*vector::borrow(&hash_1, 1), *vector::borrow(&hash_2, 1));
        let d_2 = difference_between_bytes(*vector::borrow(&hash_1, 2), *vector::borrow(&hash_2, 2));
        d = d + ((d_0 as u64) + (d_1 as u64) + (d_2 as u64)) * BYTE_DIFFERENCE_SCALE_FACTOR;
        //debug::print(&d);
        d = d +
            (if (timestamp_2 > timestamp_1) { timestamp_2 - timestamp_1 } else { timestamp_1 - timestamp_2 })
                * TIMESTAMP_DIFFERENCE_SCALE_FACTOR;
        //debug::print(&d);
        d
    }

    public fun major_difference_equals(d_1: u64, d_2: u64): bool {
        d_1 / MAJOR_DIFFERENCE_SCALE_FACTOR == d_2 / MAJOR_DIFFERENCE_SCALE_FACTOR
    }

    public fun major_difference_equals_or_less_than(d_1: u64, d_2: u64): bool {
        d_1 / MAJOR_DIFFERENCE_SCALE_FACTOR <= d_2 / MAJOR_DIFFERENCE_SCALE_FACTOR
    }

    public fun major_defference_between_hashes(hash_1: vector<u8>, hash_2: vector<u8>): u64 {
        let d: u64 = 0;
        let i: u64 = 0;
        while (i < 32) {
            let b1 = vector::borrow(&hash_1, i);
            let b2 = vector::borrow(&hash_2, i);
            let x = *b1 ^ *b2;
            d = d + (byte_util::count_bits(x) as u64);
            i = i + 1;
        };
        d
    }

    public fun difference_between_bytes(b1: u8, b2: u8): u8 {
        if (b1 > b2) { b1 - b2 } else { b2 - b1 }
    }
}
