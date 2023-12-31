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

# Mint an inscription for slot 209
# The second parameter is the round number
sui client call --package 0x51095498d7bd253ffaa719b20ece8efce3dc02f9ed6b65a9ce3072b43b2dd7b3 --module inscription_aggregate --function mint \
--args 209 \"0\" \"11111111\" \"11111111\" '"hello-world!"' \"0x6\" \
--gas-budget 1000000000

# Try to put up a candidate into slot 209
sui client call --package 0x51095498d7bd253ffaa719b20ece8efce3dc02f9ed6b65a9ce3072b43b2dd7b3 --module slot_aggregate --function put_up_candidate \
--args 0x92da056f34ee5c27d6b78e5d6ca0583a544fb748f70424eaa6e661f57a398a0d \"0x8ea9c895b356e33568978c37792d40a7025b16d38be7a3dc32e21656a07dae7f\" \"0x6\" \
--gas-budget 1000000000

# Advance slot to next round
sui client call --package 0x51095498d7bd253ffaa719b20ece8efce3dc02f9ed6b65a9ce3072b43b2dd7b3 --module slot_aggregate --function advance \
--args 0x92da056f34ee5c27d6b78e5d6ca0583a544fb748f70424eaa6e661f57a398a0d \"0x6\" \
--gas-budget 1000000000

# Delete inscription
sui client call --package 0x51095498d7bd253ffaa719b20ece8efce3dc02f9ed6b65a9ce3072b43b2dd7b3 --module inscription_aggregate --function delete \
--args 0x8ea9c895b356e33568978c37792d40a7025b16d38be7a3dc32e21656a07dae7f \
--gas-budget 1000000000

# ---------------------------------------------------------------------------------------------
# Of course, you could combine `advance` and `put_up_candidate` into one step, 
# i.e., send the winner of the previous round to leave and try to put your own candidate inscription into the slot.
# Let's say you minted an inscription of current round with Id 0xf28ae48d8dd26569d898a5462f5d7782685e6b632a4aaf27dedc0ef3998a5ddd 
# The slot Id is 0x2647f0df047e63aeca26200c820dd884657ae1711815c8f1448ee2a3e1cd3724
# Then, you can execute the following command:
sui client call --package {PACKAGE_ID} --module slot_service --function advance_and_put_up_candidate \
--args 0x2647f0df047e63aeca26200c820dd884657ae1711815c8f1448ee2a3e1cd3724 \"0xf28ae48d8dd26569d898a5462f5d7782685e6b632a4aaf27dedc0ef3998a5ddd\" \"0x6\" \
--gas-budget 1000000000


# You could even combine `advance` and `mint` and `put_up_candidate` into one step:
sui client call --package 0x74780db27ddf1426fa1f2464914c523b79b7a9c3f1020bbf16f37a7ee029609f --module slot_service --function advance_and_mint_and_put_up_candidate \
--args 0x4686acd97972122e8c8e2f6e73bf5fbbfbbb649152fb55eae31f4542c751dffe \"11111111\" \"11111111\" '"hello-world!"' \"0x6\" \
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
    package-publish-transaction: "FSJXhoiKTWM1CLemgzmzhsUquGMGfZo92X45pgF8pJ7W"
```


### Starting Off-Chain Service

In the `sui-java-service` directory, run the following command to start the off-chain service:

```shell
mvn -pl suiinscription-service-rest -am spring-boot:run
```


