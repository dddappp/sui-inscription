# README

## Prerequisites

## Deploy

### Publish contract

Execute the following command in the directory `sui-contracts` to publish the contract on the chain:

```shell
sui client publish --gas-budget 1000000000 --skip-dependency-verification
```

```shell
# _SLOT_SLOT_NUMBER_TABLE_OBJECT_ID_ = 0x27bd39a29b86d9a53414b4ada446d1d0c99b379142c8728f33963f056ba2aa36
sui client call --package 0xe7f6220ff9733475a1b5502606d2bf192cde8b98eddd171f9f7fcd2eca5e34e6 --module slot_aggregate --function create \
--args 0 0x6 \"0x27bd39a29b86d9a53414b4ada446d1d0c99b379142c8728f33963f056ba2aa36\" \
--gas-budget 1000000000

# SLOT_0: 0xc34d9e352ea89256a0d171ff9ffaeb93af6d13dbcb822ff2172a718df85f77c4
# SLOT_209: 0x27e232ed00990edd4ecd9236e39a5cf77f01c7cc40a0f6ac9dca363d71d64522


sui client call --package 0xe7f6220ff9733475a1b5502606d2bf192cde8b98eddd171f9f7fcd2eca5e34e6 --module inscription_aggregate --function mint \
--args 0 \"0\" \"11111111\" \"11111111\" '"hello-world!"' \"0x6\" \
--gas-budget 1000000000

#0xa08671d7ba75140a182ee243fbbd93b1549d0593248fb7ccc6df373c3a9d68c0
#0xaba8c3c8c79d827c4390cdb9cee516a4f8e1fa1a8b2a522bde60c3f39f0a55d9

sui client call --package 0xe7f6220ff9733475a1b5502606d2bf192cde8b98eddd171f9f7fcd2eca5e34e6 --module slot_aggregate --function put_up_candidate \
--args 0xc34d9e352ea89256a0d171ff9ffaeb93af6d13dbcb822ff2172a718df85f77c4 \"0xa08671d7ba75140a182ee243fbbd93b1549d0593248fb7ccc6df373c3a9d68c0\" \"0x6\" \
--gas-budget 1000000000

sui client call --package 0xe7f6220ff9733475a1b5502606d2bf192cde8b98eddd171f9f7fcd2eca5e34e6 --module slot_aggregate --function put_up_candidate \
--args 0xc34d9e352ea89256a0d171ff9ffaeb93af6d13dbcb822ff2172a718df85f77c4 \"0xaba8c3c8c79d827c4390cdb9cee516a4f8e1fa1a8b2a522bde60c3f39f0a55d9\" \"0x6\" \
--gas-budget 1000000000
```

