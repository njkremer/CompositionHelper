package com.kremerk.CompositionHelper.Note;

import java.util.Collection;
import java.util.LinkedHashMap;

public class Chord {

	public enum Quality {
		MAJOR, MINOR, AUGMENTED, DIMINISHED, HALF_DIMINISHED;
	}

	public Chord(Note root) {
		this(root, Quality.MAJOR);
	}

	public Chord(Note root, Quality quality) {
		_root = root;
		_quality = quality;
		_notes.put(1, root);
		_notes.put(3, root.add(4, true));
		_notes.put(5, root.add(7, true));
		_notes.put(8, root.add(12, true));
		_adjustForQuality();
	}
	
	public Chord(Chord chord) {
		this(new Note(chord.getRoot()), chord.getQuality());
	}
	
	public Chord getNextFifth() {
		// copy off the chord
		Chord chord = new Chord(this);
		for(Note note : chord.getNotes()) {
			note.add(7, false);
		}
		return chord;
	}
	
	public Chord getPreviousFifth() {
		// copy off the chord
		Chord chord = new Chord(this);
		for(Note note : chord.getNotes()) {
			note.add(-7, false);
		}
		return chord;
	}
	
	/**
	 * 
	 * @param n
	 * @param direction A positive number indicates forward, negative is backwards.
	 * @return
	 */
	public Chord getNthFifth(int n, int direction) {
		Chord chord = new Chord(this);
		for(int i = 0; i < n; i++) {
			if(direction > 1) {
				chord = chord.getNextFifth();
			}
			else if(direction < 0){
				chord = chord.getPreviousFifth();
			}
		}
		return chord;
	}
	
	public Note getRoot() {
		return _root;
	}
	
	public Quality getQuality() {
		return _quality;
	}
	
	public Note getNote(int notePlace) {
		return _notes.get(notePlace);
	}
	
	public Collection<Note> getNotes() {
		return _notes.values();
	}
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		for(Integer key : _notes.keySet()) {
			s.append(_notes.get(key) + " ");
		}
		return s.toString();
	}
	
	public boolean equals(Object other) {
		Chord chord = (Chord) other;
		return _root.equals(chord._root) &&
			   _quality.equals(chord._quality) &&
			   _notes.equals(chord._notes);
	}

	private void _adjustForQuality() {
		switch (_quality) {
			case MINOR: {
				_notes.get(3).add(-1, false);
				break;
			}
			case AUGMENTED: {
				break;
			}
			case DIMINISHED: {
				break;
			}
			case HALF_DIMINISHED: {
				break;
			}
		}
	}

	private void _parseChordString(String chordString) {

	}
	
	private Note _root;
	private Quality _quality;
	private LinkedHashMap<Integer, Note> _notes = new LinkedHashMap<Integer, Note>();
	
}
