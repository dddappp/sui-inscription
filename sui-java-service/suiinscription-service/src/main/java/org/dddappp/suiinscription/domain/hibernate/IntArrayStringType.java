package org.dddappp.suiinscription.domain.hibernate;

import org.hibernate.type.AbstractSingleColumnStandardBasicType;
import org.hibernate.type.descriptor.sql.VarcharTypeDescriptor;

public class IntArrayStringType extends AbstractSingleColumnStandardBasicType<int[]> {

    public static final IntArrayStringType INSTANCE = new IntArrayStringType();

    public IntArrayStringType() {
        super(VarcharTypeDescriptor.INSTANCE, IntArrayStringTypeDescriptor.INSTANCE);
    }

    @Override
    public String getName() {
        return "int-array-string";
    }
}