module sui_inscription::time_util {
    //const TEN_MINUTES_IN_MILLISECONDS: u64 =    600000;
    const THREE_MINUTES_IN_MILLISECONDS: u64 =  180000;
    const ROUND_DURATION_MS: u64 = THREE_MINUTES_IN_MILLISECONDS; //TEN_MINUTES_IN_MILLISECONDS;

    public fun round_duration_ms(): u64 {
        ROUND_DURATION_MS
    }

    public fun count_rounds_and_elapsed_time_in_round(genesis_timestamp: u64, timestamp: u64): (u64, u64, bool) {
        let diff = timestamp - genesis_timestamp;
        let elapsed_time_in_round = diff % ROUND_DURATION_MS;
        (diff / ROUND_DURATION_MS, elapsed_time_in_round, elapsed_time_in_round < ROUND_DURATION_MS / 2)
    }

    public fun count_rounds(genesis_timestamp: u64, timestamp: u64): u64 {
        let diff = timestamp - genesis_timestamp;
        diff / ROUND_DURATION_MS
    }

    public fun elapsed_time_after_round(genesis_timestamp: u64, timestamp: u64, round: u64): u64 {
       timestamp - genesis_timestamp - round * ROUND_DURATION_MS
    }

    public fun is_in_first_half_of_round(genesis_timestamp: u64, timestamp: u64, round: u64): bool {
        let elapsed_time = elapsed_time_after_round(genesis_timestamp, timestamp, round);
        elapsed_time < ROUND_DURATION_MS / 2
    }
}