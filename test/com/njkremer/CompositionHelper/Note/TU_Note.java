package com.njkremer.CompositionHelper.Note;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.njkremer.CompositionHelper.Note.Note;
import com.njkremer.CompositionHelper.Note.Note.Notes;

public class TU_Note {
	
	@Test
	public void testGetNote() {
		assertEquals(0, new Note(Notes.C, 1).getIntValue());
		assertEquals(1, new Note(Notes.C_SHARP, 1).getIntValue());
		assertEquals(5, new Note(Notes.F, 1).getIntValue());
		assertEquals(8, new Note(Notes.G_SHARP, 1).getIntValue());
		assertEquals(9, new Note(Notes.A, 2).getIntValue());
		assertEquals(12, new Note(Notes.C, 2).getIntValue());
		assertEquals(24, new Note(Notes.C, 3).getIntValue());
		assertEquals(36, new Note(Notes.C, 4).getIntValue());
		assertEquals(48, new Note(Notes.C, 5).getIntValue());
		assertEquals(60, new Note(Notes.C, 6).getIntValue());
		assertEquals(72, new Note(Notes.C, 7).getIntValue());
		assertEquals(84, new Note(Notes.C, 8).getIntValue());
		assertEquals(96, new Note(Notes.C, 9).getIntValue());
		assertEquals(108, new Note(Notes.C, 10).getIntValue());
		assertEquals(120, new Note(Notes.C, 11).getIntValue());
		assertEquals(127, new Note(Notes.G, 11).getIntValue());
	}
	
	@Test
	public void testGetOutOfRangeNote() {
		assertEquals(-1, new Note(Notes.A, 1).getIntValue());
		assertEquals(-1, new Note(Notes.C, 12).getIntValue());
	}
	
	@Test
	public void testGettingNoteByString() {
		assertEquals(0, new Note("C1").getIntValue());
		assertEquals(1, new Note("C#1").getIntValue());
		assertEquals(5, new Note("F1").getIntValue());
		assertEquals(8, new Note("G#1").getIntValue());
		assertEquals(9, new Note("A2").getIntValue());
		assertEquals(12, new Note("C2").getIntValue());
		assertEquals(1, new Note("Db1").getIntValue());
		assertEquals(127, new Note("G11").getIntValue());
		assertEquals(4, new Note("Fb1").getIntValue());
		assertEquals(8, new Note("Ab2").getIntValue());
	}
	
	@Test
	public void testGoingFromNaturalToSharp() {
		Note note = new Note("D1");
		note.add(1, false);
		assertEquals(3, note.getIntValue());
	}
	
	@Test
	public void testGoingFromNaturalToFlat() {
		Note note = new Note("D1");
		note.add(-1, false);
		assertEquals(1, note.getIntValue());
	}
	
	@Test
	public void testGoingFromNaturalToNatural() {
		Note note = new Note("E1");
		note.add(1, false);
		assertEquals(5, note.getIntValue());
	}
	
	@Test
	public void testGoingFromSharpToNatural() {
		Note note = new Note("D#1");
		note.add(1, false);
		assertEquals(4, note.getIntValue());
	}
	
	@Test
	public void testGoingFromFlatToNatural() {
		Note note = new Note("Db1");
		note.add(1, false);
		assertEquals(2, note.getIntValue());
	}
	
	@Test
	public void testRollingOverOctaves() {
		Note note = new Note("G#1");
		note.add(1, false);
		assertEquals(9, note.getIntValue());
	}
	
	@Test
	public void testAddWithClone() {
		Note note = new Note("G#1");
		Note newNote = note.add(1, true);
		assertEquals(8, note.getIntValue());
		assertEquals(9, newNote.getIntValue());
	}
	
}
