package code.cards;

import code.actions.ID_17Action;
import code.cards.AbstractEasyCard;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.utility.WaitAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.WeakPower;
import com.megacrit.cardcrawl.powers.watcher.MarkPower;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.Stream;

import static code.ModFile.makeID;
import static code.util.Wiz.*;

public class ID_17 extends AbstractEasyCard {
    public final static String ID = makeID("ID_17");
    // intellij stuff ATTACK, ENEMY, COMMON, 3, 1, 0, 0, 1, 0

    public ID_17() {
        super(ID, 0, CardType.ATTACK, CardRarity.COMMON, CardTarget.ENEMY);
        baseDamage = 3;
        baseBlock = 0;
        baseMagicNumber = magicNumber = 1;
    }

    public void use(AbstractPlayer p, AbstractMonster m)
    {
        this.addToTop(new ApplyPowerAction(p, p, new MarkPower(p, magicNumber)));
        this.addToBot(new ID_17Action(p,m,damage,this.damageTypeForTurn));
    }

    public void upp() {
        upgradeDamage(1);
        upgradeBlock(0);
        upgradeMagicNumber(0);
        upgradeBaseCost(0);
    }
}