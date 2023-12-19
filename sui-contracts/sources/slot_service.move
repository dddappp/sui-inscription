// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

module sui_inscription::slot_service {
    use sui::clock::Clock;
    use sui::tx_context;

    use sui_inscription::inscription::Inscription;
    use sui_inscription::slot;
    use sui_inscription::slot_aggregate;

    public entry fun advance_and_put_up_candidate(
        slot: &mut slot::Slot,
        candidate_inscription: &Inscription,
        clock: &Clock,
        ctx: &mut tx_context::TxContext,
    ) {
        slot_aggregate::advance(slot, clock, ctx);
        slot_aggregate::put_up_candidate(slot, candidate_inscription, clock, ctx);
    }
}
