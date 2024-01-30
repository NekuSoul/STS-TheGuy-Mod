package code.cards;

import code.actions.EasyModalChoiceAction;
import code.cards.AbstractEasyCard;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.DexterityPower;
import com.megacrit.cardcrawl.powers.StrengthPower;
import com.megacrit.cardcrawl.powers.watcher.MarkPower;

import java.util.ArrayList;

import static code.ModFile.makeID;
import static code.util.Wiz.*;

public class ID_33 extends AbstractEasyCard {
    public final static String ID = makeID("ID_33");
    // intellij stuff skill, self, rare, 0, 0, 0, 0, 5, 0

    public ID_33() {
        super(ID, 5, CardType.SKILL, CardRarity.RARE, CardTarget.SELF);
        baseDamage = 0;
        baseBlock = 0;
        baseMagicNumber = magicNumber = 5;
    }

    public void use(AbstractPlayer p, AbstractMonster m)
    {
        if(!this.upgraded)
        {
            applyToSelf(new StrengthPower(p,magicNumber));
            applyToSelf(new DexterityPower(p,magicNumber));
            atb(new GainEnergyAction(magicNumber));
            atb(new DrawCardAction(magicNumber));
            applyToSelf(new MarkPower(p,magicNumber));
        }
        else
        {
            ArrayList<AbstractCard> easyCardList = new ArrayList<>();
            easyCardList.add(new EasyModalChoiceCard("cardStrings.EXTENDED_DESCRIPTION[0]", "cardStrings.EXTENDED_DESCRIPTION[1]", () -> applyToSelfTop(new StrengthPower(p, magicNumber))));
            easyCardList.add(new EasyModalChoiceCard("cardStrings.EXTENDED_DESCRIPTION[2]", "cardStrings.EXTENDED_DESCRIPTION[3]", () -> applyToSelfTop(new DexterityPower(p, magicNumber))));
            easyCardList.add(new EasyModalChoiceCard("cardStrings.EXTENDED_DESCRIPTION[4]", "cardStrings.EXTENDED_DESCRIPTION[5]", () -> att(new GainEnergyAction(magicNumber))));
            easyCardList.add(new EasyModalChoiceCard("cardStrings.EXTENDED_DESCRIPTION[6]", "cardStrings.EXTENDED_DESCRIPTION[7]", () -> att(new DrawCardAction(magicNumber))));
            easyCardList.add(new EasyModalChoiceCard("cardStrings.EXTENDED_DESCRIPTION[8]", "cardStrings.EXTENDED_DESCRIPTION[9]", () -> applyToSelfTop(new MarkPower(p, secondMagic))));
            for (int i = 0; i < magicNumber; i++) {
                atb(new EasyModalChoiceAction(easyCardList));
            }
        }

    }

    public void upp() {
        upgradeDamage(0);
        upgradeBlock(0);
        upgradeMagicNumber(0);
        upgradeBaseCost(5);
    }
}