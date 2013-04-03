package com.njkremer.CompositionHelper;

import javax.sound.midi.MidiUnavailableException;

import com.njkremer.CompositionHelper.Note.Chord;
import com.njkremer.CompositionHelper.Note.Note;
import com.njkremer.CompositionHelper.Note.Chord.Quality;
import com.njkremer.CompositionHelper.Player.NotePlayer;

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
