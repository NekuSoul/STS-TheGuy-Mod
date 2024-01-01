package code.cards;

import code.cards.AbstractEasyCard;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.GameActionManager;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static code.ModFile.makeID;
import static code.util.Wiz.*;

public class ID_10 extends AbstractEasyCard {
    public final static String ID = makeID("ID_10");
    // intellij stuff ATTACK, ENEMY, COMMON, 7, 5, 0, 0, 0, 0

    public ID_10() {
        super(ID, 2, CardType.ATTACK, CardRarity.COMMON, CardTarget.ENEMY);
        baseDamage = 7;
        baseBlock = 0;
        baseMagicNumber = magicNumber = 0;
    }

    public void didDiscard() {
        this.setCostForTurn(this.costForTurn - 1);
    }
    public void triggerWhenDrawn() {
        super.triggerWhenDrawn();
        this.setCostForTurn(this.cost - GameActionManager.totalDiscardedThisTurn);
    }

    public void atTurnStart() {
        this.resetAttributes();
        this.applyPowers();
    }

    public void use(AbstractPlayer p, AbstractMonster m)
    {
        dmg(m, AbstractGameAction.AttackEffect.SLASH_HEAVY);
    }

    public void upp() {
        upgradeDamage(5);
        upgradeBlock(0);
        upgradeMagicNumber(0);
        upgradeBaseCost(0);
    }
}