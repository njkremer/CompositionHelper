package com.kremerk.CompositionHelper;

import javax.sound.midi.MidiUnavailableException;

import com.kremerk.CompositionHelper.Note.Chord;
import com.kremerk.CompositionHelper.Note.Chord.Quality;
import com.kremerk.CompositionHelper.Note.Note;
import com.kremerk.CompositionHelper.Player.NotePlayer;

public class TestDriver {

	/**
	 * @param args
	 * @throws MidiUnavailableException 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws MidiUnavailableException, InterruptedException {
		NotePlayer.play(new Note("C6"));
		NotePlayer.play(new Chord(new Note("C6")));
		NotePlayer.play(new Chord(new Note("G6")));
		NotePlayer.play(new Chord(new Note("A6"), Quality.MINOR));
		NotePlayer.play(new Chord(new Note("F6")));
	}

}
