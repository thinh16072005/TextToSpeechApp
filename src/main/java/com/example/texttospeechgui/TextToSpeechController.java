package com.example.texttospeechgui;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

import java.util.ArrayList;

public class TextToSpeechController {
    private static final VoiceManager voiceManager = VoiceManager.getInstance();

    public static ArrayList<String> getVoices() {
        System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
        // Create and browsing the list of voices:
        ArrayList<String> voices = new ArrayList<>();
        for (Voice voice : voiceManager.getVoices()) {
            voices.add(voice.getName());
        }
        return voices;
    }

    // Get speed rates
    public static ArrayList<String> getSpeedRates() {
        ArrayList<String> speedRates = new ArrayList<>();
        speedRates.add("10"); // very slow
        speedRates.add("25"); // slow
        speedRates.add("50"); // normal
        speedRates.add("75"); // fast
        speedRates.add("100"); // very fast
        return speedRates;
    }

    // Get volumes:
    public static ArrayList<String> getVolumes() {
        ArrayList<String> volumes = new ArrayList<>();
        // 1-10 volume scale:
        for (int i = 1; i <= 10 ; i++) {
            volumes.add(Integer.toString(i));
        }
        return volumes;
    }

    // Speak:
    public static void speak(String message, String voiceType, String rate, String volume) {
        Voice voice = voiceManager.getVoice(voiceType);
        if (voice == null) {
            System.err.println("Voice " + voiceType + " not found");
            System.exit(1);
        }
        // Allocate the resources for the voice:
        voice.allocate();
        // Set the volume (1-10):
        voice.setVolume(Integer.parseInt(volume));
        // Convert text to speech:
        voice.speak(message);
        // Deallocate the resources when done:
        voice.deallocate();
    }
}