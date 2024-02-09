package code.relics;

import code.CharacterFile;
import code.cards.ID_80;
import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import com.megacrit.cardcrawl.relics.ToxicEgg2;
import com.megacrit.cardcrawl.rewards.RewardItem;
import com.megacrit.cardcrawl.vfx.GainPennyEffect;

import java.util.Iterator;
import java.util.Objects;

import static code.ModFile.makeID;
public class Relic_3 extends AbstractEasyRelic{
    public static final String ID = makeID("Relic_3");

    int gainedgold = 0;
    public Relic_3() {
        super(ID, RelicTier.UNCOMMON, LandingSound.FLAT, CharacterFile.Enums.THE_GUY_COLOR);

    }

    public String getUpdatedDescription() {
        return this.DESCRIPTIONS[0];
    }

    @Override
    public void atBattleStart() {
        gainedgold = 0;
    }
    @Override
    public void onUseCard(AbstractCard targetCard, UseCardAction useCardAction) {
        if(Objects.equals(targetCard.cardID, makeID("ID_80")) && gainedgold < 12)
        {
            gainedgold += 3;
            AbstractDungeon.player.gainGold(3);
            for(int i = 0; i < 3; ++i) {
                AbstractDungeon.effectList.add(new GainPennyEffect(targetCard.current_x,targetCard.current_y));
            }
        }
    }

    @Override
    public boolean canSpawn() {
        return Settings.isEndless || AbstractDungeon.floorNum <= 48;
    }

    @Override
    public AbstractRelic makeCopy() {
        return new Relic_3();
    }
}
