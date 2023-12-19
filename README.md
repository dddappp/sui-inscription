# README

## Prerequisites

## Programming

In repository root directory, run:

```shell
docker run \
-v .:/myapp \
wubuku/dddappp:0.0.1 \
--dddmlDirectoryPath /myapp/dddml \
--boundedContextName Dddappp.SuiInscription \
--suiMoveProjectDirectoryPath /myapp/sui-contracts \
--boundedContextSuiPackageName sui_inscription \
--boundedContextJavaPackageName org.dddappp.suiinscription \
--javaProjectsDirectoryPath /myapp/sui-java-service \
--javaProjectNamePrefix suiinscription \
--pomGroupId dddappp.suiinscription
```

## Deploy

### Publish contract

Execute the following command in the directory `sui-contracts` to publish the contract on the chain:

```shell
sui client publish --gas-budget 1000000000 --skip-dependency-verification
```

Some test shell scripts:

```shell
# TXN_DIGEST: FSJXhoiKTWM1CLemgzmzhsUquGMGfZo92X45pgF8pJ7W
# PACKAGE_ID = 0x51095498d7bd253ffaa719b20ece8efce3dc02f9ed6b65a9ce3072b43b2dd7b3
# _SLOT_NUMBER_TABLE_OBJECT_ID_ = 0xb38de3ca7eb3323857676622be013dcb7d6e67f4f36dc4383c867f7dce4675a8

sui client call --package 0x51095498d7bd253ffaa719b20ece8efce3dc02f9ed6b65a9ce3072b43b2dd7b3 --module slot_aggregate --function create \
--args 209 0x6 \"0xb38de3ca7eb3323857676622be013dcb7d6e67f4f36dc4383c867f7dce4675a8\" \
--gas-budget 1000000000

sui client call --package 0x51095498d7bd253ffaa719b20ece8efce3dc02f9ed6b65a9ce3072b43b2dd7b3 --module slot_aggregate --function create \
--args 0 0x6 \"0xb38de3ca7eb3323857676622be013dcb7d6e67f4f36dc4383c867f7dce4675a8\" \
--gas-budget 1000000000

# SLOT_209: 0x92da056f34ee5c27d6b78e5d6ca0583a544fb748f70424eaa6e661f57a398a0d
# SLOT_0: 0x6b16aa24806c2427f6389f76e5d4449fd6d6d2de09cf83f4d8329d39c01926bf


sui client call --package 0x51095498d7bd253ffaa719b20ece8efce3dc02f9ed6b65a9ce3072b43b2dd7b3 --module inscription_aggregate --function mint \
--args 209 \"4\" \"11111111\" \"11111111\" '"hello-world!"' \"0x6\" \
--gas-budget 1000000000


#0x6126a970603002c6a4d8e85caccfb88eabc8eafe8a0599573b8d11cb839c4be1
#0xa2757323ba7d4281953e3325eb101477bec1115be7779a22c22207d2b6235b54
#0xe37297e6184390ef64ec0470252fe942c882a12f29115bc6274b777c4985331c

sui client call --package 0x51095498d7bd253ffaa719b20ece8efce3dc02f9ed6b65a9ce3072b43b2dd7b3 --module slot_aggregate --function put_up_candidate \
--args 0x92da056f34ee5c27d6b78e5d6ca0583a544fb748f70424eaa6e661f57a398a0d \"0x3f48b1893bfe8c643801ce4f97b0b9eea8026cad5c9bffacbebd99e9ea1c1208\" \"0x6\" \
--gas-budget 1000000000

sui client call --package 0x51095498d7bd253ffaa719b20ece8efce3dc02f9ed6b65a9ce3072b43b2dd7b3 --module slot_aggregate --function put_up_candidate \
--args 0x92da056f34ee5c27d6b78e5d6ca0583a544fb748f70424eaa6e661f57a398a0d \"0xc3c4ab27bd193758a47b78ebb35cfa1e97f07dafe62ef77d7e8f368bdb5910c8\" \"0x6\" \
--gas-budget 1000000000

sui client call --package 0x51095498d7bd253ffaa719b20ece8efce3dc02f9ed6b65a9ce3072b43b2dd7b3 --module slot_aggregate --function put_up_candidate \
--args 0x92da056f34ee5c27d6b78e5d6ca0583a544fb748f70424eaa6e661f57a398a0d \"0xcbc97bcc4ab4d33e6e7944ec2699a929f73d75a5d8a02b55bab85e9f58b78a69\" \"0x6\" \
--gas-budget 1000000000

sui client call --package 0x51095498d7bd253ffaa719b20ece8efce3dc02f9ed6b65a9ce3072b43b2dd7b3 --module slot_aggregate --function put_up_candidate \
--args 0x92da056f34ee5c27d6b78e5d6ca0583a544fb748f70424eaa6e661f57a398a0d \"0xa55c14a9be0a0230e135184710bd7a349019c7b6b35a410b266c2fd558443927\" \"0x6\" \
--gas-budget 1000000000


sui client call --package 0x51095498d7bd253ffaa719b20ece8efce3dc02f9ed6b65a9ce3072b43b2dd7b3 --module inscription_aggregate --function mint \
--args 209 \"1\" \"11111111\" \"11111111\" '"hello-world!"' \"0x6\" \
--gas-budget 1000000000

#0xe3f36446f369b0aaac53ff27e9cddde0bab3d03ea825b3668c12ad24384576e4
#0xd0b2428da80f688079be1212ed5d3ed1e7e5887dc06989158a1a9a20a1ca3ddd
#0x174b935156b22d045a7499cd1fdcec6d4b60adc0c2daa81b493b0c83c0c6070b
#0x1ca556d1afdca724ea090f1584f236ee34784e45598e4e50f2060e58e1f41d0b

sui client call --package 0x51095498d7bd253ffaa719b20ece8efce3dc02f9ed6b65a9ce3072b43b2dd7b3 --module slot_aggregate --function put_up_candidate \
--args 0x92da056f34ee5c27d6b78e5d6ca0583a544fb748f70424eaa6e661f57a398a0d \"0xe3f36446f369b0aaac53ff27e9cddde0bab3d03ea825b3668c12ad24384576e4\" \"0x6\" \
--gas-budget 1000000000

sui client call --package 0x51095498d7bd253ffaa719b20ece8efce3dc02f9ed6b65a9ce3072b43b2dd7b3 --module slot_aggregate --function put_up_candidate \
--args 0x92da056f34ee5c27d6b78e5d6ca0583a544fb748f70424eaa6e661f57a398a0d \"0xd0b2428da80f688079be1212ed5d3ed1e7e5887dc06989158a1a9a20a1ca3ddd\" \"0x6\" \
--gas-budget 1000000000

sui client call --package 0x51095498d7bd253ffaa719b20ece8efce3dc02f9ed6b65a9ce3072b43b2dd7b3 --module slot_aggregate --function put_up_candidate \
--args 0x92da056f34ee5c27d6b78e5d6ca0583a544fb748f70424eaa6e661f57a398a0d \"0x174b935156b22d045a7499cd1fdcec6d4b60adc0c2daa81b493b0c83c0c6070b\" \"0x6\" \
--gas-budget 1000000000

sui client call --package 0x51095498d7bd253ffaa719b20ece8efce3dc02f9ed6b65a9ce3072b43b2dd7b3 --module slot_aggregate --function put_up_candidate \
--args 0x92da056f34ee5c27d6b78e5d6ca0583a544fb748f70424eaa6e661f57a398a0d \"0x1ca556d1afdca724ea090f1584f236ee34784e45598e4e50f2060e58e1f41d0b\" \"0x6\" \
--gas-budget 1000000000


sui client call --package 0x51095498d7bd253ffaa719b20ece8efce3dc02f9ed6b65a9ce3072b43b2dd7b3 --module slot_aggregate --function put_up_candidate \
--args 0x6b16aa24806c2427f6389f76e5d4449fd6d6d2de09cf83f4d8329d39c01926bf \"0x268837d433ba4bef6db301856438d6a6eb3207df18eb717571f0f3b8bd26d32d\" \"0x6\" \
--gas-budget 1000000000

sui client call --package 0x51095498d7bd253ffaa719b20ece8efce3dc02f9ed6b65a9ce3072b43b2dd7b3 --module slot_aggregate --function put_up_candidate \
--args 0x6b16aa24806c2427f6389f76e5d4449fd6d6d2de09cf83f4d8329d39c01926bf \"0xdce227083dfee033a3711a2f1fef602f3ad04b65f38726ff5a53cf906bb66766\" \"0x6\" \
--gas-budget 1000000000

sui client call --package 0x51095498d7bd253ffaa719b20ece8efce3dc02f9ed6b65a9ce3072b43b2dd7b3 --module slot_aggregate --function put_up_candidate \
--args 0x6b16aa24806c2427f6389f76e5d4449fd6d6d2de09cf83f4d8329d39c01926bf \"0x4a9e3fd8bf0f54be7c19e902df2017ff56e5c1fdd3797844fe750a4a7cbf62e2\" \"0x6\" \
--gas-budget 1000000000

sui client call --package 0x51095498d7bd253ffaa719b20ece8efce3dc02f9ed6b65a9ce3072b43b2dd7b3 --module slot_aggregate --function put_up_candidate \
--args 0x6b16aa24806c2427f6389f76e5d4449fd6d6d2de09cf83f4d8329d39c01926bf \"0x1f68d14adeadc16af7bafa5c872d12d3b4a003d1738d0b5601dc38a01e7dee0f\" \"0x6\" \
--gas-budget 1000000000




sui client call --package 0x51095498d7bd253ffaa719b20ece8efce3dc02f9ed6b65a9ce3072b43b2dd7b3 --module slot_aggregate --function advance \
--args 0x92da056f34ee5c27d6b78e5d6ca0583a544fb748f70424eaa6e661f57a398a0d \"0x6\" \
--gas-budget 1000000000

sui client call --package 0x51095498d7bd253ffaa719b20ece8efce3dc02f9ed6b65a9ce3072b43b2dd7b3 --module slot_aggregate --function advance \
--args 0x6b16aa24806c2427f6389f76e5d4449fd6d6d2de09cf83f4d8329d39c01926bf \"0x6\" \
--gas-budget 1000000000



sui client call --package 0x51095498d7bd253ffaa719b20ece8efce3dc02f9ed6b65a9ce3072b43b2dd7b3 --module inscription_aggregate --function delete \
--args 0xef7aa51584eb1acc171632888266a0429b4c41b3f87d0d3010ec37a2ac079cff \
--gas-budget 1000000000
```


