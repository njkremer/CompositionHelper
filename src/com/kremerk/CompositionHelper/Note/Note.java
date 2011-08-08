package com.kremerk.CompositionHelper.Note;



public class Note {
	enum Notes {
		A(-3, "A"),
		A_SHARP(-2, "A#"),
		B(-1, "B"),
		C(0, "C"),
		C_SHARP(1, "C#"),
		D(2, "D"),
		D_SHARP(3, "D#"),
		E(4, "E"),
		F(5, "F"),
		F_SHARP(6, "F#"),
		G(7, "G"),
		G_SHARP(8, "G#");
		
		private final int _startingIndex;
		private final String _noteString;
		
		Notes(int startingIndex, String noteString) {
			_startingIndex = startingIndex;
			_noteString = noteString;
		}
		
		public int getStartingIndex() {
			return _startingIndex;
		}
		
		public String getName() {
			return _noteString;
		}
		
		public static Notes getNoteByStartIndex(int index) {
			for(Notes n : Notes.values()) {
				if(n._startingIndex == index) {
					return n;
				}
			}
			return null;
		}
		
	}
	
	public enum Accidental {
		FLAT("b", -1),
		NATURAL("", 0),
		SHARP("#", +1);
		
		private final String _symbol;
		private final int _offset;
		
		Accidental(String symbol, int offset) {
			_symbol = symbol;
			_offset = offset;
		}
		
		public String getSymbol() {
			return _symbol;
		}
		
		public int getOffset() {
			return _offset;
		}
		
	}
	
	public Note(Notes note, int octave) {
		_note = note;
		_octave = octave;
	}
	
	public Note(Note note) {
		_note = note._note;
		_octave = note._octave;
	}
	
	public Note(String noteString) {
		_parseNoteString(noteString);
	}
	
	public Note add(int halfSteps, boolean clone) {
		Note note = this;
		if(clone) {
			note = new Note(this);
		}
		note._octave += halfSteps / 12;
		int startingValue = note._note.getStartingIndex() + halfSteps % 12;
		note._note = _addNote(startingValue, note);
		return note;
	}
	
	public int getIntValue() {
		int noteIndex = (_octave - 1) * 12 + _note.getStartingIndex();
		if(noteIndex < 0 || noteIndex > 127) {
			return -1;
		}
		return noteIndex;
	}
	
	public String getName() {
		return _note.getName();
	}
	
	public String toString() {
		return _note.getName() + _octave;
	}
	
	public boolean equals(Object otherNote) {
		return _octave == ((Note) otherNote)._octave &&  _note == ((Note) otherNote)._note;
	}
	
	private Notes _addNote(int startingValue, Note note) {
		if(startingValue > 8) {
			startingValue -= 12;
			note._octave++;
		}
		else if(startingValue < -3) {
			startingValue += 12;
			note._octave--;
		}
		return Notes.getNoteByStartIndex(startingValue);
	}
	
	private void _parseNoteString(String noteString) {
		String name = noteString.substring(0, 1);
		String modifier = noteString.substring(1, 2);
		_note = Notes.valueOf(name);
		int startingValue = _note.getStartingIndex();
		_octave = noteString.length() > 2 ? Integer.parseInt(noteString.substring(2, 3)) : 1;
		if(modifier.equals("#")) {
			startingValue++;
			_note = _addNote(startingValue, this);
		}
		else if(modifier.equals("b")) {
			startingValue--;
			_note = _addNote(startingValue, this);
		}
		else {
			_octave = Integer.parseInt(noteString.substring(1, noteString.length()));
		}
	}
	
	private Notes _note;
	private int _octave;
	
}
