package code.relics;

import code.CharacterFile;
import code.cards.ID_80;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

import static code.ModFile.makeID;

public class Relic_1 extends AbstractEasyRelic {
    public static final String ID = makeID("Relic_1");

    @Override
    public void atBattleStart() {
        AbstractDungeon.player.hand.addToHand(new ID_80());
        this.flash();
        this.usedUp();
    }

    public Relic_1() {
        super(ID, RelicTier.STARTER, LandingSound.FLAT, CharacterFile.Enums.THE_GUY_COLOR);

    }
}
