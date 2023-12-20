package org.dddappp.suiinscription.domain.hibernate;

import org.hibernate.type.descriptor.WrapperOptions;
import org.hibernate.type.descriptor.java.AbstractTypeDescriptor;
import org.hibernate.type.descriptor.java.ImmutableMutabilityPlan;
import org.hibernate.type.descriptor.java.MutabilityPlan;

import java.util.Arrays;

public class IntArrayStringTypeDescriptor extends AbstractTypeDescriptor<int[]> {
    public static final IntArrayStringTypeDescriptor INSTANCE = new IntArrayStringTypeDescriptor();

    private IntArrayStringTypeDescriptor() {
        super(int[].class);
    }

    @Override
    public int[] fromString(String s) {
        if (s.startsWith("[") && s.endsWith("]")) {
            s = s.substring(1, s.length() - 1);
        }
        String[] ss = s.split(",");
        int[] intArray = new int[ss.length];
        for (int i = 0; i < ss.length; i++) {
            intArray[i] = Integer.parseInt(ss[i].trim(), 16);
        }
        return intArray;
    }

    @Override
    public String toString(int[] value) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < value.length; i++) {
            sb.append(value[i]);//Integer.toHexString(value[i]));
            if (i < value.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean areEqual(int[] one, int[] another) {
        return one == another || (one != null && another != null && Arrays.equals(one, another));
    }

    @Override
    public int extractHashCode(int[] value) {
        return Arrays.hashCode(value);
    }

    @Override
    public MutabilityPlan<int[]> getMutabilityPlan() {
        return ImmutableMutabilityPlan.INSTANCE;
    }

    @Override
    public <X> X unwrap(int[] value, Class<X> type, WrapperOptions options) {
        if (value == null) {
            return null;
        }
        if (int[].class.isAssignableFrom(type)) {
            return (X) value;
        }
        if (String.class.isAssignableFrom(type)) {
            return (X) toString(value);
        }
        throw unknownUnwrap(type);
    }

    @Override
    public <X> int[] wrap(X value, WrapperOptions options) {
        if (value == null) {
            return null;
        }
        if (value instanceof int[]) {
            return (int[]) value;
        }
        if (value instanceof String) {
            return fromString((String) value);
        }
        throw unknownWrap(value.getClass());
    }
}
