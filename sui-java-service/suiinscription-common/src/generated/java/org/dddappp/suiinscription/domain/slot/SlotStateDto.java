// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

package org.dddappp.suiinscription.domain.slot;

import java.util.*;
import java.math.*;
import java.math.BigInteger;
import java.util.Date;
import org.dddappp.suiinscription.domain.*;
import org.dddappp.suiinscription.specialization.*;


public class SlotStateDto {

    private Integer slotNumber;

    public Integer getSlotNumber()
    {
        return this.slotNumber;
    }

    public void setSlotNumber(Integer slotNumber)
    {
        this.slotNumber = slotNumber;
    }

    private String id_;

    public String getId_()
    {
        return this.id_;
    }

    public void setId_(String id)
    {
        this.id_ = id;
    }

    private BigInteger genesisTimestamp;

    public BigInteger getGenesisTimestamp()
    {
        return this.genesisTimestamp;
    }

    public void setGenesisTimestamp(BigInteger genesisTimestamp)
    {
        this.genesisTimestamp = genesisTimestamp;
    }

    private BigInteger slotMaxAmount;

    public BigInteger getSlotMaxAmount()
    {
        return this.slotMaxAmount;
    }

    public void setSlotMaxAmount(BigInteger slotMaxAmount)
    {
        this.slotMaxAmount = slotMaxAmount;
    }

    private BigInteger mintedAmount;

    public BigInteger getMintedAmount()
    {
        return this.mintedAmount;
    }

    public void setMintedAmount(BigInteger mintedAmount)
    {
        this.mintedAmount = mintedAmount;
    }

    private BigInteger round;

    public BigInteger getRound()
    {
        return this.round;
    }

    public void setRound(BigInteger round)
    {
        this.round = round;
    }

    private BigInteger qualifiedRound;

    public BigInteger getQualifiedRound()
    {
        return this.qualifiedRound;
    }

    public void setQualifiedRound(BigInteger qualifiedRound)
    {
        this.qualifiedRound = qualifiedRound;
    }

    private String qualifiedInscriptionId;

    public String getQualifiedInscriptionId()
    {
        return this.qualifiedInscriptionId;
    }

    public void setQualifiedInscriptionId(String qualifiedInscriptionId)
    {
        this.qualifiedInscriptionId = qualifiedInscriptionId;
    }

    private int[] qualifiedHash;

    public int[] getQualifiedHash()
    {
        return this.qualifiedHash;
    }

    public void setQualifiedHash(int[] qualifiedHash)
    {
        this.qualifiedHash = qualifiedHash;
    }

    private BigInteger qualifiedTimestamp;

    public BigInteger getQualifiedTimestamp()
    {
        return this.qualifiedTimestamp;
    }

    public void setQualifiedTimestamp(BigInteger qualifiedTimestamp)
    {
        this.qualifiedTimestamp = qualifiedTimestamp;
    }

    private BigInteger qualifiedDifference;

    public BigInteger getQualifiedDifference()
    {
        return this.qualifiedDifference;
    }

    public void setQualifiedDifference(BigInteger qualifiedDifference)
    {
        this.qualifiedDifference = qualifiedDifference;
    }

    private String candidateInscriptionId;

    public String getCandidateInscriptionId()
    {
        return this.candidateInscriptionId;
    }

    public void setCandidateInscriptionId(String candidateInscriptionId)
    {
        this.candidateInscriptionId = candidateInscriptionId;
    }

    private int[] candidateHash;

    public int[] getCandidateHash()
    {
        return this.candidateHash;
    }

    public void setCandidateHash(int[] candidateHash)
    {
        this.candidateHash = candidateHash;
    }

    private String candidateInscriber;

    public String getCandidateInscriber()
    {
        return this.candidateInscriber;
    }

    public void setCandidateInscriber(String candidateInscriber)
    {
        this.candidateInscriber = candidateInscriber;
    }

    private BigInteger candidateTimestamp;

    public BigInteger getCandidateTimestamp()
    {
        return this.candidateTimestamp;
    }

    public void setCandidateTimestamp(BigInteger candidateTimestamp)
    {
        this.candidateTimestamp = candidateTimestamp;
    }

    private BigInteger candidateAmount;

    public BigInteger getCandidateAmount()
    {
        return this.candidateAmount;
    }

    public void setCandidateAmount(BigInteger candidateAmount)
    {
        this.candidateAmount = candidateAmount;
    }

    private BigInteger candidateNonce;

    public BigInteger getCandidateNonce()
    {
        return this.candidateNonce;
    }

    public void setCandidateNonce(BigInteger candidateNonce)
    {
        this.candidateNonce = candidateNonce;
    }

    private BigInteger candidateDifference;

    public BigInteger getCandidateDifference()
    {
        return this.candidateDifference;
    }

    public void setCandidateDifference(BigInteger candidateDifference)
    {
        this.candidateDifference = candidateDifference;
    }

    private String candidateContent;

    public String getCandidateContent()
    {
        return this.candidateContent;
    }

    public void setCandidateContent(String candidateContent)
    {
        this.candidateContent = candidateContent;
    }

    private BigInteger version;

    public BigInteger getVersion()
    {
        return this.version;
    }

    public void setVersion(BigInteger version)
    {
        this.version = version;
    }

    private Boolean active;

    public Boolean getActive()
    {
        return this.active;
    }

