// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

package org.dddappp.suiinscription.sui.contract;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.github.wubuku.sui.bean.*;

import java.math.*;
import java.util.*;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Certificate {

    private UID id;

    private Long offChainVersion;

    private String inscriptionId;

    private int[] inscriptionHash;

    private Integer slotNumber;

    private BigInteger round;

    private String inscriber;

    private BigInteger inscriptionTimestamp;

    private BigInteger amount;

    private BigInteger inscriptionNonce;

    private String inscriptionContent;

    private BigInteger version;

    public UID getId() {
        return id;
    }

    public void setId(UID id) {
        this.id = id;
    }

    public Long getOffChainVersion() {
        return offChainVersion;
    }

    public void setOffChainVersion(Long offChainVersion) {
        this.offChainVersion = offChainVersion;
    }

    public String getInscriptionId() {
        return inscriptionId;
    }

    public void setInscriptionId(String inscriptionId) {
        this.inscriptionId = inscriptionId;
    }

    public int[] getInscriptionHash() {
        return inscriptionHash;
    }

    public void setInscriptionHash(int[] inscriptionHash) {
        this.inscriptionHash = inscriptionHash;
    }

    public Integer getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(Integer slotNumber) {
        this.slotNumber = slotNumber;
    }

    public BigInteger getRound() {
        return round;
    }

    public void setRound(BigInteger round) {
        this.round = round;
    }

    public String getInscriber() {
        return inscriber;
    }

    public void setInscriber(String inscriber) {
        this.inscriber = inscriber;
    }

    public BigInteger getInscriptionTimestamp() {
        return inscriptionTimestamp;
    }

    public void setInscriptionTimestamp(BigInteger inscriptionTimestamp) {
        this.inscriptionTimestamp = inscriptionTimestamp;
    }

    public BigInteger getAmount() {
        return amount;
    }

    public void setAmount(BigInteger amount) {
        this.amount = amount;
    }

    public BigInteger getInscriptionNonce() {
        return inscriptionNonce;
    }

    public void setInscriptionNonce(BigInteger inscriptionNonce) {
        this.inscriptionNonce = inscriptionNonce;
    }

    public String getInscriptionContent() {
        return inscriptionContent;
    }

    public void setInscriptionContent(String inscriptionContent) {
        this.inscriptionContent = inscriptionContent;
    }

    public BigInteger getVersion() {
        return version;
    }

    public void setVersion(BigInteger version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Certificate{" +
                "id=" + id +
                ", offChainVersion=" + offChainVersion +
                ", inscriptionId=" + '\'' + inscriptionId + '\'' +
                ", inscriptionHash=" + Arrays.toString(inscriptionHash) +
                ", slotNumber=" + slotNumber +
                ", round=" + round +
                ", inscriber=" + '\'' + inscriber + '\'' +
                ", inscriptionTimestamp=" + inscriptionTimestamp +
                ", amount=" + amount +
                ", inscriptionNonce=" + inscriptionNonce +
                ", inscriptionContent=" + '\'' + inscriptionContent + '\'' +
                ", version=" + version +
                '}';
    }
}