## Run Off-chain Service

After running the dddappp tool, an Off-chain service project will be generated in the `sui-java-service` directory.
It can pull application events and entity states on the chain into the off-chain database, and provides query APIs.

### Prerequisites

The off-chain services generated by the tool are written in Java and use the MySQL database by default.

So before getting started, you need to set up a basic Java development environment:

* Install JDK and [Maven](https://maven.apache.org).
* Install MySQL database server.

If you have already installed Docker, you can use Docker to run a MySQL database server. For example:

```shell
sudo docker run -p 3306:3306 --name mysql \
-v ~/docker/mysql/conf:/etc/mysql \
-v ~/docker/mysql/logs:/var/log/mysql \
-v ~/docker/mysql/data:/var/lib/mysql \
-e MYSQL_ROOT_PASSWORD=123456 \
-d mysql:5.7
```

### Creating and Initialize Database for Off-Chain Service

Use a MySQL client to connect to the local MySQL server and execute the following script to create an empty database (assuming the name is `test2`):

```sql
CREATE SCHEMA `test2` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_bin;
```


Go to the `sui-java-service` directory and package the Java project:

```shell
mvn package
```

Then, run a command-line tool to initialize the database:

```shell
java -jar ./suiinscription-service-cli/target/suiinscription-service-cli-0.0.1-SNAPSHOT.jar ddl -d "./scripts" -c "jdbc:mysql://127.0.0.1:3306/test2?enabledTLSProtocols=TLSv1.2&characterEncoding=utf8&serverTimezone=GMT%2b0&useLegacyDatetimeCode=false" -u root -p 123456
```


### Configuring Off-Chain Service

Open the `application-test.yml` file located in the directory `sui-java-service/suiinscription-service-rest/src/main/resources` and set the published contract address.
After setting, it should look like this:

```yaml

sui:
  contract:
    jsonrpc:
      #url: "https://fullnode.testnet.sui.io/"
      #url: "http://localhost:9000"
      url: "https://fullnode.devnet.sui.io/"
    package-publish-transaction: "FWDCe5cRwv1ZEujoGm6op2PdDpZsFwYxoeSNJKMoCyJ6"
```


### Starting Off-Chain Service

In the `sui-java-service` directory, run the following command to start the off-chain service:

```shell
mvn -pl suiinscription-service-rest -am spring-boot:run
```


