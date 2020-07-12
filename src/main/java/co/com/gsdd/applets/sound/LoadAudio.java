package co.com.gsdd.applets.sound;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Button;
import java.awt.Choice;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.util.HashMap;
import java.util.Map;

public class LoadAudio extends Applet {

	private static final long serialVersionUID = -6483320475550879244L;
	private AudioClip currentClip;
	private Choice selectSound;

	public void init() {
		Map<String, AudioClip> audioClips = new HashMap<>();
		audioClips.put("Hi", getAudioClip(getDocumentBase(), "hi.au"));
		audioClips.put("Welcome", getAudioClip(getDocumentBase(), "welcome.wav"));
		
		selectSound = new Choice();
		audioClips.keySet().stream().forEach(key -> selectSound.add(key));
		add(selectSound);

		selectSound.addItemListener((ItemEvent e) -> {
			currentClip.stop();
			currentClip = audioClips.getOrDefault(selectSound.getSelectedItem(), currentClip);
		});

		Button play = new Button("Play");
		play.addActionListener((ActionEvent e) -> currentClip.play());
		add(play);
		Button loop = new Button("Loop");
		loop.addActionListener((ActionEvent e) -> currentClip.loop());
		add(loop);
		Button stop = new Button("Stop");
		stop.addActionListener((ActionEvent e) -> currentClip.stop());
		add(stop);
		currentClip = audioClips.get("Hi");
	}

	public void stop() {
		currentClip.stop();
	}
	
}
