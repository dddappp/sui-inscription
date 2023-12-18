module sui_inscription::time_util {
    const TEN_MINUTES_IN_MILLISECONDS: u64 = 600000;

    public fun count_rounds_and_elapsed_time_in_round(genesis_timestamp: u64, timestamp: u64): (u64, u64, bool) {
        let diff = timestamp - genesis_timestamp;
        let elapsed_time_in_round = diff % TEN_MINUTES_IN_MILLISECONDS;
        (diff / TEN_MINUTES_IN_MILLISECONDS, elapsed_time_in_round, elapsed_time_in_round < TEN_MINUTES_IN_MILLISECONDS / 2)
    }

    public fun count_rounds(genesis_timestamp: u64, timestamp: u64): u64 {
        let diff = timestamp - genesis_timestamp;
        diff / TEN_MINUTES_IN_MILLISECONDS
    }

    public fun elapsed_time_after_round(genesis_timestamp: u64, timestamp: u64, round: u64): u64 {
       timestamp - genesis_timestamp - round * TEN_MINUTES_IN_MILLISECONDS
    }

    public fun is_in_first_half_of_round(genesis_timestamp: u64, timestamp: u64, round: u64): bool {
        let elapsed_time = elapsed_time_after_round(genesis_timestamp, timestamp, round);
        elapsed_time < TEN_MINUTES_IN_MILLISECONDS / 2
    }
}