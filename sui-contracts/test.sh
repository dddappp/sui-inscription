#!/bin/sh

sui client publish --gas-budget 1000000000 --skip-dependency-verification --json > test_sui_publish_package.json

txn_digest=$(cat test_sui_publish_package.json | jq -r '.digest')
echo "txn_digest: $txn_digest"

package_id=$(cat test_sui_publish_package.json | jq -r '.objectChanges[] | select(.type == "published").packageId')
echo "package_id: $package_id"

slot_number_table_id=$(cat test_sui_publish_package.json | jq -r '.events[] | select(.type | test("::slot::SlotNumberTableCreated"))'.parsedJson.id)
echo "slot_number_table_id: $slot_number_table_id"

slot_number=0
sui client call --package $package_id --module slot_aggregate --function create \
--args $slot_number 0x6 \"$slot_number_table_id\" \
--gas-budget 1000000000 --json > test_created_slot.json

slot_object_id=$(cat test_created_slot.json | jq -r '.objectChanges[] | select(.type == "created") | select(.objectType | test("::slot::Slot")).objectId')
echo "slot_object_id: $slot_object_id"

round=0
while [ $round -lt 1 ]
do
echo "current round: $round"

mint_count=0
while [ $mint_count -lt 5 ]
do
echo "current mint count: $mint_count"

sui client call --package $package_id --module inscription_aggregate --function mint \
--args $slot_number \"$round\" \"11111111\" \"11111111\" '"hello-world!"' \"0x6\" \
--gas-budget 1000000000 --json > test_minted_inscription.json

minted_inscription_id=$(cat test_minted_inscription.json | jq -r '.objectChanges[] | select(.type == "created") | select(.objectType | test("::inscription::Inscription")).objectId')
echo "minted_inscription_id: $minted_inscription_id"

sui client call --package $package_id --module slot_aggregate --function put_up_candidate \
--args $slot_object_id \"$minted_inscription_id\" \"0x6\" \
--gas-budget 1000000000

mint_count=$((mint_count+1))
done

sleep 150
sui client call --package $package_id --module slot_aggregate --function advance \
--args $slot_object_id \"0x6\" \
--gas-budget 1000000000

round=$((round+1))
done





