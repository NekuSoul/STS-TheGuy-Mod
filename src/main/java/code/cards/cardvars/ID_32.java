package code.cards.cardvars;

import code.cards.AbstractEasyCard;
import com.megacrit.cardcrawl.actions.animations.TalkAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.utility.SFXAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.ConfusionPower;

import static code.ModFile.makeID;
import static code.util.Wiz.*;

public class ID_32 extends AbstractEasyCard {
    public final static String ID = makeID("ID_32");
    // intellij stuff power, self, rare, 0, 0, 0, 0, 2, 0

    public ID_32() {
        super(ID, 1, CardType.POWER, CardRarity.RARE, CardTarget.SELF);
        baseDamage = 0;
        baseBlock = 0;
        baseMagicNumber = magicNumber = 1;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        applyToSelf(new ConfusionPower(p));
        this.addToBot(new SFXAction("VO_CULTIST_1A"));
        this.addToBot(new TalkAction(true, "Birds are not real", 1.0F, 2.0F));
        atb(new DrawCardAction(magicNumber));
    }

    public void upp() {
        upgradeDamage(0);
        upgradeBlock(0);
        upgradeMagicNumber(0);
        upgradeBaseCost(0);
    }
}