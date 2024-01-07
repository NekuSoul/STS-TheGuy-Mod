package code.cards;

import code.cards.AbstractEasyCard;
import code.powers.LambdaPower;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;

import static code.ModFile.makeID;
import static code.util.Wiz.*;

public class ID_39 extends AbstractEasyCard {
    public final static String ID = makeID("ID_39");
    // intellij stuff power, self, uncommon, 10, 0, 0, 0, 10, 0

    public ID_39() {
        super(ID, 1, CardType.POWER, CardRarity.UNCOMMON, CardTarget.SELF);
        baseDamage = 10;
        baseBlock = 0;
        baseMagicNumber = magicNumber = 10;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        applyToSelf(new LambdaPower(makeID("ID_39_Power"), "cardStrings.EXTENDED_DESCRIPTION[0]", AbstractPower.PowerType.BUFF, false, p, magicNumber) {


            @Override
            public void onManualDiscard()
            {
                amount--;
                if (this.amount == 0) {
                    this.flash();
                    this.amount = magicNumber;
                    this.addToBot(new DamageAllEnemiesAction(AbstractDungeon.player, DamageInfo.createDamageMatrix(damage, true), DamageInfo.DamageType.THORNS, AbstractGameAction.AttackEffect.SLASH_DIAGONAL));
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
        upgradeBaseCost(0);
    }
}