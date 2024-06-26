package code.cards;

import code.actions.ID_15Action;
import code.cards.AbstractEasyCard;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.DiscardAction;
import com.megacrit.cardcrawl.actions.common.DiscardSpecificCardAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static code.ModFile.makeID;
import static code.util.Wiz.*;

public class ID_15 extends AbstractEasyCard {
    public final static String ID = makeID("ID_15");
    // intellij stuff ATTACK, ENEMY, COMMON, 5, 0, 0, 0, 2, -2

    public ID_15() {
        super(ID, 1, CardType.ATTACK, CardRarity.COMMON, CardTarget.ENEMY);
        baseDamage = 5;
        baseBlock = 0;
        baseMagicNumber = magicNumber = 2;
    }

    public void use(AbstractPlayer p, AbstractMonster m)
    {
        this.addToBot(new DamageAction(m, new DamageInfo(p, this.damage, this.damageTypeForTurn), AbstractGameAction.AttackEffect.SLASH_HORIZONTAL));
        addToBot(new ID_15Action(p,m,magicNumber,damage,damage, this.damageTypeForTurn));
    }

    public void upp() {
        upgradeDamage(2);
        //upgradeBlock(0);
        //upgradeMagicNumber(2);
        //upgradeBaseCost(1);
    }
}