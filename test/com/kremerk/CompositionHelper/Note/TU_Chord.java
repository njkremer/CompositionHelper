package com.kremerk.CompositionHelper.Note;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

import com.kremerk.CompositionHelper.Note.Chord.Quality;

public class TU_Chord {
	
	@Test
	public void testCopyConstructor() {
		Chord chord1 = new Chord(new Note("C6"));
		Chord chord2 = new Chord(chord1);
		
		assertEquals(chord1, chord2);
		assertNotSame(chord1, chord2);
		
		// modify the first chord and make sure it doesn't affect the other one.
		chord1.getRoot().add(1, false);
		
		assertThat(chord1, not(equalTo(chord2)));
	}
	
	@Test
	public void testGettingANaturalMajorChord() {
		Chord chord = new Chord(new Note("C6"));
		assertEquals(new Note("C6"), chord.getNote(1));
		assertEquals(new Note("E6"), chord.getNote(3));
		assertEquals(new Note("G6"), chord.getNote(5));
		assertEquals(new Note("C7"), chord.getNote(8));
	}
	
	@Test
	public void testGettingANaturalMinorChord() {
		Chord chord = new Chord(new Note("C6"), Quality.MINOR);
		assertEquals(new Note("C6"), chord.getNote(1));
		assertEquals(new Note("Eb6"), chord.getNote(3));
		assertEquals(new Note("G6"), chord.getNote(5));
		assertEquals(new Note("C7"), chord.getNote(8));
	}
}
