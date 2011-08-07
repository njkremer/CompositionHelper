package com.kremerk.CompositionHelper.Note;

import static org.junit.Assert.*;

import org.junit.Test;

public class TU_Chord {
	@Test
	public void testGettingANaturalMajorChord() {
		Chord chord = new Chord(new Note("C6"));
		assertEquals(new Note("C6"), chord.getNote(1));
		assertEquals(new Note("E6"), chord.getNote(3));
		assertEquals(new Note("G6"), chord.getNote(5));
		assertEquals(new Note("C7"), chord.getNote(8));
	}
}
