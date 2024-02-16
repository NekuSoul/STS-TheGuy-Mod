package code.cards;

import code.cards.AbstractEasyCard;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static code.ModFile.makeID;
import static code.util.Wiz.*;

public class ID_75 extends AbstractEasyCard {
    public final static String ID = makeID("ID_75");
    // intellij stuff attack, enemy, common, 4, 1, 0, 0, 0, 0

    public ID_75() {
        super(ID, 1, CardType.ATTACK, CardRarity.COMMON, CardTarget.ENEMY);
        baseDamage = 4;
        baseBlock = 0;
        baseMagicNumber = magicNumber = 1;
    }

    public void use(AbstractPlayer p, AbstractMonster m)
    {
        dmg(m, AbstractGameAction.AttackEffect.NONE);
    }

    public void triggerOnManualDiscard() {
        baseDamage *= 2;
        this.addToBot(new MakeTempCardInDiscardAction(this.makeStatEquivalentCopy(), magicNumber));
    }
    public void upp() {
        upgradeDamage(1);
        //upgradeBlock(0);
        //upgradeMagicNumber(0);
        upgradeBaseCost(1);
    }
}