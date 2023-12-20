#!/bin/sh

package_id=0x776fbac3115141986702630edf576b42adbcf60dc86a56a5875703fe817b670e
slot_number_table_id=0x19d0c8a74789724f7df600c1089a16f58f3222a20606865acf115faaa9381263

slot_number=2
while [ $slot_number -lt 209 ]
do
sui client call --package $package_id --module slot_aggregate --function create \
--args $slot_number 0x6 \"$slot_number_table_id\" \
--gas-budget 1000000000

echo "Slot object created, slot_number: $slot_number"
slot_number=$((slot_number+1))
done
