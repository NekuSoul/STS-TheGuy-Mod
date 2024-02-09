package code.relics;

import code.CharacterFile;
import code.cards.ID_80;
import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.EnergizedPower;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import com.megacrit.cardcrawl.relics.ToxicEgg2;
import com.megacrit.cardcrawl.rewards.RewardItem;
import com.megacrit.cardcrawl.vfx.GainPennyEffect;

import java.util.Iterator;
import java.util.Objects;

import static code.ModFile.makeID;
import static code.util.Wiz.applyToSelf;

public class Relic_4 extends AbstractEasyRelic{
    public static final String ID = makeID("Relic_4");

    int gainedgold = 0;
    public Relic_4() {
        super(ID, RelicTier.UNCOMMON, LandingSound.FLAT, CharacterFile.Enums.THE_GUY_COLOR);

    }

    public String getUpdatedDescription() {
        return this.DESCRIPTIONS[0];
    }

    @Override
    public void onPlayerEndTurn() {
        if(AbstractDungeon.player.hand.isEmpty())
        {
            applyToSelf(new EnergizedPower(AbstractDungeon.player,1));
        }
    }

    @Override
    public boolean canSpawn() {
        return Settings.isEndless || AbstractDungeon.floorNum <= 48;
    }

    @Override
    public AbstractRelic makeCopy() {
        return new Relic_4();
    }
}