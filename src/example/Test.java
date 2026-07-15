/**
 * 示例 mod 主类 — 用于演示和测试。
 * 说明：此文件为示例入口，会在客户端加载时显示一个测试对话框，并在 `loadContent` 中加载示例内容。
 */
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
          
            Liquids.load();
            
            new ACoreBlock("acore");

    }

}
