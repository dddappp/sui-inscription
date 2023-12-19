#!/bin/sh

package_id=0x51095498d7bd253ffaa719b20ece8efce3dc02f9ed6b65a9ce3072b43b2dd7b3
slot_number_table_id=0xb38de3ca7eb3323857676622be013dcb7d6e67f4f36dc4383c867f7dce4675a8

slot_number=0
while [ $slot_number -lt 210 ]
do
sui client call --package $package_id --module slot_aggregate --function create \
--args $slot_number 0x6 \"$slot_number_table_id\" \
--gas-budget 1000000000

slot_number=$((slot_number+1))
done
