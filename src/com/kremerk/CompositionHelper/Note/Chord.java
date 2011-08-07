package com.kremerk.CompositionHelper.Note;

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
	
	public Note getNote(int notePlace) {
		return _notes.get(notePlace);
	}
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		for(Integer key : _notes.keySet()) {
			s.append(_notes.get(key) + " ");
		}
		return s.toString();
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
	
	private LinkedHashMap<Integer, Note> _notes;
	private Quality _quality;
	private Note _root;
	
}
