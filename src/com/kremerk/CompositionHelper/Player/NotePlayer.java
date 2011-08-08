package com.kremerk.CompositionHelper.Player;

import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;

import com.kremerk.CompositionHelper.Note.Chord;
import com.kremerk.CompositionHelper.Note.Note;

public class NotePlayer {
	
	public static void play(Note note) {
		if(_synthesizer == null) {
			init();
		}
		try {
			_synthesizer.open();
			_channel.noteOn(note.getIntValue(), 50);
			Thread.sleep(2000);
			_channel.allNotesOff();
			Thread.sleep(200);
			_synthesizer.close();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (MidiUnavailableException e) {
			e.printStackTrace();
		}
	}
	
	public static void play(Chord chord) {
		if(_synthesizer == null) {
			init();
		}
		try {
			_synthesizer.open();
			for(Note note : chord.getNotes()) {
				_channel.noteOn(note.getIntValue(), 50);
			}
			Thread.sleep(2000);
			_channel.allNotesOff();
			Thread.sleep(200);
			_synthesizer.close();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (MidiUnavailableException e) {
			e.printStackTrace();
		}
	}
	
	private static void init() {
		try {
			_synthesizer = MidiSystem.getSynthesizer();
			_channel = _synthesizer.getChannels()[0];
		} catch (MidiUnavailableException e) {
			e.printStackTrace();
		}
	}
	
	private static Synthesizer _synthesizer;
	private static MidiChannel _channel;
}
