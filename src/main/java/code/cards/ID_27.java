package code.cards;

import code.powers.LambdaPower;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.rooms.AbstractRoom;

import static code.ModFile.makeID;
import static code.util.Wiz.*;

public class ID_27 extends AbstractEasyCard {
    public final static String ID = makeID("ID_27");
    // intellij stuff power, self, uncommon, 0, 0, 0, 0, 1, 0

    public ID_27() {
        super(ID, 2, CardType.POWER, CardRarity.UNCOMMON, CardTarget.SELF);
        baseDamage = 0;
        baseBlock = 0;
        baseMagicNumber = magicNumber = 1;
    }

    public void use(AbstractPlayer p, AbstractMonster m)
    {
        applyToSelf(new LambdaPower(makeID("ID_27_Power"), AbstractPower.PowerType.BUFF, false, p, magicNumber) {


            @Override
            public void onDrawOrDiscard()
            {
                AbstractPlayer p = AbstractDungeon.player;
                if (AbstractDungeon.player.hand.isEmpty() && !AbstractDungeon.actionManager.turnHasEnded && !AbstractDungeon.player.hasPower("No Draw") && !AbstractDungeon.isScreenUp && AbstractDungeon.getCurrRoom().phase == AbstractRoom.RoomPhase.COMBAT && (!AbstractDungeon.player.discardPile.isEmpty() || !AbstractDungeon.player.drawPile.isEmpty()))
                    att(new DrawCardAction(amount));
            }
            @Override
            public void onAfterCardPlayed(AbstractCard usedCard)
            {
                if (AbstractDungeon.player.hand.isEmpty() && !AbstractDungeon.actionManager.turnHasEnded && !AbstractDungeon.player.hasPower("No Draw") && !AbstractDungeon.isScreenUp && AbstractDungeon.getCurrRoom().phase == AbstractRoom.RoomPhase.COMBAT && (!AbstractDungeon.player.discardPile.isEmpty() || !AbstractDungeon.player.drawPile.isEmpty()))
                    att(new DrawCardAction(amount));
            }
        });
    }

    public void upp() {
        upgradeDamage(0);
        upgradeBlock(0);
        upgradeMagicNumber(0);
        upgradeBaseCost(1);
    }
}