    public void setActive(Boolean active)
    {
        this.active = active;
    }

    private Long offChainVersion;

    public Long getOffChainVersion()
    {
        return this.offChainVersion;
    }

    public void setOffChainVersion(Long offChainVersion)
    {
        this.offChainVersion = offChainVersion;
    }

    private String createdBy;

    public String getCreatedBy()
    {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy)
    {
        this.createdBy = createdBy;
    }

    private Date createdAt;

    public Date getCreatedAt()
    {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt)
    {
        this.createdAt = createdAt;
    }

    private String updatedBy;

    public String getUpdatedBy()
    {
        return this.updatedBy;
    }

    public void setUpdatedBy(String updatedBy)
    {
        this.updatedBy = updatedBy;
    }

    private Date updatedAt;

    public Date getUpdatedAt()
    {
        return this.updatedAt;
    }

    public void setUpdatedAt(Date updatedAt)
    {
        this.updatedAt = updatedAt;
    }


    public static class DtoConverter extends AbstractStateDtoConverter
    {
        public static Collection<String> collectionFieldNames = Arrays.asList(new String[]{});

        @Override
        protected boolean isCollectionField(String fieldName) {
            return CollectionUtils.collectionContainsIgnoringCase(collectionFieldNames, fieldName);
        }

        public SlotStateDto[] toSlotStateDtoArray(Iterable<SlotState> states) {
            return toSlotStateDtoList(states).toArray(new SlotStateDto[0]);
        }

        public List<SlotStateDto> toSlotStateDtoList(Iterable<SlotState> states) {
            ArrayList<SlotStateDto> stateDtos = new ArrayList();
            for (SlotState s : states) {
                SlotStateDto dto = toSlotStateDto(s);
                stateDtos.add(dto);
            }
            return stateDtos;
        }

        public SlotStateDto toSlotStateDto(SlotState state)
        {
            if(state == null) {
                return null;
            }
            SlotStateDto dto = new SlotStateDto();
            if (returnedFieldsContains("SlotNumber")) {
                dto.setSlotNumber(state.getSlotNumber());
            }
            if (returnedFieldsContains("Id_")) {
                dto.setId_(state.getId_());
            }
            if (returnedFieldsContains("GenesisTimestamp")) {
                dto.setGenesisTimestamp(state.getGenesisTimestamp());
            }
            if (returnedFieldsContains("SlotMaxAmount")) {
                dto.setSlotMaxAmount(state.getSlotMaxAmount());
            }
            if (returnedFieldsContains("MintedAmount")) {
                dto.setMintedAmount(state.getMintedAmount());
            }
            if (returnedFieldsContains("Round")) {
                dto.setRound(state.getRound());
            }
            if (returnedFieldsContains("QualifiedRound")) {
                dto.setQualifiedRound(state.getQualifiedRound());
            }
            if (returnedFieldsContains("QualifiedInscriptionId")) {
                dto.setQualifiedInscriptionId(state.getQualifiedInscriptionId());
            }
            if (returnedFieldsContains("QualifiedHash")) {
                dto.setQualifiedHash(state.getQualifiedHash());
            }
            if (returnedFieldsContains("QualifiedTimestamp")) {
                dto.setQualifiedTimestamp(state.getQualifiedTimestamp());
            }
            if (returnedFieldsContains("QualifiedDifference")) {
                dto.setQualifiedDifference(state.getQualifiedDifference());
            }
            if (returnedFieldsContains("CandidateInscriptionId")) {
                dto.setCandidateInscriptionId(state.getCandidateInscriptionId());
            }
            if (returnedFieldsContains("CandidateHash")) {
                dto.setCandidateHash(state.getCandidateHash());
            }
            if (returnedFieldsContains("CandidateInscriber")) {
                dto.setCandidateInscriber(state.getCandidateInscriber());
            }
            if (returnedFieldsContains("CandidateTimestamp")) {
                dto.setCandidateTimestamp(state.getCandidateTimestamp());
            }
            if (returnedFieldsContains("CandidateAmount")) {
                dto.setCandidateAmount(state.getCandidateAmount());
            }
            if (returnedFieldsContains("CandidateNonce")) {
                dto.setCandidateNonce(state.getCandidateNonce());
            }
            if (returnedFieldsContains("CandidateDifference")) {
                dto.setCandidateDifference(state.getCandidateDifference());
            }
            if (returnedFieldsContains("CandidateContent")) {
                dto.setCandidateContent(state.getCandidateContent());
            }
            if (returnedFieldsContains("Version")) {
                dto.setVersion(state.getVersion());
            }
            if (returnedFieldsContains("Active")) {
                dto.setActive(state.getActive());
            }
            if (returnedFieldsContains("OffChainVersion")) {
                dto.setOffChainVersion(state.getOffChainVersion());
            }
            if (returnedFieldsContains("CreatedBy")) {
                dto.setCreatedBy(state.getCreatedBy());
            }
            if (returnedFieldsContains("CreatedAt")) {
                dto.setCreatedAt(state.getCreatedAt());
            }
            if (returnedFieldsContains("UpdatedBy")) {
                dto.setUpdatedBy(state.getUpdatedBy());
            }
            if (returnedFieldsContains("UpdatedAt")) {
                dto.setUpdatedAt(state.getUpdatedAt());
            }
            return dto;
        }

    }
}

