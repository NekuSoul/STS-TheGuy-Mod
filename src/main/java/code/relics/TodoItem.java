package code.relics;

import code.CharacterFile;
import code.cards.ID_80;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

import static code.ModFile.makeID;

public class TodoItem extends AbstractEasyRelic {
    public static final String ID = makeID("TodoItem");

    @Override
    public void atBattleStart() {
        AbstractDungeon.player.hand.addToHand(new ID_80());
        this.flash();
    }
    public TodoItem() {
        super(ID, RelicTier.STARTER, LandingSound.FLAT, CharacterFile.Enums.THE_GUY_COLOR);

    }
}
