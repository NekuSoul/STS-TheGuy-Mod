package code.cards;

import code.cards.AbstractEasyCard;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import java.security.PublicKey;

import static code.ModFile.makeID;
import static code.util.Wiz.*;

public class ID_46 extends AbstractEasyCard {
    public final static String ID = makeID("ID_46");
    // intellij stuff skill, self, Uncommon, 0, 0, 5, 0, 1, 1

    public ID_46() {
        super(ID, 1, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.SELF);
        baseDamage = 0;
        baseBlock = 5;
        baseMagicNumber = magicNumber = 1;
    }

    @Override
    public void triggerOnManualDiscard()
    {
        this.addToTop(new GainEnergyAction(magicNumber));
    }
    public void use(AbstractPlayer p, AbstractMonster m)
    {
        blck();
    }

    public void upp() {
        //upgradeDamage(0);
        //upgradeBlock(0);
        upgradeMagicNumber(1);
        //upgradeBaseCost(1);
    }
}