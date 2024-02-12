package code.relics;

import code.CharacterFile;
import code.cards.ID_80;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import com.megacrit.cardcrawl.relics.ToxicEgg2;
import com.megacrit.cardcrawl.rewards.RewardItem;

import java.util.Iterator;

import static code.ModFile.makeID;
public class Relic_2 extends AbstractEasyRelic{
    public static final String ID = makeID("Relic_2");
    public Relic_2() {
        super(ID, RelicTier.UNCOMMON, LandingSound.FLAT, CharacterFile.Enums.THE_GUY_COLOR);

    }

    public String getUpdatedDescription() {
        return this.DESCRIPTIONS[0];
    }

    @Override
    public void onEquip() {
        Iterator var1 = AbstractDungeon.combatRewardScreen.rewards.iterator();

        while(true) {
            RewardItem reward;
            do {
                if (!var1.hasNext()) {
                    return;
                }

                reward = (RewardItem)var1.next();
            } while(reward.cards == null);

            Iterator var3 = reward.cards.iterator();

            while(var3.hasNext()) {
                AbstractCard c = (AbstractCard)var3.next();
                this.onPreviewObtainCard(c);
            }
        }
    }
    @Override
    public void onPreviewObtainCard(AbstractCard c) {
        this.onObtainCard(c);
    }

    @Override
    public void onObtainCard(AbstractCard c) {
        if (c.cost == -1 && c.canUpgrade() && !c.upgraded) {
            c.upgrade();
        }

    }

    @Override
    public boolean canSpawn() {
        return Settings.isEndless || AbstractDungeon.floorNum <= 48;
    }

    @Override
    public AbstractRelic makeCopy() {
        return new Relic_2();
    }
}
