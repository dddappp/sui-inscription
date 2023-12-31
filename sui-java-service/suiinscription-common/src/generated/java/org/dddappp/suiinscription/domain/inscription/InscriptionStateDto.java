// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

package org.dddappp.suiinscription.domain.inscription;

import java.util.*;
import java.math.*;
import java.math.BigInteger;
import java.util.Date;
import org.dddappp.suiinscription.domain.*;
import org.dddappp.suiinscription.specialization.*;


public class InscriptionStateDto {

    private String id;

    public String getId()
    {
        return this.id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    private int[] hash;

    public int[] getHash()
    {
        return this.hash;
    }

    public void setHash(int[] hash)
    {
        this.hash = hash;
    }

    private Integer slotNumber;

    public Integer getSlotNumber()
    {
        return this.slotNumber;
    }

    public void setSlotNumber(Integer slotNumber)
    {
        this.slotNumber = slotNumber;
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

    private String inscriber;

    public String getInscriber()
    {
        return this.inscriber;
    }

    public void setInscriber(String inscriber)
    {
        this.inscriber = inscriber;
    }

    private BigInteger timestamp;

    public BigInteger getTimestamp()
    {
        return this.timestamp;
    }

    public void setTimestamp(BigInteger timestamp)
    {
        this.timestamp = timestamp;
    }

    private BigInteger amount;

    public BigInteger getAmount()
    {
        return this.amount;
    }

    public void setAmount(BigInteger amount)
    {
        this.amount = amount;
    }

    private BigInteger nonce;

    public BigInteger getNonce()
    {
        return this.nonce;
    }

    public void setNonce(BigInteger nonce)
    {
        this.nonce = nonce;
    }

    private String content;

    public String getContent()
    {
        return this.content;
    }

    public void setContent(String content)
    {
        this.content = content;
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

        public InscriptionStateDto[] toInscriptionStateDtoArray(Iterable<InscriptionState> states) {
            return toInscriptionStateDtoList(states).toArray(new InscriptionStateDto[0]);
        }

        public List<InscriptionStateDto> toInscriptionStateDtoList(Iterable<InscriptionState> states) {
            ArrayList<InscriptionStateDto> stateDtos = new ArrayList();
            for (InscriptionState s : states) {
                InscriptionStateDto dto = toInscriptionStateDto(s);
                stateDtos.add(dto);
            }
            return stateDtos;
        }

        public InscriptionStateDto toInscriptionStateDto(InscriptionState state)
        {
            if(state == null) {
                return null;
            }
            InscriptionStateDto dto = new InscriptionStateDto();
            if (returnedFieldsContains("Id")) {
                dto.setId(state.getId());
            }
            if (returnedFieldsContains("Hash")) {
                dto.setHash(state.getHash());
            }
            if (returnedFieldsContains("SlotNumber")) {
                dto.setSlotNumber(state.getSlotNumber());
            }
            if (returnedFieldsContains("Round")) {
                dto.setRound(state.getRound());
            }
            if (returnedFieldsContains("Inscriber")) {
                dto.setInscriber(state.getInscriber());
            }
            if (returnedFieldsContains("Timestamp")) {
                dto.setTimestamp(state.getTimestamp());
            }
            if (returnedFieldsContains("Amount")) {
                dto.setAmount(state.getAmount());
            }
            if (returnedFieldsContains("Nonce")) {
                dto.setNonce(state.getNonce());
            }
            if (returnedFieldsContains("Content")) {
                dto.setContent(state.getContent());
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

