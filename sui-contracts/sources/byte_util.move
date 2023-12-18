module sui_inscription::byte_util {
    use std::vector;

    public fun concat(v1: &vector<u8>, v2: vector<u8>): vector<u8> {
        let data = *v1;
        vector::append(&mut data, v2);
        data
    }

    public fun count_bits(x: u8): u8 {
        let count: u8 = 0;
        let temp = x;
        let i = 0;
        while (i < 8) {
            if (temp & 1 == 1) {
                count = count + 1;
            };
            temp = temp >> 1;
            i = i + 1;
        };
        count
    }
}
