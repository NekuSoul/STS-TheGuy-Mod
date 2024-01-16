package code.cards;

import code.cards.AbstractEasyCard;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.ReduceCostAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static code.ModFile.makeID;
import static code.util.Wiz.*;

public class ID_54 extends AbstractEasyCard {
    public final static String ID = makeID("ID_54");
    // intellij stuff attack, enemey, common, 9, 3, 0, 0, 0, 0

    public ID_54() {
        super(ID, 1, CardType.ATTACK, CardRarity.COMMON, CardTarget.ENEMY);
        baseDamage = 9;
        baseBlock = 0;
        baseMagicNumber = magicNumber = 0;
    }

    public void use(AbstractPlayer p, AbstractMonster m)
    {
        this.addToBot(new DamageAction(m, new DamageInfo(p, this.damage*this.cost, this.damageTypeForTurn), AbstractGameAction.AttackEffect.BLUNT_HEAVY));
        this.modifyCostForCombat(1);
    }



    public void upp() {
        upgradeDamage(3);
        //upgradeBlock(0);
        //upgradeMagicNumber(0);
        //upgradeBaseCost(1);
    }
}