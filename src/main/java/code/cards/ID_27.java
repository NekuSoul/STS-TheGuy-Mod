package code.cards;

import code.cards.AbstractEasyCard;
import code.powers.LambdaPower;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
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
        applyToSelf(new LambdaPower(makeID("ID_27_Power"), "cardStrings.EXTENDED_DESCRIPTION[0]", AbstractPower.PowerType.BUFF, false, p, magicNumber) {

            @Override
            public void onRefreshHand() {
                AbstractPlayer p = AbstractDungeon.player;
                if (AbstractDungeon.actionManager.actions.isEmpty() && AbstractDungeon.player.hand.isEmpty() && !AbstractDungeon.actionManager.turnHasEnded && !AbstractDungeon.player.hasPower("No Draw") && !AbstractDungeon.isScreenUp && AbstractDungeon.getCurrRoom().phase == AbstractRoom.RoomPhase.COMBAT && (AbstractDungeon.player.discardPile.size() > 0 || AbstractDungeon.player.drawPile.size() > 0)) {
                    this.flash();
                    this.addToBot(new DrawCardAction(AbstractDungeon.player, 1));
                }
            }

            @Override
            public void updateDescription() {
                description = ""; // cardStrings.EXTENDED_DESCRIPTION[1] + amount + cardStrings.EXTENDED_DESCRIPTION[2] + amount + cardStrings.EXTENDED_DESCRIPTION[3];
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