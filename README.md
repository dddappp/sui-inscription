# README

## Prerequisites

## Deploy

### Publish contract

Execute the following command in the directory `sui-contracts` to publish the contract on the chain:

```shell
sui client publish --gas-budget 1000000000 --skip-dependency-verification
```

```shell
# _SLOT_SLOT_NUMBER_TABLE_OBJECT_ID_ = 0xb7e07eecc02b772211ac0f76cae678cd324466952fd02508e583abfacb54840e
sui client call --package 0x48b5b529dc4d5c32b6ca5c7124bd11b21464d68335ceb0b9c486fd66a9703a63 --module slot_aggregate --function create \
--args 0 0x6 \"0xb7e07eecc02b772211ac0f76cae678cd324466952fd02508e583abfacb54840e\" \
--gas-budget 1000000000

sui client call --package 0x48b5b529dc4d5c32b6ca5c7124bd11b21464d68335ceb0b9c486fd66a9703a63 --module slot_aggregate --function create \
--args 209 0x6 \"0xb7e07eecc02b772211ac0f76cae678cd324466952fd02508e583abfacb54840e\" \
--gas-budget 1000000000

# SLOT_0: 0x310811dedc3fbbafdcea9988c35e9f6c7cb0e8e341592bab335084600a170682
# SLOT_209: 0x0d7b82459abe09de6d27d68c88e773e10c0c8aacc96dd63590f6d07340c07093


sui client call --package 0x48b5b529dc4d5c32b6ca5c7124bd11b21464d68335ceb0b9c486fd66a9703a63 --module inscription_aggregate --function mint \
--args 209 \"1\" \"11111111\" \"11111111\" '"hello-world!"' \"0x6\" \
--gas-budget 1000000000

#0x9b35fa43daa3e0b07d0bbd03971fd4b4af4be096fbb549f3e25aba5328c6d833
#0x4ad77da777fb4396785209e94c49f65c5f8ba7a92cd295287a8ef6437bc3f405
#0x779197f513eccd52672e1c3a1b7bc2c985ae135903f30eac8bbd80364d940209
#0xb7f8c9572de6f4e021b8aefad897a57d52f4c97b5e537b1cfc09756998923df3

#0x268837d433ba4bef6db301856438d6a6eb3207df18eb717571f0f3b8bd26d32d
#0xdce227083dfee033a3711a2f1fef602f3ad04b65f38726ff5a53cf906bb66766
#0x4a9e3fd8bf0f54be7c19e902df2017ff56e5c1fdd3797844fe750a4a7cbf62e2
#0x7c57cbef654b412c6902b97bde500d85296cb510f1796c97b7da30226ce73f7b

sui client call --package 0x48b5b529dc4d5c32b6ca5c7124bd11b21464d68335ceb0b9c486fd66a9703a63 --module slot_aggregate --function put_up_candidate \
--args 0x0d7b82459abe09de6d27d68c88e773e10c0c8aacc96dd63590f6d07340c07093 \"0x9b35fa43daa3e0b07d0bbd03971fd4b4af4be096fbb549f3e25aba5328c6d833\" \"0x6\" \
--gas-budget 1000000000

sui client call --package 0x48b5b529dc4d5c32b6ca5c7124bd11b21464d68335ceb0b9c486fd66a9703a63 --module slot_aggregate --function put_up_candidate \
--args 0x0d7b82459abe09de6d27d68c88e773e10c0c8aacc96dd63590f6d07340c07093 \"0x4ad77da777fb4396785209e94c49f65c5f8ba7a92cd295287a8ef6437bc3f405\" \"0x6\" \
--gas-budget 1000000000

sui client call --package 0x48b5b529dc4d5c32b6ca5c7124bd11b21464d68335ceb0b9c486fd66a9703a63 --module slot_aggregate --function put_up_candidate \
--args 0x0d7b82459abe09de6d27d68c88e773e10c0c8aacc96dd63590f6d07340c07093 \"0x779197f513eccd52672e1c3a1b7bc2c985ae135903f30eac8bbd80364d940209\" \"0x6\" \
--gas-budget 1000000000

sui client call --package 0x48b5b529dc4d5c32b6ca5c7124bd11b21464d68335ceb0b9c486fd66a9703a63 --module slot_aggregate --function put_up_candidate \
--args 0x0d7b82459abe09de6d27d68c88e773e10c0c8aacc96dd63590f6d07340c07093 \"0xb7f8c9572de6f4e021b8aefad897a57d52f4c97b5e537b1cfc09756998923df3\" \"0x6\" \
--gas-budget 1000000000

sui client call --package 0x48b5b529dc4d5c32b6ca5c7124bd11b21464d68335ceb0b9c486fd66a9703a63 --module slot_aggregate --function put_up_candidate \
--args 0x310811dedc3fbbafdcea9988c35e9f6c7cb0e8e341592bab335084600a170682 \"0x268837d433ba4bef6db301856438d6a6eb3207df18eb717571f0f3b8bd26d32d\" \"0x6\" \
--gas-budget 1000000000

sui client call --package 0x48b5b529dc4d5c32b6ca5c7124bd11b21464d68335ceb0b9c486fd66a9703a63 --module slot_aggregate --function put_up_candidate \
--args 0x310811dedc3fbbafdcea9988c35e9f6c7cb0e8e341592bab335084600a170682 \"0xdce227083dfee033a3711a2f1fef602f3ad04b65f38726ff5a53cf906bb66766\" \"0x6\" \
--gas-budget 1000000000

sui client call --package 0x48b5b529dc4d5c32b6ca5c7124bd11b21464d68335ceb0b9c486fd66a9703a63 --module slot_aggregate --function put_up_candidate \
--args 0x310811dedc3fbbafdcea9988c35e9f6c7cb0e8e341592bab335084600a170682 \"0x4a9e3fd8bf0f54be7c19e902df2017ff56e5c1fdd3797844fe750a4a7cbf62e2\" \"0x6\" \
--gas-budget 1000000000

sui client call --package 0x48b5b529dc4d5c32b6ca5c7124bd11b21464d68335ceb0b9c486fd66a9703a63 --module slot_aggregate --function put_up_candidate \
--args 0x310811dedc3fbbafdcea9988c35e9f6c7cb0e8e341592bab335084600a170682 \"0x1f68d14adeadc16af7bafa5c872d12d3b4a003d1738d0b5601dc38a01e7dee0f\" \"0x6\" \
--gas-budget 1000000000

sui client call --package 0x48b5b529dc4d5c32b6ca5c7124bd11b21464d68335ceb0b9c486fd66a9703a63 --module slot_aggregate --function advance \
--args 0x0d7b82459abe09de6d27d68c88e773e10c0c8aacc96dd63590f6d07340c07093 \"0x6\" \
--gas-budget 1000000000

sui client call --package 0x48b5b529dc4d5c32b6ca5c7124bd11b21464d68335ceb0b9c486fd66a9703a63 --module slot_aggregate --function advance \
--args 0x310811dedc3fbbafdcea9988c35e9f6c7cb0e8e341592bab335084600a170682 \"0x6\" \
--gas-budget 1000000000
```

