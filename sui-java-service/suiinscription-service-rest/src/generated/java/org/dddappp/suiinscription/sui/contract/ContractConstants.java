// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

package org.dddappp.suiinscription.sui.contract;

public class ContractConstants {
    public static final String DEFAULT_SUI_PACKAGE_NAME = "DEFAULT_SUI_PACKAGE";

    public static final String SLOT_MODULE_SLOT_NUMBER_TABLE = "slot::SlotNumberTable";

    public static final String INSCRIPTION_MODULE_INSCRIPTION_MINTED = "inscription::InscriptionMinted";

    public static final String INSCRIPTION_MODULE_INSCRIPTION_DELETED = "inscription::InscriptionDeleted";

    public static final String CERTIFICATE_MODULE_CERTIFICATE_ISSUED = "certificate::CertificateIssued";

    public static final String SLOT_MODULE_SLOT_CREATED = "slot::SlotCreated";

    public static final String SLOT_MODULE_CANDIDATE_INSCRIPTION_PUT_UP = "slot::CandidateInscriptionPutUp";

    public static final String SLOT_MODULE_SLOT_ADVANCED = "slot::SlotAdvanced";


    public static String[] getMoveObjectIdGeneratorObjectTypes(String packageId) {
        return new String[]{
                packageId + "::" + SLOT_MODULE_SLOT_NUMBER_TABLE,
        };
    }
}