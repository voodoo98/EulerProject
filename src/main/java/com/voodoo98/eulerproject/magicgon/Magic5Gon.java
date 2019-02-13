package com.voodoo98.eulerproject.magicgon;

public enum Magic5Gon {

	A,
	B,
	C,
	D,
	E,
	F,
	G,
	H,
	I,
	J;

	private int value;

	public int getValue() {
		return this.value;
	}

	public void setValue(final int value) {
		this.value = value;
	}

	public static int[] getIntValues() {
		final int[] result = new int[values().length];
		for (int i = 0; i < result.length; i++) {
			result[i] = values()[i].ordinal() + 1;
		}
		return result;
	}

	public static void setValues(final int[] permArray) {
		for (int i = 0; i < permArray.length; i++) {
			values()[i].setValue(permArray[i]);
		}
	}

}
