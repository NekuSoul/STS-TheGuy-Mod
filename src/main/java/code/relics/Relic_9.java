package code.relics;

import code.CharacterFile;
import code.cards.ID_80;
import code.util.Wiz;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.DrawCardNextTurnPower;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import com.megacrit.cardcrawl.rewards.RewardItem;

import static code.ModFile.makeID;

public class Relic_9 extends AbstractEasyRelic {
    public boolean swapedRelic = false;
    public static final String ID = makeID("Relic_9");

    @Override
    public void onManualDiscard() {
        AbstractPlayer p = AbstractDungeon.player;
        this.addToBot(new ApplyPowerAction(p, p, new DrawCardNextTurnPower(p, 1), 1));
    }

    public Relic_9() {
        super(ID, RelicTier.BOSS, LandingSound.FLAT, CharacterFile.Enums.THE_GUY_COLOR);
        swapedRelic = false;
    }

    @Override
    public void onEquip()
    {
        /*
        if (!this.swapedRelic) {
            int relicAtIndex = 0;
            for(int i = 0; i < AbstractDungeon.player.relics.size(); ++i) {
                if (((AbstractRelic)AbstractDungeon.player.relics.get(i)).relicId.equals(makeID("TodoItem"))) {
                    relicAtIndex = i;
                    break;
                }
            }

            AbstractDungeon.player.relics.get(relicAtIndex).onUnequip();
            AbstractDungeon.player.loseRelic(makeID("TodoItem"));
            //AbstractDungeon.player.relics.set(relicAtIndex,this);
            this.instantObtain(AbstractDungeon.player,relicAtIndex,false);
            this.swapedRelic = true;
        }

         */
    }

    @Override
    public void update() {
        super.update();


    }

    @Override
    public boolean canSpawn() {
       return AbstractDungeon.player.hasRelic(makeID("TodoItem"));
    }

    @Override
    public AbstractRelic makeCopy() {
        return new Relic_9();
    }
}
