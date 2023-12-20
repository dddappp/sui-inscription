#!/bin/sh

#txn_digest=$(cat test_sui_publish_package.json | jq -r '.digest')
package_id="0x776fbac3115141986702630edf576b42adbcf60dc86a56a5875703fe817b670e"
slot_number_table_id="0x19d0c8a74789724f7df600c1089a16f58f3222a20606865acf115faaa9381263"

while IFS=, read -r col1 col2
do
slot_number=${col1//\'/}
slot_object_id=${col2//\'/}
echo "slot_number: $slot_number"
echo "slot_object_id: $slot_object_id"
round=0
echo "current round: $round"

round_in_slot=$(sui client object $slot_object_id --json | jq -r '.content.fields.round')
echo "round_in_slot: $round_in_slot"

if [[ $round != $round_in_slot ]]
then
echo "current round != round_in_slot, ignore current round: $round"
continue
fi

mint_count=0
while [ $mint_count -lt 1 ]
do
echo "current mint count: $mint_count"

sui client call --package $package_id --module inscription_aggregate --function mint \
--args $slot_number \"$round\" \"385802469\" \"3\" '"dddappp"' \"0x6\" \
--gas-budget 1000000000 --json > test_minted_inscription.json

minted_inscription_id=$(cat test_minted_inscription.json | jq -r '.objectChanges[] | select(.type == "created") | select(.objectType | test("::inscription::Inscription")).objectId')
echo "minted_inscription_id: $minted_inscription_id"

if [ -z "$minted_inscription_id" ]
then
continue
fi

sui client call --package $package_id --module slot_aggregate --function put_up_candidate \
--args $slot_object_id \"$minted_inscription_id\" \"0x6\" \
--gas-budget 1000000000

mint_count=$((mint_count+1))
done

#sleep 150
sui client call --package $package_id --module slot_aggregate --function advance \
--args $slot_object_id \"0x6\" \
--gas-budget 1000000000

round=$((round+1))

done < slots.txt
