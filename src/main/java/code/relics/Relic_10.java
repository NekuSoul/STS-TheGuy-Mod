package code.relics;

import code.CharacterFile;
import code.cards.ID_80;
import code.util.Wiz;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.EnergyManager;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.DrawCardNextTurnPower;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import com.megacrit.cardcrawl.rewards.RewardItem;
import com.megacrit.cardcrawl.ui.panels.EnergyPanel;

import static code.ModFile.makeID;

public class Relic_10 extends AbstractEasyRelic {
    public boolean canTrigger = false;
    public static final String ID = makeID("Relic_10");

    @Override
    public void onManualDiscard() {
        AbstractPlayer p = AbstractDungeon.player;
        this.addToBot(new ApplyPowerAction(p, p, new DrawCardNextTurnPower(p, 1), 1));
    }

    public Relic_10() {
        super(ID, RelicTier.BOSS, LandingSound.FLAT, CharacterFile.Enums.THE_GUY_COLOR);
    }

    public void atTurnStart() {
        canTrigger = true;
        this.setCounter(1);
    }

    public void onRefreshHand()
    {
        if(EnergyPanel.totalCount == 0 && canTrigger) {
            canTrigger = false;
            AbstractDungeon.player.hand.addToHand(new ID_80());
            this.flash();
            this.setCounter(0);
        }
    }

    @Override
    public void update() {
        super.update();
    }

    @Override
    public boolean canSpawn() {
        return true;
    }

    @Override
    public AbstractRelic makeCopy() {
        return new Relic_10();
    }
}