package code.cards;

import code.cards.AbstractEasyCard;
import com.megacrit.cardcrawl.actions.common.DiscardAction;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static code.ModFile.makeID;
import static code.util.Wiz.*;

public class ID_80 extends AbstractEasyCard {
    public final static String ID = makeID("ID_80");
    // intellij stuff skill, self, special, 0, 0, 0, 0, 1, 1

    public ID_80() {
        super(ID, 0, CardType.SKILL, CardRarity.SPECIAL, CardTarget.SELF);
        baseDamage = 0;
        baseBlock = 0;
        baseMagicNumber = magicNumber = 1;
        selfRetain = true;
        exhaust = true;
    }

    public void use(AbstractPlayer p, AbstractMonster m)
    {
        atb(new DiscardAction(p,p,1,false));
        atb(new GainEnergyAction(magicNumber));

    }

    @Override
    public boolean canUse(AbstractPlayer p, AbstractMonster m)
    {
        if(p.hand.size() < 2)
            return false;
        return true;
    }
    public void upp() {
        //upgradeDamage(0);
        //upgradeBlock(0);
        upgradeMagicNumber(1);
        //upgradeBaseCost(0);
    }
}