# README

## Prerequisites

## Deploy

### Publish contract

Execute the following command in the directory `sui-contracts` to publish the contract on the chain:

```shell
sui client publish --gas-budget 1000000000 --skip-dependency-verification
```

```shell
# _SLOT_SLOT_NUMBER_TABLE_OBJECT_ID_ = 0xbcb2f68b7a54cd9698cea566efb95c792e7c7f8b402a863a15cf5f84922b7649

sui client call --package 0x01f0061ec05391fd6fa34471f0321cc9007a418da459c1fb75ab186fc0bec05b --module slot_aggregate --function create \
--args 0 0x6 \"0xbcb2f68b7a54cd9698cea566efb95c792e7c7f8b402a863a15cf5f84922b7649\" \
--gas-budget 1000000000

sui client call --package 0x01f0061ec05391fd6fa34471f0321cc9007a418da459c1fb75ab186fc0bec05b --module slot_aggregate --function create \
--args 209 0x6 \"0xbcb2f68b7a54cd9698cea566efb95c792e7c7f8b402a863a15cf5f84922b7649\" \
--gas-budget 1000000000

# SLOT_0: 0x6b16aa24806c2427f6389f76e5d4449fd6d6d2de09cf83f4d8329d39c01926bf
# SLOT_209: 0xeff7596e8ae76afb75b9c32932d51f867771779798178f41a74423081af97480


sui client call --package 0x01f0061ec05391fd6fa34471f0321cc9007a418da459c1fb75ab186fc0bec05b --module inscription_aggregate --function mint \
--args 209 \"0\" \"11111111\" \"11111111\" '"hello-world!"' \"0x6\" \
--gas-budget 1000000000

#0x3b2e1a929b9201de21491bf4028ce0e96e5868fa84b5356f7715e8f30cd2cb7e
#0xe33279ba8dd1a92e7c3c6657fa69e5dcad441dd91997484110cc7b0752f7d973
#0x380d2baf570543f122ed648f631e02cc8588e547139bf78a53ff8244e0e34ded
#0x8f3363a2eb3a38e033494a328c3c1f74c9135f55d358250e8c45b03ff19bba97

sui client call --package 0x01f0061ec05391fd6fa34471f0321cc9007a418da459c1fb75ab186fc0bec05b --module slot_aggregate --function put_up_candidate \
--args 0xeff7596e8ae76afb75b9c32932d51f867771779798178f41a74423081af97480 \"0x3b2e1a929b9201de21491bf4028ce0e96e5868fa84b5356f7715e8f30cd2cb7e\" \"0x6\" \
--gas-budget 1000000000

sui client call --package 0x01f0061ec05391fd6fa34471f0321cc9007a418da459c1fb75ab186fc0bec05b --module slot_aggregate --function put_up_candidate \
--args 0xeff7596e8ae76afb75b9c32932d51f867771779798178f41a74423081af97480 \"0xe33279ba8dd1a92e7c3c6657fa69e5dcad441dd91997484110cc7b0752f7d973\" \"0x6\" \
--gas-budget 1000000000

sui client call --package 0x01f0061ec05391fd6fa34471f0321cc9007a418da459c1fb75ab186fc0bec05b --module slot_aggregate --function put_up_candidate \
--args 0xeff7596e8ae76afb75b9c32932d51f867771779798178f41a74423081af97480 \"0x380d2baf570543f122ed648f631e02cc8588e547139bf78a53ff8244e0e34ded\" \"0x6\" \
--gas-budget 1000000000

sui client call --package 0x01f0061ec05391fd6fa34471f0321cc9007a418da459c1fb75ab186fc0bec05b --module slot_aggregate --function put_up_candidate \
--args 0xeff7596e8ae76afb75b9c32932d51f867771779798178f41a74423081af97480 \"0x8f3363a2eb3a38e033494a328c3c1f74c9135f55d358250e8c45b03ff19bba97\" \"0x6\" \
--gas-budget 1000000000


sui client call --package 0x01f0061ec05391fd6fa34471f0321cc9007a418da459c1fb75ab186fc0bec05b --module inscription_aggregate --function mint \
--args 209 \"1\" \"11111111\" \"11111111\" '"hello-world!"' \"0x6\" \
--gas-budget 1000000000

#0xe3f36446f369b0aaac53ff27e9cddde0bab3d03ea825b3668c12ad24384576e4
#0xd0b2428da80f688079be1212ed5d3ed1e7e5887dc06989158a1a9a20a1ca3ddd
#0x174b935156b22d045a7499cd1fdcec6d4b60adc0c2daa81b493b0c83c0c6070b
#0x1ca556d1afdca724ea090f1584f236ee34784e45598e4e50f2060e58e1f41d0b

sui client call --package 0x01f0061ec05391fd6fa34471f0321cc9007a418da459c1fb75ab186fc0bec05b --module slot_aggregate --function put_up_candidate \
--args 0xeff7596e8ae76afb75b9c32932d51f867771779798178f41a74423081af97480 \"0xe3f36446f369b0aaac53ff27e9cddde0bab3d03ea825b3668c12ad24384576e4\" \"0x6\" \
--gas-budget 1000000000

sui client call --package 0x01f0061ec05391fd6fa34471f0321cc9007a418da459c1fb75ab186fc0bec05b --module slot_aggregate --function put_up_candidate \
--args 0xeff7596e8ae76afb75b9c32932d51f867771779798178f41a74423081af97480 \"0xd0b2428da80f688079be1212ed5d3ed1e7e5887dc06989158a1a9a20a1ca3ddd\" \"0x6\" \
--gas-budget 1000000000

sui client call --package 0x01f0061ec05391fd6fa34471f0321cc9007a418da459c1fb75ab186fc0bec05b --module slot_aggregate --function put_up_candidate \
--args 0xeff7596e8ae76afb75b9c32932d51f867771779798178f41a74423081af97480 \"0x174b935156b22d045a7499cd1fdcec6d4b60adc0c2daa81b493b0c83c0c6070b\" \"0x6\" \
--gas-budget 1000000000

sui client call --package 0x01f0061ec05391fd6fa34471f0321cc9007a418da459c1fb75ab186fc0bec05b --module slot_aggregate --function put_up_candidate \
--args 0xeff7596e8ae76afb75b9c32932d51f867771779798178f41a74423081af97480 \"0x1ca556d1afdca724ea090f1584f236ee34784e45598e4e50f2060e58e1f41d0b\" \"0x6\" \
--gas-budget 1000000000


sui client call --package 0x01f0061ec05391fd6fa34471f0321cc9007a418da459c1fb75ab186fc0bec05b --module slot_aggregate --function put_up_candidate \
--args 0x6b16aa24806c2427f6389f76e5d4449fd6d6d2de09cf83f4d8329d39c01926bf \"0x268837d433ba4bef6db301856438d6a6eb3207df18eb717571f0f3b8bd26d32d\" \"0x6\" \
--gas-budget 1000000000

sui client call --package 0x01f0061ec05391fd6fa34471f0321cc9007a418da459c1fb75ab186fc0bec05b --module slot_aggregate --function put_up_candidate \
--args 0x6b16aa24806c2427f6389f76e5d4449fd6d6d2de09cf83f4d8329d39c01926bf \"0xdce227083dfee033a3711a2f1fef602f3ad04b65f38726ff5a53cf906bb66766\" \"0x6\" \
--gas-budget 1000000000

sui client call --package 0x01f0061ec05391fd6fa34471f0321cc9007a418da459c1fb75ab186fc0bec05b --module slot_aggregate --function put_up_candidate \
--args 0x6b16aa24806c2427f6389f76e5d4449fd6d6d2de09cf83f4d8329d39c01926bf \"0x4a9e3fd8bf0f54be7c19e902df2017ff56e5c1fdd3797844fe750a4a7cbf62e2\" \"0x6\" \
--gas-budget 1000000000

sui client call --package 0x01f0061ec05391fd6fa34471f0321cc9007a418da459c1fb75ab186fc0bec05b --module slot_aggregate --function put_up_candidate \
--args 0x6b16aa24806c2427f6389f76e5d4449fd6d6d2de09cf83f4d8329d39c01926bf \"0x1f68d14adeadc16af7bafa5c872d12d3b4a003d1738d0b5601dc38a01e7dee0f\" \"0x6\" \
--gas-budget 1000000000




sui client call --package 0x01f0061ec05391fd6fa34471f0321cc9007a418da459c1fb75ab186fc0bec05b --module slot_aggregate --function advance \
--args 0xeff7596e8ae76afb75b9c32932d51f867771779798178f41a74423081af97480 \"0x6\" \
--gas-budget 1000000000

sui client call --package 0x01f0061ec05391fd6fa34471f0321cc9007a418da459c1fb75ab186fc0bec05b --module slot_aggregate --function advance \
--args 0x6b16aa24806c2427f6389f76e5d4449fd6d6d2de09cf83f4d8329d39c01926bf \"0x6\" \
--gas-budget 1000000000
```

