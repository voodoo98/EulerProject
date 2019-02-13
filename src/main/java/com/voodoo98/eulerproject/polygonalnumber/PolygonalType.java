package com.voodoo98.eulerproject.polygonalnumber;

public enum PolygonalType {

    TRIANGLE(3),
    SQUARE(4),
    PENTAGONAL(5),
    HEXAGONAL(6),
    HEPTAGONAL(7),
    OCTAGONAL(8);

    private final int typeIndex;

    private PolygonalType(final int typeIndex) {
        this.typeIndex = typeIndex;
    }

    public static PolygonalType parseFromIndex(final int indexType) {
        PolygonalType polygonalType = null;
        for (final PolygonalType type : values()) {
            if (type.getTypeIndex() == indexType) {
                polygonalType = type;
                break;
            }
        }
        return polygonalType;
    }

    public int getTypeIndex() {
        return this.typeIndex;
    }

}
