package com.kremerk.CompositionHelper;

import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;

import com.kremerk.CompositionHelper.Note.Note;

public class TestDriver {

	/**
	 * @param args
	 * @throws MidiUnavailableException 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws MidiUnavailableException, InterruptedException {
		Synthesizer synth = MidiSystem.getSynthesizer();
		synth.open();
		
		MidiChannel channel = synth.getChannels()[0];
		channel.noteOn(new Note("C6").getIntValue(), 50);
		channel.noteOn(new Note("E6").getIntValue(), 50);
		channel.noteOn(new Note("G6").getIntValue(), 50);
		Thread.sleep(2000);
		channel.allNotesOff();
		Thread.sleep(200);
	}

}
