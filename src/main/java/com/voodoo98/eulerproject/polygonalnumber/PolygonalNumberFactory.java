package com.voodoo98.eulerproject.polygonalnumber;

public class PolygonalNumberFactory {

    private PolygonalNumberFactory() {
    }

    public static PolygonalNumber getInstance(final PolygonalType polygonalType) {

        PolygonalNumber polygonalNumber = null;
        switch (polygonalType) {
            case TRIANGLE:
                polygonalNumber = new TriangleNumber();
                break;
            case SQUARE:
                polygonalNumber = new SquareNumber();
                break;
            case PENTAGONAL:
                polygonalNumber = new PentagonalNumber();
                break;
            case HEXAGONAL:
                polygonalNumber = new HexagonalNumber();
                break;
            case HEPTAGONAL:
                polygonalNumber = new HeptagonalNumber();
                break;
            case OCTAGONAL:
                polygonalNumber = new OctagonalNumber();
                break;
            default:
                break;
        }
        polygonalNumber.setType(polygonalType);
        polygonalNumber.count();
        return polygonalNumber;
    }
}
