# Sui Client CLI Cheatsheet

[ToC]

## Inscription aggregate

### Mint method

```shell
sui client call --package _PACKAGE_ID_ --module inscription_aggregate --function mint \
--args u8_slot_number \"u64_round\" \"u64_amount\" \"u128_nonce\" '"string_content"' \"_CLOCK_OBJECT_ID_\" \
--gas-budget 100000
```

### Delete method

```shell
sui client call --package _PACKAGE_ID_ --module inscription_aggregate --function delete \
--args inscription_Object_ID \
--gas-budget 100000
```

## Certificate aggregate

## Slot aggregate

### Create method

```shell
sui client call --package _PACKAGE_ID_ --module slot_aggregate --function create \
--args u8_slot_number \"_CLOCK_OBJECT_ID_\" \"_SLOT_SLOT_NUMBER_TABLE_OBJECT_ID_\" \
--gas-budget 100000
```

### PutUpCandidate method

```shell
sui client call --package _PACKAGE_ID_ --module slot_aggregate --function put_up_candidate \
--args slot_Object_ID \"_INSCRIPTION_OBJECT_ID_\" \"_CLOCK_OBJECT_ID_\" \
--gas-budget 100000
```

### Advance method

```shell
sui client call --package _PACKAGE_ID_ --module slot_aggregate --function advance \
--args slot_Object_ID \"_CLOCK_OBJECT_ID_\" \
--gas-budget 100000
```


---

## Tips

You can escape single quotes in string arguments by using the following method when enclosing them within single quotes in a shell:

1. Close the current single quote.
2. Use a backslash `\` to escape the single quote.
3. Open a new set of single quotes to continue the string.

Here is an example of how to escape a single quote within a string enclosed by single quotes in a shell:

```shell
echo 'It'\''s a beautiful day'
```

