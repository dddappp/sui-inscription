// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

module sui_inscription::certificate_issued {

    use std::option;
    use std::string::String;
    use sui::object::{Self, ID};
    use sui_inscription::certificate::{Self, CertificateIssued};

    public fun id(certificate_issued: &CertificateIssued): option::Option<object::ID> {
        certificate::certificate_issued_id(certificate_issued)
    }

    public fun inscription_object_id(certificate_issued: &CertificateIssued): ID {
        certificate::certificate_issued_inscription_object_id(certificate_issued)
    }

    public fun inscription_hash(certificate_issued: &CertificateIssued): vector<u8> {
        certificate::certificate_issued_inscription_hash(certificate_issued)
    }

    public fun slot_number(certificate_issued: &CertificateIssued): u8 {
        certificate::certificate_issued_slot_number(certificate_issued)
    }

    public fun round(certificate_issued: &CertificateIssued): u64 {
        certificate::certificate_issued_round(certificate_issued)
    }

    public fun inscriber(certificate_issued: &CertificateIssued): address {
        certificate::certificate_issued_inscriber(certificate_issued)
    }

    public fun inscription_timestamp(certificate_issued: &CertificateIssued): u64 {
        certificate::certificate_issued_inscription_timestamp(certificate_issued)
    }

    public fun amount(certificate_issued: &CertificateIssued): u64 {
        certificate::certificate_issued_amount(certificate_issued)
    }

    public fun inscription_content(certificate_issued: &CertificateIssued): String {
        certificate::certificate_issued_inscription_content(certificate_issued)
    }

    public fun certificate_type(certificate_issued: &CertificateIssued): u8 {
        certificate::certificate_issued_certificate_type(certificate_issued)
    }

}
