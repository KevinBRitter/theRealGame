package GameDev;

import com.sun.xml.internal.messaging.saaj.soap.ver1_2.Message1_2Impl;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import static java.lang.Thread.sleep;

public class Introduction
{
    // Special thanks to Ian Anders for help on the music method featured below.
    Clip clip;
    public void intro()
    {
        String Message1 = "";
        Message1 += "\n\n\tA pounding headache was your “blissful” return to the world, quickly followed by the smell, \n";
        Message1 += "and taste, of something having died in your mouth. You gagged, wondering why you’d decided \n";
        Message1 += "to eat roadkill – or something of that nature! Then, as you opened your eyes and immediately \n";
        Message1 += "flinched at the dim light, you remembered.  You’d spent a night out and about, partying it up, \n";
        Message1 += "living to enjoy the college experience that so many sitcoms, tv shows, and high school talk-ups \n";
        Message1 += "had prepared you for. The party last night was fun, what little you could remember of it. \n";
        Message1 += "Today though? Today you wished you could die!  You remained laying down, sore and aggrieved, \n";
        Message1 += "and slowly you began to become more aware. The ground was… hard. Your hands patted around \n";
        Message1 += "you and sure enough, they touched stone and rock, rather than the comfortable \n";
        Message1 += "(or not so comfortable) bedding you’d gotten used to over the past few months.\n\n";

        String Message2 = "";
        Message2 += "\tHad you… fallen asleep on the road? That thought made you jolt, eyes opening wide. What view\n";
        Message2 += "you saw swam before you, blurry, but slowly came into focus. The light that you’d assumed was \n";
        Message2 += "the sun through a window was instead revealed to be wavering, crackling ever so quietly – \n";
        Message2 += "a torch? And not the British kind of torch that was really a flash light, but a piece of \n";
        Message2 += "wood shoved into a sconce, burning for light!\n\n";

        String Message3 = "";
        Message3 += "\tWhat the hell…? Had you been kidnapped by some madman waaaay too into roleplaying? \n";
        Message3 += "You looked around, tempted to call out, but that seemed like a silly idea. Another thought \n";
        Message3 += "made you glance down, before letting out a sigh of relief. You were still wearing your clothes, \n";
        Message3 += "smelly though they seemed to be, although you weren’t sure if you trusted your nose to tell \n";
        Message3 += "you the truth about them right now.  Glancing around the room again, you spotted a \n";
        Message3 += "wooden door. Approaching it, you see that it was quite rotten, the planks moldy and cracked, \n";
        Message3 += "hardly a secure door. \n\n\tDo you choose to open it and see what awaits you?\n...";
        Message3 += "Welp, nothing's happening here - might as well find out what kind of weird dungeon you're in!";

        try {
            System.out.println(Message1);
            sleep(10000);

            System.out.println(Message2);
            sleep(10000);

            System.out.println(Message3);
            sleep(5000);
        }catch(Exception e){ System.out.println("uh roh raggy sleep failed.\n" + e);}

        try
        {
            AudioInputStream music = AudioSystem.getAudioInputStream(
                    this.getClass().getResource("test.wav"));
            clip = AudioSystem.getClip();
            clip.open(music);
            clip.start();
            clip.loop(100000);


//            clip.stop();
        }catch(Exception e){ System.out.println("uh roh raggy music failed.\n" + e);}
    }
}
