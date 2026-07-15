package example;

import mindustry.*;
import mindustry.content.*;
import mindustry.game.EventType.*;
import mindustry.gen.*;
import mindustry.mod.*;
import mindustry.ui.dialogs.*;
import example.content.block.ACoreBlock;
import arc.util.Log;
import arc.Events;
import arc.util.Time;
import arc.Core;


public class Test extends Mod{

    public Test(){
        Log.info("Test mod loaded!");


        Events.on(ClientLoadEvent.class, e -> {
         Time.runTask(10f, () -> {
             BaseDialog dialog = new BaseDialog("Test Dialog");
             dialog.cont.add("This is a test dialog!").row();
             dialog.cont.add("You can add more content here.").row();
             dialog.cont.image(Core.atlas.find("frog")).size(64f).row();
             dialog.cont.button("Close", dialog::hide).size(200f, 64f).row();
                dialog.show();
         });
        });
    }

    @Override
    public void loadContent(){
      super.loadContent();
            // instantiate custom core block for testing
            new ACoreBlock("acore");
    }

}
